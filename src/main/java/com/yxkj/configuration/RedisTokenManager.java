package com.yxkj.configuration;

import com.alibaba.fastjson.JSONObject;
import com.yxkj.common.eumn.UserType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * reids token 管理器
 * @author ly
 * @date 20170919
 */
@Component
public class RedisTokenManager implements TokenManager{

    private Logger logger = LoggerFactory.getLogger(RedisTokenManager.class);

    /**
     * 过期时间
     */
    private long expired = 7;

    /**
     * 时间单位
     */
    @Value(value="DAYS")
    private TimeUnit timeUnit;
    
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String createToken(String username, String mac, Integer tenantId, Integer userType) {

        String token = UUID.randomUUID().toString();
        Map<String, Object> value = new HashMap<String, Object>();

        value.put("username", username);
        value.put("mac", mac);
        value.put("tenantId", tenantId);
        value.put("userType", userType);

        String valueString = JSONObject.toJSONString(value);

        logger.info("========start set token =================");
        stringRedisTemplate.opsForValue().set(token, valueString, expired, timeUnit);
        logger.info("========end set token =================");
        return token;
    }

    @Override
    public boolean checkToken(String username, String token) {

        //检查token是否过期
        long result = stringRedisTemplate.getExpire(token);
        if(result<=0){
            return false;
        }

        //检查token对应用户是否匹配
        String value = stringRedisTemplate.opsForValue().get(token);
        JSONObject valueObject = JSONObject.parseObject(value);
        String tokenUsername =valueObject.getString("username");
        if(!username.equals(tokenUsername)){
            return false;
        }

        //更新token到期时间
        stringRedisTemplate.expire(token, expired, timeUnit);
        return true;

    }

    /**
     * 注销token
     * @param token
     */
    @Override
    public void cancelToken(String token) {
        stringRedisTemplate.delete(token);
    }


    public void cancelUser(String userName, Integer tenantId) {

        Set tokenSet = stringRedisTemplate.keys("*");

        Iterator<String> iterator = tokenSet.iterator();
        while (iterator.hasNext()){
            String token = iterator.next();
            String value = stringRedisTemplate.opsForValue().get(token);

            JSONObject valueObject = JSONObject.parseObject(value);
            String tokenUsername =valueObject.getString("username");
            Integer tokenTenantId = valueObject.getInteger("tenantId");
            Integer tokenUserType = valueObject.getInteger("userType");

            if(userName.equals(tokenUsername) && tenantId.equals(tokenTenantId) && UserType.EENANT_EMPLOYEE.getCode().equals(tokenUserType)){
                stringRedisTemplate.delete(token);
            }
        }

    }

    @Override
    public void cancelMac(String mac, Integer tenantId) {

        Set tokenSet = stringRedisTemplate.keys("*");

        Iterator<String> iterator = tokenSet.iterator();
        while (iterator.hasNext()){
            String token = iterator.next();
            String value = stringRedisTemplate.opsForValue().get(token);

            JSONObject valueObject = JSONObject.parseObject(value);
            String tokenMac = valueObject.getString("mac");
            Integer tokenTenantId = valueObject.getInteger("tenantId");
            Integer tokenUserType = valueObject.getInteger("userType");

            if(mac.equals(tokenMac) && tenantId.equals(tokenTenantId) && UserType.EENANT_EMPLOYEE.getCode().equals(tokenUserType)){
                stringRedisTemplate.delete(token);
            }
        }

    }

    @Override
    public void cancelTenant(Integer tenantId) {

        Set tokenSet = stringRedisTemplate.keys("*");

        Iterator<String> iterator = tokenSet.iterator();
        while (iterator.hasNext()){
            String token = iterator.next();
            String value = stringRedisTemplate.opsForValue().get(token);

            JSONObject valueObject = JSONObject.parseObject(value);
            Integer tokenTenantId = valueObject.getInteger("tenantId");

            if(tenantId.equals(tokenTenantId)){
                stringRedisTemplate.delete(token);
            }
        }

    }


    public void setExpired(long expired) {
        this.expired = expired;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }
}

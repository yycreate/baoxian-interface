package com.yxkj.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yxkj.common.exception.TokenException;
import com.yxkj.common.security.IgnoreSecurity;
import com.yxkj.common.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class SecurityAspect {

    private static final String DEFAULT_TOKEN_NAME = "X-Token";

    private static final String DEFAULT_USER_NAME = "X-User";

    @Autowired
    private TokenManager tokenManager;
    private String tokenName;
    private String userName;

    public void setTokenManager(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    public void setTokenName(String tokenName) {
        if (StringUtil.isEmpty(tokenName)) {
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }

    public void setUserName(String userName){
        if (StringUtil.isEmpty(userName)) {
            userName = DEFAULT_USER_NAME;
        }
        this.userName = userName;
    }
    
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void token() {
    	System.out.println("token");
    }
    
    @Around("token()")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
    	System.out.println("execute");
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        // 若目标方法忽略了安全性检查，则直接调用目标方法
        if ((!method.isAnnotationPresent(IgnoreSecurity.class)) || (method.isAnnotationPresent(IgnoreSecurity.class) && method.getAnnotation(IgnoreSecurity.class).val())) {
            return pjp.proceed();
        }

        // 从 request header 中获取当前 token
        HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader(DEFAULT_TOKEN_NAME);
        String username = request.getHeader(DEFAULT_USER_NAME);

        if(StringUtil.isEmpty(token) || StringUtil.isEmpty(DEFAULT_TOKEN_NAME)){
            throw new TokenException();
        }

        // 检查 token 有效性
        if (!tokenManager.checkToken(username,token)) {
            String message = String.format("token [%s] is invalid", token);
            throw new TokenException(message);
        }
        // 调用目标方法
        return pjp.proceed();
    }

}

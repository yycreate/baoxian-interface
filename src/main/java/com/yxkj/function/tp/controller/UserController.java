package com.yxkj.function.tp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.yxkj.common.network.Response;
import com.yxkj.common.util.BaseUtil;
import com.yxkj.common.util.WxMinCodeUtil;
import com.yxkj.function.tp.Entity.User;
import com.yxkj.function.tp.mapper.other.UserElseMapper;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api("用户信息")
@RequestMapping(value="/api/user")
@SuppressWarnings({"rawtypes"})
public class UserController {
	
	@Autowired
	private UserElseMapper userElseMapper;
	
	@RequestMapping(value="infoMessageByOpenId", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiIgnore("根据openId查询用户信息")
	public Response infoMessageByOpenId(@RequestParam(required = false, value="open_id")@RequestAttribute(required = false, value="工单id")String open_id) {
		Response response = new Response(); 
		try {
			Map<String, Object> result = new HashMap<>();
			if(null==open_id) {
				return response.failure("openId为空");
			}
			User userInfo = userElseMapper.UserInfo(open_id);
			return response.success(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	@RequestMapping(value="insertUserInfo", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiIgnore("插入用户信息")
	public Response insertUserInfo(
			@RequestParam(required = false, value="open_id")@RequestAttribute(required = false, value="工单id")String open_id,
			@RequestParam(required = false, value="worker_number")@RequestAttribute(required = false, value="工单id")String worker_number
			) {
		Response response = new Response(); 
		try {
			if(null==open_id) {
				return response.failure("openId为空");
			}
			if(null==worker_number) {
				return response.failure("worker_number为空");
			}
			Long id = BaseUtil.GetWorkerId();
			Map<String, Object> userInfo = userElseMapper.addUserOne(id,open_id,worker_number);
			return response.success(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	//登陆微信接口
	/**
	 * appid: APP_ID,
	    secret: APP_SECRET,
	    js_code: res.code,
	    grant_type: 'authorization_code'
	 * */
	@ApiIgnore(value="小程序登录获取openId")
	@RequestMapping(value = "/wx/openInfo" , produces = MediaType.APPLICATION_JSON_VALUE)
	public Response wxLogin(String js_code, String grant_type) {
		Response response = new Response(); 
		try {
			String appid = "wx1987b6657c57763a";
			String secret = "368cf87ede8a22a2bbae44dafc6b165e";
			JSONObject json = WxMinCodeUtil.getUserInfoTool(appid, secret, js_code);
			response.success(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	
}

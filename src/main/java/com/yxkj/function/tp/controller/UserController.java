package com.yxkj.function.tp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yxkj.common.network.Response;
import com.yxkj.common.util.BaseUtil;
import com.yxkj.function.tp.Entity.User;
import com.yxkj.function.tp.mapper.other.UserElseMapper;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@Api("用户信息")
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	private UserElseMapper userElseMapper;
	
	@RequestMapping(value="infoMessageByOpenId", method = RequestMethod.GET)
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
	
	
	@RequestMapping(value="insertUserInfo", method = RequestMethod.POST)
	@ApiIgnore("插入用户信息")
	public Response insertUserInfo(
			@RequestParam(required = false, value="open_id")@RequestAttribute(required = false, value="工单id")String open_id,
			@RequestParam(required = false, value="worker_number")@RequestAttribute(required = false, value="工单id")String worker_number
			) {
		Response response = new Response(); 
		try {
			Map<String, Object> result = new HashMap<>();
			if(null==open_id) {
				return response.failure("openId为空");
			}
			if(null==worker_number) {
				return response.failure("worker_number为空");
			}
			Long id = BaseUtil.GetWorkerId();
			User userInfo = userElseMapper.addUserOne(id,open_id,worker_number);
			return response.success(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	//登陆微信接口
	public Response wxLogin(String OpenId) {
		Response response = new Response(); 
		try {
			
			
			response.success();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	
}

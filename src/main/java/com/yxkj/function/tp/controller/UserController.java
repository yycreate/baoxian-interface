package com.yxkj.function.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxkj.common.network.Response;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@ApiIgnore("查询是否有该openId的接口")
	public Response userInfo(String OpenId) {
		Response response = new Response(); 
		
		
		
		return response.failure();
	}
	
	
}

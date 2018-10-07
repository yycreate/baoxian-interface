package com.yxkj.function.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxkj.common.network.Response;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	public Response userInfo(String OpenId) {
		Response response = new Response(); 
		
		
		return response.failure();
	}
	
	
}

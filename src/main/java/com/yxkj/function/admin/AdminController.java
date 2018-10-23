package com.yxkj.function.admin;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxkj.common.network.Response;

@RestController
@RequestMapping(value="/api/admin")
@SuppressWarnings({"rawtypes"})
public class AdminController {
	
	@RequestMapping(value="/login",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public  Response userLogin(String user,String password) {
		Response response = new Response<>();
		
		
		return response.failure();
	}
	
}

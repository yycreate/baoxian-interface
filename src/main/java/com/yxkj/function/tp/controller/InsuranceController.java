package com.yxkj.function.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yxkj.common.network.Response;

@Controller
@RequestMapping(value="/api/Insurance")
public class InsuranceController {
	
	@RequestMapping(value="/listresurace")
	public Response listresurace() {
		Response response = new Response<>();
		
		
		return response.failure();
	}
	
}

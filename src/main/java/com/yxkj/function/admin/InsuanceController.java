package com.yxkj.function.admin;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxkj.common.network.Response;

@RestController
@RequestMapping(value="/api/admin/insuance")
@SuppressWarnings({"rawtypes"})
public class InsuanceController {

	@RequestMapping(value="/list",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  Response userLogin(String userName,Integer pageSize, Integer pageNum) {
		Response response = new Response<>();
		try{
			
			throw new Exception();
		}catch (Exception e) {
			
		}
		return response.failure();
	}
	
}

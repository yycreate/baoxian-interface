package com.yxkj.function.tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.yxkj.common.network.Response;
import com.yxkj.common.util.WxUtil;
import com.yxkj.function.ocr.pojo.XCXConfig;
import com.yxkj.function.ocr.util.XCXConfigUtil;
import com.yxkj.function.tp.service.SharedService;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api("用户信息")
@RequestMapping(value="/api/shared")
@SuppressWarnings({"rawtypes"})
public class SahredController {

	@Autowired
	private SharedService sharedService; 
	
	
	/***
	 * 每当一条信息分享  插入一条记录
	 * @param openId 
	 * @param orderNo 分享的保单号
	 * */
	@ApiIgnore("记录分享人分享动作")
	@RequestMapping(value="record", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response recordShareMessage(
			String openId,
			String orderNo
			) {
		Response response = new  Response<>();
		try {
			sharedService.recordSharedData(openId, orderNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	} 
	
	
}

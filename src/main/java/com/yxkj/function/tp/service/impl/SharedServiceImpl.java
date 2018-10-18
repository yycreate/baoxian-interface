package com.yxkj.function.tp.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.yxkj.common.util.WxUtil;
import com.yxkj.configuration.TokenManager;
import com.yxkj.function.ocr.pojo.XCXConfig;
import com.yxkj.function.ocr.util.XCXConfigUtil;
import com.yxkj.function.tp.service.SharedService;

@Service
public class SharedServiceImpl implements SharedService{
	
	private String TOKEN_KEY = "KUYEIR";
	
	@Autowired
	TokenManager tokenManager;
	
	/**
	 * 保存分享人记录
	 * @param openId
	 * @param orderNo 单号
	 * @return Map<String, Object>
	 * */
	@Override
	public Map<String, Object> recordSharedData(String openId, String orderNo) {
		String token = null;
//		if(tokenManager.checkAccessToken(TOKEN_KEY)){
//			token = tokenManager.getAccessToken(TOKEN_KEY);
//		} else {
//			XCXConfig config = XCXConfigUtil.getInstance();
//			JSONObject tokenMap = WxUtil.getTokenTool(config.getAppid(), config.getSecret()); //access_token expires_in
//			token = tokenMap.getString("access_token");
//			Long expires = tokenMap.getLong("expires_in");
//			tokenManager.setAccessToken(TOKEN_KEY, token, expires);
//		};
		
		XCXConfig config = XCXConfigUtil.getInstance();
		JSONObject tokenMap = WxUtil.getTokenTool(config.getAppid(), config.getSecret());
		token = tokenMap.getString("access_token");
		openId = "ochul5Gsx-gQ8-F0puG2fDMIdHDU";
		JSONObject userInfo = WxUtil.getUserInfoTool(token, openId);
		
		//保存用户信息
		
		return null;
	}
	
	
	
}

package com.yxkj.function.tp.service;

import java.util.Map;

public interface SharedService {
	
	/**
	 * 保存分享人记录
	 * @param openId
	 * @param orderNo 单号
	 * @return Map<String, Object>
	 * */
	public Map<String, Object> recordSharedData(String openId,String orderNo);
	
}

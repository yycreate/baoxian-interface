package com.yxkj.common.eumn;

public enum ResultCode {
	
	PARAMETER_ERROR(10101, "参数错误"),
	WEAK_NET_WORK(10000, "网络错误");
	
	private Integer code;
	private String message;
	
	ResultCode(Integer code,String message) {
		this.code = code;
		this.message = message;
	}
}

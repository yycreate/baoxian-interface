package com.yxkj.common.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseUtil {
	
	//获取时间戳做id
	public static Long GetWorkerId() {
		return new Date().getTime();
	}
	
	//正则表达式
	public static boolean ZZ(String str,String regEx) {
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    // 忽略大小写的写法
	    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(str);
	    // 查找字符串中是否有匹配正则表达式的字符/字符串
	    boolean rs = matcher.find();
	    return rs;
	}
	
}

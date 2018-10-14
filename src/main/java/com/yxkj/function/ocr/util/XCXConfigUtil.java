package com.yxkj.function.ocr.util;

import com.yxkj.common.util.PropertyUtil;
import com.yxkj.function.ocr.pojo.XCXConfig;

public class XCXConfigUtil {
	
	
	private static XCXConfig conf = null;

    public static XCXConfig getInstance (){
        if(null == conf ){
            conf = new XCXConfig();
            conf.setAppid(PropertyUtil.getProperty("config.properties","xcx.appid"));
            conf.setSecret(PropertyUtil.getProperty("config.properties","xcx.secret"));
            return conf;
        }else{
            return conf;
        }
    }
	
	
}

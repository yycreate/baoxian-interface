package com.yxkj.function.ocr.util;

import com.yxkj.common.util.PropertyUtil;
import com.yxkj.function.ocr.pojo.OcrConfig;

public class OCRConfigUtil {
	
	
	private static OcrConfig conf = null;

    public static OcrConfig getInstance (){
        if(null == conf ){
            conf = new OcrConfig();
            conf.setAPP_ID(PropertyUtil.getProperty("config.properties","baidu.OCR_APP_ID"));
            conf.setAPP_KEY(PropertyUtil.getProperty("config.properties","baidu.OCR_APP_KEY"));
            conf.setAPP_SECRET(PropertyUtil.getProperty("config.properties","baidu.OCR_APP_SECRET"));
            return conf;
        }else{
            return conf;
        }
    }
	
	
}

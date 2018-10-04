package com.yxkj.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统内部校验错误信息
 * 遵循规则 模块名-错误描述
 * 例子：比如销售模块出现了单号重复问题 销售模块就是 sale 单号重复 saleno_is_duplicate 那么此错误信息应该命名为下 sale_soaleno_is_duplicate
 * 模块命名
 * USER  --  用户模块
 * VEDIO
 * WX
 * ORDER 
 *
 */
public final class ValidationMessge {

    public static final String DIRECTION_NOT_NULL = null;
    
    /***
     * 没有用户唯一信息
     * */
    public static final String USER_NO_UNQUIRE_ID = "没有用户唯一信息";
}

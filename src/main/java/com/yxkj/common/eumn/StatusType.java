package com.yxkj.common.eumn;

public enum StatusType {

    NORMAL("正常", 1),
    DIASABLE("停用", 0);

    private String name;
    private Integer code;

    StatusType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

}

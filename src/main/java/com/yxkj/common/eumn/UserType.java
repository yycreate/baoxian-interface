package com.yxkj.common.eumn;

public enum UserType {

    TENANT_MANAGER("商户", 1),
    EENANT_EMPLOYEE("商户员工", 2);

    private String name;
    private Integer code;

    UserType(String name, Integer code) {
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

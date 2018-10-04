package com.yxkj.common.eumn;

public enum SourceType {
	
	UNKNOWN(null,"未知",0),
	B2("B2","B2数据库",1),
	PX("PX","云数据库0016",2),//品兴
	ZX("ZX","云数据库0022",3),//中兴
	NG("NG","云数据库0042",4)//南岗
	;
	
	
	private String dataBase;
	private String name;
    private Integer code;

    SourceType(String dataBase,String name, Integer code) {
    	this.dataBase = dataBase;
        this.name = name;
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

	public String getDataBase() {
		return dataBase;
	}
    
}

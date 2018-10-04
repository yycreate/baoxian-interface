package com.yxkj.function.searcher.entity.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.yxkj.common.eumn.SourceType;

@Document(indexName = "cgin",type = "goods", shards = 1,replicas = 0, refreshInterval = "-1")
public class Goods implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id = -1l;
    
    private String code;

    private String name;
    
    private Integer status = -1;
    
    private String auxiliaryBarcode;
    
    private String barCode;
    //[简称]
    private String abbreviation;
    //[拼音]
    private String phoneticize;
    //[型号规格]
    private String typeSpecification;
    //[包装规格]
    private BigDecimal packingSpecification;
    //[大单位]
    private String largeUnit;
    //[小单位]
    private String smallUnit;
    //[类型编号]
    private Integer typeId;
    //[产地]
    private String placeOfOrigin;
    //[供应商Id]
    private Integer supplierId;
    
    private Integer Source = SourceType.UNKNOWN.getCode();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSource() {
		return Source;
	}

	public void setSource(Integer source) {
		Source = source;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAuxiliaryBarcode() {
		return auxiliaryBarcode;
	}

	public void setAuxiliaryBarcode(String auxiliaryBarcode) {
		this.auxiliaryBarcode = auxiliaryBarcode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getPhoneticize() {
		return phoneticize;
	}

	public void setPhoneticize(String phoneticize) {
		this.phoneticize = phoneticize;
	}

	public String getTypeSpecification() {
		return typeSpecification;
	}

	public void setTypeSpecification(String typeSpecification) {
		this.typeSpecification = typeSpecification;
	}

	public BigDecimal getPackingSpecification() {
		return packingSpecification;
	}

	public void setPackingSpecification(BigDecimal packingSpecification) {
		this.packingSpecification = packingSpecification;
	}

	public String getLargeUnit() {
		return largeUnit;
	}

	public void setLargeUnit(String largeUnit) {
		this.largeUnit = largeUnit;
	}

	public String getSmallUnit() {
		return smallUnit;
	}

	public void setSmallUnit(String smallUnit) {
		this.smallUnit = smallUnit;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(String placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	
	@Override
	public String toString() {
		String jsonStr = "{";
		java.lang.reflect.Field[] field = this.getClass().getDeclaredFields();
		
		if(this.id != -1l) {
			jsonStr+="\"id\":\""+this.id+"\",";
		}
		if(this.code!=null) {
			jsonStr+="\"code\":\""+this.code+"\",";
		}
		if(this.name!=null) {
			jsonStr+="\"name\":\""+this.name+"\",";
		}
		if(this.status==-1) {
			jsonStr+="\"status\":\""+this.status+"\",";
		}
		if(this.auxiliaryBarcode!=null) {
			jsonStr+="\"auxiliaryBarcode\":\""+this.auxiliaryBarcode+"\",";
		}
		if(this.barCode!=null) {
			jsonStr+="\"barCode\":\""+this.barCode+"\",";
		}
		if(this.abbreviation!=null) {
			jsonStr+="\"abbreviation\":\""+this.abbreviation+"\",";
		}
		if(this.phoneticize!=null) {
			jsonStr+="\"phoneticize\":\""+this.phoneticize+"\",";
		}
		if(this.typeSpecification!=null) {
			jsonStr+="\"typeSpecification\":\""+this.typeSpecification+"\",";
		}
		if(this.largeUnit!=null) {
			jsonStr+="\"largeUnit\":\""+this.largeUnit+"\",";
		}
		if(this.smallUnit!=null) {
			jsonStr+="\"smallUnit\":\""+this.smallUnit+"\",";
		}
		jsonStr += "\"SK\":\"1\"";
		jsonStr += "}";
		return jsonStr;
	}
	
}
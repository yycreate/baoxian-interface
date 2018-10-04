package com.yxkj.function.tp.Entity;

import java.io.Serializable;
import java.util.Date;

public class EnsureInsuraceRelation implements Serializable {
    private Integer id;

    private String ensure_name;

    private String insurance_name;

    private Integer money;

    private Date updateNo;

    private Date createTime;

    private String project_name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnsure_name() {
        return ensure_name;
    }

    public void setEnsure_name(String ensure_name) {
        this.ensure_name = ensure_name == null ? null : ensure_name.trim();
    }

    public String getInsurance_name() {
        return insurance_name;
    }

    public void setInsurance_name(String insurance_name) {
        this.insurance_name = insurance_name == null ? null : insurance_name.trim();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(Date updateNo) {
        this.updateNo = updateNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name == null ? null : project_name.trim();
    }
}
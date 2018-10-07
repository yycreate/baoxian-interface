package com.yxkj.function.tp.Entity;

import java.io.Serializable;

public class EnsureType implements Serializable {
    private Integer id;

    private String ensure_type_name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnsure_type_name() {
        return ensure_type_name;
    }

    public void setEnsure_type_name(String ensure_type_name) {
        this.ensure_type_name = ensure_type_name == null ? null : ensure_type_name.trim();
    }
}
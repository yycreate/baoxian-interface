package com.yxkj.function.tp.Entity;

import java.io.Serializable;
import java.util.Date;

public class InsuranceFile implements Serializable {
    private Long insurance_file_id;

    private String url;

    private String file_name;

    private Long file_size;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public Long getInsurance_file_id() {
        return insurance_file_id;
    }

    public void setInsurance_file_id(Long insurance_file_id) {
        this.insurance_file_id = insurance_file_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name == null ? null : file_name.trim();
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
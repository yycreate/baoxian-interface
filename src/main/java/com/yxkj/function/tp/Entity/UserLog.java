package com.yxkj.function.tp.Entity;

import java.io.Serializable;
import java.util.Date;

public class UserLog implements Serializable {
    private Long log_id;

    private String ip;

    private Date log_time;

    private static final long serialVersionUID = 1L;

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getLog_time() {
        return log_time;
    }

    public void setLog_time(Date log_time) {
        this.log_time = log_time;
    }
}
package com.yxkj.function.tp.Entity;

import java.io.Serializable;

public class User implements Serializable {
    private Long user_id;

    private String open_id;

    private String name;

    private String phone;

    private String worker_number;

    private static final long serialVersionUID = 1L;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id == null ? null : open_id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(String worker_number) {
        this.worker_number = worker_number == null ? null : worker_number.trim();
    }
}
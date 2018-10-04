package com.yxkj.function.tp.Entity;

import java.io.Serializable;

public class Insurance implements Serializable {
    private Long insurance_id;

    private String insurance_number;

    private Long insurance_type_id;

    private String insurance_type_name;

    private String policy_holder_name;

    private String policy_holder_sex;

    private String policy_creit_card;

    private String policy_holder_birthday;

    private String insured_person_name;

    private String insured_person_sex;

    private String insured_creit_card;

    private String insured_person_birthday;

    private String worker_number;

    private Long file_id;

    private Integer is_check;

    private Integer sure_num;

    private static final long serialVersionUID = 1L;

    public Long getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(Long insurance_id) {
        this.insurance_id = insurance_id;
    }

    public String getInsurance_number() {
        return insurance_number;
    }

    public void setInsurance_number(String insurance_number) {
        this.insurance_number = insurance_number == null ? null : insurance_number.trim();
    }

    public Long getInsurance_type_id() {
        return insurance_type_id;
    }

    public void setInsurance_type_id(Long insurance_type_id) {
        this.insurance_type_id = insurance_type_id;
    }

    public String getInsurance_type_name() {
        return insurance_type_name;
    }

    public void setInsurance_type_name(String insurance_type_name) {
        this.insurance_type_name = insurance_type_name == null ? null : insurance_type_name.trim();
    }

    public String getPolicy_holder_name() {
        return policy_holder_name;
    }

    public void setPolicy_holder_name(String policy_holder_name) {
        this.policy_holder_name = policy_holder_name == null ? null : policy_holder_name.trim();
    }

    public String getPolicy_holder_sex() {
        return policy_holder_sex;
    }

    public void setPolicy_holder_sex(String policy_holder_sex) {
        this.policy_holder_sex = policy_holder_sex == null ? null : policy_holder_sex.trim();
    }

    public String getPolicy_creit_card() {
        return policy_creit_card;
    }

    public void setPolicy_creit_card(String policy_creit_card) {
        this.policy_creit_card = policy_creit_card == null ? null : policy_creit_card.trim();
    }

    public String getPolicy_holder_birthday() {
        return policy_holder_birthday;
    }

    public void setPolicy_holder_birthday(String policy_holder_birthday) {
        this.policy_holder_birthday = policy_holder_birthday == null ? null : policy_holder_birthday.trim();
    }

    public String getInsured_person_name() {
        return insured_person_name;
    }

    public void setInsured_person_name(String insured_person_name) {
        this.insured_person_name = insured_person_name == null ? null : insured_person_name.trim();
    }

    public String getInsured_person_sex() {
        return insured_person_sex;
    }

    public void setInsured_person_sex(String insured_person_sex) {
        this.insured_person_sex = insured_person_sex == null ? null : insured_person_sex.trim();
    }

    public String getInsured_creit_card() {
        return insured_creit_card;
    }

    public void setInsured_creit_card(String insured_creit_card) {
        this.insured_creit_card = insured_creit_card == null ? null : insured_creit_card.trim();
    }

    public String getInsured_person_birthday() {
        return insured_person_birthday;
    }

    public void setInsured_person_birthday(String insured_person_birthday) {
        this.insured_person_birthday = insured_person_birthday == null ? null : insured_person_birthday.trim();
    }

    public String getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(String worker_number) {
        this.worker_number = worker_number == null ? null : worker_number.trim();
    }

    public Long getFile_id() {
        return file_id;
    }

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public Integer getIs_check() {
        return is_check;
    }

    public void setIs_check(Integer is_check) {
        this.is_check = is_check;
    }

    public Integer getSure_num() {
        return sure_num;
    }

    public void setSure_num(Integer sure_num) {
        this.sure_num = sure_num;
    }
}
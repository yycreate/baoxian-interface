package com.yxkj.function.tp.mapper;

import org.springframework.stereotype.Component;

import com.yxkj.function.tp.Entity.Insurance;

@Component
public interface InsuranceMapper {
    int deleteByPrimaryKey(Long insurance_id);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Long insurance_id);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);
}
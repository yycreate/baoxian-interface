package com.yxkj.function.tp.mapper;

import org.springframework.stereotype.Component;

import com.yxkj.function.tp.Entity.InsuranceFile;

@Component
public interface InsuranceFileMapper {
    int deleteByPrimaryKey(Long insurance_file_id);

    int insert(InsuranceFile record);

    int insertSelective(InsuranceFile record);

    InsuranceFile selectByPrimaryKey(Long insurance_file_id);

    int updateByPrimaryKeySelective(InsuranceFile record);

    int updateByPrimaryKey(InsuranceFile record);
}
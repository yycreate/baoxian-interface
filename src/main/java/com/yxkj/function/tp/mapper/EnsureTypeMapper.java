package com.yxkj.function.tp.mapper;

import org.springframework.stereotype.Component;

import com.yxkj.function.tp.Entity.EnsureType;

@Component
public interface EnsureTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnsureType record);

    int insertSelective(EnsureType record);

    EnsureType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnsureType record);

    int updateByPrimaryKey(EnsureType record);
}
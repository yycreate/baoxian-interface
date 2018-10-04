package com.yxkj.function.tp.mapper;

import com.yxkj.function.tp.Entity.EnsureInsuraceRelation;

public interface EnsureInsuraceRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnsureInsuraceRelation record);

    int insertSelective(EnsureInsuraceRelation record);

    EnsureInsuraceRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnsureInsuraceRelation record);

    int updateByPrimaryKey(EnsureInsuraceRelation record);
}
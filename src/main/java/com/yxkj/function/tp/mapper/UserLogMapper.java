package com.yxkj.function.tp.mapper;

import com.yxkj.function.tp.Entity.UserLog;

public interface UserLogMapper {
    int deleteByPrimaryKey(Long log_id);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    UserLog selectByPrimaryKey(Long log_id);

    int updateByPrimaryKeySelective(UserLog record);

    int updateByPrimaryKey(UserLog record);
}
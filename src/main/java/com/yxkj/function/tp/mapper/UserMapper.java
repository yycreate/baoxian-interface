package com.yxkj.function.tp.mapper;

import com.yxkj.function.tp.Entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long user_id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long user_id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
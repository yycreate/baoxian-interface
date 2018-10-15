package com.yxkj.function.tp.mapper.other;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.yxkj.function.tp.Entity.User;

@Component
public interface UserElseMapper {
    
	@Select("select * from tp3_user where open_id = #{openId}")
	public User UserInfo(@Param(value="openId") String openId);
	
	@Insert("insert into tp3_user (user_id,open_id,worker_number) values (#{id}, #{openId}, #{workerNumber})")
	public Integer addUserOne(@Param(value="id")Long id,@Param(value="openId") String openId, @Param(value="workerNumber")String workerNumber);
	
	
	
}
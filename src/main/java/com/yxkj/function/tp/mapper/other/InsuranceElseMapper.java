package com.yxkj.function.tp.mapper.other;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.yxkj.function.tp.Entity.Insurance;

@Component
public interface InsuranceElseMapper {
	
	@Select("select * from tp3_insurance where worker_number = #{workerNumber}")
	public List<Map<String, Object>> listInsuance(@Param("workerNumber")String workerNumber, @Param("status")Integer status);
	
	@Select("select count(0) count, insurance_name from tp3_ensure_insurace_relation GROUP BY insurance_name")
	public List<Map<String, Object>> typeInsure(); 
	
	@Select("select * from tp3_insurance where worker_number = #{workerNumber} and insured_person_name = #{insured_person_name}")
	public List<Map<String, Object>> listSomeOneInsuance(@Param("workerNumber")String workerNumber,@Param("insured_person_name")String insured_person_name, @Param("status")Integer status);
	
	@Select("select count(0) count, insured_person_name from tp3_insurance where worker_number = #{workerNumber} group by #{insured_person_name}")
	public List<Map<String, Object>> personWithInsure(@Param("workerNumber")String workerNumber,@Param("insured_person_name")String insured_person_name, @Param("status")Integer status);
	
	@Update("")
	void updateInsuraceInfo(Insurance insurance);
	
}

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
	
	
	/**
	 * 根据id查询文件地址
	 * @param 
	 * */
	@Select("select url from tp3_insurance_file where insurance_file_id = #{insurance_file_id}")
	public String urlInfo(@Param("insurance_file_id")Long insurance_file_id);
			
	/**
	 * 查询一份保单包含多少钱
	 * */
	@Select("select sum(money),insurance_name from tp3_ensure_insurace_relation where insurance_name = #{insurance_name} GROUP BY insurance_name")
	public Float sumInsuanceMoney(@Param("insurance_name")String insurance_name);
	
	/***
	 * 查询保单里的金额明细
	 * */
	@Select("select * from tp3_ensure_insurace_relation where insurance_name = #{insurance_name}")
	public List<Map<String, Object>> insuanceTypeTips(@Param("insurance_name")String insurance_name);
	
	/**
	 * 保单详情
	 * */
	@Select("select * from tp3_insurance where insurance_id = #{id}")
	public Map<String, Object> insuanceInfo(@Param("id")Long id, @Param("status")Integer status);
	
	@Select("select * from tp3_insurance where policy_holder_name = #{name}")
	public List<Map<String, Object>> listInsuanceWithName(@Param("name")String name, @Param("status")Integer status);
	
	@Select("select count(0) count, insurance_name from tp3_ensure_insurace_relation GROUP BY insurance_name")
	public List<Map<String, Object>> typeInsure(); 
	
	@Select("select * from tp3_insurance where worker_number = #{workerNumber} and insured_person_name = #{insured_person_name}")
	public List<Map<String, Object>> listSomeOneInsuance(@Param("workerNumber")String workerNumber,@Param("insured_person_name")String insured_person_name, @Param("status")Integer status);
	
	@Select("select count(0) count, policy_holder_name from tp3_insurance where worker_number = #{workerNumber} group by policy_holder_name")
	public List<Map<String, Object>> personWithInsure(@Param("workerNumber")String workerNumber, @Param("status")Integer status);
	
	@Update("UPDATE tp3_insurance SET insurance_number = #{insurance_number}, insurance_type_name = #{insurance_type_name}, insured_creit_card = #{insured_creit_card},	insured_person_name = #{insured_person_name},policy_creit_card = #{policy_creit_card}, policy_holder_name = #{policy_holder_name},  policy_holder_birthday = #{policy_holder_birthday},	sure_num = #{sure_num} WHERE insurance_id = #{insurance_id}")
	void updateInsuraceInfo(Insurance insurance);
	
}

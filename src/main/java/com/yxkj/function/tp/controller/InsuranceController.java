package com.yxkj.function.tp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yxkj.common.eumn.StatusType;
import com.yxkj.common.network.Response;
import com.yxkj.function.tp.Entity.Insurance;
import com.yxkj.function.tp.mapper.other.InsuranceElseMapper;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/api/Insurance")
public class InsuranceController {
	
	@Autowired
	private InsuranceElseMapper InsuranceElseMapper;
	//直接调用mapper
	
	/***
	 * 根据用户查询表单列表
	 * @param workerNumber 工号
	 * 
	 * */
	@ApiIgnore("根据用户查询表单列表")
	@RequestMapping(value="/listresurace")
	public Response listresurace(
			@RequestParam(required = true, value="workerNumber")@RequestAttribute(required = true, value="工号")
			String workerNumber
			) {
		Response response = new Response<>();
		try {
			List<Map<String, Object>> result = new ArrayList<>();
			result = InsuranceElseMapper.listInsuance(workerNumber, StatusType.NORMAL.getCode());
			return response.success(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	/**
	 * 查询保单根据 用户名分组
	 * @param worker_number 工号
	 * @param insured_person_name 被保人姓名
	 * @return list
	 * */
	@ApiIgnore("查询保单根据 用户名分组")
	@RequestMapping(value="/personWithInsure",method=RequestMethod.GET)
	public Response personWithInsure(
			@RequestParam(required = true, value="worker_number")@RequestAttribute(required = true, value="工号")String worker_number
			) {
		Response response = new Response<>();
		try {
			List<Map<String, Object>> result = new ArrayList<>();
			result = InsuranceElseMapper.personWithInsure(worker_number, StatusType.NORMAL.getCode());
			return response.success(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	/**
	 * 根据工号Id查询该人保单
	 * @param worker_number
	 * @param insured_person_name
	 * @return list
	 * */
	@ApiIgnore("根据工号Id查询该人保单")
	@RequestMapping(value="/protectedName")
	public Response protectedName(
			@RequestParam(required = true, value="worker_number")@RequestAttribute(required = true, value="工号")String worker_number,
			@RequestParam(required = true, value="insured_person_name")@RequestAttribute(required = true, value="被保人名字")String insured_person_name
			) {
		Response response = new Response<>();
		try {
			List<Map<String, Object>> result = new ArrayList<>();
			result = InsuranceElseMapper.listSomeOneInsuance(worker_number, insured_person_name,StatusType.NORMAL.getCode());
			return response.success(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	
	/**
	 * 查询所有保单类型
	 * @param 
	 * */
	@ApiIgnore("查询保险类型")
	@RequestMapping(value="/typeInsure",method = RequestMethod.GET)
	public Response typeInsure() {
		Response response = new Response<>();
		try {
			List<Map<String, Object>> result = new ArrayList<>();
			result = InsuranceElseMapper.typeInsure();
			return response.success(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
	/**
	 * 更新保单信息
	 * @author yy
	 * @param
	 * @param
	 * @return
	*/
	@ApiIgnore("更新保单信息")
	@RequestMapping(value="/updateInsuraceInfo",method = RequestMethod.POST)
	public Response updateInsuraceInfo(
			Long insurance_id,
			@RequestParam(required = true, value="insurance_number")@RequestAttribute(required = true, value="单号")String insurance_number,
			String insurance_type_name,
			Integer sure_num,
			String insured_person_name,
			String insured_person_birthday,
			String insured_creit_card,
			String policy_holder_name,
			String policy_holder_birthday,
			String policy_creit_card
			) {
		Response response = new Response<>();
		try {
			Insurance insurance = new Insurance();
			if(null==insurance_id) {
				return response.failure("没有更新的id");
			}
			insurance.setInsurance_id(insurance_id);
			insurance.setInsurance_number(insurance_number);
			insurance.setInsured_creit_card(insured_creit_card);
			insurance.setInsured_person_birthday(insured_person_birthday);
			insurance.setInsured_person_name(insured_person_name);
			insurance.setPolicy_creit_card(policy_creit_card);
			insurance.setPolicy_holder_birthday(policy_holder_birthday);
			insurance.setPolicy_holder_name(policy_holder_name);
			InsuranceElseMapper.updateInsuraceInfo(insurance);
			return response.success();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
}

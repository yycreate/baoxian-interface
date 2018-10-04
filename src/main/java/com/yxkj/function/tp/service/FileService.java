package com.yxkj.function.tp.service;

import com.yxkj.function.tp.Entity.Insurance;
import com.yxkj.function.tp.Entity.InsuranceFile;

public interface FileService {
	
	//保存保单文件信息
	public void createFileRecord(InsuranceFile file) throws Exception;
	//保存文件信息
	public void createInsuranceRecord(Insurance insurance) throws Exception;
}

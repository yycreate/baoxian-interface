package com.yxkj.function.tp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxkj.common.db.DatabaseContextHolder;
import com.yxkj.function.tp.Entity.Insurance;
import com.yxkj.function.tp.Entity.InsuranceFile;
import com.yxkj.function.tp.mapper.InsuranceFileMapper;
import com.yxkj.function.tp.mapper.InsuranceMapper;
import com.yxkj.function.tp.service.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Autowired
	private InsuranceMapper inMapper;
	
	@Autowired
	private InsuranceFileMapper inFileMapper;
	
	@Override
	public void createFileRecord(InsuranceFile file) throws Exception {
		if(file.equals(null)||file.getUrl().equals(null)) {
			throw new Exception("参数不全，文件url不存在");
		}
		if(null==file.getInsurance_file_id()) {
			file.setInsurance_file_id(new Date().getTime());
		}
		inFileMapper.insert(file);
	}

	@Override
	public void createInsuranceRecord(Insurance insurance) throws Exception{
		if(insurance.equals(null)||insurance.getInsurance_id().equals(null)) {
			throw new Exception("参数不全，id或文件id不存在");
		}
		inMapper.insert(insurance);
	}



}

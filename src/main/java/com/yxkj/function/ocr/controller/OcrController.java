package com.yxkj.function.ocr.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.ocr.AipOcr;
import com.yxkj.common.network.Response;
import com.yxkj.common.util.BaseUtil;
import com.yxkj.function.ocr.pojo.OcrConfig;
import com.yxkj.function.ocr.util.OCRConfigUtil;
import com.yxkj.function.tp.Entity.Insurance;
import com.yxkj.function.tp.Entity.InsuranceFile;
import com.yxkj.function.tp.service.FileService;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/ocr")
@Api(value="百度语音识别保单信息")
public class OcrController {
	
	@ApiIgnore(value="描述接口功能 ")
	@RequestMapping(value="/message",method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
	public Response message() {
		return new Response().success("百度语音识别保单信息,v1.0.0");
	}
	
	private Logger logger = LoggerFactory.getLogger(OcrController.class);
    
	//域名
	private String webName = "https://www.pailibaook.com/Uploads/main/"+DateNowStr()+"/";
	
	//上传路径
	private String uploadPath ="C:/wamp64/www/Uploads/main/"+DateNowStr()+"/";
	
	@Autowired
	private FileService fileService;
	
	
	public static String DateNowStr() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String nowdateStr = df.format(d);
		return nowdateStr;
	}
	
	@ApiIgnore("文件上传并读取信息")
	@RequestMapping(value = "/upload/{worderNumber}", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public String upload(@PathVariable(name="worderNumber",required=true) String worderNumber,HttpServletRequest request, @RequestParam(value = "img", required = false) MultipartFile file){
		try {
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		
		//保存保单新信息的id
		Long id = BaseUtil.GetWorkerId();//获取id
		String path = null;
		if(!file.isEmpty()) {
			logger.info("成功获取照片");            
			String fileName = file.getOriginalFilename();            
			String type = null;            
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null; 
			logger.info("图片初始名称为：" + fileName + " 类型为：" + type);            
			if (type != null) {                
			if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {     
			    String realPath = uploadPath;// c:/
			    File filepath = new File(uploadPath);
			    if(!filepath.exists()) {
			    	filepath.mkdirs();
			    }
			    // 自定义的文件名称
			    String trueFileName = new Date().getTime() + fileName;
			    path = realPath + trueFileName;
			    logger.info("存放图片文件的路径:" + path);
			    file.transferTo(new File(path));
			    logger.info("文件成功上传到指定目录下");
			    
			    //保存文件信息
				InsuranceFile fileParams = new InsuranceFile();
				fileParams.setInsurance_file_id(id);
				fileParams.setUrl(webName+trueFileName);
				fileService.createFileRecord(fileParams);
			    
			}else {
				logger.info("不是我们想要的文件类型,请按要求重新上传");
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return "error";
			}
			}else {
				logger.info("文件类型为空");
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return "error";            
			}        
		}else {            
			logger.info("没有找到相对应的文件");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "error";
		}
		//保存保单信息
		Insurance su = new Insurance();
		//读取文件信息
		OcrConfig conf = OCRConfigUtil.getInstance();
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(conf.getAPP_ID(), conf.getAPP_KEY(), conf.getAPP_SECRET());
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", "true");
		options.put("probability", "true");
		JSONObject res = client.accurateGeneral(path, options);
		System.out.println(res.toString(2));
		JSONObject jsonObject = new JSONObject(res.toString(2));
		JSONArray readData = JSONArray.parseArray(jsonObject.get("words_result").toString());
		for (Object object : readData) {
			
			Map<String, Object> aData = (Map<String, Object>) object;
			System.out.println(aData.get("words"));			
			if(BaseUtil.ZZ(aData.get("words").toString(), "^投保人.*")&&!BaseUtil.ZZ(aData.get("words").toString(), "^投保人投保年龄.*")) {
				su.setInsured_person_name(aData.get("words").toString().substring(3));
			}
			if(BaseUtil.ZZ(aData.get("words").toString(), "^被保险人.*")) {
				su.setPolicy_holder_name(aData.get("words").toString().substring(4));
			}
			if(BaseUtil.ZZ(aData.get("words").toString(), "^投保份数.*")) {
				su.setSure_num(Integer.parseInt(aData.get("words").toString().substring(4).split(".00")[0].toString()));
			}
			if(BaseUtil.ZZ(aData.get("words").toString(), "^保险单号.*")) {
				su.setInsurance_number(aData.get("words").toString().substring(4));
			}
			if(BaseUtil.ZZ(aData.get("words").toString(), "^险种名称及款式.*")) {
				su.setInsurance_type_name(aData.get("words").toString().substring(7));
			}
		}
		su.setWorker_number(worderNumber);
		su.setInsurance_id(id);
		su.setFile_id(id);
		fileService.createInsuranceRecord(su);
		}catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return "error";
		}
		
		return "success";
	}
	
	private class ReadImageRunable implements Runnable {
		private String path;
		ReadImageRunable(String path){
			this.path = path;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
	
	//删除文件接口
	
	//修改文件名接口  -- 修改表的文件名
	
	//清除多余文件接口
	
	
	public void test() {
		
		
		
		
	}
	
	//end
	
}

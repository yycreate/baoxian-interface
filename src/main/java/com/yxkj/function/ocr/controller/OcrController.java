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

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
@RequestMapping(value="/ocr")
@Api(value="百度语音识别保单信息")
public class OcrController {
	
	@ApiIgnore(value="描述接口功能")
	@RequestMapping(value="/message")
	public Response message() {
		return new Response().success("百度语音识别保单信息,v1.0.0");
	}
	
	
	@ApiIgnore(value="描述接口功能")
	@RequestMapping(value="/uploadAndRead")
	public Response readImageAndLoadFile() {
		Response response = new Response();
		
		//保存文件到
		
		
		
		//获取文件信息
		OcrConfig conf = OCRConfigUtil.getInstance();
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(conf.getAPP_ID(), conf.getAPP_KEY(), conf.getAPP_SECRET());

		HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
	    options.put("probability", "true");
	    
	    
	    // 参数为本地图片路径
	    String image = "test.jpg";
	    JSONObject res = client.basicAccurateGeneral(image, options);
	    System.out.println(res.toString(2));

	    // 参数为本地图片二进制数组
//	    byte[] file = readImageFile(image);
//	    
//	    res = client.basicAccurateGeneral(file, options);
//	    System.out.println(res.toString(2));
		
		
		return response.failure();
	}
	
	
	@ApiIgnore(value="上传文件测试")
	@RequestMapping(value="/upload01")
	public void uploadTest(HttpServletRequest request, HttpServletResponse response) {
        if (request.getContentLength() > 0) {
               InputStream inputStream = null;
               FileOutputStream outputStream = null;
            try {
                inputStream = request.getInputStream();
                // 给新文件拼上时间毫秒，防止重名
                long now = System.currentTimeMillis();
                File file = new File("c:/", "file-" + now + ".jpg");
                file.createNewFile();
                outputStream = new FileOutputStream(file);
                byte temp[] = new byte[1024];
                int size = -1;
                while ((size = inputStream.read(temp)) != -1) { // 每次读取1KB，直至读完
                    outputStream.write(temp, 0, size);
                }
            } catch (IOException e) {
            	
            } finally {
                try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
                try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
     
        
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
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST) 
	public String upload(HttpServletRequest request, @RequestParam(value = "img", required = false) MultipartFile file){
		try {
		request.setCharacterEncoding("UTF-8");        
		logger.info("执行图片上传");        
		String user = request.getParameter("user");        
		logger.info("user:"+user);
		
		//保存保单新信息的id
		Long id = -1l;
		
		
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
				id = BaseUtil.GetWorkerId();//获取id
				fileParams.setInsurance_file_id(id);
				fileParams.setUrl(webName+trueFileName);
				fileService.createFileRecord(fileParams);
			    
			}else {
				logger.info("不是我们想要的文件类型,请按要求重新上传");
				return "error";
			}
			}else {
				logger.info("文件类型为空");
				return "error";            
			}        
		}else {            
			logger.info("没有找到相对应的文件");
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
				su.setSure_num(Integer.parseInt(aData.get("words").toString().substring(4).split(".0")[0]));
			}
			if(BaseUtil.ZZ(aData.get("words").toString(), "^保险单号.*")) {
				su.setInsurance_number(aData.get("words").toString().substring(4));
			}
			if(BaseUtil.ZZ(aData.get("words").toString(), "^险种名称及款式.*")) {
				su.setInsurance_type_name(aData.get("words").toString().substring(7));
			}
		}
		
		su.setInsurance_id(id);
		su.setFile_id(id);
		fileService.createInsuranceRecord(su);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	//删除文件接口
	
	//修改文件名接口  -- 修改表的文件名
	
	//清除多余文件接口
	
	//end
	
}

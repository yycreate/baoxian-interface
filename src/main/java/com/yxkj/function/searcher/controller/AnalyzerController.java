package com.yxkj.function.searcher.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yxkj.common.network.Response;
import com.yxkj.function.searcher.entity.Analyze.KeyAnalyze;
import com.yxkj.function.searcher.entity.es.GoodsRepository;
import com.yxkj.function.searcher.entity.pojo.Goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 
@Api(value="分析器")
@RestController
@RequestMapping("/api/analyze")
public class AnalyzerController {
	
    @Autowired
    private KeyAnalyze keyAnalyze;
	
    //查询
	@ApiOperation(value="逐字分词")
	@RequestMapping(value="/key",method=RequestMethod.GET)
	public Response query(String keyWork){
		Response response = new Response();
		try {
			keyAnalyze.splitWork(keyWork);
			return response.success();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
}
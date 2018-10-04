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
import com.yxkj.function.searcher.entity.es.GoodsRepository;
import com.yxkj.function.searcher.entity.pojo.Goods;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
 
@Api(value="弹性搜索")
@RestController
@RequestMapping("/es")
public class ElasticSearchController {
	
    @Autowired
    private GoodsRepository gr;
	
	//增加
    @ApiOperation(value="新增索引")
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Response add(){
		Response response = new Response();
		try {
			Goods goods = new Goods();
			goods.setId(6l);
			goods.setName("黑人茶倍健牙膏");
			goods.setCode("00010011");
			goods = gr.save(goods);
			return response.success(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
    //删除
    
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String delete(){
		
		
		
		return "success";
	}
	
    //局部更新
	@RequestMapping(value="/update",method=RequestMethod.PATCH)
	public String update(){
		
		
	
		return "success";
	}
	
    //查询
	@ApiOperation(value="查询索引")
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public Response query(){
		Response response = new Response();
		try {
			List<Map<String, Object>> result = gr.queryGoodsAll();
			return response.success(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.failure();
	}
	
}
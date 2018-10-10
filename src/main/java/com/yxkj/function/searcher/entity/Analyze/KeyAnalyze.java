package com.yxkj.function.searcher.entity.Analyze;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

@Component
public class KeyAnalyze {
	
	@Autowired
    ElasticsearchTemplate elasticsearchTemplate;
	
	
	public void testone(){
		Client client = elasticsearchTemplate.getClient();
		AnalyzeRequest request = new AnalyzeRequest();
		request.text("菜单栏在左侧，你要干什么？");
		
		
	}
	
}

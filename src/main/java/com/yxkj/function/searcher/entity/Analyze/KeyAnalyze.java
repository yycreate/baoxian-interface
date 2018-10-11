package com.yxkj.function.searcher.entity.Analyze;

import java.util.List;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

@Component
public class KeyAnalyze {
	
	@Autowired
    ElasticsearchTemplate elasticsearchTemplate;
	
	
	public void splitWork(String keyWork){
		Client client = elasticsearchTemplate.getClient();
		AnalyzeRequest request = new AnalyzeRequest();
		request.text(keyWork);
		
		ActionFuture<AnalyzeResponse> analyzeResponseActionFuture = client.admin().indices().analyze(request);
		List<AnalyzeResponse.AnalyzeToken> analyzeTokens = analyzeResponseActionFuture.actionGet().getTokens();
		for (AnalyzeResponse.AnalyzeToken analyzeToken : analyzeTokens) {
			System.out.println(analyzeToken.getTerm());
		}
		
	}
	
	
}

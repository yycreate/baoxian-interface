package com.yxkj.function.searcher.mapping.init;

import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.yxkj.function.searcher.mapping.TreatMapping;

@Component
public class CreateMapping {
	
	@Autowired
    ElasticsearchTemplate elasticsearchTemplate;
	
	/**
	 * 新建文档
	 * @param index 例子：cgin
	 * @param type 例子：goods
	 * void
	 * */
	public void puttingMapping(String index, String type) {
		 PutMappingRequest mapping = Requests.putMappingRequest(index).type(type).source(TreatMapping.getMapping());
		 elasticsearchTemplate.getClient().admin().indices().putMapping(mapping).actionGet();
	}
	
	
	/**
	 * 构建索引
	 * @param
	 * @return
	 * */
	public void test() {
		Client client = elasticsearchTemplate.getClient();
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());            
		searchSourceBuilder.aggregation(AggregationBuilders.terms("top_10_states").field("state").size(10));
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("social-*");
		searchRequest.source(searchSourceBuilder);
		ActionFuture<SearchResponse> searchResponse = client.search(searchRequest);
		
		System.out.println(searchResponse);
	}
	
}

package com.yxkj.function.searcher.mapping.init;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.client.Requests;

import com.yxkj.function.searcher.mapping.TreatMapping;

public class CreateMapping {
	
	public void test() {
		 PutMappingRequest mapping = Requests.putMappingRequest("").type("").source(TreatMapping.getMapping());
		  
	}
	
}

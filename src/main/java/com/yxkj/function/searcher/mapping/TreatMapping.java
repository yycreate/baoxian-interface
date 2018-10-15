package com.yxkj.function.searcher.mapping;

import org.elasticsearch.common.xcontent.XContentBuilder;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

public class TreatMapping {

	public static XContentBuilder getMapping() {
		XContentBuilder mapping = null;
		try {
			mapping = jsonBuilder().startObject()
					.startObject("message")
						.startObject("_ttl")
						.field("enabled",false)
						.endObject()
							.startObject("properties")
								.startObject("title")
									.field("type","string")
								.endObject()
								.startObject("question")
									.field("type","string")
									.field("index","not_analyzed")
								.endObject()
								.startObject("answer")
									.field("type","string")
									.field("index","not_analyzed")
								.endObject()
								.startObject("author")
									.field("type","string")
									.field("index","not_analyzed")
								.endObject()
							.endObject()
					.endObject();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping;
	}
	
}

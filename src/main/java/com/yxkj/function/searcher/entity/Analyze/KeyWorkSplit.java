package com.yxkj.function.searcher.entity.Analyze;

import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

@Component
public class KeyWorkSplit extends AbstractIndexAnalyzerProvider<IKAnalyzer>{
	
	

	public KeyWorkSplit(IndexSettings indexSettings, String name, Settings settings) {
		super(indexSettings, name, settings);
		// TODO Auto-generated constructor stub
	}

	@Autowired
    ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public IKAnalyzer get() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}

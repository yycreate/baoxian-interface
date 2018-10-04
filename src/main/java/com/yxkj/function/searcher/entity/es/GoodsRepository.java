package com.yxkj.function.searcher.entity.es;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.visitor.functions.Insert;
import com.yxkj.function.searcher.entity.pojo.Goods;

@Component
public class GoodsRepository implements ElasticsearchRepository<Goods,String>{
	
	@Autowired
    ElasticsearchTemplate elasticsearchTemplate;
	
	public List<Map<String, Object>> queryGoodsAll() {
		Client client = elasticsearchTemplate.getClient();
        // @Document(indexName = "product", type = "book")
        SearchRequestBuilder srb = client.prepareSearch("cgin").setTypes("goods");
        SearchResponse sr = srb.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(); // 查询所有
        SearchHits hits = sr.getHits();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (SearchHit hit : hits) {
            Map<String, Object> source = hit.getSource();
            list.add(source);
            System.out.println(hit.getSourceAsString());
        }
        return list;
	};
	
	@Override
	public Iterable<Goods> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Goods> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Goods> S save(S entity) {
		Client client = elasticsearchTemplate.getClient();
		String source = entity.toString();
	    IndexResponse response = client.prepareIndex("cgin", "goods", "5").setSource(source).get();
		return entity;
	}

	@Override
	public <S extends Goods> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Goods> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Goods> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Goods> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Goods entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Goods> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<Goods> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Goods> S index(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Goods> search(QueryBuilder arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Goods> search(SearchQuery arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Goods> search(QueryBuilder arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Goods> searchSimilar(Goods arg0, String[] arg1, Pageable arg2) {
		// TODO Auto-generated method stub
		return null;
	}

}

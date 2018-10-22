package com.yxkj.function.tp.util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class IKUtil {
	
	private static final CloseableHttpClient httpclient = HttpClients.createDefault();
	
	public static List<String> IKKeyWorks(String text) throws ClientProtocolException, IOException {
		
		HttpPost post = new HttpPost("http://localhost:9200/_analyze?pretty");
		HttpEntity entity = new StringEntity("{\"analyzer\": \"ik_smart\",\"text\": \""+text+"\"}",
				Consts.UTF_8);
		post.setEntity(entity);
		post.setHeader("Content-Type", "application/json");
		HttpResponse response = httpclient.execute(post);
		HttpEntity responseEntity = response.getEntity();
        String result = null;
        result = EntityUtils.toString(responseEntity);
        List<String> keyWorksList = new LinkedList<>();
        JSONObject json = JSONObject.parseObject(result);
        JSONArray keyWorkArray = json.getJSONArray("tokens");
        for (int i=0;i<keyWorkArray.size();i++) {
        	JSONObject itemObj =  JSONObject.parseObject(keyWorkArray.get(i).toString());
        	keyWorksList.add(itemObj.getString("token"));
		}
        return keyWorksList;
	}
	
	
	
	
	
}

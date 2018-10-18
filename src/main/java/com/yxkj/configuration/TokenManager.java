package com.yxkj.configuration;

public interface TokenManager {
	
    String createToken(String username, String mac, Integer userType);
    boolean checkToken(String username, String token);
    void cancelToken(String token);
    void cancelUser(String userName);
    /**
     * 微信检查access_token
     * */
    public String getAccessToken(String key);
    public boolean checkAccessToken(String key);
    public boolean setAccessToken(String key,String token,Long expires);
    public boolean cancelAccessToken(String key);
}

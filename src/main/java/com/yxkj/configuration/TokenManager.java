package com.yxkj.configuration;

public interface TokenManager {

    String createToken(String username, String mac, Integer tenantId, Integer userType);

    boolean checkToken(String username, String token);

    void cancelToken(String token);

    void cancelUser(String userName, Integer tenantId);

    void cancelMac(String mac, Integer tenantId);

    void cancelTenant(Integer tenantId);

}

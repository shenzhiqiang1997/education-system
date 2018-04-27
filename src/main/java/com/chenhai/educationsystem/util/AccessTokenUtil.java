package com.chenhai.educationsystem.util;

import com.chenhai.educationsystem.constant.RequestParameter;
import com.chenhai.educationsystem.constant.RequestURL;
import com.chenhai.educationsystem.dto.AccessTokenJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class AccessTokenUtil {
    @Autowired
    private RestTemplate restTemplate;

    public String getNewestAccessToken(int tryTime)throws Exception{
        try {
            String accessTokenUrl = RequestURL.ACCESS_TOKEN_URL
                    .replace("APPID",RequestParameter.APP_ID)
                    .replace("APPSECRET",RequestParameter.SECRET);
            tryTime--;
            String accessTokenJsonString = restTemplate.getForObject(accessTokenUrl,String.class);
            ObjectMapper mapper = new ObjectMapper();
            AccessTokenJson accessTokenJson = mapper.readValue(accessTokenJsonString,AccessTokenJson.class);
            String accessToken = accessTokenJson.getAccess_token();
            return accessToken;
        } catch (Exception e){
            if (tryTime<=0)
                return null;
            else
                Thread.sleep(200);
                return getNewestAccessToken(tryTime);
        }
    }
}

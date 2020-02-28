package com.cricket.cricket.services;

import com.cricket.cricket.models.MatchInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceHelper {
    ResponseEntity getMatchInfo(String url, HttpMethod httpMethod, HttpEntity<String> entity){
        RestTemplate restTempalte = new RestTemplate();
        ResponseEntity<MatchInfo> responseEntity = restTempalte.exchange(url, HttpMethod.GET, entity, MatchInfo.class);

        return responseEntity;
    }
}

package com.nagarro.camunda.service.impl;

import com.nagarro.camunda.model.GstnResponse;
import com.nagarro.camunda.model.PanResponse;
import com.nagarro.camunda.service.ThirdPartyIntegrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ThirdPartyIntegrationServiceImpl implements ThirdPartyIntegrationService {

    private static final Logger log = LoggerFactory.getLogger(ThirdPartyIntegrationServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public PanResponse getPanDetails(String input) {
        String url = "https://commonapi.mastersindia.co/commonapis/pandetail?pan="+input;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("client_id", "JarZChUcsytSBbnkpt");
        httpHeaders.setBearerAuth("0ab31ef7392227173c6e8d34195e86d5eb0da1e9");
        HttpEntity<PanResponse> entity = new HttpEntity<PanResponse>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, PanResponse.class).getBody();
    }

    @Override
    public GstnResponse getGstnDetails(String input) {
        String url = "https://commonapi.mastersindia.co/commonapis/searchgstin?gstin="+input;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("client_id", "JarZChUcsytSBbnkpt");
        httpHeaders.setBearerAuth("0ab31ef7392227173c6e8d34195e86d5eb0da1e9");
        HttpEntity<GstnResponse> entity = new HttpEntity<GstnResponse>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, GstnResponse.class).getBody();
    }
}

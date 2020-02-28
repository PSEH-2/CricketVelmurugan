package com.cricket.cricket.services;

import com.cricket.cricket.models.MatchInfo;
import com.cricket.cricket.models.MatchMetaInfo;
import com.cricket.cricket.models.Provider;
import com.cricket.cricket.models.ResponseModel;
import jdk.net.SocketFlow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.*;

public class BasicServicesTest {

    @Mock
    ServiceHelper serviceHelper;

    @InjectMocks
    BasicServices basicServices;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getMatchInfoSuccess() throws Exception {

        ResponseEntity<MatchInfo> response = getResponse();
        Mockito.when(serviceHelper.getMatchInfo(Mockito.any(String.class), Mockito.eq(HttpMethod.GET),
                Mockito.eq(getHeaders()))).thenReturn(response);
        ResponseModel responseModel = basicServices.getMatchDetails("uniqueId");
        Assert.assertNotNull(responseModel);
    }

    @Test(expected = ResponseStatusException.class)
    public void getMatchInfoFail() throws Exception {

        Mockito.when(serviceHelper.getMatchInfo(Mockito.any(String.class), Mockito.eq(HttpMethod.GET),
                Mockito.eq(getHeaders()))).thenReturn(getResponseFailed());
        basicServices.getMatchDetails("uniqueId");

    }

    private ResponseEntity<MatchInfo> getResponse() {


        MatchInfo matchInfo = new MatchInfo("India Women won by 18 runs", "Bangladesh Women 124/8 * v India Women 142/6 ", "Bangladesh Women 124/8 * v India Women 142/6 ", true,
                "Bangladesh Women", "India Women",
                "1", 2, new Provider(), 100);
        ResponseEntity<MatchInfo> response = new ResponseEntity<MatchInfo>(matchInfo, HttpStatus.OK);
        return response;
    }

    private ResponseEntity<MatchInfo> getResponseFailed() {


        MatchInfo matchInfo = new MatchInfo("India Women won by 18 runs", "Bangladesh Women 124/8 * v India Women 142/6 ",
                "Bangladesh Women 124/8 * v India Women 142/6 ", true,
                "Bangladesh Women", "India Women",
                "1", 2, new Provider(), 100);

        ResponseEntity<MatchInfo> response = new ResponseEntity<MatchInfo>(matchInfo, HttpStatus.BAD_REQUEST);
        return response;
    }

    private HttpEntity<String> getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", "WmPJrX2s3KMyZVPFwlm1vxXLXKw1");
        return new HttpEntity<String>(headers);
    }
}
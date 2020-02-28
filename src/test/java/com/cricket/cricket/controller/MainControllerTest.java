package com.cricket.cricket.controller;

import com.cricket.cricket.excepitonhandling.ResourceNotFoundException;
import com.cricket.cricket.models.MatchInfo;
import com.cricket.cricket.models.Matches;
import com.cricket.cricket.models.ResponseModel;
import com.cricket.cricket.services.BasicServices;
import com.cricket.cricket.services.CricketServiceException;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.ArgumentMatchers.anyString;


@RunWith (SpringJUnit4ClassRunner.class)
public class MainControllerTest {

    private MockMvc mockMvc;


    @Mock
    BasicServices basicServices;

    @InjectMocks
    MainController mainController;

    @Before
     public void setUp()throws  Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getMatchDetailsSuccess() throws CricketServiceException, ResourceNotFoundException {
        ResponseModel responseModel = new ResponseModel( "team1:India",  "team2: SriLanka", "146/6", "6146/");
        Mockito.when(basicServices.getMatchDetails(Mockito.any(String.class))).thenReturn(responseModel);

        ResponseModel resultModel =mainController.getMatchDetails("12345");

        Assert.assertNotNull(resultModel);

    }

    @Test(expected = ResponseStatusException.class)
    public void getMatchDetailsException() throws CricketServiceException {
        ResponseStatusException responseStatusException = new ResponseStatusException(HttpStatus.BAD_REQUEST,"NOT FOUND");
        Mockito.when(basicServices.getMatchDetails(Mockito.any(String.class))).thenThrow(responseStatusException);
        basicServices.getMatchDetails("uniqueId");

    }

}
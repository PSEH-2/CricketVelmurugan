package com.cricket.cricket.controller;



import com.cricket.cricket.excepitonhandling.ResourceNotFoundException;
import com.cricket.cricket.models.MatchMetaInfo;
import com.cricket.cricket.models.Matches;
import com.cricket.cricket.models.ResponseModel;
import com.cricket.cricket.services.CricketServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.cricket.cricket.models.MatchInfo;
import com.cricket.cricket.services.BasicServices;


@RestController
@RequestMapping("/match")
public class MainController {

    @Autowired
    private BasicServices basicServices;

    @RequestMapping("/status")
    public ResponseModel getMatchDetails(@RequestParam("unique_id") String unique_id) throws ResourceNotFoundException, CricketServiceException {

            ResponseModel responseModel = basicServices.getMatchDetails(unique_id);

        return responseModel;
    }


}

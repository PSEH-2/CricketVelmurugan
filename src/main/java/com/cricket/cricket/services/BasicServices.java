package com.cricket.cricket.services;

import com.cricket.cricket.models.MatchMetaInfo;
import com.cricket.cricket.models.Matches;
import com.cricket.cricket.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.cricket.cricket.models.MatchInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BasicServices {

		@Autowired
		ServiceHelper serviceHelper;

	   public ResponseModel getMatchDetails(String unique_id) throws CricketServiceException {

		   String url = "https://cricapi.com/api/cricketScore?unique_id="+unique_id;
		   HttpHeaders headers = new HttpHeaders();
		   headers.set("apiKey", "WmPJrX2s3KMyZVPFwlm1vxXLXKw1");
		   HttpEntity<String> entity = new HttpEntity<String>(headers);

		   ResponseEntity<MatchInfo> response = serviceHelper.getMatchInfo(url,HttpMethod.GET,entity);


		   ResponseModel responseModel = getResponse(response);


		   if (response.getStatusCode().is2xxSuccessful()) {
			   return responseModel;
			   }else {
			   throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No details Found");
			   }
	   }

//	public ResponseEntity<Matches> getMatchMetaInfo() throws CricketServiceException {
//		String url = "https://cricapi.com/api/matches";
//		final HttpHeaders headers = new HttpHeaders();
//		headers.set("apiKey", "WmPJrX2s3KMyZVPFwlm1vxXLXKw1");
//		final HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//		RestTemplate restTempalte = new RestTemplate();
//		ResponseEntity<Matches> response = restTempalte.exchange(url, HttpMethod.GET, entity, Matches.class);
//
//
//		if (response.getStatusCode().is2xxSuccessful()) {
//			return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
//		}else {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No details found for the given match uniqueId");
//		}
//	}

	private ResponseModel getResponse(ResponseEntity response){
		MatchInfo matchInfo = (MatchInfo) response.getBody();
		String stat = matchInfo.getStat();
		String winningTeam = stat.substring(0,stat.indexOf("won")-1);
		String winnerTag = " (winner)";

		String team1 = matchInfo.getTeam1();
		String team2 = matchInfo.getTeam2();

		if (team1.equals(winningTeam)) {
			team1 = team1 + winnerTag;
		} else if (team1.equals(winningTeam)) {
			team2 = team2 + winnerTag;
		}

		String score = matchInfo.getScore();
		String subScore = score.substring(score.indexOf(winningTeam));
		String winningTeamScore = score;
		Pattern p = Pattern.compile("^*\\d*/\\d*");
		Matcher m = p.matcher(subScore);
		if (m.find()) {
			winningTeamScore = m.group();
		}

		winningTeamScore = winningTeamScore.trim();
		int toBeRotated = winningTeamScore.substring(winningTeamScore.indexOf('/') + 1).length();
		String roundRotation = rightRotate(winningTeamScore, toBeRotated);

		ResponseModel responseModel = new ResponseModel();

		responseModel.setTeam1(team1);
		responseModel.setTeam2(team2);
		responseModel.setWinningTeamSScore(winningTeamScore);
		responseModel.setRoundRotation(roundRotation);

		return responseModel;

	}


	private String leftRotate(String winningTeamScore, int toBeRotated) {
		return winningTeamScore.substring(toBeRotated) + winningTeamScore.substring(0, toBeRotated);
	}

	private String rightRotate(String winningTeamScore, int toBeRotated) {
		return leftRotate(winningTeamScore, winningTeamScore.length() - toBeRotated);
	}


//	public BasicServices getBasicServicesull() throws CricketServiceException {
//
//		return null;
//	}
//
//
//	public BasicServices getBasicServicesException() throws CricketServiceException {
//
//		throw new CricketServiceException();
//	}
}

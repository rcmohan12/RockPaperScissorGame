package com.rcm.app.rps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcm.app.rps.model.ResultModel;
import com.rcm.app.rps.service.GamingService;
import com.rcm.app.rps.service.GamingServiceImpl;

@RestController
public class PlayController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayController.class);
	
	@Autowired
	private GamingService gamingService;

	/**
	 * Rest end point serving each round of the game
	 * 
	 * @param gameVals : Result object sent from client that indicates the game mode (player/computer)
	 * and a pre set player one object defined in case of player mode
	 * @return : Returns Result Model object with both player objects and result of the game
	 */
	@PostMapping(path = "/play", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<?> getGameResult(@RequestBody ResultModel gameVals) {
		LOGGER.info("getGameResult : START");
		ResultModel res = null;
		try {
			if("player".equalsIgnoreCase(gameVals.getGameMode())) {
				res = gamingService.getPlayerModeResult(gameVals);
			} else if ("computer".equalsIgnoreCase(gameVals.getGameMode())) {
				res = gamingService.getComputerModeResult(gameVals);
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOGGER.info("getGameResult : END");
		return ResponseEntity.ok(res);
	}
}

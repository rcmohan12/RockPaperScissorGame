package com.rcm.app.rps.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcm.app.rps.model.ResultModel;
import com.rcm.app.rps.service.GamingService;

@RunWith(SpringRunner.class)
@WebMvcTest
@ComponentScan(basePackages = "com.rcm.app.rps")
@ContextConfiguration(classes = GamingService.class)
public class PlayControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Mock
	private GamingService gameService;
	
	@InjectMocks
	PlayController controller;
	
	ResultModel playerModeVals;
	
	ResultModel computerModeVals;
	
	ResultModel playerModeResults;
	
	ResultModel computerModeResults;
	
	@Before
	public void init() {
		
		computerModeVals = new ResultModel();
		computerModeVals.setGameMode("computer");
		computerModeVals.setPlayerOneObj("");
		computerModeVals.setPlayerTwoObj("");
		computerModeVals.setResult("");
		
		playerModeVals = new ResultModel();
		playerModeVals.setGameMode("player");
		playerModeVals.setPlayerOneObj("ROCK");
		playerModeVals.setPlayerTwoObj("");
		playerModeVals.setResult("");
		
		playerModeResults = new ResultModel();
		playerModeResults.setGameMode("player");
		playerModeResults.setPlayerOneObj("ROCK");
		playerModeResults.setPlayerTwoObj("PAPER");
		playerModeResults.setResult("Player 2 wins");
		
		computerModeResults = new ResultModel();
		computerModeResults.setGameMode("computer");
		computerModeResults.setPlayerOneObj("SCISSOR");
		computerModeResults.setPlayerTwoObj("ROCK");
		computerModeResults.setResult("Player 2 wins");
	}
	
	@Test 
	public void testService() throws Exception {
		
		mvc.perform(post("http://localhost:8080/play")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(playerModeVals))
		.characterEncoding("utf-8"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andReturn();

	}
	
	@Test
	public void testPlayerMode() throws Exception {
		
		when(gameService.getPlayerModeResult(playerModeVals)).thenReturn(playerModeResults);
		when(gameService.getComputerModeResult(computerModeVals)).thenReturn(computerModeResults);
		
		ResponseEntity<?> response = controller.getGameResult(playerModeVals);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("{\"playerOneObj\":\"ROCK\",\"playerTwoObj\":\"PAPER\",\"gameMode\":\"player\",\"result\":\"Player 2 wins\"}", asJsonString(response.getBody()));
		
	}
	
	@Test
	public void testComputerMode() throws Exception {
		
		when(gameService.getPlayerModeResult(playerModeVals)).thenReturn(playerModeResults);
		when(gameService.getComputerModeResult(computerModeVals)).thenReturn(computerModeResults);
		
		ResponseEntity<?> response = controller.getGameResult(computerModeVals);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("{\"playerOneObj\":\"SCISSOR\",\"playerTwoObj\":\"ROCK\",\"gameMode\":\"computer\",\"result\":\"Player 2 wins\"}", asJsonString(response.getBody()));
		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
}

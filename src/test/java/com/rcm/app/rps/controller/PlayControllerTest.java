package com.rcm.app.rps.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rcm.app.rps.service.GamingService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlayControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private GamingService gameService;
	
	@Test
	public void getPlayerModeResult() throws Exception {
		
	}
	
}

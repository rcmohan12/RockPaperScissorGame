package com.rcm.app.rps.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rcm.app.rps.model.ResultModel;

public class GameUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(GameUtils.class);
	
	private static Random numGenerator = new Random();
	
	private static final String PLAYER_ONE_WINS = "Player 1 wins";
	
	private static final String PLAYER_TWO_WINS = "Player 2 wins";
	
	private static final String DRAW = "DRAW";
	
	
	
	public enum Obj {
		ROCK, PAPER, SCISSOR
	}
	
	/**
	 * This method is used to return an ENUM (ROCK,PAPER,SCISSOR) based on random selection
	 * @return
	 */
	public static Obj getObject() {
		LOGGER.info("getObject : START");
		
		int randomNumber = numGenerator.nextInt(300);

		if(randomNumber < 100) {
			LOGGER.info("getObject : END");
			return Obj.ROCK;
		} else if (randomNumber > 99 && randomNumber < 200) {
			LOGGER.info("getObject : END");
			return Obj.PAPER;
		} else {
			LOGGER.info("getObject : END");
			return Obj.SCISSOR;
		}
		
	}
	
	/**
	 * 
	 * This method compares the two players' objects and return winner details
	 * 
	 * @param p1 : player mode object (either user selected or computer generated depending on the game mode)
	 * @param p2 : player 2 object always computer generated
	 * @param res : String val indicating the winner of the game
	 */
	public static void returnResult(Obj p1, Obj p2, ResultModel res) {
		LOGGER.info("returnResult : START");
		
		if(p1.equals(Obj.ROCK) && p2.equals(Obj.PAPER)) {
			res.setResult(PLAYER_TWO_WINS);
		} else if (p1.equals(Obj.PAPER) && p2.equals(Obj.ROCK)) {
			res.setResult(PLAYER_ONE_WINS);
		} else if (p1.equals(Obj.PAPER) && p2.equals(Obj.SCISSOR)) {
			res.setResult(PLAYER_TWO_WINS);
		} else if (p1.equals(Obj.SCISSOR) && p2.equals(Obj.PAPER)) {
			res.setResult(PLAYER_ONE_WINS);
		} else if (p1.equals(Obj.ROCK) && p2.equals(Obj.SCISSOR)) {
			res.setResult(PLAYER_ONE_WINS);
		} else if (p1.equals(Obj.SCISSOR) && p2.equals(Obj.ROCK)) {
			res.setResult(PLAYER_TWO_WINS);
		} else if (p1.equals(p2)) {
			res.setResult(DRAW);
		}
		
		LOGGER.info("returnResult : END");
	}
	
}

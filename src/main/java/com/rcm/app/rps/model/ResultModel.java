package com.rcm.app.rps.model;

public class ResultModel {
	
	private String playerOneObj;
	
	private String playerTwoObj;
	
	private String gameMode;
	
	private String result;
	

	public String getPlayerOneObj() {
		return playerOneObj;
	}

	public void setPlayerOneObj(String playerOneObj) {
		this.playerOneObj = playerOneObj;
	}

	public String getPlayerTwoObj() {
		return playerTwoObj;
	}

	public void setPlayerTwoObj(String playerTwoObj) {
		this.playerTwoObj = playerTwoObj;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

}

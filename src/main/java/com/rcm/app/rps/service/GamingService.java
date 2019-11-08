/**
 * 
 */
package com.rcm.app.rps.service;

import com.rcm.app.rps.model.ResultModel;

/**
 * Service interface to declare methods to handle game actions and outcomes
 * @author rcm
 *
 */
public interface GamingService {

	/**
	 * Get outcome of game when in player mode
	 * @param res : Would contain the player object selected & game mode, expected to be updated with
	 * the computer object and game result
	 * @throws Exception
	 */
	void getPlayerModeResult(ResultModel res) throws Exception; 
	
	/**
	 * Get outcome of game when in computer mode
	 * result model would only contain the game mode ans is expected to be updated with
	 * objects and game result
	 * @param res
	 * @throws Exception
	 */
	void getComputerModeResult(ResultModel res) throws Exception; 
	
}

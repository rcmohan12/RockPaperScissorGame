package com.rcm.app.rps.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rcm.app.rps.model.ResultModel;
import com.rcm.app.rps.utils.GameUtils;
import com.rcm.app.rps.utils.GameUtils.Obj;
/**
 * 
 * 
 * @author rcm
 *
 */
@Component
public class GamingServiceImpl implements GamingService{
	private static final Logger LOGGER = LoggerFactory.getLogger(GamingServiceImpl.class);
	
	@Override
	public void getPlayerModeResult(ResultModel res) throws Exception{
		LOGGER.info("getPlayerModeResult : START");
		
		Obj p1 = Obj.valueOf(res.getPlayerOneObj());
		Obj p2 = GameUtils.getObject();
		res.setPlayerTwoObj(p2.toString());
		GameUtils.returnResult(p1, p2, res);
		
		LOGGER.info("getPlayerModeResult : END");
	}
	
	@Override
	public void getComputerModeResult(ResultModel res) throws Exception{
		LOGGER.info("getComputerModeResult : START");
		
		Obj p1 = GameUtils.getObject();
		Obj p2 = GameUtils.getObject();
		res.setPlayerOneObj(p1.toString());
		res.setPlayerTwoObj(p2.toString());
		GameUtils.returnResult(p1, p2, res);
		
		LOGGER.info("getComputerModeResult : ENDED");
	}

}

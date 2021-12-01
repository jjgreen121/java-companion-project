package com.organization.mvcproject.mgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.mgl.dao.MockDao;
import com.organization.mvcproject.mgl.model.Game;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	MockDao mockDao;
	
	@Override
	public List<Game> retrieveAllGames() {
		return mockDao.retrieveAllGames();
	}

	@Override
	public Game saveGame(Game game) {
		return mockDao.saveGame(game);
	}
	
	@Override
	public Game getGameById(long id) {
		return mockDao.getGameById(id);
	}

}
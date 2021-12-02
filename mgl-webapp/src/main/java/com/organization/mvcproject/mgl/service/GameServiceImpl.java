package com.organization.mvcproject.mgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.dao.MockDao;
import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.api.model.Game;

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
	public Game getGameById(Long id) {
		return mockDao.getGameById(id);
	}
	
	@Override
	public boolean deleteGame(Long id) {
		return mockDao.deleteGame(id);
	}
	
	@Override
	public Game updateGame(Game game, Long id) {
		return mockDao.updateGame(game, id);
	}

}
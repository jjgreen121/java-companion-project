package com.organization.mvcproject.mgl.dao;

import java.util.List;

import com.organization.mvcproject.mgl.model.Game;

public interface MockDao {
	
	List<Game> retrieveAllGames();
	
	Game saveGame(Game game);
	
	Game getGameById(Long id);
	
	boolean deleteGame(Long id);
	
	Game updateGame(Game game, Long id);

}

package com.organization.mvcproject.mgl.dao;

import java.util.List;

import com.organization.mvcproject.mgl.model.Game;

public interface MockDao {
	
	List<Game> retrieveAllGames();
	
	Game saveGame(Game game);

}

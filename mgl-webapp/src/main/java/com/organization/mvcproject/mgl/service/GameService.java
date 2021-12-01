package com.organization.mvcproject.mgl.service;

import java.util.List;

import com.organization.mvcproject.mgl.model.Game;

public interface GameService {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);
	
	Game getGameById(long id);

}

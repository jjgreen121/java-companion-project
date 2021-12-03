package com.organization.mvcproject.mgl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableList;
import com.organization.mvcproject.api.dao.MockDao;
import com.organization.mvcproject.api.model.Game;
import com.organization.mvcproject.mgl.model.GameImpl;

@Repository
public class MockDaoImpl implements MockDao {
	
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<>();

	static {
		games = populateGames();
	}

	private static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setId(++gameId);
		game1.setGenre("Sport");
		game1.setName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setId(++gameId);
		game2.setGenre("Shooter");
		game2.setName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setId(++gameId);
		game3.setGenre("MMORPG");
		game3.setName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	@Override
	public List<Game> retrieveAllGames() {
		return ImmutableList.copyOf(games);
	}

	@Override
	public Game saveGame(Game game) {
		game.setId(++gameId);
		games.add((GameImpl) game);
		return game;
	}
	
	@Override
	public Game getGameById(Long id) {
		for (Game game : games) {
			if (game.getId().equals(id)) return game;
		}
		return null;
	}
	
	@Override
	public boolean deleteGame(Long id) {
		return games.remove(getGameById(id));
	}
	
	@Override
	public Game updateGame(Long id, Game game) {
		Game _game = getGameById(id);
		if (_game != null) {
			_game.setGenre(game.getGenre());
			_game.setName(game.getName());
		}
		return _game;
	}
	
}

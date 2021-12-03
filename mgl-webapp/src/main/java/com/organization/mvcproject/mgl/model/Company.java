
package com.organization.mvcproject.mgl.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.Game;

public class Company {

	private Long id;
	private String name;
	private List<Game> gamesMade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGamesMade() {
		return gamesMade;
	}

	public void setGamesMade(List<Game> gamesMade) {
		this.gamesMade = gamesMade;
	}
}
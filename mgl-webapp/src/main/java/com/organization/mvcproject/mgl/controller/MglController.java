package com.organization.mvcproject.mgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.api.service.GameService;
import com.organization.mvcproject.mgl.model.Game;
import com.organization.mvcproject.mgl.model.ReviewImpl;

@RestController
@RequestMapping("/game")
public class MglController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<List<Game>>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Void> createGame(@RequestBody Game game) {
		gameService.saveGame(game);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGame(@PathVariable("id") Long id) {
		if (gameService.deleteGame(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathVariable("id") Long id) {
		Game update = gameService.updateGame(game, id);
		if (update != null) {
			return new ResponseEntity<>(update, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
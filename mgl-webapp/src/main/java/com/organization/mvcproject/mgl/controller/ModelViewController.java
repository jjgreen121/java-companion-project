package com.organization.mvcproject.mgl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.mgl.model.Game;
import com.organization.mvcproject.mgl.model.ReviewImpl;

@Controller
public class ModelViewController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/review")
	public ModelAndView review() {
		return new ModelAndView("reviewCreatePage", "command", new ReviewImpl());
	}

	@PostMapping("/review")
	public ModelAndView addReview(ReviewImpl review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

	
	@GetMapping("/games")
	public ModelAndView game() {
		return new ModelAndView("gamesPage", "command", new Game());
	}

}

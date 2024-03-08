package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.service.SongsService;

@Controller
public class SongsController {

	@Autowired
	SongsService songsService;

	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Songs song) {

		songsService.addSongs(song);
		return "Admin";
	}

	@GetMapping("/songs")
	public String viewSongs(Model model) {
		List<Songs> songs = songsService.getAllSongs();
		model.addAttribute("songs", songs);
		return "ViewSongs";
	}

	@PostMapping("/playsongs")
	public String playsongs(Model model, User user) {
		if (user.isIspremium()) {
			List<Songs> songList = songsService.getAllSongs();
			model.addAttribute("songs", songList);
			return "ViewSongs";
		} else {
			return "pay";
		}
	}

}

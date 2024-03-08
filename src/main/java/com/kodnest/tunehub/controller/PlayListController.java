package com.kodnest.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.serviceimpl.PlayListServiceImpl;
import com.kodnest.tunehub.serviceimpl.SongsServiceImpl;

@Controller
public class PlayListController {

	@Autowired
	SongsServiceImpl sSI;
	
	@Autowired
	PlayListServiceImpl pSI;
	 
	@GetMapping("/createplaylist")
	public String viewSongs(Model model) {
		List<Songs> songList = sSI.getAllSongs();
		model.addAttribute("songs", songList);
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute PlayList playList,Model model) {
//		pSI.addPlayList(playList);
//		
//		List<Songs> songList = playList.getSongs();
//		for(Songs s : songList ) {
//			s.getPlayList().add(playList);
//			sSI.updateSongs(s);
//		}
//		return "Admin";
		
		  String existingPlaylist = pSI.findByName(playList.getName());
	        if (existingPlaylist != null) {
	            model.addAttribute("error", "Playlist with the same name already exists");
	            return "createplaylist";
	        } else {
	            pSI.addPlayList(playList);
	            
	            List<Songs> songList = playList.getSongs();
	            for (Songs s : songList ) {
	                s.getPlayList().add(playList);
	                sSI.updateSongs(s);
	            }
	            return "Admin";
	        }
		
	}
	
	@GetMapping("/viewplaylist")
	public String viewPlayList(Model model) {
		List<PlayList> pL =  pSI.getPlayList();
		model.addAttribute("playlist", pL);
		return "viewplaylist";
	}
	
	
	@GetMapping("/playlistsongs")
	public String playListSongs(Model model, @RequestParam("playlistId") int playlistId) {
	    PlayList playlist = pSI.getPlayListById(playlistId);
	    List<Songs> songs = playlist.getSongs(); // Assuming the PlayList entity has a getSongs() method

	    model.addAttribute("songs", songs);
	    return "ViewSongs";
	}

	
}

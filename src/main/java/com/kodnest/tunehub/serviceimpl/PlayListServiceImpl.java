package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.repository.PlayListRepository;
import com.kodnest.tunehub.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	PlayListRepository pL;
	
	@Override
	public void addPlayList(PlayList playList) {
		pL.save(playList);  
	}

	@Override
	public List<PlayList> getPlayList() {   
		// TODO Auto-generated method stub
		return pL.findAll();
	}
	
	@Override
	public List<Songs> getPlayListSongs(PlayList playlist) {
		return playlist.getSongs();
	}
	
	@Override
	public PlayList getPlayListById(int playlistId) {
		return pL.findById(playlistId).orElse(null);
	}
	
	@Override
	public String findByName(String name) {
		PlayList playlist = pL.findByName(name);
		return playlist.getName();
	}


	
	



}

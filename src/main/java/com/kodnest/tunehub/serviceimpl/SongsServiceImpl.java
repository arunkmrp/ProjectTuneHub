package com.kodnest.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.Songs;
import com.kodnest.tunehub.repository.SongsRepository;
import com.kodnest.tunehub.service.SongsService;

@Service
public class SongsServiceImpl implements SongsService{

	@Autowired
	SongsRepository songsRepository;
	
	@Override
	public Songs addSongs(Songs song) {
		return songsRepository.save(song);
	}

	@Override
	public List<Songs> getAllSongs() {
		 return songsRepository.findAll();
	}
	
	@Override
	public void updateSongs(Songs s) {
		songsRepository.save(s);
		
	}


}

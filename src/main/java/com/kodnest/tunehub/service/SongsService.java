package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.Songs;

public interface SongsService {

	Songs addSongs(Songs song);

	List<Songs> getAllSongs();

	void updateSongs(Songs s);

}

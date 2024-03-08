package com.kodnest.tunehub.service;

import java.util.List;

import com.kodnest.tunehub.entity.PlayList;
import com.kodnest.tunehub.entity.Songs;

public interface PlayListService {

	void addPlayList(PlayList playList);

	List<PlayList> getPlayList();

	List<Songs> getPlayListSongs(PlayList playlist);

	PlayList getPlayListById(int playlistId);

	String findByName(String name);

}

package com.gn.homework.controller;

import com.gn.homework.model.dao.MusicDao;

public class MusicContorller {
	private MusicDao md = new MusicDao();
	
	public int insertMusicOne(String songTitle, String artistName) {
		int result = md.insertMusicOne(songTitle,artistName);
		return result;
			
	} 
}

package com.gn.homework.controller;

import java.util.List;

import com.gn.homework.model.dao.MusicDao;
import com.gn.homework.model.vo.Music;

public class MusicContorller {
	private MusicDao md = new MusicDao();
	
	// 음악 추가
	public int insertMusicOne(String songTitle, String artistName) {
		int result = md.insertMusicOne(songTitle,artistName);
		return result;
	} 
	// 인기순위조회
	public List<Music> selectMusicTop10(){
		return md.selectMusicTop10();
	}
	// 음악전체조회
	public List<Music> selectMusicAll(){
		return md.selectMusicAll();
	}
	public int musicPlay(int playCount) {
		int result = md.musicPlay(playCount);
		return result;
	}
}

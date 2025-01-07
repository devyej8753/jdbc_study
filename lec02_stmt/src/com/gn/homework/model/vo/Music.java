package com.gn.homework.model.vo;

public class Music {
	private int songNo;
	private String songTitle;
	private String artistName;
	private int playCount;
	
	public Music() {}
	
	public Music(String songTitle,String artistName) {
		this.songTitle = songTitle;
		this.artistName = artistName;
	}
	
	public Music(int songNo, String songTitle, String artistName, int playCount) {
		this.songNo = songNo;
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.playCount = playCount;
	}

	public int getSongNo() {
		return songNo;
	}

	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public int getPlayCount() {
		return playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	@Override
	public String toString() {
		return "음악 [음악번호=" + songNo + ", 음악제목=" + songTitle + ", 아티스트명=" + artistName + ", 재생 횟수="
				+ playCount + "]";
	}
	
	
	
	
}

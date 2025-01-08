package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.homework.model.vo.Music;

public class MusicDao {
	// 음악 추가
	public int insertMusicOne(String songTitle, String artistName) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO wm_song (title,artist_name) "
						+ "VALUES ('"+songTitle+"' ,'"+artistName+"') ";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Music> selectMusicTop10(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Music m = null;
		List<Music> list = new ArrayList<Music>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * "
					+ "FROM wm_song "
					+ "ORDER BY play_count DESC "
					+ "LIMIT 10 ");
			while(rs.next()) {
				m = new Music();
				m.setSongNo(rs.getInt("song_no"));
				m.setSongTitle(rs.getString("title"));
				m.setArtistName(rs.getString("artist_name"));
				m.setPlayCount(rs.getInt("play_count"));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
}

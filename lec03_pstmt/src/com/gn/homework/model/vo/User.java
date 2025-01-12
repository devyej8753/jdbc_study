package com.gn.homework.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
	public User() {}

	public User(String userId , String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}
	
	
	public User(int userNo, String userId, String userPw, String userName, LocalDateTime regDate,
			LocalDateTime modDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
		String regDateStr = dtf.format(regDate);
		String modDateStr = dtf.format(modDate);
		return " [번호 = " + userNo + ", 아이디 = " + userId + ", 비밀번호 = " + userPw + ", 닉네임 = " + userName
				+ ", 회원가입 일 = " + regDateStr + ", 회원정보 수정 일자 = " + modDateStr + "]";
	}
	
	
}

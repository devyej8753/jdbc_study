package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberContorller {
	
	public int MemberSecession(String memberId ,String memberPw) {
		int result = new MemberDao().MemberSecession(memberId ,memberPw);
		return result;
	}
	
	public int updateMemberInfo(String memberName ,String memberPhone ,String memberEmail,String memberId ) {
		int result = new MemberDao().updateMemberInfo(memberName ,memberPhone ,memberEmail,memberId);
		return result;
	}
	
	public Member selectMemberOneByIdAndPw(String memberName ,String memberPw) {
		return new MemberDao().selectMemberOneByIdAndPw(memberName ,memberPw);
		
	}
	
	
	public List<Member> selectKeywordName(String memberName) {
		List<Member> list = new MemberDao().selectKeywordName(memberName);
		return list;
	}
	
	public Member searchMemberOneById(String memberId) {
//		Member m = new MemberDao().searchMemberOneById(memberId);
//		return m;
		return new MemberDao().selectMemberOneById(memberId);
	}
	
	public List<Member> selectMemberAll() {
		List<Member> list = new MemberDao().selectMemberAll();
		return list;
	}
	
	
	public int insertMember(String memberId, String memberPw , String memberName
			,String memberEmail ,String memberPhone ,String memberGender) {
		Member m = new Member(memberId, memberPw,memberName,memberEmail,memberPhone,memberGender);
		
		int result = new MemberDao().insertMember(m);
		return result;

	}
}

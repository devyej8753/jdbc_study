package com.gn.study.controller;

import java.util.List;

import com.gn.study.model.dao.ProjectDao;
import com.gn.study.model.vo.ProjectVo;

public class ProjectController {
	private ProjectDao pd = new ProjectDao();
	
	// 프로젝트 삭제
	public int deleteProjectOne(int deleteNo) {
		int result = pd.deleteProjectOne(deleteNo);
		return result;
	}
	
	
	// 프로젝트 이름 수정
	public int updateProjectOne(int projectNo,String projectName) {
		int result = pd.updateProjectOne(projectNo,projectName);
		return result;
	}
	
	// 프로젝트 담당자 이름 검색
	public List<ProjectVo> searchByManager(String managerName){
		List<ProjectVo> list = pd.searchByManager(managerName);
		return list;
	}
	// 프로젝트 이름 검색
	public List<ProjectVo> selectProjectAllByName(String projectName){
		List<ProjectVo> list = pd.selectProjectAllByName(projectName);
		return list;
	}
	
	// 프로젝트 추가
	public int insertProjectOne(String projectName, String managerName) {
		int result = pd.insertProjectOne(projectName, managerName);
		return result;
	}
	
	public List<ProjectVo> selectProjectAll(){
		List<ProjectVo> list = pd.selectProjectAll();
		return list;
	}
}

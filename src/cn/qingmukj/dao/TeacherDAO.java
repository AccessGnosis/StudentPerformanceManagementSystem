/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: TeacherDAO.java
* Copyright 2017-06-14 By Gnosis. Allright reserved.
* Time: 上午9:10:39
*/
package cn.qingmukj.dao;

import java.util.List;

import cn.qingmukj.domain.TeacherBean;

public interface TeacherDAO {
	public List<TeacherBean> getTeacherInfo(String str);

	public boolean deleteTeacher(String uid);

	public TeacherBean getTeacher(String uid);

	public List<TeacherBean> getTotalTeacherInfo();

	public boolean updateTeacher(List<String> strlist);
	
	public boolean insertTeacher(List<String> strlist);
}

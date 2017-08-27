/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: StudentDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:23:52
*/
package cn.qingmukj.dao;

import java.util.List;

import cn.qingmukj.domain.StudentBean;

public interface StudentDAO {
	public List<StudentBean> getTotalStudentInfo();

	public boolean deleteStudent(String uid);

	public StudentBean getStudent(String uid);

	public boolean updateStudent(List<String> strlist);

	public List<StudentBean> getStudentInfo(String str);

	public boolean insertStudent(List<String> strlist);
}

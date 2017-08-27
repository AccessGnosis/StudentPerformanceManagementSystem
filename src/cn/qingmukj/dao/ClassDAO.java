/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: ClassDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:24:34
*/
package cn.qingmukj.dao;

import java.util.List;

import cn.qingmukj.domain.ClassBean;
import cn.qingmukj.domain.TeachClassBean;

public interface ClassDAO {
	public List<ClassBean> getClassInfo(String str);

	public boolean deleteClass(String uid);

	public ClassBean getClass(String uid);

	public List<ClassBean> getLikedClass(String str);

	public List<ClassBean> getTotalClassInfo();

	public boolean updateClass(List<String> strlist);

	public boolean insertClass(List<String> strlist);
	
	public List<TeachClassBean> selectTeachClass(String tid);
	
}

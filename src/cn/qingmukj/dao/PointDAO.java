/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: PointDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:24:55
*/
package cn.qingmukj.dao;

import java.util.List;

import cn.qingmukj.domain.PointBean;
import cn.qingmukj.domain.PointGenBean;

public interface PointDAO {
	public List<PointGenBean> getPointList();

	public List<PointGenBean> getSinglePointList(String sid);
}

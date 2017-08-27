/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: SettingDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:25:02
*/
package cn.qingmukj.dao;

import java.util.List;

import cn.qingmukj.domain.SettingBean;

public interface SettingDAO {
	public boolean settingDBValue(List list);

	public List<SettingBean> getSettingInfo();
}

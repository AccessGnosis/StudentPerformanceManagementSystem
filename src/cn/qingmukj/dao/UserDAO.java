/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: UserDAO.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:24:01
*/
package cn.qingmukj.dao;

import cn.qingmukj.domain.UserBean;

public interface UserDAO {
	boolean check(String username, String password, String judge);

	boolean updateUser(UserBean user);
}

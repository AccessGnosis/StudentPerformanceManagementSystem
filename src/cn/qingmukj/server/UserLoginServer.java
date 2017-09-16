/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: UserLoginServer.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:36:44
*/
package cn.qingmukj.server;

import cn.qingmukj.dao.UserDAO;
import cn.qingmukj.dao.imp.UserDAOImp;
import cn.qingmukj.domain.UserBean;

public class UserLoginServer {
	public UserBean getLoginState(String username, String password, String judge) {
		// 实例化UserBean对象
		UserBean user = new UserBean();
		// DAO:Data Access Object：操作数据库
		// 实例化UserDAO对象，作用：通过该对象里的方法去对数据库进行CRUD（增删改查）
		UserDAO studao = new UserDAOImp();
		boolean logresult = studao.check(username, password, judge);

		switch (judge) {
		case "stu":
			if (logresult) {
				user.setUid(username);
				user.setUpass(password);
				user.setUauth(judge);
				System.out.println("学生登录成功");
			} else {
				System.out.println("学生登录失败");
			}
			break;
		case "mgr":
			if (logresult) {
				user.setUid(username);
				user.setUpass(password);
				user.setUauth(judge);
				System.out.println("教师登录成功");
			} else {
				System.out.println("教师登录失败");
			}
			break;
		case "admin":
			if (logresult) {
				user.setUid(username);
				user.setUpass(password);
				user.setUauth(judge);
				System.out.println("管理员登录成功");
			} else {
				System.out.println("管理员登录失败");
			}
			break;
		default:
			System.out.println("未正常登录的服务器失败 异常");
			break;
		}

		return user;
	}
}

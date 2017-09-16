/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: UserEditor.java
* Copyright 2017-06-15 By Gnosis. Allright reserved.
* Time: 上午12:17:00
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qingmukj.dao.UserDAO;
import cn.qingmukj.dao.imp.UserDAOImp;
import cn.qingmukj.domain.UserBean;

public class UserEditor extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String auth = req.getParameter("auth");
		
		UserBean user = new UserBean();
		user.setUid(username);
		user.setUpass(password);
		user.setUauth(auth);
		
		UserDAO userdao = new UserDAOImp();
		if(userdao.updateUser(user)){
			System.out.println("修改成功");
			resp.sendRedirect("../../");
		}else{
			System.out.println("修改失败");
			resp.sendRedirect("../../");
		}
	}
}

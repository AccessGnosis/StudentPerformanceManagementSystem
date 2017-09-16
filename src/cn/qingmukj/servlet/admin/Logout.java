/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: Logout.java
* Copyright 2017-06-14 By Gnosis. Allright reserved.
* Time: 下午11:55:50
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.removeAttribute("user");
		System.out.println("aaa");
		resp.sendRedirect("../../");
	}
}

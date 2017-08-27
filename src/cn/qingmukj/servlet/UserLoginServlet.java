/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: UserLoginServlet.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:28:05
*/
package cn.qingmukj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.qingmukj.domain.UserBean;
import cn.qingmukj.server.UserLoginServer;
import cn.qingmukj.util.ConvertStringNumEct;

public class UserLoginServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 通过req对象获取到前台页面输入的用户名、密码和权限值，他们都是String类型的
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String judge = req.getParameter("judge");

		// PrintWriter输出流，将内存中的数据以流的方式显示在页面上
		PrintWriter pw = resp.getWriter(); // 通过PrintWriter对象获取pw流对象
		// pw.println(password + " " + username + " " + judge);

		//
		UserLoginServer uls = new UserLoginServer();
		// 从Server中获取UserBean对象
		// getLoginState()获取到登录状态（成功、失败）
		UserBean user = uls.getLoginState(username, password, judge);

		// 如果UserBean都不为空，则进行不同页面判定
		if (user.getUid() != null && user.getUpass() != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			switch (ConvertStringNumEct.convertJudge(judge)) {
			case 1:
				System.out.println("管理员跳转页面");
				resp.sendRedirect("logined/admin");
				break;
			case 2:
				System.out.println("管理员跳转页面");
				resp.sendRedirect("logined/tech");
				break;
			case 3:
				System.out.println("学生跳转页面");
				resp.sendRedirect("logined/stu");
				break;
			default:
				break;
			}
		} else {
			// 登录失败
			resp.sendRedirect("loginfailed.jsp");
		}

	}

	@Override
	public void destroy() {
		super.destroy();
	}
}

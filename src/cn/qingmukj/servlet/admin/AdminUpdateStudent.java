/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: AdminUpdateStudent.java
* Copyright 2017-06-13 By Gnosis. Allright reserved.
* Time: 下午7:08:01
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qingmukj.dao.StudentDAO;
import cn.qingmukj.dao.imp.StudentDAOImp;
import cn.qingmukj.domain.StudentBean;
import cn.qingmukj.util.JDBCUtil;

public class AdminUpdateStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> strlist = new ArrayList<String>();

		String sid = req.getParameter("sid");
		String sclass = req.getParameter("sclass");
		String sname = req.getParameter("sname");
		String snation = req.getParameter("snation");
		String sgender = req.getParameter("sgender");
		String spolitics = req.getParameter("spolitics");
		String spermanent = req.getParameter("spermanent");
		String sidnum = req.getParameter("sidnum");
		String stele = req.getParameter("stele");
		String sloc = req.getParameter("sloc");
		String sparent1 = req.getParameter("sparent1");
		String sparent1tele = req.getParameter("sparent1tele");
		String sparent2 = req.getParameter("sparent2");
		String sparent2tele = req.getParameter("sparent2tele");
		String sdorm = req.getParameter("sdorm");
		String sremark = req.getParameter("sremark");

		strlist.add(sid);
		strlist.add(sclass);
		strlist.add(sname);
		strlist.add(snation);
		strlist.add(sgender);
		strlist.add(spolitics);
		strlist.add(spermanent);
		strlist.add(sidnum);
		strlist.add(stele);
		strlist.add(sloc);
		strlist.add(sparent1);
		strlist.add(sparent1tele);
		strlist.add(sparent2);
		strlist.add(sparent2tele);
		strlist.add(sdorm);
		strlist.add(sremark);

		StudentDAO studentdao = new StudentDAOImp();
		if (studentdao.updateStudent(strlist)) {
			resp.sendRedirect("admin_select_total_stu.jsp");
		}
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}

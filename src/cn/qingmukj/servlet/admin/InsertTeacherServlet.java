/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: InsertTeacherServlet.java
* Copyright 2017-06-14 By Gnosis. Allright reserved.
* Time: 上午10:20:42
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qingmukj.dao.TeacherDAO;
import cn.qingmukj.dao.imp.TeacherDAOImp;

public class InsertTeacherServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> strlist = new ArrayList<String>();
		
		String tid = req.getParameter("tid");
		String tname = req.getParameter("tname");
		String tedubag = req.getParameter("tedubag");
		String slevel = req.getParameter("slevel");
		String tdepart = req.getParameter("tdepart");
		
		strlist.add(tid);
		strlist.add(tname);
		strlist.add(tedubag);
		strlist.add(slevel);
		strlist.add(tdepart);
		
		TeacherDAO teacherdao = new TeacherDAOImp();
		if(teacherdao.insertTeacher(strlist)){
			resp.sendRedirect("admin_select_total_tech.jsp");
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

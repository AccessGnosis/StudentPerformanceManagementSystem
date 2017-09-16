/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: AdminInsertClass.java
* Copyright 2017-06-15 By Gnosis. Allright reserved.
* Time: 上午10:49:54
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qingmukj.dao.ClassDAO;
import cn.qingmukj.dao.imp.ClassDAOImp;

public class AdminInsertClass extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("cid");
		String cname = req.getParameter("cname");
		String ctimelength = req.getParameter("ctimelength");
		String cloc = req.getParameter("cloc");
		String ctype = req.getParameter("ctype");
		String cpoint = req.getParameter("cpoint");
		String cdesc = req.getParameter("cdesc");

		List<String> strlist = new ArrayList<String>();
		strlist.add(cid);
		strlist.add(cname);
		strlist.add(ctimelength);
		strlist.add(cloc);
		strlist.add(ctype);
		strlist.add(cpoint);
		strlist.add(cdesc);

		ClassDAO classdao = new ClassDAOImp();
		if (classdao.insertClass(strlist)) {
			System.out.println("插入成功");
			resp.sendRedirect("admin_select_total_class.jsp");
		} else {
			System.out.println("插入失败");
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

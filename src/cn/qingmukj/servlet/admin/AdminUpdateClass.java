/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: AdminUpdateClass.java
* Copyright 2017-06-14 By Gnosis. Allright reserved.
* Time: 下午4:51:08
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

public class AdminUpdateClass extends HttpServlet {
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

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
		
		List<String> liststr = new ArrayList<String>();
		liststr.add(cid);
		liststr.add(cname);
		liststr.add(ctimelength);
		liststr.add(cloc);
		liststr.add(ctype);
		liststr.add(cpoint);
		liststr.add(cdesc);
		
		ClassDAO classdao = new ClassDAOImp();
		if(classdao.updateClass(liststr)){
			resp.sendRedirect("admin_select_total_class.jsp");
		}
	}
}

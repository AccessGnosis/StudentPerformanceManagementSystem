/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: InsertStudentServlet.java
* Copyright 2017-06-14 By Gnosis. Allright reserved.
* Time: 上午12:53:35
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qingmukj.dao.StudentDAO;
import cn.qingmukj.dao.imp.StudentDAOImp;
import cn.qingmukj.util.JSONUtil;
import net.sf.json.JSONObject;

public class InsertStudentServlet extends HttpServlet {
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
		String sbirth = req.getParameter("sbirth");
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
		strlist.add(sbirth);
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
		if(studentdao.insertStudent(strlist)){
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

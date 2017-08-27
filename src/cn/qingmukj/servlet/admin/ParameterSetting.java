/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: ParameterSetting.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 下午9:01:15
*/
package cn.qingmukj.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qingmukj.dao.SettingDAO;
import cn.qingmukj.dao.imp.SettingDAOImp;

public class ParameterSetting extends HttpServlet {
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String NationalScholarship = req.getParameter("NationalScholarship");
		String NationalEncouragementScholarship = req.getParameter("NationalEncouragementScholarship");
		String SchoolFirstScholarship = req.getParameter("SchoolFirstScholarship");
		String SchoolSecondScholarship = req.getParameter("SchoolSecondScholarship");
		String SchoolThirdScholarship = req.getParameter("SchoolThirdScholarship");
		String NationalSpecialPoverty = req.getParameter("NationalSpecialPoverty");
		String NationalNormalPoverty = req.getParameter("NationalNormalPoverty");
		
		List<String> strList = new ArrayList<String>();
		strList.add(NationalScholarship);
		strList.add(NationalEncouragementScholarship);
		strList.add(SchoolFirstScholarship);
		strList.add(SchoolSecondScholarship);
		strList.add(SchoolThirdScholarship);
		strList.add(NationalSpecialPoverty);
		strList.add(NationalNormalPoverty);
		
		SettingDAO setting = new SettingDAOImp();
		setting.settingDBValue(strList);
		
		resp.sendRedirect("index.jsp");
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}

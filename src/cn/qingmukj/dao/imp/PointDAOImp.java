/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: PointDAOImp.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:25:51
*/
package cn.qingmukj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qingmukj.dao.PointDAO;
import cn.qingmukj.domain.PointBean;
import cn.qingmukj.domain.PointGenBean;
import cn.qingmukj.util.JDBCUtil;

public class PointDAOImp implements PointDAO {

	@Override
	public List<PointGenBean> getPointList() {
		List<PointGenBean> list = new ArrayList<PointGenBean>();

		String sql1 = "select tb_class.cid, tb_class.cname, tb_stu.sid, tb_stu.sname, tb_point.pgrade, tb_point.psession from tb_class, tb_stu, tb_point where tb_point.sid=tb_stu.sid and tb_class.cid=tb_point.cid;";

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql1);
			rs = pstm.executeQuery();

			while (rs.next()) {
				PointGenBean point = new PointGenBean();
				point.setCid(rs.getString(1));
				point.setCname(rs.getString(2));
				point.setSid(rs.getString(3));
				point.setSname(rs.getString(4));
				point.setSpoint(rs.getString(5));
				point.setSession(rs.getString(6));

				list.add(point);
				point = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return list;
	}

	@Override
	public List<PointGenBean> getSinglePointList(String sid) {
		List<PointGenBean> list = new ArrayList<PointGenBean>();

		String sql1 = "select tb_class.cid, tb_class.cname, tb_stu.sid, tb_stu.sname, tb_point.pgrade, tb_point.psession from tb_class, tb_stu, tb_point where tb_point.sid=tb_stu.sid and tb_class.cid=tb_point.cid and tb_stu.sid=?;";

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql1);
			pstm.setString(1, sid);
			rs = pstm.executeQuery();

			while (rs.next()) {
				PointGenBean point = new PointGenBean();
				point.setCid(rs.getString(1));
				point.setCname(rs.getString(2));
				point.setSid(rs.getString(3));
				point.setSname(rs.getString(4));
				point.setSpoint(rs.getString(5));
				point.setSession(rs.getString(6));

				list.add(point);
				point = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return list;
	}

}

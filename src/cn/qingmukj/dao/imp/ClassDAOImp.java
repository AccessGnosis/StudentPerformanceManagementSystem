/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: ClassDAOImp.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:25:34
*/
package cn.qingmukj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qingmukj.dao.ClassDAO;
import cn.qingmukj.domain.ClassBean;
import cn.qingmukj.domain.TeachClassBean;
import cn.qingmukj.domain.TeacherBean;
import cn.qingmukj.util.JDBCUtil;

public class ClassDAOImp implements ClassDAO {

	@Override
	public List<ClassBean> getClassInfo(String str) {
		List<ClassBean> classes = new ArrayList<ClassBean>();
		ClassBean cclass = new ClassBean();

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_class where cid=? or cname=?;";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, str);
			pstm.setString(2, str);
			rs = pstm.executeQuery();

			while (rs.next()) {
				cclass.setCid(rs.getString(1));
				cclass.setCname(rs.getString(2));
				cclass.setCtimelength(rs.getString(3));
				cclass.setCloc(rs.getString(4));
				cclass.setCtype(rs.getString(5));
				cclass.setCpoint(rs.getString(6));
				cclass.setCdesc(rs.getString(7));

				classes.add(cclass);
				cclass = null;
				cclass = new ClassBean();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return classes;
	}

	@Override
	public boolean deleteClass(String uid) {
		boolean tag = false;

		JDBCUtil jdbcutil = JDBCUtil.getInstance();
		Connection con = jdbcutil.getConnection();
		PreparedStatement pstm1 = null;

		String sql1 = "delete from tb_class where cid=?;";

		try {
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(sql1);
			pstm1.setString(1, uid);
			int re1 = pstm1.executeUpdate();

			if (re1 != 1) {
				throw new SQLException();
			}
			tag = true;
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			jdbcutil.close(con, pstm1);
		}

		return tag;
	}

	@Override
	public ClassBean getClass(String uid) {
		ClassBean cclass = new ClassBean();

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_class where cid=?;";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				cclass.setCid(rs.getString(1));
				cclass.setCname(rs.getString(2));
				cclass.setCtimelength(rs.getString(3));
				cclass.setCloc(rs.getString(4));
				cclass.setCtype(rs.getString(5));
				cclass.setCpoint(rs.getString(6));
				cclass.setCdesc(rs.getString(7));
			} else {
				System.out.println("数据表中没有" + uid + "的数据");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(con, pstm, rs);
		}
		return cclass;
	}

	@Override
	public List<ClassBean> getTotalClassInfo() {
		List<ClassBean> classes = new ArrayList<ClassBean>();
		ClassBean cclass = new ClassBean();

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_class;";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				cclass.setCid(rs.getString(1));
				cclass.setCname(rs.getString(2));
				cclass.setCtimelength(rs.getString(3));
				cclass.setCloc(rs.getString(4));
				cclass.setCtype(rs.getString(5));
				cclass.setCpoint(rs.getString(6));
				cclass.setCdesc(rs.getString(7));

				classes.add(cclass);
				cclass = null;
				cclass = new ClassBean();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return classes;
	}

	@Override
	public boolean updateClass(List<String> strlist) {
		boolean tag = false;

		ClassBean cclass = new ClassBean();
		String sql = "update tb_class set cid=?, cname=?, ctimelength=?, cloc=?, ctype=?, cpoint=?, cdesc=? where cid=?;";

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm1 = null;

		try {
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(sql);

			for (int i = 1; i <= strlist.size(); ++i) {
				if (strlist.get(i - 1) == null) {
					continue;
				}
				pstm1.setString(i, strlist.get(i - 1));
			}
			pstm1.setString(8, strlist.get(0));
			int re1 = pstm1.executeUpdate();

			if (re1 != 1) {
				throw new SQLException();
			}
			tag = true;
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			instance.close(con, pstm1);
		}

		return tag;
	}

	@Override
	public boolean insertClass(List<String> strlist) {
		boolean tag = false;

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;

		String sql = "insert into tb_class values(?, ?, ?, ?, ?, ?, ?);";
		try {
			pstm = con.prepareStatement(sql);

			for (int i = 0; i < strlist.size(); ++i) {
				pstm.setString(i + 1, strlist.get(i));
			}
			int re = pstm.executeUpdate();
			if (re != 1) {
				// 抛异常
				throw new SQLException();
			}
			tag = true;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			util.close(con, pstm);
		}

		return tag;
	}

	@Override
	public List<ClassBean> getLikedClass(String str) {
		ClassBean cclass = null;
		List<ClassBean> classes = new ArrayList<ClassBean>();

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_class where cid=? or cname like '%%" + str + "%%'";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, str);

			rs = pstm.executeQuery();

			while (rs.next()) {
				cclass = new ClassBean();

				cclass.setCid(rs.getString(1));
				cclass.setCname(rs.getString(2));
				cclass.setCtimelength(rs.getString(3));
				cclass.setCloc(rs.getString(4));
				cclass.setCtype(rs.getString(5));
				cclass.setCpoint(rs.getString(6));
				cclass.setCdesc(rs.getString(7));

				classes.add(cclass);

				cclass = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return classes;
	}

	@Override
	public List<TeachClassBean> selectTeachClass(String tid) {
		List<TeachClassBean> list = new ArrayList<TeachClassBean>();

		String sql = "select tb_class.cid, tb_class.cname, tb_teacher.tname, tb_class.cloc from tb_class, tb_teacher, tb_tech_class where tb_class.cid=tb_tech_class.cid and tb_teacher.tid=?;";

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, tid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				TeachClassBean bean = new TeachClassBean();
				bean.setCid(rs.getString(1));
				bean.setCname(rs.getString(2));
				bean.setTname(rs.getString(3));
				bean.setCloc(rs.getString(4));
				list.add(bean);
				bean = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return list;
	}

}

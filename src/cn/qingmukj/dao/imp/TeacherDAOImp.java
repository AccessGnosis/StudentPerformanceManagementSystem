/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: TeacherDAOImp.java
* Copyright 2017-06-14 By Gnosis. Allright reserved.
* Time: 上午9:10:49
*/
package cn.qingmukj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qingmukj.dao.TeacherDAO;
import cn.qingmukj.domain.TeacherBean;
import cn.qingmukj.util.JDBCUtil;

public class TeacherDAOImp implements TeacherDAO {
	public List<TeacherBean> getTeacherInfo(String str) {
		List<TeacherBean> teachers = new ArrayList<TeacherBean>();
		TeacherBean teacher = new TeacherBean();

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_teacher where tid=? or tname=?;";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, str);
			pstm.setString(2, str);
			rs = pstm.executeQuery();

			while (rs.next()) {
				teacher.setUid(rs.getString(1));
				teacher.setTid(rs.getString(2));
				teacher.setTname(rs.getString(3));
				teacher.setTedubag(rs.getString(4));
				teacher.setTlevel(rs.getString(5));
				teacher.setTdepart(rs.getString(6));

				teachers.add(teacher);
				teacher = null;
				teacher = new TeacherBean();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return teachers;
	}

	public boolean deleteTeacher(String uid) {
		boolean tag = false;

		JDBCUtil jdbcutil = JDBCUtil.getInstance();
		Connection con = jdbcutil.getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;

		String sql1 = "delete from tb_user where uid=?;";
		String sql2 = "delete from tb_teacher where tid=?;";

		try {
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(sql1);
			pstm1.setString(1, uid);
			int re1 = pstm1.executeUpdate();

			pstm2 = con.prepareStatement(sql2);
			pstm2.setString(1, uid);
			int re2 = pstm2.executeUpdate();

			if (re1 != re2 || re1 != 1) {
				throw new SQLException();
			}
			tag = true;
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcutil.close(con, pstm1, pstm2);
		}

		return tag;
	}

	@Override
	public TeacherBean getTeacher(String uid) {
		TeacherBean teacher = new TeacherBean();

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_teacher where tid=?;";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				teacher.setUid(rs.getString(1));
				teacher.setTid(rs.getString(2));
				teacher.setTname(rs.getString(3));
				teacher.setTedubag(rs.getString(4));
				teacher.setTlevel(rs.getString(5));
				teacher.setTdepart(rs.getString(6));
			} else {
				System.out.println("数据表中没有" + uid + "的数据");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(con, pstm, rs);
		}
		return teacher;
	}

	@Override
	public List<TeacherBean> getTotalTeacherInfo() {
		List<TeacherBean> list = new ArrayList<TeacherBean>();
		TeacherBean teacher = new TeacherBean();

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_teacher;";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				teacher.setUid(rs.getString(1));
				teacher.setTid(rs.getString(2));
				teacher.setTname(rs.getString(3));
				teacher.setTedubag(rs.getString(4));
				teacher.setTlevel(rs.getString(5));
				teacher.setTdepart(rs.getString(6));

				list.add(teacher);

				teacher = null;
				teacher = new TeacherBean();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return list;
	}

	@Override
	public boolean updateTeacher(List<String> strlist) {
		boolean tag = false;

		TeacherBean teacher = new TeacherBean();
		String sql = "update tb_teacher set uid=?, tid=?, tname=?, tedubag=?, tlevel=?, tdepart=? where tid=?;";
		String sql1 = "update tb_user set uid=? where uid=?;";

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;

		try {
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(sql);

			pstm1.setString(1, strlist.get(0));

			for (int i = 1; i <= strlist.size(); ++i) {
				if (strlist.get(i - 1) == null) {
					continue;
				}
				pstm1.setString(i + 1, strlist.get(i - 1));
			}
			pstm1.setString(7, strlist.get(0));
			int re1 = pstm1.executeUpdate();

			pstm2 = con.prepareStatement(sql1);
			pstm2.setString(1, strlist.get(0));
			pstm2.setString(2, strlist.get(0));
			int re2 = pstm2.executeUpdate();

			if (re1 != re2 || re1 != 1) {
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
			instance.close(con, pstm1, pstm2);
		}

		return tag;
	}

	@Override
	public boolean insertTeacher(List<String> strlist) {
		boolean tag = false;

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;

		String sql = "insert into tb_teacher values(?, ?, ?, ?, ?, ?);";
		String sql1 = "insert into tb_user values(?, '123', '2');";

		try {
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(sql);
			pstm1.setString(1, strlist.get(0));

			for (int i = 1; i <= strlist.size(); ++i) {
				if (strlist.get(i - 1) == null) {
					continue;
				}
				pstm1.setString(i + 1, strlist.get(i - 1));
			}
			int re1 = pstm1.executeUpdate();

			pstm2 = con.prepareStatement(sql1);
			pstm2.setString(1, strlist.get(0));
			int re2 = pstm2.executeUpdate();

			if (re1 != re2 || re1 != 1) {
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
			instance.close(con, pstm1, pstm2);
		}

		return tag;
	}
}

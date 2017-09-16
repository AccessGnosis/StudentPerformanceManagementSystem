/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: StudentDAOImp.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:26:06
*/
package cn.qingmukj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qingmukj.dao.StudentDAO;
import cn.qingmukj.domain.StudentBean;
import cn.qingmukj.util.JDBCUtil;

public class StudentDAOImp implements StudentDAO {
	public List<StudentBean> getTotalStudentInfo() {
		// List——集合
		// List<String>:String类型的集合 Strings
		// List<StudentBean>:StudentBean类型的集合：存放了很多学生StudentBean对象
		List<StudentBean> list = new ArrayList<StudentBean>();
		StudentBean stu = new StudentBean();

		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_stu;";

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				stu.setUid(rs.getString(1));
				stu.setSid(rs.getString(2));
				stu.setSclass(rs.getString(3));
				stu.setSname(rs.getString(4));
				stu.setSnation(rs.getString(5));
				stu.setSgender(rs.getString(6));
				stu.setSbirth(rs.getString(7));
				stu.setSpolitics(rs.getString(8));
				stu.setSpermanent(rs.getString(9));
				stu.setSidnum(rs.getString(10));
				stu.setStele(rs.getString(11));
				stu.setSloc(rs.getString(12));
				stu.setSparent1(rs.getString(13));
				stu.setSparent1tele(rs.getString(14));
				stu.setSparent2(rs.getString(15));
				stu.setSparent2tele(rs.getString(16));
				stu.setSdorm(rs.getString(17));
				stu.setSremark(rs.getString(18));

				list.add(stu);

				stu = null;
				stu = new StudentBean();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(con, pstm, rs);
		}

		return list;
	}

	public boolean deleteStudent(String uid) {
		boolean tag = false;

		JDBCUtil jdbcutil = JDBCUtil.getInstance();
		Connection con = jdbcutil.getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;

		String sql1 = "delete from tb_user where uid=?;";
		String sql2 = "delete from tb_stu where sid=?;";

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
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			jdbcutil.close(con, pstm1, pstm2);
		}

		return tag;
	}

	@Override
	public StudentBean getStudent(String uid) {
		StudentBean student = new StudentBean();

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_stu where sid=?;";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, uid);
			rs = pstm.executeQuery();

			if (rs.next()) {
				student.setUid(rs.getString(1));
				student.setSid(rs.getString(2));
				student.setSclass(rs.getString(3));
				student.setSname(rs.getString(4));
				student.setSnation(rs.getString(5));
				student.setSgender(rs.getString(6));
				student.setSbirth(rs.getString(7));
				student.setSpolitics(rs.getString(8));
				student.setSpermanent(rs.getString(9));
				student.setSidnum(rs.getString(10));
				student.setStele(rs.getString(11));
				student.setSloc(rs.getString(12));
				student.setSparent1(rs.getString(13));
				student.setSparent1tele(rs.getString(14));
				student.setSparent2(rs.getString(15));
				student.setSparent2tele(rs.getString(16));
				student.setSdorm(rs.getString(17));
				student.setSremark(rs.getString(18));
			} else {
				System.out.println("数据表中没有" + uid + "的数据");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(con, pstm, rs);
		}

		return student;
	}

	@Override
	public boolean updateStudent(List<String> strlist) {
		boolean tag = false;

		StudentBean student = new StudentBean();
		String sql = "update tb_stu set uid=?, sid=?, sclass=?, sname=?, snation=?, sgender=?, spolitics=?, spermanent=?, sidnum=?, stele=?, sloc=?, sparent1=?, sparent1tele=?, sparent2=?, sparent2tele=?, sdorm=?, sremark=? where sid=?;";
		String sql1 = "update tb_user set uid=? where uid=?;";

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;

		try {
			// 关闭自动提交事务
			con.setAutoCommit(false);
			pstm1 = con.prepareStatement(sql);

			pstm1.setString(1, strlist.get(0));

			for (int i = 1; i <= strlist.size(); ++i) {
				if (strlist.get(i - 1) == null) {
					continue;
				}
				pstm1.setString(i + 1, strlist.get(i - 1));
			}
			pstm1.setString(18, strlist.get(0));
			int re1 = pstm1.executeUpdate();

			pstm2 = con.prepareStatement(sql1);
			pstm2.setString(1, strlist.get(0));
			pstm2.setString(2, strlist.get(0));
			int re2 = pstm2.executeUpdate();

			// 如果在更新数据库的过程中，不是更新了一行数据
			if (re1 != re2 || re1 != 1) {
				// 抛异常
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
	public List<StudentBean> getStudentInfo(String str) {
		StudentBean student = null;
		List<StudentBean> students = new ArrayList<StudentBean>();

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String sql = "select * from tb_stu where sid=? or sname=?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, str);
			pstm.setString(2, str);
			rs = pstm.executeQuery();

			while (rs.next()) {
				student = new StudentBean();

				student.setUid(rs.getString(1));
				student.setSid(rs.getString(2));
				student.setSclass(rs.getString(3));
				student.setSname(rs.getString(4));
				student.setSnation(rs.getString(5));
				student.setSgender(rs.getString(6));
				student.setSbirth(rs.getString(7));
				student.setSpolitics(rs.getString(8));
				student.setSpermanent(rs.getString(9));
				student.setSidnum(rs.getString(10));
				student.setStele(rs.getString(11));
				student.setSloc(rs.getString(12));
				student.setSparent1(rs.getString(13));
				student.setSparent1tele(rs.getString(14));
				student.setSparent2(rs.getString(15));
				student.setSparent2tele(rs.getString(16));
				student.setSdorm(rs.getString(17));
				student.setSremark(rs.getString(18));

				students.add(student);
				student = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(con, pstm, rs);
		}

		return students;
	}

	@Override
	public boolean insertStudent(List<String> strlist) {
		boolean tag = false;

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;

		String sql = "insert into tb_stu values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		String sql1 = "insert into tb_user values(?, '123', '3');";

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

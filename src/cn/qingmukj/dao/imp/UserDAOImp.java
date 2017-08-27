/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: UserDAOImp.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:26:12
*/
package cn.qingmukj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.qingmukj.dao.UserDAO;
import cn.qingmukj.domain.UserBean;
import cn.qingmukj.util.JDBCUtil;

public class UserDAOImp implements UserDAO {
	public boolean check(String username, String password, String judge) {
		boolean tag = false;

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			if (judge.equals("stu")) {
				String sql = "select * from tb_user where uid = ? and upass = ? and uauth = '3';";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, username);
				pstm.setString(2, password);
				rs = pstm.executeQuery();

				while (rs.next()) {
					tag = true;
					break;
				}
			} else if (judge.equals("mgr")) {
				String sql = "select * from tb_user where uid = ? and upass = ? and uauth = '2';";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, username);
				pstm.setString(2, password);
				rs = pstm.executeQuery();

				while (rs.next()) {
					tag = true;
					break;
				}
			} else if (judge.equals("admin")) {
				String sql = "select * from tb_user where uid = ? and upass = ? and uauth = '1';";
				pstm = con.prepareStatement(sql);
				pstm.setString(1, username);
				pstm.setString(2, password);
				rs = pstm.executeQuery();

				while (rs.next()) {
					tag = true;
					break;
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			instance.close(con, pstm, rs);
		}

		return tag;
	}

	@Override
	public boolean updateUser(UserBean user) {
		boolean tag = false;

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;

		String sql = "update tb_user set uid=?, upass=?, uauth=? where uid=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user.getUid());
			pstm.setString(2, user.getUpass());
			pstm.setString(3, user.getUauth());
			pstm.setString(4, user.getUid());

			int re = pstm.executeUpdate();
			if (re != 1) {
				throw new SQLException();
			}
			tag = true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			instance.close(con, pstm);
		}

		return tag;
	}
}

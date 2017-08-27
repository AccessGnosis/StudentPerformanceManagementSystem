/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: JDBCTest.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 下午2:45:53
*/
package cn.qingmukj.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import cn.qingmukj.util.JDBCUtil;

public class JDBCTest {

	@Test
	public void test() {
		JDBCUtil util = JDBCUtil.getInstance();
		Connection con = util.getConnection();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement("select * from tb_stu;");
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		util.close(con, pstm);
	}

}

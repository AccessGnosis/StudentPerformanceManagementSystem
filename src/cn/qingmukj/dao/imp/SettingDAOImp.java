/**
* Describe: 
* Keyword: 
* Hint: 
* Filename: SettingDAOImp.java
* Copyright 2017-06-12 By Gnosis. Allright reserved.
* Time: 上午9:25:58
*/
package cn.qingmukj.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qingmukj.dao.SettingDAO;
import cn.qingmukj.domain.SettingBean;
import cn.qingmukj.util.JDBCUtil;

public class SettingDAOImp implements SettingDAO {
	public boolean settingDBValue(List list) {
		boolean tag = false;

		Connection con = JDBCUtil.getInstance().getConnection();
		PreparedStatement pstm = null;
		for (int i = 0; i < list.size(); ++i) {
			if ("".equals(list.get(i)) || list.get(i) == "") {
				continue;
			}
			String sql = "UPDATE `tb_setting` SET `setvalue`=? WHERE `setid`=?;";
			try {
				pstm = con.prepareStatement(sql);

				pstm.setString(1, (String) list.get(i));
				pstm.setInt(2, (i + 1));

				pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return tag;
	}

	public List<SettingBean> getSettingValues() {
		List<SettingBean> list = null;
		SettingBean setting = new SettingBean();

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();
		PreparedStatement pstm = null;
		String sql = "select * from tb_setting;";
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				setting.setSetid(rs.getInt(1));
				setting.setSetname(rs.getString(2));
				setting.setSetvalue(rs.getString(3));
				setting.setSetdesc(rs.getString(4));

				list.add(setting);

				setting = null;
				setting = new SettingBean();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(con, pstm, rs);
		}

		return list;
	}

	public List<SettingBean> getSettingInfo() {
		List<SettingBean> list = new ArrayList<SettingBean>();
		SettingBean setting = null;

		JDBCUtil instance = JDBCUtil.getInstance();
		Connection con = instance.getConnection();

		String sql = "select * from tb_setting;";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				setting = new SettingBean();

				setting.setSetid(rs.getInt(1));
				setting.setSetname(rs.getString(2));
				setting.setSetvalue(rs.getString(3));
				setting.setSetdesc(rs.getString(4));

				list.add(setting);
				setting = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance.close(con, pstm, rs);
		}

		return list;
	}
}

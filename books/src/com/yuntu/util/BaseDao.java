package com.yuntu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @Description JDBC数据库连接工具类
 * @version 3.0
 * @date 2018-10-11
 */
public class BaseDao {
	public Connection conn = null;
	public PreparedStatement pstate = null;
	public ResultSet rs = null;

	public BaseDao(Connection conn) {
		this.conn = conn;
	}

	// 增删改工具
	public int executeUpdate(String sql, List<Object> list) {
		int num = 0;
		try {
			//获取statement/preparedstatement对象,执行SQL语句，得到返回结果
			pstate = conn.prepareStatement(sql);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					pstate.setObject((i + 1), list.get(i));
				}
			}
			num = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	// 查询工具
	public ResultSet executeQuery(String sql, List<Object> list) {
		try {
			//获取statement/preparedstatement对象,执行SQL语句，得到返回结果
			pstate = conn.prepareStatement(sql);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					pstate.setObject((i + 1), list.get(i));
				}
			}
			rs = pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}

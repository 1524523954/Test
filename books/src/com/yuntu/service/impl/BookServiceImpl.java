package com.yuntu.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuntu.dao.BookDao;
import com.yuntu.dao.impl.BookDaoImpl;
import com.yuntu.entity.bookentity;
import com.yuntu.service.Bookservlet;
import com.yuntu.util.DataBaseUtil;
import com.yuntu.util.PageUtil;

public class BookServiceImpl implements Bookservlet{

	@Override
	public void getsele_limit(PageUtil pageutil,String sele_type,String sele_gjz) {
		Connection conn = DataBaseUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			BookDao sdao = new BookDaoImpl(conn);
			//pageutil设置总条数 和 总页数
			int countAll = sdao.getCountAll(sele_type,sele_gjz);
			System.out.println(countAll+"COunt");
			pageutil.setTotalCount(countAll);
			if(pageutil.getTotalCount()>0){
				if(pageutil.getPageIndex()>pageutil.getPageCount()){
					pageutil.setPageIndex(pageutil.getPageCount());
				}
				sdao.getsele_limit(pageutil,sele_type,sele_gjz);
			}else{//没有必要去数据库获取
				pageutil.setPageCount(0);
				pageutil.setPageList(new ArrayList<bookentity>());
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
	}

	@Override
	public int delById(int id) {
		int Count= 0;
		Connection conn = DataBaseUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			BookDao sdao = new BookDaoImpl(conn);
			Count = sdao.delById(id);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return Count;
	}

	@Override
	public bookentity seleone(int id) {
		bookentity b = null;
		Connection conn = DataBaseUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			BookDao sdao = new BookDaoImpl(conn);
			b = sdao.seleone(id);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return b;
	}

	@Override
	public int updByid(bookentity b) {
		int Count = 0;
		Connection conn = DataBaseUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			BookDao sdao = new BookDaoImpl(conn);
			Count = sdao.updByid(b);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return Count;
	}

	@Override
	public List<bookentity> getsele_All() {
		List<bookentity> lists = new ArrayList<bookentity>();
		Connection conn = DataBaseUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			BookDao sdao = new BookDaoImpl(conn);
			lists = sdao.getsele_All();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			DataBaseUtil.closeAll(conn, null, null);
		}
		return lists;
	}
}

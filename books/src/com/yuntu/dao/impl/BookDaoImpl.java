package com.yuntu.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuntu.dao.BookDao;
import com.yuntu.entity.bookentity;
import com.yuntu.util.BaseDao;
import com.yuntu.util.DataBaseUtil;
import com.yuntu.util.PageUtil;

public class BookDaoImpl extends BaseDao implements BookDao{

	public BookDaoImpl(Connection conn) {
		super(conn);
	}

	@Override
	public int getCountAll(String sele_type,String sele_gjz) {
		int Count = 0;
		StringBuffer sql = new StringBuffer(" SELECT COUNT(1) FROM books ") ;
		if(sele_type!=null&sele_gjz!=null&sele_type!=""){
			sql.append(" WHERE "+sele_type+" LIKE '%"+sele_gjz+"%' ");
		}
		System.out.println(sele_type);
		System.out.println(sql.toString());
		rs=this.executeQuery(sql.toString(), null);
		try {
			if(rs.next()){
				System.out.println("½øÀ´ÁË");
				Count = rs.getInt(1);
				System.out.println(rs.getInt(1)+"rs");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(null, null, rs);
		}
		return Count;
	}
	@Override
	public void getsele_limit(PageUtil pageutil,String sele_type,String sele_gjz) {
		StringBuffer sql = new StringBuffer(" SELECT * FROM books ");
		ArrayList<Object> list = new ArrayList<Object>();
		if(sele_type!=null&sele_gjz!=null&sele_type!=""){
			sql.append(" WHERE "+sele_type+" LIKE '%"+sele_gjz+"%' ");
		}
		sql.append(" LIMIT ?,?; ");
		list.add((pageutil.getPageIndex()-1)*pageutil.getPageSize());
		list.add(pageutil.getPageSize());
		
		List<bookentity> list2 = new ArrayList<bookentity>();
		rs=this.executeQuery(sql.toString(), list);
		try {
			while(rs.next()){
				bookentity s= new bookentity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
				list2.add(s);
			}
			pageutil.setPageList(list2);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(null, null, rs);
		}
	}

	@Override
	public int delById(int id) {
		String sql = "DELETE FROM `books` WHERE id=?";
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(id);
		return this.executeUpdate(sql, list);
	}

	@Override
	public bookentity seleone(int id) {
		bookentity b = null;
		String sql = "SELECT * FROM `books` WHERE id=? ";
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(id);
		rs=this.executeQuery(sql, list);
		try {
			while(rs.next()){
				b = new bookentity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public int updByid(bookentity b) {
		String sql= " UPDATE books SET bookName=?,bookAuthor=?,publicsher=?,pageCount=?,price=? WHERE id=?";
		ArrayList<Object> list =  new ArrayList<Object>();
		list.add(b.getBookname());
		list.add(b.getBookAuthor());
		list.add(b.getPublicsher());
		list.add(b.getPagecount());
		list.add(b.getPrice());
		list.add(b.getId());
		return this.executeUpdate(sql, list);
	}

	@Override
	public List<bookentity> getsele_All() {
		String sql = "SELECT * FROM books ";
		rs=this.executeQuery(sql, null);
		List<bookentity> lists= new ArrayList<bookentity>();
		try {
			while(rs.next()){
				bookentity b = new bookentity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
				lists.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeAll(null, null, rs);
		}
		return lists;
	}

}

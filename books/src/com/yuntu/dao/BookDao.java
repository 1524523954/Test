package com.yuntu.dao;

import java.util.List;

import com.yuntu.entity.bookentity;
import com.yuntu.util.PageUtil;

public interface BookDao {
	//获取总条数
		public int getCountAll(String sele_type,String sele_gjz);

	// 分页获取学生集合
	public void getsele_limit(PageUtil pageutil,String sele_type,String sele_gjz);
	
	//根据id删除数据
	public int delById(int id);
	
	public bookentity seleone(int id);
	
	//根据id修改book信息
	public int updByid(bookentity b);
	
	public List<bookentity> getsele_All();
}

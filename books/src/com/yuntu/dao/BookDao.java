package com.yuntu.dao;

import java.util.List;

import com.yuntu.entity.bookentity;
import com.yuntu.util.PageUtil;

public interface BookDao {
	//��ȡ������
		public int getCountAll(String sele_type,String sele_gjz);

	// ��ҳ��ȡѧ������
	public void getsele_limit(PageUtil pageutil,String sele_type,String sele_gjz);
	
	//����idɾ������
	public int delById(int id);
	
	public bookentity seleone(int id);
	
	//����id�޸�book��Ϣ
	public int updByid(bookentity b);
	
	public List<bookentity> getsele_All();
}

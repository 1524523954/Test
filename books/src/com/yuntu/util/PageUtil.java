package com.yuntu.util;

import java.util.List;

public class PageUtil {
	//����
	private int pageIndex = 1;//��ǰҳ��
    private int pageSize = 5;//ҳ���С����ÿҳ��ʾ��¼��
    private int pageCount = 0;//��ҳ��
    private int totalCount = 0;//��¼����
    private List pageList;//ÿҳ����
    
    //get set����
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//�ж����������Ƿ�ҳ��С����
		if (totalCount > 0) {
			if (totalCount % pageSize==0) {
				pageCount = totalCount / pageSize;
			}else{
				pageCount = totalCount / pageSize + 1;
			}
		}
	}
	public List getPageList() {
		return pageList;
	}
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}

	
}

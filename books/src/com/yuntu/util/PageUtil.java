package com.yuntu.util;

import java.util.List;

public class PageUtil {
	//属性
	private int pageIndex = 1;//当前页码
    private int pageSize = 5;//页面大小，即每页显示记录数
    private int pageCount = 0;//总页数
    private int totalCount = 0;//记录总数
    private List pageList;//每页集合
    
    //get set方法
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
		//判断新闻总量是否被页大小整除
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

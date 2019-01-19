package com.yuntu.entity;

public class bookentity {
	private int id;
	private String bookname;
	private String bookAuthor;
	private String publicsher;
	private int pagecount;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublicsher() {
		return publicsher;
	}
	public void setPublicsher(String publicsher) {
		this.publicsher = publicsher;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public bookentity(int id, String bookname, String bookAuthor,
			String publicsher, int pagecount, int price) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.bookAuthor = bookAuthor;
		this.publicsher = publicsher;
		this.pagecount = pagecount;
		this.price = price;
	}
	public bookentity() {
		super();
	}
}

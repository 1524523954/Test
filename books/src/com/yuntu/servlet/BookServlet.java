package com.yuntu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yuntu.entity.bookentity;
import com.yuntu.service.Bookservlet;
import com.yuntu.service.impl.BookServiceImpl;
import com.yuntu.util.PageUtil;

public class BookServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		Bookservlet bs = new BookServiceImpl();
		if("login".equals(opr)){
			String page = request.getParameter("pageindex");
			String sele_gjz = request.getParameter("sele_gjz");
			String sele_type = request.getParameter("sele_type");
			if(page==null){
				page="1";
			}
			int pageindex = Integer.parseInt(page);
			if(pageindex<1){
				pageindex=1;
			}
			PageUtil pageutil = new PageUtil();
			pageutil.setPageIndex(pageindex);
			pageutil.setPageSize(3);
			bs.getsele_limit(pageutil,sele_type,sele_gjz);
			
			if(pageutil.getPageList().size()==0){
				out.print("false");
			}else{
				out.print(JSON.toJSONString(pageutil));
			}
		}else if("zhuce".equals(opr)){
			String zcyx = request.getParameter("zcyx");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			if(zcyx!=null && zcyx!=""&&name!=null&&name!="" &&pwd!=null&&pwd!=""){
				if(zcyx.equals("123@qq.com")){
					out.print("该邮箱已被注册！！");
				}else{
					out.print("可以使用！！");
				}
			}else{
				out.print("不能为空！！");
			}
			
		}else if("boolist".equals(opr)){
			List<bookentity> lists=  bs.getsele_All();
			StringBuffer sb = new StringBuffer();
		
			for (int i = 0;i<lists.size();i++) {
				bookentity b = lists.get(i);
				//{"id" :1,"" :"2","" :"3","" :"4" ,"":5, "" :6}
				sb.append("{\"id\" :"+b.getId()+",\"bookname\" :\""+b.getBookname()+"\",\"bookAuthor\" :\""+b.getBookAuthor()+"\",\"publicsher\" :\""+b.getPublicsher()+"\" ,\"pagecount\":"+b.getPagecount()+", \"price\" :"+b.getPrice()+"}");
				sb.append("<li>"+b.getId()+"     "+b.getId()+"</li>");
			}
			out.print(sb);
		}else if("del".equals(opr)){
			String stuid = request.getParameter("stuid");
			String pagecount = request.getParameter("pagecount");
			if(stuid!=null){
				int id = Integer.parseInt(stuid); //要删除的ID
				int pagecount2 = Integer.parseInt(pagecount); //要删除的ID
				//调用业务层的方法
				int flag = bs.delById(id);
				if(flag!=0){
					out.print("{\"opr\" :\"true\",\"pagecount\" :\""+pagecount2+"\"}");
				}else{
					out.print("{\"opr\" :\"false\",\"pagecount\" :\""+pagecount2+"\"}");
				}
			}
		}else if("doupdata".equals(opr)){
			System.out.println("1111111111111111");
			String bookid = request.getParameter("bookid");
			String bookname = request.getParameter("bookname");
			String bookAuthor = request.getParameter("bookAuthor");
			String publicsher = request.getParameter("publicsher");
			String pagecount = request.getParameter("pagecount");
			String price = request.getParameter("price");
			int id = Integer.parseInt(bookid);
			int pagecount1 = Integer.parseInt(pagecount);
			int price1 = Integer.parseInt(price);
			bookentity b = new bookentity(id,bookname,bookAuthor,publicsher,pagecount1,price1);
			int flag = bs.updByid(b);
			if(flag!=0){
				out.print("<script type=\"text/javascript\">alert(\"修改成功\");open(\""+request.getContextPath()+"/index.jsp\",\"_self\");</script>");
				//response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else{
				out.print("<script type='text/javascript'>alert('修改失败');window.history.go(-1);</script>");
				//response.sendRedirect(request.getContextPath()+"/Updata.jsp?id="+b.getId());
			}
		}else if("selone".equals(opr)){
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			bookentity b =  bs.seleone(id);
			//{"id" : 1, "bookname" : "2" ,"bookAuthor" : "3" ,"publicsher" : "4" ,"pagecount" :5 ,"price" :6}
			if(b!=null){
				out.print("{\"id\" : "+b.getId()+", \"bookname\" : \""+b.getBookname()+
						"\" ,\"bookAuthor\" : \""+b.getBookAuthor()+"\" ,\"publicsher\" : \""+b.getPublicsher()+
						"\" ,\"pagecount\" :"+b.getPagecount()+" ,\"price\" :"+b.getPrice()+",\"opr\" : 1}");
			}else{
				out.print("{\"opr\" : 0}");
			}
		}else{
			out.print("真的没有值啊！！");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}

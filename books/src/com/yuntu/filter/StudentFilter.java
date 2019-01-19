package com.yuntu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StudentFilter implements Filter{
	String charStr=null;
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(charStr);
		response.setCharacterEncoding(charStr);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		String charset = fc.getInitParameter("charset");
		if(charset != null && (charset=charset.trim()).length()!=0){
			charStr = charset;
		}
		
	}

}

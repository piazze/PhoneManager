package com.hxzy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	private String encode;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 设置请求和响应的中文编码方式的过滤器
		 */
		request.setCharacterEncoding(encode);
		response.setCharacterEncoding(encode);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		encode = config.getInitParameter("encode");
	}

}

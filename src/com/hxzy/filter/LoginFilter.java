package com.hxzy.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {
	private String exclude;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//判断用户是否登录
		System.out.println("进入loginFilter");
		
		HttpServletRequest req = (HttpServletRequest)request; //将父接口request转换为子接口的对象
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		
		//解析需要放行的特殊的jsp
		String[] split = exclude.split(";");
		
		for (String t : split) {
			if (path.equals(t)) { //如果path是特殊的jsp   login.jsp, register.jsp
				chain.doFilter(req, resp);
				return;
			}
		}
		
		//System.out.println("您访问的资源路径为：" + path);

		//判断用户是否登录
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if (null != user) { //已经登录
			chain.doFilter(request, response);
		} else {
			//获取当前请求的路径
			//   协议 :// 服务器名字:端口号/项目名
			//   http://localhost:8080/PhoneManager
	        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+req.getContextPath();
			
			//重定向到登录页面
			String xmlHttpRequest = req.getHeader("X-Requested-With");
			if ("XMLHttpRequest".equals(xmlHttpRequest)) { //说明这是一次ajax的请求
				//前端需要判断是否是重定向
				resp.setHeader("REDIRECT", "REDIRECT");
	            //需要重定向的路径
				resp.setHeader("CONTENTPATH", basePath+"/login.jsp");
				resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}else {
				resp.sendRedirect("/PhoneManager/login.jsp");
			}
			
			
		}
		
		
		System.out.println("退出loginFilter");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		exclude = config.getInitParameter("exclude");
	}

}

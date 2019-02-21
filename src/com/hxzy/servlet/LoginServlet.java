package com.hxzy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hxzy.bean.User;
import com.hxzy.biz.UserBiz;
import com.hxzy.biz.impl.UserBizImpl;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6566477543955478454L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String loginPwd = request.getParameter("loginPwd");
		
		UserBiz biz = new UserBizImpl();
		User login = biz.login(account, loginPwd);
		if (null != login) { //用户不为空，说明登录成功
			HttpSession session = request.getSession();
			//将用户保存到session
			session.setAttribute("user", login);
			
			//重定向到首页
			response.sendRedirect("index");
		} else {
			//重定向到登录页面
			response.sendRedirect("login.jsp");
		}
	}

	
}

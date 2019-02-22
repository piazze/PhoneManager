package com.hxzy.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet({ "/TestServlet", "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public String userName = "page_admin";
	
    public TestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向request作用域中存放数据
		request.setAttribute("userName", "request_zhangsan");
		
		//向session作用域中存放数据
		HttpSession session = request.getSession();
		session.setAttribute("userName", "session_lisi");
		
		//向application作用域中存放数据
		ServletContext application = request.getServletContext();
		application.setAttribute("userName", "application_wangwu");
		
		request.getRequestDispatcher("/test.jsp").forward(request, response);//页面转发
	}

}

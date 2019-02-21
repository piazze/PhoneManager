package com.hxzy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bean.Phone;
import com.hxzy.biz.PhoneBiz;
import com.hxzy.biz.impl.PhoneBizImpl;

public class IndexServlet extends HttpServlet {

	private PhoneBiz biz = new PhoneBizImpl();
	
	private static final long serialVersionUID = 4594217411682440663L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Phone> list = biz.queryAll();
		//将查询出的list存放到request作用域
		request.setAttribute("list", list);
		
		//页面转发
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	
}

package com.hxzy.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxzy.bean.Brand;
import com.hxzy.bean.Phone;
import com.hxzy.biz.PhoneBiz;
import com.hxzy.biz.impl.PhoneBizImpl;

public class AddPhoneServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8270572657795615796L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求编码方式
		request.setCharacterEncoding("utf-8");
		
		/*Enumeration<String> names = request.getParameterNames();//获取页面中提交的参数的name值
		while (names.hasMoreElements()) {
			String param = names.nextElement();
			System.out.println(param);
		}*/
		 Integer brandId = Integer.valueOf(request.getParameter("brand")); //获取品牌编号
		 String pName = request.getParameter("pName"); //获取手机名称
		 Double price = Double.valueOf(request.getParameter("price")); //获取价格
		 Integer cores = Integer.valueOf(request.getParameter("cores")); //获取品牌编号
		 Integer rom = Integer.valueOf(request.getParameter("rom")); //获取品牌编号
		 Integer ram = Integer.valueOf(request.getParameter("ram")); //获取品牌编号
		 Integer os = Integer.valueOf(request.getParameter("os")); //获取品牌编号
		 Integer count = Integer.valueOf(request.getParameter("count")); //获取品牌编号
		 
		 //将数组主键为java对象
		 Phone phone = new Phone(0, pName, new Brand(brandId), price, cores, ram, rom, os, count, new Date());
		 PhoneBiz biz = new PhoneBizImpl();
		 
		 biz.add(phone);
		 //不管添加是否成功，直接跳转到首页。
		 response.sendRedirect("../index"); //重定向到首页的servlet
	}

	
}

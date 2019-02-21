package com.hxzy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hxzy.bean.Brand;
import com.hxzy.biz.BrandBiz;
import com.hxzy.biz.impl.BrandBizImpl;

public class QueryBrandServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4595744501100133793L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//查询已有的品牌
		BrandBiz biz = new BrandBizImpl();
		List<Brand> list = biz.queryAll();
		/*
		 * 我们需要通过ajax利用异步的方式请求servlet获取所有的品牌信息
		 * ajax是通过JavaScript实现，我们这边的集合是java语言实现。
		 * 我们通过json这种特殊的字符串，将lis集合解析称为json的数据
		 * ajax得到的具有格式的json的数据，在前端再通过循环的方式读取json中的数据。
		 * 
		 * {
		 * 		"key":"value"
		 * }
		 * 
		 * [
		  	{},{},{}
		 * ]
		 * */
		String jsonString = JSON.toJSONString(list);
		response.setCharacterEncoding("utf-8");//设置响应的编码方式
		response.setContentType("application/json");//设置响应类型,告诉客户端我给你的数据是什么类型的。
		response.getWriter().write(jsonString);
		response.getWriter().flush();//手动刷新缓存
	}

	
}

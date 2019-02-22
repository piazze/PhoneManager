package com.hxzy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hxzy.biz.PhoneBiz;
import com.hxzy.biz.impl.PhoneBizImpl;
import com.hxzy.util.DataUtil;

/**
 * Servlet implementation class DeletePhoneServlet
 */
@WebServlet("/servlet/deletePhone")
public class DeletePhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer pId = Integer.valueOf(request.getParameter("pId"));
		
		PhoneBiz biz = new PhoneBizImpl();
		
		int row = biz.remove(pId);
		
		DataUtil util = new DataUtil();
		
		if (row > 0) { //成功
			util.setCode(DataUtil.SUCCESS);
			util.setMsg("删除成功!");
		} else {
			util.setCode(DataUtil.FAIL);
			util.setMsg("删除失败！");
		}
		
		String jsonString = JSON.toJSONString(util);
		
		response.setContentType("application/json");
		response.getWriter().write(jsonString);
		response.getWriter().flush();
	}

}

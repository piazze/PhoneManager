package com.hxzy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.hxzy.bean.User;
import com.hxzy.biz.UserBiz;
import com.hxzy.biz.impl.UserBizImpl;
import com.hxzy.util.DataUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收请求中的参数，account和loginPwd
		String account = request.getParameter("account");
		String loginPwd = request.getParameter("loginPwd");
		
		UserBiz biz = new UserBizImpl();
		int row = biz.add(new User(0, account, loginPwd, 2));
		
		DataUtil util = null;
		if (row > 0) {
			util = new DataUtil(DataUtil.SUCCESS, "注册成功！");
		} else {
			util = new DataUtil(DataUtil.FAIL, "注册失败！");
		}
		
		//将util转换为json
		String jsonString = JSON.toJSONString(util);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(jsonString);
		response.getWriter().flush();
	}

}

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
 * Servlet implementation class ValidateAccountServlet
 */
@WebServlet("/ValidateAccount")
public class ValidateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBiz biz = new UserBizImpl();
		
		String account = request.getParameter("account");
		
		User user = biz.validateAccount(account);
		
		DataUtil util = null;
		if ( null == user ) { //说明账号不存在
			util = new DataUtil(1, "该用户名可以注册"); //状态码1说明可以注册
		} else {
			util = new DataUtil(2, "该用户名已注册"); //状态码2说明该账号已经存在
		}
		
		String jsonStr = JSON.toJSONString(util);
		response.setContentType("application/json");//响应json格式的数据
		response.getWriter().write(jsonStr);
		response.getWriter().flush();
	}

}

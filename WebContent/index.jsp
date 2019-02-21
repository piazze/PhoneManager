<%@page import="com.hxzy.bean.Phone"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet" href="static/css/style.css" />
</head>
<body>
	<%
		List<Phone> list = (List)request.getAttribute("list");
	%>
	<div class="wrap">
		<div class="add clearfix">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
			<a href="add.jsp">新增手机信息</a>
		</div>
		<table cellpadding="0" cellspacing="0">
			<caption>
				<h3>手机信息</h3>
			</caption>
			<tr>
				<td>品牌</td>
				<td>系列</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
			<%
				for(Phone phone : list){
			%>
				<tr>
					<td><%=phone.getBrand().getBrandName() %></td>
					<td><%=phone.getpName() %></td>
					<td><%=phone.getPrice() %></td>
					<td>
						<a href="#">修改</a>
						<a href="#">删除</a>
					</td>
				</tr>		
			<%	}
			%>
		</table>
	</div>
	
</body>
</html>
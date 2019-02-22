<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!-- 引入jstl核心标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
	.red{
		color:red;
	}
	.green{
		color:green;
	}
</style>
</head>
<body>
	<%
		String request_userName = (String)request.getAttribute("userName");
		String session_userName = (String)session.getAttribute("userName");
		String application_userName = (String)application.getAttribute("userName");
		
		pageContext.setAttribute("a", 2);//向page作用域存变量a
		pageContext.setAttribute("b", 2);
	%>
	<%=request_userName %> <br />
	<%=session_userName %><br />
	<%=application_userName %>
	
	<h1>通过EL表达式获取作用域中的对象</h1>
	<p>
		${userName}
	</p>
	<p>
		requestScope:${requestScope.userName}  <!-- 从request作用域中取userName -->
	</p>
	<p>
		sessionScope:${sessionScope.userName } <!-- 从session作用域中取userName -->
	</p>
	<p>
		applicationScope:${applicationScope.userName } <!-- 从application作用域中取userName -->
	</p>
	
	<p>${pageScope.b * pageScope.a }</p>
	<p>
		${a != b ?'T':'F' }
	</p>
	
	<!-- JSTL循环 --> 
	
	<!-- 
		begin:从0开始循环
		step：每次循环变量增量为1
		end：循环结束的索引
	 -->
	<c:forEach begin="0" step="1" end="5" varStatus="status">
		<p 
			<c:if test="${status.index % 2 == 0 }">class="red"</c:if> 
			<c:if test="${status.index % 2 == 1 }">class="green"</c:if> 
		 >${status.index }</p>
	</c:forEach>
</body>
</html>
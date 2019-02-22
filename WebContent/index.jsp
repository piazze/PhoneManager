<%@page import="com.hxzy.bean.Phone"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link rel="stylesheet" href="static/css/style.css" />
<style>
	.bg{
		background: rgba(0,0,0,0.2);/*半透明的背景色*/
	}
</style>

<script type="text/javascript" src="static/js/jquery-1.9.0.js"></script>
<script>
	$(function(){
		
		/*
			大家一定要思考一个问题，虽然在我们的页面中不存在这个问题。
			如果是静态html页面中，通过js生成的标签在jquery   ready()执行后才加载到dom节点
			那么这个a标签在ready()中绑定的单击事件就不会生效。
			
			我们这边能够生效的原因是因为jsp页面需要转换成servlet，在servlet中通过java代码的形式转换为静态的html
			响应给前端浏览器。浏览器在得到html节点时，就已经存在了a标签中的数据，所以能够直接为a标签绑定单击事件。
			
			在静态html中为了解决这个问题，我们不能够直接为a标签绑定单击事件，而是使用$(a).on("click","父级节点",function(){点击a标签后的回调函数})

			*/
		$("td a:last-of-type").click(function(){
			//寻找当前被点击的a标签父级中的隐藏域
			var v = $(this).parent().find(":hidden").val();
			//console.log(v);
			//将要删除的v传递给servlet
			var tr = $(this).parents("tr");//找到a标签的父级tr
			$.ajax({
				url:"http://127.0.0.1:8080/PhoneManager/servlet/deletePhone",
				data:"pId=" + v,
				dataType:"json",
				type:"GET",
				complete:function(XMLHttpRequest, textStatus){
					var redirect = XMLHttpRequest.getResponseHeader("REDIRECT");
					if("REDIRECT" == redirect){ 
						//获取服务器响应回来的路径
						var contentpath = XMLHttpRequest.getResponseHeader("CONTENTPATH");
						window.location.href = contentpath; //通过js实现重定向
					}
				},
				success:function(data){
					$(".modal .content span.info").text(data["msg"]);
					if(data["code"] == 1){
						//成功
						$(".modal .content span.info").addClass("success");
					} else {
						$(".modal .content span.info").addClass("fail");
					}
					//让模态框显示出来
					$(".modal").show(500);
					$(tr).remove(); //删除一行数据
					
					//1秒钟后隐藏模态框
					setTimeout(function() {
						$(".modal").hide(500); //在500毫秒内隐藏模态框
					}, 1000);
				}
				
			});
		});
	})
</script>
</head>
<body>
	
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
			<!-- 相当于java中foreach -->
			<c:forEach items="${requestScope.list}" var="phone" varStatus="status">
			
				<tr 
					<c:if test="${status.index % 2 == 0 }">class="bg"</c:if>
				>
					<td>${phone.brand.brandName }</td>
					<td>${phone.pName }</td>
					<td>${phone.price }</td>
					<td>
						<!-- 通过隐藏域保存每条数据的id -->
						<input type="hidden" value="${phone.pId }" />
						<a href="javascript:void(0)">修改</a>
						<a href="javascript:void(0)">删除</a>
					</td>
				</tr>	
			
			</c:forEach>
				
		</table>
	</div>
	<!-- 模态框 -->
	<div class="modal">
		<div class="mask"></div>
		<div class="content">
			<span class="info"></span>
		</div>
	</div>
	
</body>
</html>
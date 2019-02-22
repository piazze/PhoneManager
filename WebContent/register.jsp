<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link rel="stylesheet" href="static/css/style.css" />
<style>
	td:first-child{
		width: 100px;
	}
	td:last-child {
		text-align: left;
		padding-left: 20px;
	}
	.fail{
		color: red;
	}
	.success{
		color:green;
	}
</style>
<script type="text/javascript" src="static/js/jquery-1.9.0.js"></script>
<script>
	$(function(){
		//用户名文本框失去焦点后触发的函数
		$("input[name='account']").blur(function(){
			$("span.msg").text("");//清空提示信息
			if($(this).val() == ""){
				return;
			}
			
			$.ajax({
				url:"http://127.0.0.1:8080/PhoneManager/ValidateAccount",
				dataType:"json",  //预计服务器会返回的数据的格式
				type:"GET",//请求方式
				data:"account=" + $(this).val(), //发送到服务器的数据
				success:function(data){ //服务器成功执行ajax后的回调函数
					if(data["code"] == 1){
						$("span.msg").addClass("success");
					} else {
						$("span.msg").addClass("fail");
					}
					$("span.msg").text(data["msg"]);
				}
				
			});
		});
		
		$("form").submit(function(event){ //事件源
			event.preventDefault();  //凡是通过ajax实现异步提交数据，都需要阻止表单默认的提交行为
			var flag = true;
			//飞控验证
			$(".wrap :text,.wrap :password").each(function(){
				if($(this).val() == ''){
					alert("请完善数据");
					$(this).focus();//获取焦点
					flag = false;
					return false; //退出each循环
				}
			});
		
			if(!flag){return;}
			
			if($("#loginPwd").val() != $("#confirmPwd").val()){
				alert("两次输入的密码不知一致");
				return; //不去执行return之后的代码
			}
			console.log("--------------------------------------");
			$.ajax({
				url:"http://127.0.0.1:8080/PhoneManager/register",//把数据提交到哪里
				dataType:"json",//服务器响应的数据的类型
				/*
					http://127.0.0.1:8080/PhoneManager/register?account=admin&loginPwd=123
				*/
				data:"account="+$("[name='account']").val() + "&loginPwd=" + $("[name='loginPwd']").val() ,//要发送到数据库的数据
				type:"POST",//提交方式
				success:function(data){ //服务器响应的数据在data中
					$("div.msg").text(data["msg"]);
				}
			});
		
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<form action="#" method="post">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td>用户名</td>
					<td>
						<input type="text" name="account" placeholder="请输入用户名" />
						<span class="msg"></span>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="password" id="loginPwd" name="loginPwd" placeholder="请输入密码" />
					</td>
				</tr>
				<tr>
					<td>确认密码</td>
					<td>
						<input type="password" id="confirmPwd" placeholder="请再次输入密码" />
					</td>
				</tr>
			</table>
			<div class="msg"></div>
			<div class="btn"> 
				<button type="submit">提交</button>
			</div>
		</form>
		
	</div>
</body>
</html>
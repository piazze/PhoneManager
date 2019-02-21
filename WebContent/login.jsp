<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<link rel="stylesheet" href="static/css/style.css" />
</head>
<body>
	<div class="wrap">
		<form action="login" method="post">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td>用户名</td>
					<td>
						<input type="text" name="account" placeholder="请输入用户名" />
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="password" name="loginPwd" placeholder="请输入密码" />
					</td>
				</tr>
			</table>
			<div class="btn"> 
				<button type="submit">提交</button>
			</div>
		</form>
		
	</div>
</body>
</html>
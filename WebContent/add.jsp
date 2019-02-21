<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新增手机信息</title>
<link rel="stylesheet" href="static/css/style.css" />
<script type="text/javascript" src="static/js/jquery-1.9.0.js"></script>
<script type="text/javascript" src="static/js/add.js"></script>

<style>
	td:last-child {
		text-align: left;
		padding-left: 20px;
	}
</style>
</head>
<body>
	<div class="wrap">
		<form action="servlet/addPhone" method="post">
			<table cellpadding="0" cellspacing="0">
				<caption><h3>新增手机信息</h3></caption>
				<tr>
					<td>品牌</td>
					<td>
						<select name="brand" id="brand"></select>
					</td>
				</tr>
				<tr>
					<td>名称</td>
					<td>
						<input type="text" name="pName" />
					</td>
				</tr>
				<tr>
					<td>价格</td>
					<td>
						<input type="text" name="price" />
					</td>
				</tr>
				<tr>
					<td>核心数</td>
					<td>
						<select name="cores">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>RAM</td>
					<td>
						<input type="text" name="ram" />
					</td>
				</tr>
				<tr>
					<td>ROM</td>
					<td>
						<input type="text" name="rom" />
					</td>
				</tr>
				<tr>
					<td>系统</td>
					<td>
						<select name="os">
							<option value="1">安卓</option>
							<option value="2">IOS</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>库存数量</td>
					<td>
						<input type="text" name="count" />
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
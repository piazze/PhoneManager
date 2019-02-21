/**
 * 
 */

$(function(){ /*浏览器加载完成后执行的函数*/
	$.ajax({
		url:"http://127.0.0.1:8080/PhoneManager/servlet/queryBrand",
		dataType:"json",  //预计服务器会返回的数据的格式
		type:"GET",//请求方式
		success:function(data){  //参数data指服务器响应的数据
			for(var item in data){
				//console.log(data[item]);
				$("#brand").append("<option value='"+data[item]["brandId"]+"'>" + data[item]["brandName"] + "</option>");
			}
		}
		
	});
	
	/*表单非空验证*/
	$("form").submit(function(event){
		$("input").each(function(){
			var v = $(this).val();//获取当前input标签的value值
			if(v == ""){
				alert("请完善数据！");
				$(this).focus();//获取焦点
				event.preventDefault(); //阻止事件冒泡，阻止默认行为.   阻止表单提交
				return false;//退出循环
			}
		});
	});
});
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
var pageSize=3;
$(function(){
	queryList(1);
	xiala();
});
 
function xiala(){
	$.ajax({
		url:"<%=request.getContextPath() %>/user/selectxiala",
		type:"post",
		dataType:"json",
		data:{},
		success:function(data){
		 var aa="";
		 for (var i = 0; i < data.length; i++) {
		aa+="<option value='"+data[i].id+"'>"+data[i].carType+"</option>";
		}
		$("#sel").append(aa);
		},
		error:function(){
			alert("请求失败");
		}
	});
}
 
function queryList(pageNum){	  
	var name=$("#name").val();
	var xiala=$("#sel").val();
	var shijian=$("#shijian").val();
	$.post(
			"${pageContext.request.contextPath}/user/queryList",
			{
				"pageNum":pageNum,
				"pageSize":pageSize,
				"uname":name,
				"carid":xiala,
				"buyDate":shijian
							 
			},
			function(data){
				$("#div1").html(data);
			}
		)
	}
</script>
<body>
<a href="${pageContext.request.contextPath}/user/toAdd">新增</a><br>
购买人名称<input id="name"><br>
汽车选择<select id="sel">
							<option value="0">===请选择===</option>
				</select><br>
购买时间<input id="shijian" type="date"><br>
<input type="button" value="搜索" onclick="queryList(1)">
<div id="div1"></div>
</body>
</html>
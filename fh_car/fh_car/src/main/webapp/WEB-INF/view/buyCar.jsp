 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>  
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<body>
<form action="${pageContext.request.contextPath }/user/userAdd" method="post">
购买人名称<input name="uname"><br>
汽车类型	<select name="carid"> 
			<c:forEach items="${list }" var="car">
 					 <option value="${car.id }">${car.carType }</option>
			</c:forEach>
			</select><br>
价格<input name="price"><br>
购买时间<input name="buyDate" type="date"><br>
是否全款<input name="isAllIn" type="radio" value="1">是
				<input name="isAllIn" type="radio" value="2">否<br>
汽车图片  <input type="file" id="file" onchange="uploadFile()" width="150px">
  <input type="hidden" id="imgurl">
<input type="submit">
</form> 
</body>
<script type="text/javascript">
function uploadFile(){
	var form=new FormData();
	form.append("file",$("#file").get(0).files[0]);
	$.ajax({
		contentType:false,
 		processData:false,
		url:"${pageContext.request.contextPath }/user/uploadFile",
		data:form,
		dataType:"json",
		type:"post",
		success:function(res){
			alert(res.aaa);
			var a=res.aaa;
			<%-- $("#divFile").append("<img src='<%=request.getContextPath()%>/"+a+"' width='150px'>") --%>
		   $("#imgurl").val(a);
		},
		error:function(){
			alert("请求失败");
		}
	})
}
</script>
</html>
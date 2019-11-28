<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<table border="1">
<tr>
<td>id</td>
<td>购买人</td>
<td>汽车选择</td>
<td>价格</td>
<td>购买时间</td>
<td>是否全款</td>
<td>图片</td>
<td>删除</td>
</tr>
<c:forEach items="${pager.list }" var="user">
<tr>
<td>${user.id }</td>
<td>${user.uname }</td>
<td>${user.carType }</td>
<td>${user.price }</td>
<td>
<fmt:formatDate value="${user.buyDate }" pattern="yyyy-MM-dd"/>
 </td>
<td>${user.isAllIn==1?"是":"否" }</td>
<td><img alt="" src="http://192.168.134.128:8000/${user.imgUrl }"  style="width: 50px"></td>
 <td>
 <a href="${pageContext.request.contextPath }/user/userdelete?id=${user.id }">删除</a>
 </td>
</tr>

</c:forEach>
</table>
</body>
<jsp:include page="/pager.jsp"></jsp:include>
</html>
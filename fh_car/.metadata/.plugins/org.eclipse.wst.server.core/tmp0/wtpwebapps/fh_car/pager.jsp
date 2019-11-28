<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
 
    	<table border="1" cellpadding="0" cellspacing="0" bgcolor="pink" width="800">
	  		<tr>
	  			<td>
	  			<c:if test="${pager.pageNum==1 }">
	  			首页   上一页
	  			</c:if>
	  			 <c:if test="${pager.pageNum!=1 }">
	  			 <a href="javascript:;" onclick="queryList(1)" >首页</a> 
		       <a href="javascript:;" onclick="queryList(${pager.pageNum}-1)" >上一页</a> 
	  			 </c:if>

               </td>
	  			
	  			<td>当前第${pager.pageNum} 页,总共${pager.totalCount}条，</td>
	  			
	  			<td>跳转到 <input type="number" id="pageNum" style="width:30px">页,总共${pager.totalPage}页
	  			<input type="button" value="跳转" onclick="go()"/></td>
	  			<td>每页显示
	  				<select id="pageSize" onchange="changes()">
	  				     <option value="3"  ${pageSize==3?"selected":"" }>3</option>
			             <option value="5"  ${pageSize==5?"selected":"" }>5</option>
			             <option value="10" ${pageSize==10?"selected":"" }>10</option>
			             <option value="20" ${pageSize==20?"selected":"" }>20</option>
                    </select>
	  			条</td>
	  			
	  			<td>
	  			<c:if test="${pager.pageNum==pager.totalPage||pager.totalPage==0 }">
	  			尾页   下一页
	  			</c:if>
	  			 
			     <c:if test="${pager.pageNum!=pager.totalPage && pager.totalPage!=0 }">
			       <a href="javascript:;" onclick="queryList(${pager.pageNum}+1)" >下一页</a> 
			       <a href="javascript:;" onclick="queryList(${pager.totalPage})" >尾页</a> 
			       </c:if>
			      </td>
	  			
	  		</tr>
	  	</table>
	  	<script type="text/javascript">
 
      function changes(){
       pageSize= $("#pageSize").val();
       queryList(1);
      }
      
      function go(){
       var pageNum = $("#pageNum").val();
       var totalPage =${pager.totalPage};
       if(pageNum >totalPage){
          alert("你输入的值超过总页数！");
       }else if(pageNum <=0){
          alert("你输入的值小于等于0！！！");
       }else{
       queryList(pageNum);
       }
       
      }
      
  </script>
  
	  	  </body>
 
</html>

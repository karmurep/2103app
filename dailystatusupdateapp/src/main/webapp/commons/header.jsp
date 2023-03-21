<%@include file="../imports.jsp"%>
<tr height="80px" align="center">
	<c:if test="${sessionScope.userName==null }">
	
	<td colspan="2"><b><font size=12 color="red">Task Manager App</font></b> </td>
	
	</c:if>
	<c:if test="${sessionScope.userName!=null }">
	
	<td colspan="2"><b><font size=12 color="red">Task Manager App</font></b> </td>
	
	</c:if>
	
	
</tr>
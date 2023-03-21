<%@include file="../imports.jsp"%>
<tr height="50px">
	<td colspan="2" align="center">
		
		<%-- Guest User Navigation --%>
		
		 <c:if test="${sessionScope.aUserId==null }"> 
			<a href=".../userRegistration.jsp">Sign up</a> |
			<a href="../login.jsp">Sign In</a> 
		</c:if>
		
		<%-- LoggedIn User Navigation --%>
		
		 <c:if test="${sessionScope.aUserId!=null }">
		 
			<a href="./PrepareTaskController">Task List</a> |
			<a href="./createTask.jsp">Add Task</a> |
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">Update Profile</a> |
			<a href="./LogoutController">Logout</a> |
			
			<strong>Welcome : ${sessionScope.userName}</strong>
		</c:if>
	</td>
</tr>
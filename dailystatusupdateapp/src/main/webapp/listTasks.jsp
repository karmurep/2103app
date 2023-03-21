<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="imports.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Creation</title>
</head>
<body>

	<table border="1" width="80%" align="center">
		<jsp:include page="./commons/header.jsp" />
		<jsp:include page="./commons/navigation.jsp" />
		<tr height="300px" valign="top" align="center">
			<td colspan="2">
				<h2>List Tasks</h2>
				
				
				<table border="1">
					<tr>
						<th>Task</th>
						<th>Due Date</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					
					
					<c:forEach items="${requestScope.taskList}" var="task">
						<tr>
							<td>${task.task }</td>
							<td>${task.duedate }</td>
							<td>${task.status}</td>
							<td><a href="./EditTaskController?taskId=${task.id}">Edit</a> | <a href="./DeleteTaskController?taskId=${task.id}">Delete</a></td>
						</tr>
					</c:forEach>
					
					
				</table>

			</td>
			
		</tr>
		<jsp:include page="./commons/footer.jsp" />
	</table>



</body>
</html>
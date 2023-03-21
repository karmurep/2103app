<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<tr height="500px" valign="top" align="center">
			<td colspan="2">
				<h2>Add Task</h2>
				<form action="./AddTaskController" method="post">

					<table border="1">

						<tr>
							<td>Due Date</td>
							<td><input type="text" name="duedate" placeholder = "dd/MM/yyyy"/></td>
						</tr>
						
						<tr>
							<td>Task</td>
							<td><input type="text" name="task" placeholder="Add Task...."/></td>
						</tr>

						<tr>
							<td>Status</td>
							<td><select name="status">
								<option value="todo">TODO</option>
								<option value="pending">PENDING</option>
								<option value="completed">Completed</option>
							</select></td>
						</tr>

						<tr>

							<td colspan="2" align="right"><input type="submit"
								value="Add" /></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
		<jsp:include page="./commons/footer.jsp" />
	</table>



</body>
</html>
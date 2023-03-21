<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TaskManager | Login Page</title>
</head>
<body>


	<table border="1" width="80%" align="center">
		<jsp:include page="./commons/header.jsp" />
		<jsp:include page="./commons/navigation.jsp" />
		<tr height="300px" valign="top" align="center">
			<td colspan="2">
				<h2>User Login</h2>
				<form action="./HandleUserAuthenticationController" method="post">

					<table border="1">

						<tr>
							<td>Login Name</td>
							<td><input type="text" name="loginname" /></td>
						</tr>

						<tr>
							<td>Password</td>
							<td><input type="password" name="password" /></td>
						</tr>

						<tr>

							<td colspan="2" align="right">
							<a href="./userRegistration.jsp">Sign up</a> 
							<input type="submit" value="Login" />
							</td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
		<jsp:include page="./commons/footer.jsp" />
	</table>

</body>
</html>
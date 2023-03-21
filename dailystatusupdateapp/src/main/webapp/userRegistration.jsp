<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>

	<table border="1" width="80%" align="center">
		<jsp:include page="./commons/header.jsp" />
		<jsp:include page="./commons/navigation.jsp" />
		<tr height="500px" valign="top" align="center">
			<td colspan="2">
				<h2>User Registration</h2>
				<form action="./HandleUserRegistrationController" method="post">

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

							<td colspan="2" align="right"><input type="submit"
								value="Register" /></td>
						</tr>
					</table>
				</form>

			</td>
		</tr>
		<jsp:include page="./commons/footer.jsp" />
	</table>



</body>
</html>
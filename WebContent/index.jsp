<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>

<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<!-- Load the css file properly : add this -> ${pageContext.request.contextPath}-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="login-card">
			<h1>Log-in</h1>
			<br>
			<form action="login" method="post">
				<input type="text" name="username" required="required" placeholder="Username"> 
				<input type="password" name="userpass" required="required" placeholder="Password">
				<button type="submit" value="Login" class="btn btn-primary">
					login <span class="glyphicon glyphicon-user
"></span>
				</button>
			</form>
			<div class="login-help">
				<a href="#/password">Forgot Password <span
					class="glyphicon glyphicon-lock"></span></a>
			</div>

		</div>
	</div>
</body>
</html>

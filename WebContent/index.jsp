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
<!--link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script-->

<script src="bower_components/jquery/dist/jquery.js"></script>
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.css">
<script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<div class="login-card">
			<h1>Log-in</h1>
			<br>
			<form action="login" method="post">
				<input type="text" name="username" required="required"
					placeholder="Username"> <input type="password"
					name="userpass" required="required" placeholder="Password">
				<button type="submit" value="Login" class="btn btn-primary">
					login <span class="glyphicon glyphicon-user
"></span>
				</button>
			</form>
			<div class="login-help">
				<a href="helper.jsp">Demo Only:login Helper <span
					class="glyphicon glyphicon-lock"></span></a>
			</div>

		</div>

	</div>

</body>
</html>




<!--  
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Tieapp</title>


<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<tieapp-root>Loading...</tieapp-root>
	
	<script type="text/javascript" src="dist/inline.js"></script>
	<script type="text/javascript" src="dist/styles.bundle.js"></script>
	<script type="text/javascript" src="dist/scripts.bundle.js"></script>
	<script type="text/javascript" src="dist/main.bundle.js"></script>
</body>
</html> 

-->

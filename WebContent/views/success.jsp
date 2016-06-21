<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300|Montserrat'
	rel='stylesheet' type='text/css'>


<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

<link rel="stylesheet" href="css/style.css">




</head>

<body>

	<div class="background"></div>
	<div class="container">
		<div class="row">
			<div
				class="modalbox success col-sm-18 col-md-16 col-lg-15 center animate">
				<div class="icon">
					<span class="glyphicon glyphicon-ok"></span>
				</div>
				<!--/.icon-->
				<h1>Success!</h1>
				<p>
					You've sent out the message! <br>to User.
				</p>
				<a href="#/write" class="btn btn-primary">OK <span
					class="glyphicon glyphicon-pencil"></span></a>
					
				
			</div>
			<!--/.success-->
		</div>
		<!--/.row
		<div class="row">
			<div class="modalbox error col-sm-8 col-md-6 col-lg-5 center animate">
				<div class="icon">
					<span class="glyphicon glyphicon-thumbs-down"></span>
				</div>
				
				<h1>Oh no!</h1>
				<p>
					Oops! Something went wrong, <br> you should try again.
				</p>
				<button type="button" class="redo btn">Try again</button>
				<span class="change">-- Click to see opposite state --</span>
			</div>
			
		</div>
		row-->
	</div>
	<!--/.container-->
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>




</body>
</html>
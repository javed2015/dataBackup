<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap core CSS -->
<link href="styles/bootstrap.min.css" rel="stylesheet">
<link href="styles/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="styles/style.css?t=3" rel="stylesheet">
</head>
<title>VOTSH VSERVER</title>
<body class="login-body">
	<div class="container">
		<form class="form-registration" id="vinform" name="vinform"
			method="post" action="registration.jsp">
			<div class="form-signin-heading form-registration-heading">VOTSH
				Registration</div>
			<div class="registration-wrap">
				<div class="row">
					<div class="left">
						<label for="first-name">First Name</label>
					</div>
					<div class="right">
						<label for="last-name">Last Name</label>
					</div>
				</div>
				<div class="row">
					<div class="left">
						<input type="text" class="form-control" placeholder=""
							name="fname" id="fname" autofocus>
					</div>
					<div class="right">
						<input type="text" class="form-control" placeholder=""
							name="lname" id="lname" autofocus>
					</div>
				</div>
				<div class="row">
					<div class="left">
						<label for="email">Email Address</label>
					</div>
					<div class="right">
						<label for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="left">
						<input type="email" class="form-control" placeholder=""
							name="email" id="email" autofocus>
					</div>
					<div class="right">
						<input type="password" class="form-control" placeholder=""
							name="pass" id="pass" autofocus>
					</div>
				</div>
				<!-- <div class="row">
					<div class="left"><label for="project-selection">Projects</label><br></div>
				</div>
	            <div class="row">
					<div class="left"><input type="checkbox" name="project" id="project1" value="1" class="projectcheck">&nbsp;Instant Win </div>
					<div class="right"><input type="checkbox" name="project" value="2" class="checkproject projectcheck">&nbsp;Wordpress Defender<br></div>
				</div> -->
				<div class="row">
					<div class="left">
						<label for="first-name">GIT HUB User-Id</label>
					</div>
					<div class="right">
						<label for="last-name">GIT HUB Password</label>
					</div>
				</div>
				<div class="row">
					<div class="left">
						<input type="text" name="github-uname" class="form-control"
							id="github-uname">
					</div>
					<div class="right">
						<input type="password" name="github-password" class="form-control"
							id="github-password">
					</div>
				</div>
				<input class="btn btn-lg btn-login btn-registration btn-block"
					type="button" value="Register"><br> <a class="aux-btn"
					href="index.jsp">Sign In</a>
			</div>
			<div id="errorMessage" align="center">${message}</div>
		</form>

	</div>
	<script src="scripts/jquery.js"></script>
	<script src="scripts/reg.js"></script>
	<script src="scripts/bootstrap.min.js"></script>
	<script>
		function isEmail(str) {
			var len = str.length;
			if (len > 0) {
				if (isNaN(str.charAt(0)) == false) {
					return false;
				} else {
					var addressPattern = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
					return addressPattern.test(str);
				}
			}
		}
	</script>
</body>
</html>
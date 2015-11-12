<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<jsp:include page="generic.jsp" />
<link rel="stylesheet" href="resources/css/register.css">
<script src="resources/js/lib/jquery-validate/jquery.validate.js"></script>
<script src="resources/js/register.js"></script>
</head>

<body class="login-body">
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="wrapper">
		<form class="register-form" method="POST" role="form">
			<h3 class="form-signup-heading">Please sign up</h3>
			<hr id="line_rb" class="colorgraph">
			<div class="input-group col-xs-12">
				<input type="text" name="firstName" id="firstName"
					class="form-control" placeholder="First Name">
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" type="text" name="lastName"
					id="lastName" placeholder="Last Name">
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" placeholder="E-mail" id="email"
					name="email" type="text">
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" placeholder="Password" id="password"
					name="password" type="password" required>
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" placeholder="Confirm Password"
					id="passwordConfirmation" name="passwordConfirmation"
					type="password" required>
			</div>
			<button id="signUpBtn" class="loginbtn btn btn-lg btn-success btn-block"
				type="submit">Sign up</button>
			<a class="register-suggestion" href="login">Already registered?
				Please, login.</a>
		</form>
	</div>
</body>
</html>
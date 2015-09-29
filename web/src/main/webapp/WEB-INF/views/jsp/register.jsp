<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <jsp:include page="generic.jsp"/>
	<link rel="stylesheet" href="resources/css/register.css">
	<script src="resources/js/lib/jquery-validate/jquery.validate.js"></script>
	<script src="resources/js/register.js"></script>
</head>

<body class="login-body">
<div class="wrapper">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form class="register-form" method="POST" role="form" enctype='application/json'>
			<h3 class="form-signup-heading">Please sign up</h3>
			<hr class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
                        <input type="text" name="firstName" id="firstName" class="form-control" placeholder="First Name" tabindex="1">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="text" name="lastName" id="lastName" class="form-control" placeholder="Last Name" tabindex="2">
					</div>
				</div>
			</div>

			<div class="form-group">
				<input type="email" name="email" id="email" class="form-control" placeholder="Email Address" tabindex="4">
			</div>
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="password" id="password" class="form-control" placeholder="Password" tabindex="5">
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6">
					<div class="form-group">
						<input type="password" name="passwordConfirmation" id="passwordConfirmation" class="form-control" placeholder="Confirm Password" tabindex="6">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-4 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn col-sm-12" data-color="success" tabindex="7">I Agree</button>
                        <input type="checkbox" name="tAndC" id="tAndC" class="hidden" value="1">
					</span>
				</div>
				<div class="col-xs-8 col-sm-9 col-md-9">
					 By clicking <strong class="label label-success">Register</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#tAndCm">Terms and Conditions</a> set out by this site, including our Cookie Use.
				</div>
			</div>
			
			<hr id = "bot_line" class="colorgraph">
			<div class="row">
				<div class="col-xs-12 col-md-6 col-md-offset-3"><input type="submit" value="Register" class="btn btn-success btn-block btn-lg" tabindex="7"></div>
			</div>
		</form>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="tAndCm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">Terms and Conditions</h4>
			</div>
			<div class="modal-body">
				<p>JResume allows people to generate resumes online based on the data provided by them. </p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" data-dismiss="modal">I Agree</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>
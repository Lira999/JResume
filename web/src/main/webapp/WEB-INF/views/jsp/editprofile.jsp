<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
<title>Edit profile</title>
<jsp:include page="generic.jsp" />
<link rel="stylesheet" href="resources/css/editprofile.css">
<script src="resources/js/lib/jquery-validate/jquery.validate.js"></script>
<script src="resources/js/editprofile.js"></script>

</head>
<body class="login-body">
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="wrapper">
		<form class="edit-profile-form" method="POST" role="form">
			<h3 class="form-signup-heading">Edit profile</h3>
			<hr id="line_rb" class="colorgraph">
			<div class="input-group col-xs-12">
				<input type="text" name="firstName" id="firstName"
					class="form-control" placeholder="First Name" required>
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" type="text" name="lastName"
					id="lastName" placeholder="Last Name" required>
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" placeholder="Current Password"
					id="currentPassword" name="currentPassword" type="password"
					required>
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" placeholder="Password" id="password"
					name="password" type="password">
			</div>
			<div class="input-group col-xs-12">
				<input class="form-control" placeholder="Confirm Password"
					id="passwordConfirmation" name="passwordConfirmation"
					type="password">
			</div>
			<a href="viewprofile">
				<button class="loginbtn btn btn-lg btn-success btn-block"
					type="submit">Save</button>
			</a>
		</form>
	</div>
</body>
</html>
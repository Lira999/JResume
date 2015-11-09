<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
<title>View profile</title>
<jsp:include page="generic.jsp" />
<link href="resources/css/viewprofile.css" rel="stylesheet">
<script src="resources/js/viewprofile.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h3 class="heading">User profile</h3>
		<hr class="colorgraph">
		<div class="col-md-4">
			<h5>First Name</h5>
		</div>
		<div class="col-md-8" id="firstName"></div>
		<div class="col-md-4">
			<h5>Last Name</h5>
		</div>
		<div class="col-md-8" id="lastName"></div>
		<div class="col-md-4">
			<h5>
				<i class="glyphicon glyphicon-envelope"></i>
			</h5>
		</div>
		<div class="col-md-8" id="email"></div>
	</div>
</body>
</html>
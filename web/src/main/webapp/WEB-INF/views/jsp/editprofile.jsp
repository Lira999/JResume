<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
<title>Edit profile</title>
<jsp:include page="generic.jsp" />
<link rel="stylesheet" href="resources/css/editprofile.css">
<link rel="stylesheet"
	href="resources/css/lib/bootstrap/datepicker.min.css">
<script src="resources/js/lib/moment.js"></script>


<script src="resources/js/editprofile.js"></script>
<script src="resources/js/lib/bootstrap/bootstrap-datepicker.min.js"></script>

</head>
<jsp:include page="navbar.jsp"></jsp:include>

<body>
	<div class="container" id="well">

		<form class="editprofile-form" method="POST" role="form">

			<div class="row">
				<h3 style="margin-bottom: 25px; text-align: center;">Edit
					Profile</h3>
				<hr class="colorgraph">

				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="firstname"
						name="firstname" placeholder="Name" required>
				</div>
				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="lastname"
						name="lastname" placeholder="Surname" required>
				</div>
				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="position"
						name="position" placeholder="Position" required>
				</div>
				<div class="input-group input-append date col-lg-6" id="datePicker">
					<input type="text" class="form-control" name="date" id="birthdate"
						placeholder="Birth Date" /> <span
						class="input-group-addon add-on"><span
						class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<div class="form-group col-lg-12">
					<input name="summary" class="form-control" id="summary"
						placeholder="Summary">
				</div>
				<div class="form-group col-lg-12">
					<input name="programminglanguages" class="form-control"
						id="programminglanguages" placeholder="Programming Languages">
				</div>
				<div class="form-group col-lg-12">
					<input name="technologies" class="form-control" id="technologies"
						placeholder="Technologies">
				</div>
				<div class="form-group col-lg-12">
					<input name="rdbms" class="form-control" id="rdbms"
						placeholder="RDBMS">
				</div>
				<div class="form-group col-lg-12">
					<input name="methodologies" class="form-control" id="methodologies"
						placeholder="Methodologies">
				</div>
				<div class="form-group col-lg-12">
					<input name="frameworks" class="form-control" id="frameworks"
						placeholder="Frameworks">
				</div>
				<div class="form-group col-lg-12">
					<input name="webservers" class="form-control" id="webservers"
						placeholder="Web Servers">
				</div>
				<div class="form-group col-lg-12">
					<input name="tools" class="form-control" id="tools"
						placeholder="Tools">
				</div>
				<div class="form-group col-lg-12">
					<input name="testingtools" class="form-control" id="testingtools"
						placeholder="Testing Tools">
				</div>
				<div class="form-group col-lg-12">
					<input name="operatingsystems" class="form-control"
						id="operatingsystems" placeholder="Operating Systems">
				</div>
				<div class="form-group col-lg-12">
					<input name="hardware" class="form-control" id="hardware"
						placeholder="Hardware">
				</div>
				<div class="form-group col-lg-4">
					<button id="savebutton"
						class="btn-success btn-save btn-lg btn-block btn" type="button">Save</button>
				</div>
			</div>
		</form>
	</div>






</body>
</html>
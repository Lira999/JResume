<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
<title>User Information</title>
<jsp:include page="generic.jsp" />
<link rel="stylesheet" href="resources/css/userinformation.css">
<link rel="stylesheet"
	href="resources/css/lib/bootstrap/datepicker.min.css">
<script src="resources/js/lib/moment.js"></script>
<script src="resources/js/userinformation.js"></script>
<script src="resources/js/lib/bootstrap/bootstrap-datepicker.min.js"></script>
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container" id="well">

		<form class="editprofile-form" method="POST" role="form">

			<div class="row">
				<h3 style="margin-bottom: 25px; text-align: center;">User
					Information</h3>
				<hr class="colorgraph">
				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="position"
						name="position" placeholder="Position" required>
				</div>
				<div class="col-lg-6">
					<div class="input-group input-append date col-lg-12"
						id="datePicker">
						<input type="text" class="form-control" name="date" id="birthdate"
							placeholder="Birth Date" /> <span
							class="input-group-addon add-on"><span
							class="glyphicon glyphicon-calendar"></span></span>
					</div>
				</div>
				<div class="form-group col-lg-12">
					<input name="summary" class="form-control" id="summary"
						placeholder="Summary">
				</div>
				<div class="form-group col-lg-12">
					<h4>Education</h4>
				</div>

				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="schoolName"
						name="schoolName" placeholder="School Name" required>
				</div>
				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="university"
						name="university" placeholder="University" required>
				</div>
				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="degreeReceived"
						name="degreeReceived" placeholder="Degree Received" required>
				</div>
				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="department"
						name="department" placeholder="Department" required>
				</div>
				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="graduationYear"
						name="graduationYear" placeholder="Graduation Year" required>
				</div>
				<div class="form-group col-lg-12">
					<h4>Project</h4>
				</div>
				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="description"
						name="description" placeholder="Description" required>
				</div>

				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="customer"
						name="customer" placeholder="Customer" required>
				</div>
				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="role" name="role"
						placeholder="Role" required>
				</div>

				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="teamSize"
						name="teamSize" placeholder="Team Size" required>
				</div>

				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="involvementDuration"
						name="involvementDuration" placeholder="Involvement Duration"
						required>
				</div>

				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="tools" name="tools"
						placeholder="Tools" required>
				</div>
				<div class="form-group col-lg-12">
					<h4>Certification</h4>
				</div>
				<div class="form-group col-lg-8">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Name" required>
				</div>
				<div class="form-group col-lg-4">
					<input type="text" class="form-control" id="yearReceived" name="yearReceived"
						placeholder="Year Received" required>
				</div>
				
				<div class="form-group col-lg-12">
					<div class="col-xs-2">
						<button id="next"
							class="btn-success btn-save btn-lg btn-block btn" type="button">Next</button>
					</div>
				</div>

				<div id="nextfields"></div>
				<div class="form-group col-lg-12">
					<div class="col-xs-2">
						<button id="savebutton"
							class="btn-success btn-save btn-lg btn-block btn" type="button">Save</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
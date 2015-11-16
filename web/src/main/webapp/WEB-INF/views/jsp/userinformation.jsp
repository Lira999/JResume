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
				<div class="header">
					<h3>User Information</h3>
				</div>
				<hr class="colorgraph">
				<div class="form-group col-lg-6">
					<input type="text" class="form-control" id="position"
						name="position" placeholder="Position">
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
				<div id="education"></div>
				<div class="form-group col-lg-12">
					<span class="pull-right">
						<button id="addeducation"
							class="btn-success btn-save btn-lg btn-block btn" type="button">One
							more</button>
					</span>

				</div>
				<div class="form-group col-lg-12">
					<h4>Project</h4>
				</div>
				<div id="project"></div>


				<div class="form-group col-lg-12">
					<span class="pull-right">
						<button id="addproject"
							class="btn-success btn-save btn-lg btn-block btn" type="button">One
							more</button>
					</span>
				</div>

				<div class="form-group col-lg-12">
					<h4>Certification</h4>
				</div>
				<div id="certification"></div>
				<div class="form-group col-lg-12">
					<span class="pull-right">
						<button id="addcertification"
							class="btn-success btn-save btn-lg btn-block btn" type="button">One
							more</button>
					</span>
				</div>


				<div class="form-group col-lg-12">
					<div class="col-xs-2">
						<button id="next"
							class="btn-success btn-save btn-lg btn-block btn" type="button">Next</button>
					</div>
				</div>

				<div id="nextfields"></div>
				<div class="form-group col-lg-12">
					<span class="pull-right">
						<button id="savebutton"
							class="btn-success btn-save btn-lg btn-block btn" type="button">Save</button>
					</span>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
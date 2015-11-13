<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Resume</title>
<jsp:include page="generic.jsp" />
<link rel="stylesheet" href="resources/css/resume.css">
<script src="resources/js/resume.js"></script>
</head>
<body class="body">
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="center col-lg-10">
				<div class="well well-lg" id="well">
					<div id="resume"></div>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-md-offset-3">
			<button id="pdf" class="btn-success btn-save btn-lg btn-block btn"
				type="button">Save as PDF</button>
		</div>
		<div class="col-md-3">
			<button id="doc" class="btn-success btn-save btn-lg btn-block btn"
				type="button">Save as Doc</button>
		</div>
	</div>
</body>
</html>
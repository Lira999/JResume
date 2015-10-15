<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
	<title></title>
	<jsp:include page="generic.jsp"/>
	<link href="resources/css/viewtempl.css" rel="stylesheet">
	<script src="resources/js/viewtempl.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container" id="view">
	<div class="row">
		<div class="center col-lg-10">
			<div class="well well-lg" id= "well">
				<div id= "page-content">
					<h2 class="title" id= "name"></h2>
					<hr class="colorgraph">
					<div class ="img-responsive img-thumbnail thumbnail" id="img"></div>
						<h4><strong>Description</strong></h4>
						<p class="about" id="description"></p>
						<br>
						<div class= "center col col-sm-3">
							<button class="btn btn-lg btn-block" id="control" type="button"></button>
						</div>
						<br>
						<h4><strong>Customer Reviews</strong></h4>
						<jsp:include page="viewcomments.jsp"/>
						<br>
						<h4><strong>Leave a Customer Review</strong></h4>
						<jsp:include page="addcomment.jsp"/>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
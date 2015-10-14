<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>This Template</title>
    <jsp:include page="generic.jsp"/>
    <link href="resources/css/viewtempl.css" rel="stylesheet">
	<script src="resources/js/viewtempl.js"></script>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
  <div class="container" id="view">
    <div class="well well-lg">
		<h2 id = "name"></h2>
		<hr class="colorgraph">
			<div class="row">
			<div class="col-xs-12 col-sm-12">
					<p class="about" id="description"></p>	
			</div>
			<br/>
			<div class="col-xs-12 col-sm-8 col-md-offset-2">
				<div class ="img-responsive img-thumbnail thumbnail" id="img"></div>
			</div>
			</div>
			<div class="col-xs-2 col-md-offset-8">
				<button class="btn btn-lg button btn-block  " id="control" type="button"></button>
			</div>
			
			<div class="col-xs-4 col-md-7">
				<div class="row lead">
					<div id="stars" class="starrr"></div>
				</div>
			</div>
			<footer>
			<div class="row"></div>
			</footer>
		<br>
		<br>
		<jsp:include page="addcomment.jsp"/>
		<jsp:include page="viewcomments.jsp"/>
    </div>
</div>
</body>
</html>
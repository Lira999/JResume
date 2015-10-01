<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>This Template</title>
    <jsp:include page="generic.jsp"/>
    <link href="resources/css/viewtempl.css" rel="stylesheet">
	<script src="resources/js/viewtempl.js"></script>
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"	rel="stylesheet">
</head>
<body>
 <div class="container" id="view">
    <div class="well well-lg">
		<h2 class="page-header">
			<a href="#" id = "name"></a>	     
		</h2>
		<hr class="colorgraph">   
		<div>
			<div class="row" class="span9" >
				<p class="about" id= "description"></p>
				
			</div>
			
			<div>
				<hr>
					<img class="img-responsive" src="resources/images/Resume.jpg" alt="">
				<hr>
			</div>
		</div>	
        <div class="col-xs-4 col-md-7">
       		<div class="row lead">
         		<div id="stars" class="starrr"></div>		
         	</div>
		</div>
		<div class="col-xs-4 col-md-2">
			<button class ="btn button" type="button"></button>
		</div>
		
		<footer>
			<div class="row"></div>
			</footer>
		<br>
		<br>
		<jsp:include page="addcomment.jsp"/>
		<jsp:include page="viewcommentsandmarks.jsp"/>
    </div>
</div>
</body>
</html>
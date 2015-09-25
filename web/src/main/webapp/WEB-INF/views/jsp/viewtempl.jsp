<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>This Template</title>
    <jsp:include page="generic.jsp"/>
    <link href="resources/css/viewtempl.css" rel="stylesheet">
    
    <link href="resources/css/comment.css" rel="stylesheet">
	<script src="resources/js/mark.js"></script>
	<script src="resources/js/sendcomment.js"></script>
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"	rel="stylesheet">
</head>
<body>
 <div class="container">
    <div class="well well-lg">
		<h2 class="page-header">
			<a href="#">Template myTemplate</a>	     
		</h2>
		<hr class="colorgraph">   
		<div>
			<div class="row" class="span9" >
				<p class="about">Some description about resume.</p>
				
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
			<button type="button" class="btn btn-success  btn-lg btn-block" >Use</button>
		</div>
		<div class="col-xs-4 col-md-2">
			<button type="button" class="btn btn-primary  btn-lg btn-block" >Buy</button>
		</div>
		<footer>
			<div class="row"></div> 
		</footer>
		<br>
		
    </div>
</div>
</body>
</html>
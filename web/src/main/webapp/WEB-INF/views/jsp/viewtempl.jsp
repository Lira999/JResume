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
		<h2 id = "name"></h2>
		<hr class="colorgraph">   
		<div class="row" class="span9" >	
			
			
			
		<div class="row" id="row">
  			<div class="col-xs-6 col-sm-8" id = "img">
					
				</div>
			
			<div class="col-xs-6 col-sm-4" >
				<p class="about" id= "description"></p>
			</div>	
			
			
		</div>
		<div class="col-md-3 col-md-offset-3 posbut">
				<button class ="btn btn-lg button" id="control" type="button"></button>
			</div>
		</div>	
		
		
		<hr>
		
		
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
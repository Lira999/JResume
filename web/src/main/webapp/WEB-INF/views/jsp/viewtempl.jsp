<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>This Template</title>
    <jsp:include page="generic.jsp"/>
   	<link href="resources/css/viewtempl.css" rel="stylesheet">
</head>
<body>
 <div class="container">
    <div class="well well-lg">
		<h2 class="page-header">
			<a href="#">Template myTemplate</a>	     
		</h2>
		    
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
        <div class="col-md-8">
			<h4>Place for Marks</h4>
		</div>
		<div class="col-md-2">
			<button type="button" class="btn btn-success  btn-lg btn-block" >Use</button>
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-primary  btn-lg" >Buy</button>
		</div>
		
		<div class="col-md-8">
            <div class="row">
                <h3>Comment field</h3>
            </div>      
        </div> 
		<footer>
			<div class="row"></div> 
		</footer>
    </div>
</div>
</body>
</html>
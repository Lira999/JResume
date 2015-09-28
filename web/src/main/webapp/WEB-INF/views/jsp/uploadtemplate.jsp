<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>Upload a template</title>
    <jsp:include page="generic.jsp"/>
    <link rel="stylesheet" href="resources/css/uploadtemplate.css">
    <script src="resources/js/uploadtemplate.js"></script>
</head>
<body>
<div class="wrapper">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form class="register-form" method="POST" role="form">
			<h3 class="form-signup-heading">Upload a new template here:</h3>
			<hr class="colorgraph1">
			
			<div>
				<input type="text" class="form-control" placeholder="Name of the template" id = "NameTeplate" required>
			</div>
			<br/>
			<textarea class="form-control" rows="3" placeholder="Write description"id = "DescriptionTeplate" required></textarea>
		
		<br>
		<div class="checkbox">
		  <label>
		    <input type="checkbox" name="checkbox" id="checkbox" value="scheckbox" />
		    if you gonna push it It'll be paid!
		  </label>
		  <br/>
		  <input id="showthis" name="showthis" type="text" class="form-control" placeholder="costs in dollars" >
		  
		</div>

			<!--Button for image-->
			<br/>
			<hr class="colorgraph"/>
			
			
			<span class="btn btn-primary btn-file"><span class="fileupload-new">Select image</span>
				<input  type="file" name="fileUpload1" id="fileUpload1" class="fileUpload" accept="image/*"/>
			</span> 
			<!--Button for xssl-->
			<span class="btn btn-primary btn-file"><span class="fileupload-new">Select Template</span>
				<input   type="file" name="fileUpload2[]" id="fileUpload2" class="fileUpload" accept=".xslt*/"/>
			</span>
			
			<div id="display"></div>
			<div id="previews"></div>
			<hr class="colorgraph">
			<button type="submit" class="btn btn-lg btn-success" id ="uploadBtn">Send</button>
			
			
		</form>
		
	</div>
</div>
</body>
</html>
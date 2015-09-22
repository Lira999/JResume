<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>Upload a template</title>
    <jsp:include page="generic.jsp"/>
    <script src="resources/js/fileupload.js"></script>
    <link rel="stylesheet" href="resources/css/fileupload.css">
</head>
<body>
<div class="wrapper">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form class="register-form" method="POST" role="form">
			<h3 class="form-signup-heading">Upload a new template here:</h3>
			<hr class="colorgraph">
			
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Name of the template">
			</div>
			
			<!--Button-->
			<hr class="colorgraph">
			  <div class="fileupload fileupload-new" data-provides="fileupload">
				<span class="btn btn-primary btn-file"><span class="fileupload-new">Select file</span>
				<span class="fileupload-exists">Change</span>         <input type="file" /></span>
				<span class="fileupload-preview"></span>
				<a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">?</a>
			  </div>
		</form>
	</div>
</div>
</body>
</html>
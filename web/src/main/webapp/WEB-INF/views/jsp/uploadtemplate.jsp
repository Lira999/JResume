<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Template</title>
<jsp:include page="generic.jsp"/>
<script src="resources/js/uploadtemplate.js"></script>
<link rel="stylesheet" href="resources/css/uploadtemplate.css">
<script src="resources/js/lib/jquery-validate/jquery.validate.js"></script>
</head>
<body>
	<div class="modal-dialog">
		<div class="modal-content">
			<div>
				<h3>Form for Upload Template</h3>
			</div>
			<hr id="line_rb" class="colorgraph">
			<div class="modal-body">
				<form id="upload-form" method="POST" action="uploadMultipleFile2"
					enctype="multipart/form-data">
					<div class="input-group">
						<label>Template name</label> 
						<input type="text"
							class="form-control" name = "name" id="name"
							placeholder="Set name for template">
					</div>
					
					<div class="input-group">
						<label>Please write some description about this Template</label>
						<textarea rows="3" class="form-control" name = "description" id="DescriptionTeplate"
							placeholder="This tempate is ... "></textarea>
					</div>
					
					<div class = "input-group">
						Please enter price:
						<input id="price" name="price" type="text"
							class="form-control" placeholder="Free / Paid">
					</div>
					<div class="input-group">
						Image file to upload:
						<input id="file" class="upl " type="file" name="file" accept="image/*">
					</div>
					<div class="input-group"> 
						Template view to upload: 
						<input id="file2" class="upl " type="file" name="file2" > 
					</div>
					<input type="submit" name="submit" id="uploadBtn" class="btn btn-success  btn-lg" value="Upload">
						Press here to upload the files and data!
				</form>
			</div>
		</div>
	</div>
</body>
</html>
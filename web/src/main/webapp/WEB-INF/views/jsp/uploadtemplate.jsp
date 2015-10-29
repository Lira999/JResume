<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Template</title>
<jsp:include page="generic.jsp"/>
<link rel="stylesheet" href="resources/css/uploadtemplate.css">
<script src="resources/js/lib/jquery-validate/jquery.validate.js"></script>
<script src="resources/js/lib/jquery-validate/additional-methods.js"></script>
<script src="resources/js/uploadtemplate.js"></script>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="wrapper">
		<form class= "upload-form" id="upload-form" method="POST" action="uploadMultipleFile2" enctype="multipart/form-data">
		<h3 class= "form-heading">Upload Template</h3>
		<div id= "error-div"></div>
		<hr class="colorgraph">
		<div class="input-group col-xs-12">
			<input id= "name" class="form-control data-input" placeholder="Template Name" name="name" type="text">
		</div>
		<br>
		<div class="input-group col-xs-12">
			<textarea rows="3" class="form-control data-input" name = "description" id="description" placeholder="Template Description"></textarea>
		</div>
		<br>
		<div class="input-group col-xs-12">
			<input id= "price" class="form-control data-input" placeholder="Template Price (Leave blank to set as free)" name="price" type="text">
		</div>
		<br>
		<div class= "input-group col-xs-12">
			<span class="file-input btn btn-block btn-default btn-file">
				Pick An Preview Image <input id= "pic" name= "pic" type="file" accept="png" class="form-control data-input" >
			</span>
		</div>
		<br>
		<div class= "input-group col-xs-12">
			<span class="file-input btn btn-block btn-default btn-file">
				Pick A Template <input id= "file" name= "file" type="file" class="form-control data-input" >
			</span>
		</div>
		<br>
		<button class="loginbtn btn btn-lg btn-success btn-block" name="submit" id="uploadBtn"
				type="submit">Upload</button>
		<br>
		</form>
	</div>
</body>
</html>
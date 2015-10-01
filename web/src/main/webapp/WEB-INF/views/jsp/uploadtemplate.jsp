<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload a template</title>
    <jsp:include page="generic.jsp"/>
    <link rel="stylesheet" href="resources/css/uploadtemplate.css">
    <script src="resources/js/uploadtemplate.js"></script>
</head>
<body><div class="center"><button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Upload Template here</button></div>


<!-- line modal -->
<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
 
 <div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
			<h3 class="modal-title" id="lineModalLabel">Form for Upload Template</h3>
		</div>
		
		<div class="modal-body">
			
            <!-- content goes here -->
			<form>
              <div class="form-group">
                <label>Template name</label>
                <input type="text" class="form-control" id="NameTeplate" placeholder="Really good name for tamplate">
              </div>
              <div class="form-group">
                <label>Please write some description about this Template</label>
                <textarea rows = "3" class="form-control" id="DescriptionTeplate" placeholder="This tempate is ... "></textarea>
              </div>
              <div>
              	<input id="showthis" name="showthis" type="text" class="form-control" placeholder="Free / A dollar" >
              </div>
              <div class="form-group">
                <label class = "marginFile" for="exampleInputFile">File input</label>
                <input type="file" id="fileUpload1" name="fileUpload1" accept="image/*">
                <p class="help-block">Example block-level help text here.</p>
              </div>
              <button type="submit" class="btn btn-default" id ="uploadBtn">Submit</button>
            </form>

		</div>
  </div>
</div>
</div>
</body>
</html>
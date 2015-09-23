<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>Upload a template</title>
    <jsp:include page="generic.jsp"/>
    <link rel="stylesheet" href="resources/css/uploadtemplate.css">
</head>
<body>
<div class="wrapper">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		<form class="register-form" method="POST" role="form">
			<h3 class="form-signup-heading">Upload a new template here:</h3>
			<hr class="colorgraph1">
			
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Name of the template" id = "NameTeplate" required>
			</div>
			<textarea class="form-control" rows="3" placeholder="Write description"id = "DescriptionTeplate" required></textarea>
		
			<!--RADIO-->
			<br>
			<div data-toggle="buttons">
				<div class="btn-group" >
					<div class="col-lg-5">
						<div class="input-group">
							<span class="input-group-addon">
								<input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" aria-label="..." required>
							</span>
							<fieldset disabled>
								<input type="text" class="form-control" id="disabledTextInput" placeholder="Free"/>
							 </fieldset>
						</div>
					</div>
					
					<div class="col-lg-6">
						<div class="input-group">
							<span class="input-group-addon">
								<input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option2" aria-label="..." >
							 </span>
							<input type="text" class="form-control" placeholder="costs in dollars">
						</div><!-- /input-group -->
					</div>
				</div>
			</div>
			<!--Button for image-->
			<br/>
			<hr class="colorgraph"/>
			
			
			<span class="btn btn-primary btn-file"><span class="fileupload-new">Select image</span>
				<input required type="file" name="fileUpload1" id="fileUpload1" class="fileUpload" accept="image/*"/>
			</span> 
			<!--Button for xssl-->
			<span class="btn btn-primary btn-file"><span class="fileupload-new">Select Tamplate</span>
				<input   type="file" name="fileUpload2[]" id="fileUpload2" class="fileUpload" accept=".xslt*/"/>
			</span>
			
			<div id="display"></div>
			<div id="previews"></div>
			<hr class="colorgraph">
			<button type="submit" class="btn btn-lg btn-success">Send</button>
			
			
		</form>
		
	</div>
</div>
</body>
</html>
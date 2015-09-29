<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="resources/css/addcomment.css" rel="stylesheet">
<link href="resources/css/lib/star-rating.css" rel="stylesheet">
<script src="resources/js/addcomment.js"></script>
<script src="resources/js/lib/star-rating.js"></script>
<div class="container">
	<div class="row">
		<div class="col-md-12">
	    	<div class="well well-sm">
	            <div class="row" id="post-review-box">
	            	<div class="useravatar">
	            	<div class="form-location">
			            <div class="col-md-1"><img src="resources/images/avatar.png" class="img-responsive user-photo"/>
			            <p><br>UserName</p>
			            </div></div>
			            <div class="form-location">
			            
		                <div class="col-md-11">
		                    <input id="rating-input" type="number" data-size="xs"/>
		                   	<form accept-charset="UTF-8" action="" method="post">
		                    	<textarea class="form-control animated" cols="50" id="comment" name="comment" placeholder="Enter your review here..." rows="5"></textarea>
			                   	<div class="row lead">
					        		<div class="addbutton">
					        			<div class="col-xs-2 col-md-offset-10">
					        				<button id="addcomment" class="btn btn-success  btn-lg btn-block" type="button">Add</button>
					        			</div>
					        		</div>
					        	</div>
		                	</form>
		                </div>
		        	</div>
	            </div>
	        </div> 
		</div>
	</div>
</div>
</div>
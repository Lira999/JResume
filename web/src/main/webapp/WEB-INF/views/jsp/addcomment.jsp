<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="resources/css/addcomment.css" rel="stylesheet">
<div class="container">
	<div class="row">
		<div class="col-md-12">
	    	<div class="well well-sm">
	            <div class="row" id="post-review-box">
	            	<div class="useravatar">
			            <div class="col-md-1"><img src="resources/images/avatar.png" class="img-responsive user-photo"/>
			            <br>
			            <p>UserName</p>
			            </div>
		                <div class="col-md-11">
		                    <form accept-charset="UTF-8" action="" method="post">
		                        <input id="ratings-hidden" name="rating" type="hidden"> 
		                        <textarea class="form-control animated" cols="50" id="comment" name="comment" placeholder="Enter your review here..." rows="5"></textarea>
		        
		                        <div class="text-right">
		                        	<div class="row lead">
		                        		<div class="col-sm-10">
		                        			<div class="starsforcomment">
					        					<div id="stars" class="starrr"></div>
					        				</div>
					        			</div>
					        			<div class="col-sm-2">
					        				<div class="addbutton">
					        					<button id="addComment" class="btn btn-success btn-lg" type="button">Add</button>
					        				</div>
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
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="resources/css/lib/star-rating.css" rel="stylesheet">
<link href="resources/css/addcomment.css" rel="stylesheet">
<script src="resources/js/lib/star-rating.js"></script>
<script src="resources/js/addcomment.js"></script>

<div class="row">
	<div class="col-md-12">
		<div class="row" id="post-review-box">
		<div class="col-md-3">
			<h3>UserName</h3>
		</div>
		<div class="col-md-offset-9">
			<input id="rating-input" type="number" name="rating" data-size="xs"/>
		</div>
			<form accept-charset="UTF-8" action="" method="post">
				<textarea class="form-control" cols="50" id="comment" name="comment" placeholder="Enter your review here..." rows="5"></textarea>
				<div class="row lead">
					<div class="addbutton">
						<div class="col-xs-2 col-md-offset-10">
							<button id="addbutton" class="add-comment-btn btn-success btn-lg btn-block btn" type="button" disabled>Add</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
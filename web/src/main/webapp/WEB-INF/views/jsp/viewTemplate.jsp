<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>Edit profile</title>
    <jsp:include page="generic.jsp"/>
   	<link href="resources/css/ViewTempl.css" rel="stylesheet">
	<link href="resources/css/star-rating.css" rel="stylesheet">
    <script src="resources/js/star-rating.js"></script>
</head>
<body>
 <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h1 class="page-header">
                    Template myTemplate     
                </h1>
                <h2>
                    <a href="#">NameOfTemplate</a>
                </h2>
                <p class="lead">
                    by <a href="index.php">someone</a>
                </p>
                <p><span class="glyphicon glyphicon-time"></span> Posted today</p>
                <hr>
                <img class="img-responsive" src="resources/images/Resume.jpg" alt="">
                <hr>
                <p>Some description about resume.</p>
              

                <hr>

				<div class="clear-rating clear-rating-active" title="Clear"></div>
				<div class="rating-stars" data-content="" style="width: 0%;"></div>
				<input id="input-21e" class="rating form-control hide" type="number" data-size="xs" step="0.5" max="5" min="0" value="0">
				<div class="caption">
					<span class="label label-default">Not Rated</span>
				</div>

				<ul class="pager">
					 <li class="previous">
						<a href="#">&larr; Older template</a>
					 </li>
					 <li class="next">
						<a href="#">Newer template&rarr;</a>
					</li>
				</ul>

				<div class="new-comment js-new-comment">
						<div class="member member-no-menu">
							<img class="member-avatar" width="30" height="30" title="Petro (chyvaak)" alt="Petro (chyvaak)" src="resources/images/face.png">
						</div>
						<form>
							<div class="comment-frame">
								<div class="comment-box">
									<textarea class="comment-box-input js-new-comment-input" tabindex="1" placeholder="Write a comment…" style="overflow: hidden; word-wrap: break-word; height: 75px;"></textarea>
								</div>
							</div>	
						</form>
						<footer class="coments-form-footer">
							<input class="submit" type="submit" onclick="testData(); return false;" value="додати коментар">
						</footer>
					</div>
					<div class="phenom phenom-action u-clearfix phenom-comment">
						<div class="creator member js-show-mem-menu">
							<img class="member-avatar" width="30" height="30" title="Petro (chyvaak)" alt="Petro (chyvaak)" src="resources/images/face.png">
							<span class="member-gold-badge" title="This member has Trello Gold."></span>
						</div>
						<div class="phenom-desc">
							<span class="inline-member js-show-mem-menu">
								<span class="u-font-weight-bold">Petro</span>
							</span>
							<div class="action-comment markeddown js-comment">
								<div class="current-comment js-friendly-links">
									<p>
									It's Really cool CV!!!
									</p>
								</div>
							</div>
							<div class="hide embedly js-embedly"></div>
						</div>
						<p class="phenom-meta quiet">
							<span >Sep 17 at 1:38 PM</span>
							<span class="js-spinner hide"></span>
							<span class="js-hide-on-sending">
								-
								<a class="js-edit-action" href="#">Edit</a>
								-
								<a class="js-confirm-delete-action" href="#">Delete</a>
							</span>
						</p>
					</div>		
			</div>

          
            <div class="col-md-4">
                <div class="well">
                    <h4>Price</h4>
                    <p>Free!!!</p>
                </div>
            </div>
        </div>
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy;</p>
                </div>
            </div>      
        </footer>

    </div>
</body>
</html>
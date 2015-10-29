<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../generic.jsp"></jsp:include>
	<title>403 - JResume</title>
</head>
<body>
<jsp:include page="../navbar.jsp"></jsp:include>
<br><br>
<div class="container">
  <div class="row">
  <div class="col-md-2"></div>
    <div class="col-md-8">
      <div class="panel panel-danger">
        <div class="panel-heading">
          <h3 class="text-center">
          <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
          Access denied
          </h3>
        </div>
        <div class="panel-body">
          <h4 class="text-center">We're sorry, but you don't have access to this section</h4>
          <br>
          <h5 class="text-center"><a href= "index">Click here</a> to return to home page</h5>
          </div>
        </div>
      </div>
    </div>
    </div>
</body>
</html>
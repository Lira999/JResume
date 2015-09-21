<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html/>
<html>

<head>
    <title>Resume templates</title>
    <jsp:include page="generic.jsp"/>
</head>

<body class="login-body">
<div class="wrapper">
<div class="container">
    <div class="well well-lg">
    <h1>Resume templates</h1>
    <hr class="colorgraph">     
    <form class="form-inline" role="form">
      <div class="form-group">
        <label for="sel1">View:</label>
          <select class="form-control" id="sel1">
            <option>all</option>
            <option>only free</option>
            <option>only paid</option>
          </select>
      </div>
      <div class="form-group">
        <label for="sel1">Order by:</label>
          <select class="form-control" id="sel1">
            <option>newest</option>
            <option>popular</option>
            <option>price</option>
          </select>
      </div>    
    </form>
    </div>
</div>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-xs-12 col-md-4 col-lg-4">
      <div class="thumbnail bootsnipp-thumb">
           <img src="./resources/images/Template1.png">
        </div>
    </div>                  
    <div class="col-sm-12 col-xs-12 col-md-4 col-lg-4">
      <div class="thumbnail bootsnipp-thumb">
         <img src="./resources/images/Template1.png">
      </div>
    </div>    
    <div class="col-sm-12 col-xs-12 col-md-4 col-lg-4">
      <div class="thumbnail bootsnipp-thumb">
         <img src="./resources/images/Template1.png">
      </div>
    </div>  
    </div>    
    <div class="row">
    <div class="col-sm-12 col-xs-12 col-md-4 col-lg-4">
      <div class="thumbnail bootsnipp-thumb">
         <img src="./resources/images/Template1.png">
      </div>
    </div>          
    <div class="col-sm-12 col-xs-12 col-md-4 col-lg-4">
      <div class="thumbnail bootsnipp-thumb">
         <img src="./resources/images/Template1.png">
      </div>
    </div>    
    <div class="col-sm-12 col-xs-12 col-md-4 col-lg-4">
      <div class="thumbnail bootsnipp-thumb">
         <img src="./resources/images/Template1.png">
      </div>
    </div>  
    </div>
</div>    
 
</body>
</html>
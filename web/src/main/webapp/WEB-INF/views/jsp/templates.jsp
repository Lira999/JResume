<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html/>
<html>

<head>
    <title>Resume templates</title>
    <link rel="stylesheet" href="resources/css/templates.css">
    <jsp:include page="generic.jsp"/>
    <script src="resources/js/templates.js"></script>
</head>

<body class="body">
<div class="wrapper">
<div class="container">
<div class="well well-lg">
   
  <h1>Resume templates</h1>
  <hr class="colorgraph">       
  <form class="form-inline" role="form">
    <div class="form-group">
      <label for="sel1">View:</label>
        <select class="form-control">
          <option>all</option>
          <option>only free</option>
          <option>only paid</option>
        </select>
    </div>
    <div class="form-group">
      <label for="sel1">Order by:</label>
        <select class="form-control">
          <option>newest</option>
          <option>popular</option>
          <option>price</option>
        </select>
    </div>    
  </form>

<div class="wrapper">  
    <div class="row" id="row">
    
    </div>
</div>

</div>
</div>
</div>

</body>
</html>
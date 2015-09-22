<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html/>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="resources/css/login.css">
    <jsp:include page="generic.jsp"/>
</head>
<body class="login-body">
<div class="wrapper">
  <form class="login-form form-signin" action="j_spring_security_check" method="POST">
    <h3 class="form-signin-heading">Please sign in</h3>
    <hr class="colorgraph">
    <!-- displaying login error -->
    <c:if test="${not empty error}">
      <div class="error alert alert-danger fade in">
      <strong>Error! </strong>${error}
      </div>
    </c:if>
    <div class="input-group">
      <span class="input-group-addon">
        <i class="glyphicon glyphicon-user"></i>
      </span> 
      <input class="form-control" placeholder="E-mail" name="username" type="text" autofocus required>
    </div>
    <div class="input-group">
      <span class="input-group-addon">
        <i class="glyphicon glyphicon-lock"></i>
      </span>
      <input class="form-control" placeholder="Password" name="password" type="password" required>
    </div>
    <label class="checkbox">
      <input type="checkbox" name="remember-me"/> Remember me
    </label>
    <button class="loginbtn btn btn-lg btn-success btn-block" type="submit">Sign in</button>
    <a class="register-suggestion" href="">Don't have an account? Sign up now.</a>
  </form>
</div>
</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html/>
<html>
<head>
    <title>Edit profile</title>
    <jsp:include page="generic.jsp"/>
    <link rel="stylesheet" href="resources/css/editprofile.css">
</head>
<body class="login-body">
<div class="wrapper">
  <div class="general">
    <h3 class="form-signin-heading">Edit profile</h3>
    <hr class="colorgraph">
      <form class="form-horizontal" role="form" id="changeForm" method="post" name="changeUserForm">
        <fieldset>

          <div class="form-group">
            <label class="col-sm-4 control-label" for="cfirstname">First name:</label>
            <div class="col-sm-7">
              <input type="text" value="Andriy" class="form-control" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-4 control-label" for="clastname">Last name:</label>
            <div class="col-sm-7">
              <input type="text" value="Luchko" class="form-control" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-4 control-label" for="cname">Display name:</label>
            <div class="col-sm-7">
              <input type="text" id="cname" name="name" value="aluchko96" class="form-control" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-4 control-label" for="cemail">Email</label>
            <div class="col-sm-7">
              <input id="cemail" type="email" name="email" value="info@support.com" class="form-control" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-4 control-label" for="cur_password">Current password:</label>
            <div class="col-sm-7">
              <input type="password" value="Xw158ref" class="form-control" name="cur_password" id="cur_password"/>
            </div>
          </div>

          <div class="form-group">
            <label class="col-sm-4 control-label" for="new_pass">New password:</label>
            <div class="col-sm-7">
              <input type="password" value="" class="form-control" name="new_pass" id="new_pass"/>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-4 col-sm-7">
              <div class="pull-right">
                <button type="submit" class="btn btn-default">Cancel</button>
                <button type="submit" class="btn btn-primary">Save</button>
              </div>
            </div>
          </div>

        </fieldset>
      </form>
    <hr class="colorgraph">
    <hr>
  </div>
</div>
<script type="text/javascript">$("#changeForm").validate();</script>
</body>
</html>
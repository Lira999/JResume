$(document).ready(function() {
	getUserInformation();
});

function getUserInformation() {
    $.ajax({
    url: 'getUserInformation',
    type: 'GET',
    contentType: 'text',
    success: function(userInformation) {
        if (userInformation) {
            var logged;
            if (userInformation[1] === 'ROLE_USER') {
                logged = '<li class="dropdown"><a class="dropdown-toggle" ' + 
                'data-toggle="dropdown" href="#">' + 
                userInformation[0] + '<span class="caret">' + 
                '</span></a><ul class="dropdown-menu"><li><a href="#">' + 
                'View Profile</a></li><li><a href="editprofile">Edit Profile</a>' + 
                '</li></ul></li><li><a href="logout"><span class="glyphicon' +
                ' glyphicon-log-out"></span> Log Out</a></li>';
            } else {
                logged = '<li class="dropdown"><a class="dropdown-toggle" ' + 
                'data-toggle="dropdown" href="#">' + 
                userInformation[0] + '<span class="caret">' + 
                '</span></a><ul class="dropdown-menu"><li><a href="#">' + 
                'View Profile</a></li><li><a href="editprofile">Edit Profile</a>' + 
                '</li><li><a href="uploadtemplate">Upload New Template</a>' + 
                '</li></ul></li><li><a href="logout"><span class="glyphicon' +
                ' glyphicon-log-out"></span> Log Out</a></li>';
            }
            $('#toggles').prepend(logged);
        } else {
            var notLogged = '<li><a href="register"><span class="glyphicon ' + 
            'glyphicon-user"></span> Sign Up</a></li><li><a href="login">' +
            '<span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>';
            $('#toggles').prepend(notLogged);
        }
    },
    error:function() {
        var errorMessage = '<li><a href="#"><span class="glyphicon ' + 
        'glyphicon-exclamation-sign"></span><strong> Error: </strong> ' + 
        'Something went wrong. Please, try to refresh page.</a></li>';
        showErrorMessage('#toggles', errorMessage);
    }
    });
}
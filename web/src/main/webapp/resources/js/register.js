$(function() {
	jQuery.validator.addMethod('regx', function (value, element, regexpr) {
		return regexpr.test(value);
	}, 'Please enter a valid data.');

	jQuery.validator.setDefaults({
		highlight: function(element) {
			$(element).closest('.input-group').removeClass('has-success');
    		$(element).closest('.input-group').addClass('has-error');
    		$(element).nextAll('.glyphicon').remove();
    		$(element).after('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
		},
		unhighlight: function(element) {
			$(element).closest('.input-group').removeClass('has-error');
	    	$(element).closest('.input-group').addClass('has-success');
	    	$(element).nextAll('.glyphicon').remove();
	    	$(element).after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
		}
	});
	
	// Setup form validation on the .register-form element
	$('.register-form').validate({
			onkeyup: function (element) { 
				if ($(element).attr('id') === $('#password').attr('id') 
					&& $('#passwordConfirmation').val().length > 0) {
					$('#passwordConfirmation').valid();
				}
				return $(element).valid();
			},
			// Specify the validation rules
			rules : {
				firstName : {
					required : true,
					regx : /^[A-Za-z][A-Za-z\- ']*$/
				},
				lastName : {
					required : true,
					regx : /^[A-Za-z][A-Za-z\- ']*$/
				},
				email : {
					required : true,
					regx : /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]+)$/,
					remote: {
                        url: 'emailExist',
                        type: 'POST',
                        value: true
                    }
				},
				password : {
					required : true,
					minlength : 5,
				},
				passwordConfirmation : {
					required : true,
					minlength : 5,
					equalTo: '#password'
				}
			},
			// Specify the validation error messages
			messages : {
				firstName : {
					required : 'Please enter your first name',
					regx : 'Please enter your first name correctly'
				},
				lastName : {
					required: 'Please enter your last name.',
					regx : 'Please enter your last name correctly'
				},
				password : {
					required : 'Please provide a password',
					minlength : 'Enter a password with at least 5 characters'
				},
				passwordConfirmation : {
					required : 'You must confirm your password',
					minlength : 'Enter a password with at least 5 characters',
					equalTo : 'Your passwords must match'
				},
				email : {
					required : 'Please enter your e-mail',
					regx : 'Please enter your e-mail correctly',
					remote : 'This e-mail is already taken'
				}
			},
			errorPlacement: function (error, element) {
				var _popover;
				_popover = $(element).popover({
					trigger: 'manual',
					animation: false,
					placement: 'right',
					content: $(error).text(),
					template: '<div class="popover"><div class="arrow"></div><div class="popover-inner"><div class="popover-content"><p></p></div></div></div>'
				});
				_popover.data('bs.popover').options.content = $(error).text();
				$(element).popover('show');
			},
			success: function (label, element) {
    			$(element).popover('hide');
			},
			submitHandler : function(form) {
				$('#signUpBtn').text('Please wait');
				$('#signUpBtn').prop('disabled', true);
				sendAjax();
			}
		});
	
	/**
	 * Send json to server.
	 */
	function sendAjax() {
		const BAD_REQUEST = 400;
		var data = JSON.stringify({
			firstName: $('#firstName').val(),
			lastName: $('#lastName').val(),
			email: $('#email').val(),
			password: $('#password').val()
		});
		$.ajax({
			url: 'register',
			type: 'POST',
			dataType: 'text',
			contentType: 'application/json',
			data: data,
			success: function(data, textStatus, xhr) {
				top.location.href = xhr.getResponseHeader('Location');
			},
			error: function(data, textStatus) {
				if (!$('#err').length) {
					if (data.status===BAD_REQUEST)
						$('#line_rb').after('<div class="error alert alert-danger fade in" id="err"><strong> Error! </strong>' + data.responseText + '</div>');
					else
						$('#line_rb').after('<div class="error alert alert-danger fade in" id="err"><strong> Internal error! </strong></div>');
				}
				$('#signUpBtn').text('Sign up');
				$('#signUpBtn').prop('disabled', false);
			}
		});
	}
});
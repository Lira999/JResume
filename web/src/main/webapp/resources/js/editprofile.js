$(document).ready(function() {
	$.ajax({
		type : 'GET',
		url : 'editprofile/result',
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
			$('#firstName').val(response.firstName);
			$('#lastName').val(response.lastName);
		},
		error : function(data, status, er) {
		}
	});
});

$(function() {
	jQuery.validator.addMethod('regx', function(value, element, regexpr) {
		return regexpr.test(value);
	}, 'Please enter a valid data.');

	jQuery.validator
			.setDefaults({
				ignore : ':hidden:not(#tAndC)',
				highlight : function(element) {
					$(element).closest('.input-group').removeClass(
							'has-success');
					$(element).closest('.input-group').addClass('has-error');
					$(element).nextAll('.glyphicon').remove();
					$(element)
							.after(
									'<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
				},
				unhighlight : function(element) {
					$(element).closest('.input-group').removeClass('has-error');
					$(element).closest('.input-group').addClass('has-success');
					$(element).nextAll('.glyphicon').remove();
					$(element)
							.after(
									'<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
				}
			});

	$('.edit-profile-form')
			.validate(
					{
						onkeyup : function(element) {
							if ($(element).attr('id') === $('#password').attr(
									'id')
									&& $('#passwordConfirmation').val().length > 0) {
								$('#passwordConfirmation').valid();
							}
							return $(element).valid();
						},
						rules : {
							firstName : {
								required : true,
								regx : /^[A-Za-z][A-Za-z\- ']*$/
							},
							lastName : {
								required : true,
								regx : /^[A-Za-z][A-Za-z\- ']*$/
							},
							currentPassword : {
								required : true,
								remote : {
									url : 'currentPassword',
									type : 'POST',
									value : true
								}
							},
							password : {
								minlength : 5,
							},
							passwordConfirmation : {
								minlength : 5,
								equalTo : '#password'
							}
						},
						messages : {
							firstName : {
								required : 'Please enter your first name',
								regx : 'Please enter your first name correctly'
							},
							lastName : {
								required : 'Please enter your last name.',
								regx : 'Please enter your last name correctly'
							},
							currentPassword : {
								required : 'Please enter current password',
								remote : 'This password does not match'
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
						},
						errorPlacement : function(error, element) {
							var _popover;
							_popover = $(element)
									.popover(
											{
												trigger : 'manual',
												animation : false,
												placement : 'right',
												content : $(error).text(),
												template : '<div class="popover"><div class="arrow"></div><div class="popover-inner"><div class="popover-content"><p></p></div></div></div>'
											});
							_popover.data('bs.popover').options.content = $(
									error).text();
							$(element).popover('show');
						},
						success : function(label, element) {
							$(element).popover('hide');
						},
						submitHandler : function(form) {
							sendAjax();
						},
						invalidHandler : function(form) {
						}
					});

	function sendAjax() {
		const
		BAD_REQUEST = 400;
		var data = JSON.stringify({
			firstName : $('#firstName').val(),
			lastName : $('#lastName').val(),
			password : $('#password').val()
		});
		$
				.ajax({
					url : 'editprofile',
					type : 'POST',
					dataType : 'text',
					contentType : 'application/json',
					data : data,
					success : function(data, textStatus, xhr) {
						top.location.href = '';
					},
					error : function(data, textStatus) {
						if (!$('#err').length) {
							if (data.status === BAD_REQUEST)
								$('#line_rb')
										.after(
												'<div class="error alert alert-danger fade in" id="err"><strong> Error! </strong>'
														+ data.responseText
														+ '</div>');
							else
								$('#line_rb')
										.after(
												'<div class="error alert alert-danger fade in" id="err"><strong> Internal error! </strong></div>');
						}
					}
				});
	}
});

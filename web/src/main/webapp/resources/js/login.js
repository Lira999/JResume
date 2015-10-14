$(function() {
	jQuery.validator.addMethod('regx', function(value, element, regexpr) {
		return regexpr.test(value);
	}, 'Please enter a valid data.');
	jQuery.validator.setDefaults({
		highlight: function(element) {
			$(element).closest('.input-group').removeClass('has-success');
			$(element).closest('.input-group').addClass('has-error');
			$(element).nextAll('.glyphicon').remove();
			$(element).after('<span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>');
		},
		unhighlight: function(element) {
			$(element).closest('.input-group').removeClass('has-error');
			$(element).closest('.input-group').addClass('has-success');
			$(element).nextAll('.glyphicon').remove();
			$(element).after('<span class="glyphicon glyphicon-ok form-control-feedback"></span>');
		}
	});
	$(".login-form").validate({
			rules : {
				username : {
					required : true,
					regx : /^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$/
				},
				password : {
					required : true
				}
			},
			messages : {
				username : {
					required : 'Please, enter your e-mail',
					regx : 'Please, enter your e-mail correctly'
				},
				password : {
					required : 'Please, enter your password'
				}
			},
			errorPlacement: function (error, element) {
				var _popover;
				_popover = $(element).popover({
					trigger: 'manual',
					placement: 'right',
					content: $(error).text(),
					template: '<div class=\"popover\"><div class=\"arrow\"></div><div class=\"popover-inner\"><div class=\"popover-content\"><p></p></div></div></div>'
				});
				_popover.data('bs.popover').options.content = $(error).text();
				$(element).popover('show');
			},
			success: function (label, element) {
				$(element).popover('hide');
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
});
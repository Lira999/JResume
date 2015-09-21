$(document).ready(function() {
	$("#showHide").click(function() {
		if ($(".form-control").attr("type") == "form-control") {
			$(".form-control").attr("type", "password");
			$(this).val("Show password");
		} else {
			$(".form-control").attr("type", "form-control");
			$(this).val("Hide password");
		}
	});
});
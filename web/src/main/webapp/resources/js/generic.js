var TYPICAL_ERRROR_MESSAGE = '<div class="alert error alert-danger fade in">' + 
				'<strong>Error: </strong>JResume encountered some internal' + 
				' problems. We working to resolve the issue as soon as possible.' + 
				' Please, try again later.</div>';
function showErrorMessage(element, message) {
	$(element).empty();
	$(element).prepend(message === undefined ? TYPICAL_ERRROR_MESSAGE : message);
}
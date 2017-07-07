var id_calendar_departure = new 'departure_date';
function calendar(id_calendar_departure) {
	var today = new Date().toISOString().split('T')[0];
	document.getElementsByName("departure_date")[0].setAttribute('min', today);
}

var id_calendar_arrival = new 'departure_date';
function calendar_arrival(id_calendar_arrival) {
	var today = new Date().toISOString().split('T')[0];
	document.getElementsByName("arrival_date")[0].setAttribute('min', today);
}

function validate_form() {
	valid = true;
	if (document.val_form.login.value == "") {
		alert("Пожалуйста заполните поле 'Login'.");
		valid = false;
		return valid;
	}
	if (document.val_form.pass.value == "") {
		alert("Пожалуйста заполните поле 'Password'.");
		valid = false;
		return valid;
	}
}

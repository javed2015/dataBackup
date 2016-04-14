function required() {
	var val = 0;

	if (document.vinform.fname.value.length == 0) {
		val = 1;
		document.vinform.fname.style.background = 'Yellow';
	} else {
		document.vinform.fname.style.background = 'White';
	}
	if (document.vinform.lname.value.length == 0) {
		val = 1;
		document.vinform.lname.style.background = 'Yellow';
	} else {
		document.vinform.lname.style.background = 'White';
	}
	if (document.vinform.email.value.length == 0) {
		val = 1;
		document.vinform.email.style.background = 'Yellow';
	} else {
		document.vinform.email.style.background = 'White';
	}
	if (document.vinform.pass.value.length == 0) {
		val = 1;
		document.vinform.pass.style.background = 'Yellow';
	} else {
		document.vinform.pass.style.background = 'White';
	}
	if (val == 0) {
		return true;
	} else if (val == 1) {
		alert("fill all required fields");
		return false;
	}

}

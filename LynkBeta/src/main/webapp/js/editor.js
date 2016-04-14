
$.get("header.jsp", function(data) {
	$("head").append(data);
});
$.get("body.jsp", function(dataa) {
	$('#lytop').append(dataa);
});

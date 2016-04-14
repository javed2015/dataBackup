<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/jquery-ui.min.js"></script>

<style>
.ui-autocomplete {
	cursor: pointer;
	height: 120px;
	overflow-y: scroll;
}
</style>
</head>
<body>
	<h3>Country</h3>
	<input type="text" id="country" name="country" />
	<div id="result"></div>

	<script>
$(document).ready(function() {
$(function() {
                $("#country").autocomplete({     
                source : function(request, response) {
                $.ajax({
                        url : "srs",
                        type : "POST",
                        data : 'q='+request.term,
                        dataType: "json",
                        success : function(data) {
							$("#country").removeClass('ui-autocomplete-loading');  
							response(data);                       
                        }
                });
        },
		select : function(event, ui){
			autocompleteGenNotesResult(ui.item.label);
			}
});
});
});
function autocompleteGenNotesResult(query){
	$.ajax({
				type : 'post',
				url : 'agns',
				data : 'query='+query,
				dataType: "json",
				success: function(resp){
					var row= $('<tr> </tr>').appendTo('#result');  
				$.each(resp, function(key, value) {   
    var urlLink= value.restCall;
	console.log(urlLink);
        $('<td> </td>').text(resp[key].name).appendTo(row);
        $('<td> </td>').text(value.description).appendTo(row);
        $('<a target="_blank" href='+urlLink+'> <td> </td> </a>').text(urlLink).appendTo(row);
				})
				},
				error: function(resp){},
			});
}
    </script>
</body>
</html>
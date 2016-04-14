/*project test page starts here*/
$('#btn-test').click(function(){
	var testurl  = $.trim($('#testurl').val());
	if(testurl=="")
	{
		alert("Please enter the test url");
		$('#testurl').focus();
		return false;
	}
	else
	{
        	$("body").css("overflow", "hidden");
     		$('#overlay').show();     		
        		 $.ajax({
        			  method: "POST",
        			   url: 'InstantWinAppTest', 
        			   data:"testurl="+testurl,
        			  dataType: "json",        			
        			  success:function(resp){
        				  
        				  $('#overlay').hide();
	          			  $("body").css("overflow", "auto");
        				  var jsonm = JSON.stringify(resp);
        				  var obj = JSON.parse(jsonm);
        				  if(parseInt(obj[1].percentage)>90){
        					  var approvemessage ="This application is approved for release";
        				  }else{
        					  var approvemessage ="This application is not scalable";
        				  }
        				  //alert(obj[1].percentage);
        				  $('#percentagediv').html("<h4 style='color:red;display:inline-block;margin:0px'>"+obj[1].percentage+"% </h4> <h5 style='display:inline-block;margin:0px'>of the pages loaded below 5 seconds.</h5><h5 style='margin:0px'>"+approvemessage+"</h5>").css('color','green');
	        				 
	        				  //var jsonmessage = '[{ "message":"http://ec2-54-224-23-27.compute-1.amazonaws.com:8080/Appvance/analyze.html?config=1511216891&exeId=1442926918691"},{"percentage":"99.44"}]';
	        				 
	        				  //$('#percentagediv').text(obj[1].percentage);
		        				alert("Test is done. Please click on view results");
		        			    $("#resultBtn").click(function(){
		        			    	window.open(obj[0].message, "_blank"); 
		        			    });       
        					
        			  },
        			  error:function(data)
        			  {
        			//	alert("data");  
        			  },
        			});
		}
        		
 });

/*project test page ends here*/
/*newprojectcreation scripts starts here*/
$("#rpath,#projname").keypress(function(e) {
	if (e.keyCode == 13) {
		$('#checkbtn').trigger('click');
	}
});
$('#projname').blur(
		function() {

			var projname = $.trim($('#projname').val());

			if (projname == "") {
				$('#errormessage-div').text("Please Enter Project Name").css(
						'color', 'red');
				$('#projname').focus();

			} else if (projname != "") {
				$('#errormessage-div').text("");
			}
		});
/*$('#rpath').blur(
		function() {

			var remotepath = $.trim($('#rpath').val());

			if (remotepath == "") {
				$('#errormessage-div').text("Please Enter Repository Path")
						.css('color', 'red');
				$('#rpath').focus();

			} else if (remotepath != "") {
				$('#errormessage-div').text("");
			}
		});*/

$('#checkbtn')
		.click(
				function() {
					var userid = $('#useridval').val();
					var userFname = $('#userFname').val();
					var githubUser = $('#githubUser').val();
					var githubPass = $('#githubPwd').val();
						var projname = $.trim($('#projname').val());
					var remotepath = $.trim($('#rpath').val());
						var project_type = $('.project-type').val();
						var platform = $('.platform:checked').length;
						var cloud = $('.cloud:checked').length;
						var language = $('.language:checked').length;
					if (projname == "") {
						$('#errormessage-div')
								.text("Please Enter Project Name").css('color',
										'red');
						$('#projname').focus();
						return false;
					} /*else if (remotepath == "") {
						$('#errormessage-div').text(
								"Please Enter Repository Path").css('color',
								'red');
						$('#rpath').focus();
						return false;
					} else if (project_type < 1) {

						$('#errormessage-div').text(
								"Please select any one project type.").css(
								'color', 'red');
						return false;
					}*/ else if (platform < 1) {

						$('#errormessage-div').text(
								"Please select any one platform.").css('color',
								'red');
						return false;
					} else if (cloud < 1) {

						$('#errormessage-div').text(
								"Please select any one cloud.").css('color',
								'red');
						return false;
					} else if (language < 1) {

						$('#errormessage-div').text(
								"Please select any one language.").css('color',
								'red');
						return false;
					} else {
						var projecttype = $('.project-type').val();
						var platformval = $('.platform:checked').val();
						var cloudval = $('.cloud:checked').val();
						var languageval = $('.language:checked').val();
						$('#errormessage-div').text("");
						$("body").css("overflow", "hidden");
						$('#overlay').show();
						$('.ajaxresponsemsg').text('Cloning Repo');
						
						var queryString = 'rpath='
								+ encodeURIComponent(remotepath) + '&projname='
								+ encodeURIComponent(projname)
								+ '&projecttype='
								+ encodeURIComponent(projecttype)
								+ '&platformval='
								+ encodeURIComponent(platformval)
								+ '&cloudval=' + encodeURIComponent(cloudval)
								+ '&languageval='
								+ encodeURIComponent(languageval) + '&userid='
								+ encodeURIComponent(userid)+ '&userFname='
								+ encodeURIComponent(userFname) + '&githubUser='
								+ encodeURIComponent(githubUser)+ '&githubPass='
								+ encodeURIComponent(githubPass);
						if(projecttype=="InstantWinApp"){
						newprojectcreate(queryString,0);
						}else{
							newprojectWordPress(queryString,0);
						}
						}
				});

function newprojectWordPress(queryString, status)
{
	$.ajax({
		method : "POST",
		url : 'WordPressImpl',
//		url : 'AjaxResponse',
		dataType : "html",
		data : queryString+'&status='+status,
		
		success : function(resp) {
			
			if($.trim(resp)!="Invalid" && $.trim(resp)!="Terminate")
			{
				$('.ajaxresponsemsg').text(resp);
				newprojectWordPress(queryString, ++status);
			}
			else if($.trim(resp)=="Invalid")
			{
				$('#overlay').hide();
				$("body").css("overflow", "auto");
				//window.location.href='dashboard.jsp';
				alert("Invalid Repository Credentials");
				return false;
				
			}
			else
			{
				$('#overlay').hide();
				$("body").css("overflow", "auto");
				window.location.href='dashboard.jsp';
				
			}
		},
	});
}

function newprojectcreate(queryString, status)
{
	$.ajax({
		method : "POST",
		url : 'FetchRepository',
//		url : 'AjaxResponse',
		dataType : "html",
		data : queryString+'&status='+status,
		
		success : function(resp) {
			
			if($.trim(resp)!="Invalid" && $.trim(resp)!="Terminate")
			{
				$('.ajaxresponsemsg').text(resp);
				newprojectcreate(queryString, ++status);
			}
			else if($.trim(resp)=="Invalid")
			{
				$('#overlay').hide();
				$("body").css("overflow", "auto");
				//window.location.href='dashboard.jsp';
				alert("Invalid Repository Credentials");
				return false;
				
			}
			else
			{
				$('#overlay').hide();
				$("body").css("overflow", "auto");
				window.location.href='dashboard.jsp';
				
			}
		},
	});
}

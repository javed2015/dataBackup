
<%

String userId = null;
String fName = null;
String message =null;
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies){
		 if(cookie.getName().equals("userid")) {
			 userId = cookie.getValue();
		 }else if(cookie.getName().equals("fName")) {
			 fName = cookie.getValue();
		 }else if(cookie.getName().equals("message")) {
			 message = cookie.getValue();
		 }
	}

}else{
	userId = null;
	fName = null;
	message =null;
}
Cookie messageCk =new Cookie("message", " ");
response.addCookie(messageCk);

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FactualNote</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="google-signin-client_id"
	content="367684915910-37hs9sir7qoqvtp9gebefeifmst7m1mf.apps.googleusercontent.com">
<!-- jQuery -->
<script type="text/javascript" src="js/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/i18n/grid.locale-en.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/js/jquery.jqGrid.min.js"></script>
<!-- #change & want to check -->
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/jqgrid/4.6.0/css/ui.jqgrid.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://platform.linkedin.com/in.js">
api_key:   75npkyj6xcz5vd
authorize: false
onLoad:    onLinkedInLoad
lang: 	   en_US 
</script>
<script type="text/javascript" src="js/factualnote_script.js"></script>
<!--Lynked css-->
<link href="css/factualnoteStyle.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/redmond/jquery-ui.css" />
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />
<link href='https://fonts.googleapis.com/css?family=Lobster'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<div class="container-fluid" style="overflow-x: hidden;">
		<div id="fb-root"></div>
		<div class="lynked-bg lynked-ful"></div>
		<div class="lynked-overlay lynked-ful"></div>
		<nav class="navbar navbar-default navbar-fixed-top lynked-navbar">
		<div class="container-fluid lynked-nav">
			<%
				if (userId != null) {
			%>
			<div class="dropdown">
				<a class="dropdown-toggle" type="button" id="menu1"
					data-toggle="dropdown"><%=fName%> <span class="caret"></span></a>
				<ul class="dropdown-menu user-menu" role="menu"
					aria-labelledby="menu1">
					<li><input type="button" id="open-notes" class="ly-logout"
						value="Notes"></li>
					<li><input type="submit" class="ly-logout" value="Settings"></li>
					<li><input type="submit" class="ly-logout"
						onClick="signOut();" value="Sign out"></li>
				</ul>
			</div>
			<%
				}
			%>
			<a class="signin-close" style="display: none">Home</a>
			<%
				if ((message == null)
						|| message.equals("You have Successfully Registered and Logged In")) {
			%>
			<script>
					$(document).ready(function(){
					$('#lynked-popup1').hide();
					$('#lynked-url').show();
					$(".signin-close").hide();
					$(".lynked-signin-open").show();
				});
					</script>
			<%
				} else if (message.equals("Invalid User Name or Password")) {
			%>
			<script>
					$(document).ready(function(){
					console.log("in");
					$('#lynked-popup1').show();
					$('#lynked-url').hide();
					$(".lynked-signin-open").hide();
					$('.lb-header').show();	
					$(".signin-close").show();
				});
				</script>
			<%
				} else if (message.equals("User Already Exists")) {
			%>
			<script>
					$(document).ready(function(){
					$('#lynked-popup1').show();
					$('#lynked-url').hide();
					$(".lynked-signin-open").hide();
					$('.lb-header').show();	
					$(".signin-close").show();
					$('#signup-box-link').click();
					console.log("signup");
				});
				</script>
			<%
				}
			%>
			<a class="lynked-signout" onclick="signOut();" style="display: none">Signout</a>
			<%
				if (userId == null) {
			%>
			<a class="lynked-signin-open" type="button">Sign In / Up</a>
			<%
				} else {
			%>

			<%
				}
			%>
		</div>
		</nav>
		<div class="col-xs-12 col-sm-6 col-md-6 lynkdesc">
			<p class="ly-para">Factualnote.com is an web annotation
				application, which helps the users to mark the specific text,
				element, page, video, etc in a web page and share it to like-minded
				people.</p>
			<p class="ly-para">As we know the relevant data has been
				wide-spreaded across various sites under many intentions,
				factualnote.com is a type of social software tool in which factual
				data are brought forward or narrow down to the web users.</p>
		</div>
		<div class="col-xs-12 col-sm-6 col-md-6">
			<div class="signup-header">
				<form name="myForm" method="post" onsubmit="return check_it()"
					action="f">
					<div id="lynked-url">
						<label class="heading">FactualNote</label> <input id="lynked-eUrl"
							class="lynked-url-i tx1" type="text" placeholder="Enter the URL"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = 'Enter the URL'"
							message="Please enter the URL" data-toggle="tooltip" name="URL">
						<p1></p1>
						<input class="btn-url" id="lynked-url-submit" type="submit"
							value="Create a Note">
						<div class="row">
							<div class="col-xs-12">
							<div class="forgeterrorMessage" align="center"
								style="color: green";>
								<%
									if (("You have Successfully Registered and Logged In").equals(message)) {
								%><%=message%>
								<%
									}
								%>
							</div>
						</div>
						</div>
					</div>
				</form>
				<div class="login-box" id="lynked-popup1">
					<div class="lb-header">
						<a class="active parent" name="signin" id="signin-box-link">Sign
							In</a> <a class="parent" name="signup" id="signup-box-link">Sign
							Up</a>
					</div>
					<form id="lynkedSignin" method="post" action="uls">
						<div id="signin" class="child lynk-signin">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="email" placeholder="Email" name="factual_email" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="password" placeholder="Password"
											name="factual_pwd" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="u-form-group">
										<input type="submit" value="Sign in">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<span class="forgot-password">Forgot password?</span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="forgeterrorMessage" align="center"
										style="color: red";>
										<%
											if (("Invalid User Name or Password").equals(message)) {
										%><%=message%>
										<%
											}
										%>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="lynked-social-login">
										<li><fb:login-button scope="public_profile,email"
												onlogin="checkLoginState();"></fb:login-button></li>
										<div id="status" style="display: none";></div>
										<li><div class="g-signin2" data-onsuccess="onSignIn"
												data-height="25" data-width="82"></div></li>
										<li><script type="in/Login"></script></li>
									</div>
								</div>
							</div>
						</div>
					</form>
					<form id="lynkedSignup" method="post" action="urs">
						<div id="signup" class="child lynk-signup">
							<div class="row">
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group lynked-iname">
										<input type="text" name="lynked_first_name"
											placeholder="First Name" />
									</div>
								</div>
								<div class="col-xs-12 col-sm-6 col-md-6">
									<div class="form-group lynked-iname">
										<input type="text" name="lynked_last_name"
											placeholder="Last Name" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="email" name="user_reg_email" placeholder="Email" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="password" name="user_reg_pwd"
											placeholder="Password" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="password" name="user_reg_cnfrm_pwd"
											placeholder="Confirm Password" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group" style="color: #fff">
										<input type="checkbox">Subscribe for Newsletter
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="u-form-group">
										<input type="submit" value="Sign up">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="forgeterrorMessage" align="center"
										style="color: red";>
										<%
											if (("User Already Exists").equals(message)) {
										%><%=message%>
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		</form>
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">Generated Notes</h4>
					</div>
					<div class="modal-body">
						<table id="grid"></table>
						<div id="generatedNotes"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.javascript files -->
	<script type="text/javascript">
    
    // Setup an event listener to make an API call once auth is complete
    function onLinkedInLoad() {
        IN.Event.on(IN, "auth", getProfileData);
		console.log('<%=message%>');
    }
    // Handle the successful return from the API call
    function onSuccess(data) {
        lynkedStatus="connected-ln";
    	sts.lynkedLog();
    	//console.log(lynkedStatus);
        //console.log(data);
    }

    // Handle an error response from the API call
    function onError(error) {
        //console.log(error);
    }

    // Use the API call wrapper to request the member's basic profile data
    function getProfileData() {
    	IN.API.Raw("/people/~:(id,firstName,lastName,emailAddress)?format=json").result(onSuccess).error(onError);
    }

</script>
	<script>

function onSignIn(googleUser) {
  lynkedStatus="connected-g+";
  //console.log(lynkedStatus);
  sts.lynkedLog();
  var profile = googleUser.getBasicProfile();
  //console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
 // console.log('Name: ' + profile.getName());
 // console.log('Image URL: ' + profile.getImageUrl());
 // console.log('Email: ' + profile.getEmail());
}
</script>
	<script>
	var lynkURL = window.location.href;
	function signOut() {
		if(lynkedStatus === "connected-g+"){
			document.location.href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue="+lynkURL;//lynked-server
		}
		else if (lynkedStatus === "connected-ln"){
			IN.User.logout(function(){
			  window.location= lynkURL; 
	  		});
		}
		else if( lynkedStatus === "connected-fb"){
		  	FB.logout(function(response) {
			  window.location= lynkURL; 		 
		     });
		 }
		else{
				$.ajax({
					async : true,
					type : 'POST',
					url : 'ls',
					success : window.location.hostname =="localhost" ? window.location= "http://localhost:8080/LynkBetaTest" : window.location= window.location.origin,		
				});
		}
		  lynkedStatus="0";
		  sts.lynkedLog();
	  }
</script>
	<script>
		new WOW().init();
		$(document).ready(function() {
			$('.signup-header').css('transform', 'translateX(0px)');
			$('.lynkdesc').css('transform','translateX(0px)');
			$('.lynked-navbar').css('transform','translateY(0px)');
		});	      
	</script>
	<script type="text/javascript">//fb
// This is called with the results from from FB.getLoginStatus().
function statusChangeCallback(response) {
	//console.log('statusChangeCallback');
	//console.log(response);
	// The response object is returned with a status field that lets the
	// app know the current login status of the person.
	// Full docs on the response object can be found in the documentation
	// for FB.getLoginStatus().
	if (response.status === 'connected') {
		// Logged into your app and Facebook.
		lynkedStatus="connected-fb";
		//console.log(lynkedStatus);
		sts.lynkedLog();
		testAPI();
	} else if (response.status === 'not_authorized') {
		// The person is logged into Facebook, but not your app.
		document.getElementById('status').innerHTML = 'Please log ' +
			'into this app.';
	} else {
		// The person is not logged into Facebook, so we're not sure if
		// they are logged into this app or not.
		document.getElementById('status').innerHTML = 'Please log ' +
			'into Facebook.';

	}
}

// This function is called when someone finishes with the Login
// Button.  See the onlogin handler attached to it in the sample
// code below.
function checkLoginState() {
	FB.getLoginStatus(function(response) {
		statusChangeCallback(response);
	});
}

window.fbAsyncInit = function() {
FB.init({
	appId      : '1496614563980450',
	cookie     : true,  // enable cookies to allow the server to access
											// the session
	xfbml      : true,  // parse social plugins on this page
	version    : 'v2.5' // use version 2.2
});

// Now that we've initialized the JavaScript SDK, we call
// FB.getLoginStatus().  This function gets the state of the
// person visiting this page and can return one of three states to
// the callback you provide.  They can be:
//
// 1. Logged into your app ('connected')
// 2. Logged into Facebook, but not your app ('not_authorized')
// 3. Not logged into Facebook and can't tell if they are logged into
//    your app or not.
//
// These three cases are handled in the callback function.

FB.getLoginStatus(function(response) {
	statusChangeCallback(response);
}, {scope:'public_profile,email'});

};

// Load the SDK asynchronously
(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) return;
	js = d.createElement(s); js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));

// Here we run a very simple test of the Graph API after login is
// successful.  See statusChangeCallback() for when this call is made.
function testAPI() {
	//console.log('Welcome!  Fetching your information.... ');
	FB.api('/me?fields=name,email', function(response) {
		//console.log('Successful login for: ' + response.name);
		document.getElementById('status').innerHTML =
			'Thanks for logging in, ' + response.name + '!';
	//console.log(response);
	});
}	</script>
	<script>
 $(document).ready(function() {
    $('#lynkedSignin').bootstrapValidator({
        framework: 'bootstrap',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [':disabled'],
        fields: {
          factual_email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    }
                }
            },
            factual_pwd : {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
             //       stringLength: {
             //           min: 5,
             //           message: 'The password is not valid'
             //       }
                }
            },
        }
    });
  $('#lynkedSignup').bootstrapValidator({
       framework: 'bootstrap',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        excluded: [':disabled'],
        fields: {
        lynked_first_name: {
                 validators: {
                    notEmpty: {
                        message: 'The first name is required'
                    }
                }
            },
         lynked_last_name: {
    validators: {
       notEmpty: {
       message: 'The last name is required'
      }
     }
    },
   user_reg_email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required'
                    }
                }
            },    
            user_reg_pwd : {
                validators: {
                    notEmpty: {
                        message: 'The password is required'
                    }
                }
            },
      user_reg_cnfrm_pwd : {
                validators: {
                    notEmpty: {
                        message: 'The confirm password is required'
                    },
      identical: {
                            field: 'user_reg_pwd',
                            message: 'The password and its confirm must be the same'
                        }
                }
            }
        }
    });
 });
 </script>
	<script>
 (function($) {
    $.fn.bootstrapValidator.validators.emailAddress = {
        enableByHtml5: function($field) {
            return ('email' == $field.attr('type'));
        },
        validate: function(validator, $field, options) {
            var value = $field.val();
            if (value == '') {
                return true;
            }
            var emailRegExp = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return emailRegExp.test(value);
        }
    }
}(window.jQuery));
 </script>

	<script>
var jsonData;
$('#open-notes').on('click', function(e) {

			e.preventDefault();
		$.ajax({
				type : 'post',
				url : 'gnl',
				success: function(resp){
				jsonData = resp;
				showContent();
				
				},
				error: function(resp){},
			});
	
});
		
		
function showContent(){
$("#grid").jqGrid({
    colModel: [            
			{ name: 'name'},
			{ name: 'description'},
			{ name: 'restCall',hidden:true,},
			{ name: '', align: 'center', sortable: false, 
			formatter: function () { return "<a class='ly-logout' target='_blank'>view</a>"; } }
        ],
		 
        pager: '#generatedNotes',
        datatype: "jsonstring",
        datastr: jsonData,
        jsonReader: { repeatitems: false },
        rowNum: 10,
        viewrecords: true,
        caption: "Generated Notes",
        height: "auto",
        ignoreCase: true,
		beforeSelectRow: function (rowid, e) {
		var rowData = $(this).jqGrid("getRowData", rowid);
        rowData.restCall;
		lynked_noteView(rowData.restCall);
		return true;		
    },
	
});
//$('#grid').jqGrid('hidecolumn', 'restCall');
function lynked_noteView(lynked_noteUrl){
	$('.ly-logout').attr('href',lynked_noteUrl);
}
 $('#myModal').modal('show');
 $("#grid").jqGrid('navGrid', '#generatedNotes',
        { add: false, edit: false, del: false, search: true, view: true}, {}, {}, {},{multipleSearch:false});
		
}		
</script>
</body>

</html>

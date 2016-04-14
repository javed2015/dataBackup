<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="google-signin-client_id"
	content="367684915910-sdgofi4i1ctmmknudkck7nqnj8tjf2v6.apps.googleusercontent.com">
<title>FactualNote</title>
<%
	String context = application.getAttribute("lynk_context")
			.toString();
%>
<link href=<%=context + "/css/factualnoteStyle.css"%> rel="stylesheet" />
<link href=<%=context + "/css/bootstrap.min.css"%> rel="stylesheet" />
<script type="text/javascript" src=<%=context + "/js/jquery.js"%>></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script type="text/javascript" src=<%=context + "/js/bootstrap.min.js"%>></script>
<script type="text/javascript" src="//platform.linkedin.com/in.js"></script>
<script type="text/javascript" src=<%=context + "/js/factualnote_script.js"%>></script>
</head>
<body class="bg-2">
	<input type="hidden" name="lynk_context" id="lynk_context"
		value=<%=context%> />
	<div id="fb-root"></div>
	<div class="lynked-overlay lynked-ful"></div>
	<form action="index.jsp">
		<div class="cong-box">
			<h3>Generated a Note</h3>
			<input class="tx4 lynked-url-box" id="lynked-gen-url" type="text"
				placeholder=""><br> <input class="btn" type="submit"
				value="Home">
			<div style="display: inline-block; position: relative">
				<div class="lynk-copy">copied!</div>
				<div class="lynk-copy-arrow"></div>
				<input id="lynk-copy-btn" class="btn" type="button"
					value="Clipboard" onclick="copyToClipboard()">
			</div>
			<input class="btn" type="button" value="Email a Note"
				id="lynk-emailid">
			<div class="lynked-social-share">
				<li><div class="fb-share-button" id="fb" data-href=""
						data-layout="button"></div></li>
				<li><div class="g-plus" data-action="share" data-size="medium"
						data-annotation="none" data-href="" id="gl"></div></li>
				<li><a href="https://twitter.com/share"
					class="twitter-share-button" {count} data-url="" data-size="medium"
					id="tw-fn-share"></a></li>
				<li><script type="IN/Share" id="ln" data-url=""></script></li> <br>
				<p2></p2>
			</div>
		</div>
	</form>

	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Email a Note</h4>
				</div>
				<form>
					<div class="modal-body">
						<label>To:</label><input type="email" class="ly-email"
							id="lynked-rec-id" required="required" style="width: 95%;"
							message="Email send successfully"><br>
					</div>
					<div class="modal-footer">
						<button type="button" id="lynk-email-button-submit"
							class="btn emailsend-btn" data-dismiss="modal">Send</button>
						<button type="reset" class="btn">Reset</button>
					</div>
				</form>
			</div>

		</div>
	</div>

	<script>
		$(document).ready(function() {
			$("#lynk-emailid").click(function() {
				$("#myModal").modal();
			});
		});
	</script>
	<script>
		$(".emailsend-btn").click(
				function() {
					$(".lynked-social-share").parent().find('p2').html(
							$(".ly-email").attr('message')).addClass(
							'success-msg');
					$('.success-msg').fadeOut("3000");
				});
	</script>

	<script>
		function getParameterByName(name) {
			name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
			var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), results = regex
					.exec(location.search);
			return results === null ? "" : decodeURIComponent(results[1]
					.replace(/\+/g, " "));
		}
		function getToken() {
			var t = getParameterByName('lynk_token1');
			var baseURL = document.getElementById('lynk_context').value + "/f/";
			var token = baseURL.concat(t);
			document.getElementById('lynked-gen-url').value = token;
		}
		$(document).ready(getToken);
	</script>
	<script>
		var aux = document.createElement("input");
		function copyToClipboard(elementId) {
			//	console.log(document.getElementById(elementId));
			aux.setAttribute("value",
					document.getElementById('lynked-gen-url').value);
			document.body.appendChild(aux);
			aux.select();
			document.execCommand("copy");
			document.body.removeChild(aux);
		}
	</script>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=1496614563980450";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<script>
		$('#lynk-email-button-submit').on('click', function(e) {
			e.preventDefault();

			var generatedUrl = $('#lynked-gen-url').val();
			var recId = $('#lynked-rec-id').val();
			//console.log("generatedUrl" + generatedUrl + "recId" + recId);

			$.ajax({
				async : true,
				type : 'GET',
				url : 'LynkedEMail',
				//dataType : "text",
				data : '&generatedUrl=' + generatedUrl + '&recId=' + recId

			});
			$('#myModal').hide();
		});
	</script>
	<script>
		$(document).ready(
				function() {
					var lynkdata = $("#lynked-gen-url").val();
					//console.log(lynkdata);
					var res = lynkdata.substr(25);
						//console.log(res);
					document.getElementById('fb').setAttribute('data-href',lynkdata);
					document.getElementById('gl').setAttribute('data-href',
							'http://factualnote.com/f/' + res);
					document.getElementById('ln').setAttribute('data-url',
							lynkdata);
					$(".twitter-share-button").attr('data-url', lynkdata);
				});
	</script>
</body>
</html>

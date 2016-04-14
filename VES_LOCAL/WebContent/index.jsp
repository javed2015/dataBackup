<%@ include file="loginHeader.jsp"%>
<div class="container">
	<form class="form-signin" id="form-signin" method="post"
		action="login.jsp">
		<div class="form-signin-heading">
			<img src="images/vserver_logo.png" class="login-logo">
		</div>
		<div class="login-wrap">
			<label for="email">Email address</label> <input id="email"
				type="text" class="form-control" name="uname" placeholder=""
				autofocus> <label for="password">Password</label> <input
				id="password" type="password" class="form-control" name="pass"
				placeholder="" style="margin-bottom: 5px;">

			<div class="pass-bar">
				<span data-toggle="modal" href="#forgotPass"
					class="forgot-pass forgetpassword">Forgot Password?</span>
			</div>

			<input class="btn btn-lg btn-login btn-block" type="button"
				value="Sign In">
			<div id="errorMessage" align="center">${message}</div>
			<div class="registration">
				<p class="reg-text">Don't have an account?</p>
				<a class="aux-btn" href="reg.jsp">Sign Up</a>
			</div>

		</div>







		<!--<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="reqAccess" class="modal fade">
             <div class="modal-dialog">
                 <div class="modal-content">
                     <div class="modal-header">
                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                         <h4 class="modal-title">Forgot Password ?</h4>
                     </div>
                     <div class="modal-body">
                         <p>Enter your e-mail address below to reset your password.</p>
                         <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                     </div>
                     <div class="modal-footer">
                         <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                         <button class="btn btn-success" type="button">Submit</button>
                     </div>
                 </div>
             </div>
         </div>-->
		<!-- modal -->

	</form>
	<!-- Modal -->

	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
		tabindex="-1" id="forgotPass" class="modal fade">
		<form class="form-forgetpass" id="form-forgetpass" method="post"
			action="login.jsp">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Forgot Password ?</h4>
					</div>
					<div class="modal-body">
						<p>Enter your e-mail address below to reset your password.</p>
						<input type="text" name="email" id="forgetemail"
							placeholder="Email" autocomplete="off"
							class="form-control placeholder-no-fix">

					</div>
					<div class="modal-footer">
						<div id="forgeterrorMessage" align="center">${message}</div>
						<button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
						<input class="btn btn-success" type="button" id="forgetbtn"
							value="Submit">
					</div>

				</div>
			</div>
		</form>
	</div>
</div>
<script src="scripts/login.js"></script>
<!-- <script src="scripts/forgetpassword.js?t=1"></script> -->
<%@ include file="loginFooter.jsp"%>


<div id="dynamicData" style="display: block"></div>
<%@ include file="Header.jsp"%>
<section class="wrapper">

	<div class="row">
		<div class="col-lg-12">
			<section class="panel project-header">
				<div class="panel-body">
					<div style="color: red">
						<h1>
							<%=request.getParameter("projectName")%>
						</h1>
					</div>

					<h3><%=request.getParameter("projectType")%>
					</h3>
					<a class="header-button-aux" id="proj-trash"><img
						src="images/trash.png"></a>
					<div class="git-url">
						GIT URL: <a href="#" class="git-url-link">https://www.votsh.com/svn/repos/repository_directory_name</a>
					</div>
				</div>
			</section>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<section class="panel">

				<header class="panel-heading tab-bg-dark-navy-blue">
					<ul class="nav nav-tabs nav-justified ">
						<li class="active"><a aria-expanded="true"
							href="#overviewTab" data-toggle="tab"> Overview </a></li>
						<li class="rep"><a aria-expanded="true" href="#repositoryTab"
							data-toggle="tab"> Repository </a></li>
						<li class=""><a aria-expanded="false" href="#tasksTab"
							data-toggle="tab"> Tasks </a></li>
						<li class="build"><a aria-expanded="false" href="#buildsTab"
							data-toggle="tab"> Builds </a></li>
						<li class=""><a aria-expanded="true" href="#workflowTab"
							data-toggle="tab"> Workflow </a></li>
						<li class=""><a aria-expanded="true" href="#userdatabaseTab"
							data-toggle="tab"> UserDatabase </a></li>
						<li class=""><a aria-expanded="false" href="#optionsTab"
							data-toggle="tab"> Options </a></li>
						<li class=""><a aria-expanded="false" href="#testsTab"
							data-toggle="tab"> Tests </a></li>
						<li class=""><a aria-expanded="false" href="#cloudTab"
							data-toggle="tab"> Cloud </a></li>
					</ul>
				</header>
			</section>
		</div>
	</div>
	<div class="panel-body">
		<div class="tab-content tasi-tab">
			<div class="tab-pane active" id="overviewTab">
				Overview <br> <br> <br>Description About the Project
			</div>
			<div class="tab-pane" id="repositoryTab">Your GIT Repository</div>
			<div class="tab-pane" id="tasksTab">
				Tasks
				<section class="tasks">
					<table class="table bulid-task" style="margin-top: 20px">
						<tr>
							<th>Build Tasks</th>
						</tr>
						<tr>
							<td>- Clean</td>
						</tr>
						<tr>
							<td>- Compile</td>
						</tr>
						<tr>
							<td>- Process Resource</td>
						</tr>
						<tr>
							<td>- Initializing</td>
						</tr>
						<tr>
							<td>- Build</td>
						</tr>
						<tr>
							<td>- Reading project Structure</td>
						</tr>
					</table>
				</section>

				<table class="table git-task" style="margin-top: 20px">
					<tr>
						<th>Git Task</th>
					</tr>
					<tr>
						<td>- Pushing Template</td>
					</tr>
				</table>
			</div>
			<div class="tab-pane" id="buildsTab">
				Builds
				<table class="table build-table">
					<thead>
						<th>Job Name</th>
						<th>Build</th>
						<th>Status</th>
						<th>Log</th>
					</thead>
					<tbody></tbody>
				</table>
			</div>
			<div class="tab-pane" id="workflowTab">
				Workflow
				<section id="workflow" class="flowdiagram">
					<?xml version="1.0" encoding="UTF-8"?>
					<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
					<svg xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink" width="592px"
						height="702px" version="1.1"
						content="%3Cmxfile%20userAgent%3D%22Mozilla%2F5.0%20(Windows%20NT%206.3%3B%20WOW64)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F45.0.2454.93%20Safari%2F537.36%22%20type%3D%22device%22%3E%3Cdiagram%3E7VtLk5s4EP41PmYLEOCZ43jiZA87W1OZSm1yJEbG1GLkBTyP%2FfVpgZqHBDY2Ing964NtGqFHf63uTy0xI%2Ffb18%2BJt9s8MJ9GM8vwX2fk48yybm4M%2BOaCt0Jg2zeFIEhCvxCZleAp%2FJcKoXgu2Ic%2BTRsFM8aiLNw1hSsWx3SVNWRrFjWb2HkBVl8JnlZepEr%2FCv1sI8ZguZX8dxoGG2zGdG%2BLO2n2hnX4dO3to%2BxDLoJ7%2FPbWw7ryUZElKCxhDKrh%2F7av9zTiSkOFFEP%2F1HG37GRCY9GRww9YopPPXrQXnVR6TWP%2FLknYC1ytIi9Nw9WMLDbZNgKBCX%2BhqeTtW%2F3iO1wYvzlwqfYHgfKSgAqRRQoZ9RsQiB5%2FpmxLoVIoIAzHdkUnhd0QwymuXypgHGEjmxomKPOEeQRlzWVjjyyEjpYtOUJ9SktYRcr2yYqKp%2Bp6liqy50cqKvShVAR%2FahqoRDmMHZAeR%2FRlE2b0aeet%2BPULzM0moJ2gPdMko2JEhyEqdS3Gi3qsIUSMFojIAYgaOjmgAHu4SXdq4KiJ9jTBhEZeFj43fUt%2Fu7Qkc5Itu69ZyvWYsv71maWw92lQEcMlt%2B1q0%2B43uho6FR%2B5nhHxEXFsUnxkdzsaPl0NnYqPXM%2BI%2BMwVfJZxRhMQ3QOvShWwwFGDeurwpFnC%2Fqb3LGIJSGIWQ8nFOowiSeRFYRBzjAFGaIAsuNsPgQndiRvb0Pd5M4u2OMKg9DrKjWQD5Sg8oCOgEFcKKGrIx7lSNw3EZ0g8EaR04oCKpBfHj9c1BZg4Wt0RtQdJHF8DMoVq1QDKdGvAxO7WVeBGfIatWe4RVmISgfifPafvMGagOPP1el0XuQH%2F%2FZrmMzeEaWvEcMcy%2FmBBQH0ui7Fi6FNRd%2FHMtc%2Fwcq6iL23hjG1T%2FJD37w1vG2c8Di8ht7cH4PUZ98sCYPoaphzL9witfSO89RTQthHPwdDmM9eLEupB8uL%2F2QtOVlrw%2FVKIL4G7Kkup0cir0hJSo6GrvzKi6mevZg8SxTX9JC5Zkm1YwGIvWlbSRcL2sQ%2FzDLJLutAbuBBXFgDnYiFXNCYWKp0D%2F8U915UTDDknhaGhNkPtkdYQWEdN509cE5bxdXftencw0XdA722eUYveRWpZU%2FS%2FyytfFQtuA5RSVM1b%2B%2FReAz8RKkZ0cVensTAViOuO%2FNPmervCKC44R4%2F8pbsaGvnLXPwI2xGXkPhVoutoECktnQuRuvU0HkQa%2BHO5CciZ2aibgNPssJy980ekxF15rR9HNOqDOEYRbI93xYgaoPX4AxER0lg8kyUHK7izvHMXrquJouFsQWUhnR4wT%2FvGEtKW4jtXezoCKwbSKXShbiL%2F6UHe48oXCHYzTUXmv26BgCyqpvHv169xIiUGf6XGsV49GQhI72Zl%2BIP%2FRfSD4UyYnJAXvDIV6Yg8aj2yV0bUjsRCIAweHwYW2%2FEC%2BU5lezumHHNFO139ksuLblb4Fx04N5zaYst15BRVobwTSdBAyyCOWDihpuU9st4LCemAgmIaHTZ2qmkoHW6axnCs1cN6OpxBTn%2FRHUyaqLSRv8ps4lRnoFTU03TOOTI0joe%2BXFBsXaDY8iJDk4dW2nEOe%2Bgj5QdPW6cHZz%2FC1JX1jJF%2FNDFKicOXANf4TSvB0UHiHZXEf6E%2B3e6ykPHM8xeawmFknsh85Gefr53cy1C0UM1yBa2ba2L0ulxP1jFhHdmRnO7UHF1OTenLSE7NOdGpSeWHO7UeGdOznZrvpZvcpjRlKUxDPCKjXc9StG38KzulZ82rtsxlY3un0hnu5fAbH9L8ZZI7KADjf1U3erCWHyh44GP%2BCMr7wbwETnqUez1lif%2Fi%2Fo9uayCY7UdraHGyJsp0n9Fz1COyl0UGzOZOmdtyRMY0xCC0k4Hhp1hHVQ6xp1TO8AOuoyrHnouBT6Ec9NM15eTO0Pr2ePWckTTdmYvX9eDW4s10UEZXXdrkan9MQhi5ZcDp%2FyR8D%2Bf%2BxdwsTV84siMQIFKDIGhfQNEtyB5YfvjjXbx7IR%2FfdXu%2BfCHnm8%2FCQO8BniXsYfPzuw80TfNF72icrb5nqh%2FVonl8EblibwqoLdB3c3lkYZjaQwD1v2QDl9VLzsUaqXpFnCx%2FAg%3D%3D%3C%2Fdiagram%3E%3C%2Fmxfile%3E">
						<defs />
						<g transform="translate(0.5,0.5)">
						<path d="M 420 286 L 364.37 286" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 359.12 286 L 366.12 282.5 L 364.37 286 L 366.12 289.5 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<rect x="150" y="1" width="300" height="30" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<path d="M 170 31 L 170 104.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 170 109.88 L 166.5 102.88 L 170 104.63 L 173.5 102.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 290 31 L 290 104.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 290 109.88 L 286.5 102.88 L 290 104.63 L 293.5 102.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 420 31 L 420 104.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 420 109.88 L 416.5 102.88 L 420 104.63 L 423.5 102.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<g transform="translate(270,10)">
						<switch>
						<foreignObject pointer-events="all" width="70" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 86px; width: 70px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Enter Codes</div>
						</div></foreignObject>
						<text x="35" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<rect x="110" y="191" width="120" height="30" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<rect x="370" y="191" width="110" height="30" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<g transform="translate(122,113)">
						<switch>
						<foreignObject pointer-events="all" width="86" height="30"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 46px; max-width: 86px; width: 86px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">
								<font color="#007fff">User is not Logged in</font>
							</div>
						</div></foreignObject>
						<text x="43" y="21" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(387,113)">
						<switch>
						<foreignObject pointer-events="all" width="86" height="30"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 46px; max-width: 86px; width: 86px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">
								<font color="#3399ff">User does not exist</font>
							</div>
						</div></foreignObject>
						<text x="43" y="21" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(252,113)">
						<switch>
						<foreignObject pointer-events="all" width="86" height="30"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 46px; max-width: 86px; width: 86px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">
								<font color="#3399ff">User is already Logged in</font>
							</div>
						</div></foreignObject>
						<text x="43" y="21" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<path d="M 170 141 L 170 184.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 170 189.88 L 166.5 182.88 L 170 184.63 L 173.5 182.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 420 141 L 420 184.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 420 189.88 L 416.5 182.88 L 420 184.63 L 423.5 182.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<g transform="translate(154,200)">
						<switch>
						<foreignObject pointer-events="all" width="33" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 36px; width: 33px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Login</div>
						</div></foreignObject>
						<text x="17" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(402,200)">
						<switch>
						<foreignObject pointer-events="all" width="46" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 46px; width: 46px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Sign Up</div>
						</div></foreignObject>
						<text x="23" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(241,280)">
						<switch>
						<foreignObject pointer-events="all" width="109" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 46px; max-width: 121px; width: 109px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">
								<font color="#3399ff">All codes are valid?</font>
							</div>
						</div></foreignObject>
						<text x="55" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<path d="M 170 221 L 170 274.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 170 279.88 L 166.5 272.88 L 170 274.63 L 173.5 272.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 420 221 L 420 274.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 420 279.88 L 416.5 272.88 L 420 274.63 L 423.5 272.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 170 286 L 226.63 286" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 231.88 286 L 224.88 289.5 L 226.63 286 L 224.88 282.5 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<ellipse cx="165" cy="366" rx="25" ry="25" fill="#ffffff"
							stroke="#ea6b66" pointer-events="none" />
						<ellipse cx="305" cy="366" rx="25" ry="25" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<g transform="translate(154,360)">
						<switch>
						<foreignObject pointer-events="all" width="22" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 36px; width: 22px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Nar</div>
						</div></foreignObject>
						<text x="11" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(295,360)">
						<switch>
						<foreignObject pointer-events="all" width="21" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 36px; width: 21px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Yar</div>
						</div></foreignObject>
						<text x="11" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<path d="M 140 366 L 70 366 L 70 21 L 143.63 21" fill="none"
							stroke="#000000" stroke-miterlimit="10" pointer-events="none" />
						<path d="M 148.88 21 L 141.88 24.5 L 143.63 21 L 141.88 17.5 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 254 311 L 254 366 L 196.37 366" fill="none"
							stroke="#000000" stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 191.12 366 L 198.12 362.5 L 196.37 366 L 198.12 369.5 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 305 311 L 305 334.63" fill="none" stroke="#000000"
							stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 305 339.88 L 301.5 332.88 L 305 334.63 L 308.5 332.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<path d="M 305 391 L 305 436 L 305 434.63" fill="none"
							stroke="#000000" stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 305 439.88 L 301.5 432.88 L 305 434.63 L 308.5 432.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<rect x="180" y="441" width="240" height="50" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<g transform="translate(223,460)">
						<switch>
						<foreignObject pointer-events="all" width="145" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 226px; width: 145px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Redemption Results Page</div>
						</div></foreignObject>
						<text x="73" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<path d="M 305 491 L 305 536 L 305 534.63" fill="none"
							stroke="#000000" stroke-miterlimit="10" pointer-events="none" />
						<path
							d="M 305 539.88 L 301.5 532.88 L 305 534.63 L 308.5 532.88 Z"
							fill="#000000" stroke="#000000" stroke-miterlimit="10"
							pointer-events="none" />
						<rect x="1" y="541" width="590" height="160" fill="#ffffff"
							stroke="#000000" stroke-dasharray="3 3" pointer-events="none" />
						<g transform="translate(243,560)">
						<switch>
						<foreignObject pointer-events="all" width="139" height="26"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 26px; max-width: 171px; width: 139px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">
								<font style="font-size: 20px"><b>My Dashboard</b></font>
							</div>
						</div></foreignObject>
						<text x="70" y="19" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<rect x="113" y="601" width="107" height="50" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<rect x="243" y="601" width="107" height="50" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<rect x="377" y="601" width="107" height="50" fill="#ffffff"
							stroke="#000000" pointer-events="none" />
						<g transform="translate(141,620)">
						<switch>
						<foreignObject pointer-events="all" width="44" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 51px; width: 44px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">My 2XP</div>
						</div></foreignObject>
						<text x="22" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(271,614)">
						<switch>
						<foreignObject pointer-events="all" width="51" height="30"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 31px; max-width: 51px; width: 51px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">My Price Entries</div>
						</div></foreignObject>
						<text x="26" y="21" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<g transform="translate(387,613)">
						<switch>
						<foreignObject pointer-events="all" width="86" height="30"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 36px; max-width: 86px; width: 86px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">Redeem More Codes</div>
						</div></foreignObject>
						<text x="43" y="21" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g>
						<rect x="30" y="321" width="90" height="20" fill="#ffffff"
							stroke="none" pointer-events="none" />
						<g transform="translate(34,325)">
						<switch>
						<foreignObject pointer-events="all" width="82" height="16"
							requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility">
						<div xmlns="http://www.w3.org/1999/xhtml"
							style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; overflow: hidden; max-height: 16px; max-width: 86px; width: 82px; white-space: normal; text-align: center;">
							<div xmlns="http://www.w3.org/1999/xhtml"
								style="display: inline-block; text-align: inherit; text-decoration: inherit;">
								<font color="#3399ff">Error Message</font>
							</div>
						</div></foreignObject>
						<text x="41" y="14" fill="#000000" text-anchor="middle"
							font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g></g></svg>
				</section>
			</div>
			<div class="tab-pane" id="userdatabaseTab">
				UserDatabase
				<section id="test">
					<form id="form-database">
						<div class="info-box">
							<input class="btn btn-lg btn-submit" id="btn-database"
								type="button" value="Add Database">
						</div>
					</form>
					<div class="wrapper database-pop">
						<div class="hd">User Database Options</div>
						<form action="" id="create_project">

							<div class="row">
								<input type="hidden" id="sessionuser_id"
									value="<%=session.getAttribute("userid")%>" /> <input
									type="text" name="living-user" id="living-user"
									class="form-control" placeholder="Living Registration Users">
								<input type="text" name="mysql-path" id="mysql-path"
									class="form-control" placeholder="MySQL Path">
							</div>
							<div class="row">
								<p>
									<span class="heading">PROVIDER</span>
								</p>
								<input type="radio" name="provider" class="provider"
									value="Solo User Database">Solo User Database <input
									type="radio" name="provider" class="provider" value="Epsilon">Epsilon
								<input type="radio" name="provider" class="provider"
									value="Gigya-Facebook,Twitter">Gigya-Facebook,Twitter <input
									type="radio" name="provider" class="provider"
									value="External MDM Users">External MDM Users <input
									type="radio" name="provider" class="provider" value="MailChimp">MailChimp
							</div>
							<div class="row">
								<p>
									<span class="heading">DATABASE TYPE</span>
								</p>
								<input type="radio" name="database-type" class="database_type"
									value="MySQL">MySQL <input type="radio"
									name="database-type" class="database_type" value="SQL Server">SQL
								Server <input type="radio" name="database-type"
									class="database_type" value="Oracle">Oracle <input
									type="radio" name="database-type" class="database_type"
									value="NoSQL">NoSQL <input type="radio"
									name="database-type" class="database_type" value="Hadoop">Hadoop
							</div>
							<div class="row">
								<p>
									<span class="heading">INTERFACE</span>
								</p>
								<input type="radio" name="interface" class="interface"
									value="REST API">REST API <input type="radio"
									name="interface" class="interface" value="FTP for ETL">FTP
								for ETL <input type="radio" name="interface" class="interface"
									value="SSL">SSL <input type="radio" name="interface"
									class="interface" value="Pub/sub">Pub/sub <input
									type="radio" name="interface" class="interface"
									value="Fraud Check">Fraud Check
							</div>
							<div class="row">
								<p>
									<span class="heading">OPTIONS</span>
								</p>
								<input type="radio" name="language" class="options"
									value="CAN-SPAM">CAN-SPAM <input type="radio"
									name="language" class="options" value="COPPA">COPPA <input
									type="radio" name="language" class="options" value="Fair Use">Fair
								Use

							</div>
							<div class="btn1">
								<input type="button" name="Cancel" class="btn btn-lg btn-login"
									id="btn-cancel" value="cancel"> <input type="button"
									name="Create" class="btn btn-lg btn-login" value="create"
									id="createdatabase">
							</div>
							<div id="errormessage-div"></div>
						</form>
					</div>
				</section>
			</div>
			<div class="tab-pane" id="optionsTab">Options</div>
			<div class="tab-pane" id="testsTab">
				Performance & Security
				<section id="test">
					<form id="form-test">
						<!-- <div class="info-box">
								<button class="btn btn-lg btn-submit" id="btn-settings" type="button">Test Settings</button>
							</div> -->
						<input type="text" name="testurl" class="form-control"
							placeholder="Testing machine URL" id="testurl"> <span
							class="info-box">
							<button class="btn btn-lg btn-submit" id="btn-test" type="button">Run
								Test</button>
						</span> <span class="info-box">
							<button class="btn btn-lg btn-submit" id="resultBtn"
								type="button">View Results</button>
						</span>
					</form>
					<div class="settings-pop">
						<div class="hd">Test Machine</div>
						<form action="" id="test_settings" autocomplete="on">
							<input type="text" name="test-url" class="form-control"
								placeholder="Testing machine URL"> <input type="button"
								name="submit" class="btn btn-lg btn-submit" id="btn-submit"
								value="Submit"> <input type="button" name="cancel"
								class="btn btn-lg btn-submit" id="btn-cancel" value="Cancel">
						</form>
					</div>
					<div id="percentagediv"></div>
				</section>
			</div>
			<div class="tab-pane" id="cloudTab">
				Cloud
				<section class="cloud">
					<table class="table" style="border-top: 1px solid #ddd">
						<tr>
							<td>Application URL:</td>
							<td><a href="http://52.76.35.31:8080/InstantWinApp-1.1/"
								target="_blank">http://52.76.35.31:8080/InstantWinApp-1.1/</a></td>

						</tr>
						<!-- <tr>
												                  <td>Description:</td>
												                  <td>About the Project</td>
												                 </tr> -->
						<tr>
							<td>Last Updated</td>
							<td>01/10/2015</td>
						</tr>
						<tr>
							<td>Last Test Result</td>
							<td>99.8% of pages loaded below 5sec</td>
						</tr>
					</table>
				</section>
			</div>
		</div>
	</div>
</section>



<!--main content end-->


<!-- Right Slidebar start -->


<!-- OPENING BUTTON -->
<a class="master-menu-open-btn sb-toggle-right"><i
	class="fa fa-caret-square-o-left"></i></a>


<div class="sb-slidebar sb-right sb-style-overlay">
	<div class="side-menu-top">
		Master Tasks <a class="master-menu-close-btn sb-toggle-right"><i
			class="fa fa-close"></i></a>
	</div>
	<h5 class="side-title">Task Group</h5>
	<ul class="sidebar-task-list">
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
	</ul>


	<h5 class="side-title">Task Group</h5>
	<ul class="sidebar-task-list">
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
	</ul>

	<h5 class="side-title">Task Group</h5>
	<ul class="sidebar-task-list">
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
		<li><a class="sidebar-task-btn" href="#">Task</a></li>
	</ul>
</div>
<!-- Right Slidebar end -->
<script>
$('.rep').click(function(){
	  window.open("https://github.com/javed2015/TesJav.git");
	});
	
var queryString = 'projname=<%=request.getParameter("projectName")%>&userid=<%=request.getParameter("projectCreator")%>';
	
	
$('.build').click(function(){
	$('.build-table tbody').empty();
	//alert(1);
 	$.ajax({
		method : "POST",
		url : 'ProjectTasks',
		dataType: "json", 
		data : queryString,
		async:   false,
		success : function(data) {
			var s = " ";
			data.forEach(function(obj) {
			console.log(obj);
			s += '<tr> <td>'+ obj.job +'</td> <td> '+ obj.buildNo +'</td> <td>'+ obj.status+'</td> <td><a href="'+ obj.log +'" target="_blank">'+ obj.log +'</a></td> </tr>'
			});
			console.log(s);
			$('.build-table tbody').append(s);
			
		}, 
		
		failure: function() {
			alert("failure");
		}
	});
	});
	
function trash() {
    "<%=session.getAttribute("userid")%>"=="<%=request.getParameter("projectCreator")%>"  ? $('#proj-trash').css('display','block'):$('#proj-trash').css('display','none');
   };
   trash();
   $('#proj-trash').click(function(){
  var  dataString= 
      'projectCreator=<%=request.getParameter("projectCreator")%>&projectName=<%=request.getParameter("projectName")%>&userid=<%=session.getAttribute("userid")%>';

						$.ajax({
							method : "POST",
							url : 'DeleteProjectImpl',
							data : dataString,
							dataType : "html",
							success : function(resp) {
								window.location = "dashboard.jsp";
							},failure : function(resp) {
								window.location = "dashboard.jsp";
							}
						})
					});
</script>

<script src="scripts/projectdatabase.js"></script>
<script src="scripts/projecttest.js?t=5"></script>
<%@ include file="Footer.jsp"%>

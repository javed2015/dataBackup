<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ page import="com.votsh.access.UserProjectAccess"%>

<html lang="en">
<%
javax.servlet.http.HttpServletRequest _request = (javax.servlet.http.HttpServletRequest) request;
javax.servlet.http.HttpServletResponse _response = (javax.servlet.http.HttpServletResponse) response;
String _path = _request.getContextPath();
String gridValues=null; 
	UserProjectAccess ups=new UserProjectAccess();
	gridValues=ups.userProjectAccess();
	request.setAttribute("message", gridValues);   
%>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>VOTSH VSERVER</title>

    <!-- Bootstrap core CSS -->
    <link href="../styles/bootstrap.min.css" rel="stylesheet">
   <link href="../styles/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
      <!--right slidebar-->
      <link href="../styles/slidebars.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../styles/style.css" rel="stylesheet">
    <link href="../styles/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript"
	src="<%=_path%>/scripts/grid/dhtmlxgrid.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>VOTSH</title>
<link rel="STYLESHEET" type="text/css"
	href="<%=_path%>/styles/dhtmlxgrid.css">
<%-- <link rel="STYLESHEET" type="text/css"
	href="<%=_path%>/styles/style.css"> --%>

 <script type="text/javascript" src="<%=_path%>/scripts/application.js"></script> 

</head>
<body class="boxed-page access-approve">
      <div class="container">

        <section id="container" class="">
          <!--header start-->

          <!--header end-->
          <!--main content start-->
          <section id="main-content">
				<section class="inner-header">
					<div class="upper-nav">
						<a href="../dashboard.jsp" class="nav-link-left">Dashboard</a>
						<!--<a href="#" class="nav-link-left">Projects</a>-->

						<a href="../login.jsp" class="nav-link-right">Log Out<i class="fa fa-chevron-right ico-right"></i></a>
						<a href="#" class="nav-link-right"><i class="fa fa-group ico-left"></i><%=session.getAttribute("userid")%></a>
						<a href="#" class="nav-link-right"><i class="fa fa-user ico-left"></i>My Account</a>


					</div>
				</section>
<section class="wrapper">
	<form method="POST" action="authenticate.jsp">
		<!-- id="myForm"> -->
		<h4>Please Check The Required Projects To Give Access To The User</h4>
		<div id="gridbox" ></div>
		<div class="row" align="center">
				<input type="submit" value="submit" onClick="validate();" class="btn btn-lg btn-login " />
				<input type="reset" value="Reset"class="btn btn-lg btn-login "/>
		</div>
		
		
				
		<!--       <input type="hidden" id="queryGrid" value="GetXMLString(mygrid)" /> -->
		<input type="hidden" name="eXml" id="eXml">
		<script> 
   
   
        mygrid = new dhtmlXGridObject('gridbox'); 
        mygrid.setImagePath("../images/imgs/");           
        mygrid.setHeader("Sl.No,User Name,Project,Access"); 
        mygrid.setInitWidths("100,150,150,100");          
        mygrid.setColAlign("center,left,left,left");         
        mygrid.setColTypes("ed,ed,ro,ch");    

        mygrid.init();       
        var	jsonData= ${message}; 
     
        
        	mygrid.parse(jsonData,"json");
        	
        	 function validate(){
        	    	document.getElementById("eXml").value = GetXMLString(mygrid);    	
        	    }
        	
      
        	</script>


	</form>
</section>
<!--footer start-->
          <footer class="site-footer">
              <div class="text-center">
					<img src="../images/vserver_logo.png" class="footer-logo">
					<div class="copyright-text">&copy; 2015 - VOTSH</div>
              </div>
          </footer>
          <!--footer end-->
      </section>

      </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../scripts/jquery.js"></script>
    <script src="../scripts/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../scripts/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../scripts/jquery.scrollTo.min.js"></script>
    <script src="../scripts/slidebars.min.js"></script>
    <script src="../scripts/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="../scripts/respond.min.js" ></script>

    <!--common script for all pages-->
    <script src="../scripts/common-scripts.js"></script>

	

  </body>
</html>
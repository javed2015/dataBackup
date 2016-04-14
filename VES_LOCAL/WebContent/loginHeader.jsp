
<%
	javax.servlet.http.HttpServletRequest _request = (javax.servlet.http.HttpServletRequest) request;
	javax.servlet.http.HttpServletResponse _response = (javax.servlet.http.HttpServletResponse) response;
	String _path = _request.getContextPath();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<link rel="shortcut icon" href="images/favicon.png">

<title>VOTSH VSERVER</title>
<link href="<%=_path%>/styles/bootstrap.min.css" rel="stylesheet">
<link href="<%=_path%>/styles/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<link href="<%=_path%>/styles/style.css" rel="stylesheet">
<link href="<%=_path%>/styles/style-responsive.css" rel="stylesheet" />
<script src="scripts/jquery.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<script src="scripts/commonscript.js"></script>
</head>
<body class="login-body">
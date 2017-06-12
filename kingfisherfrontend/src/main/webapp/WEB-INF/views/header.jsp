<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <c:url value="/resource/images" var="img"/>
    <c:url value="/resource/css" var="css"/>
    <c:url value="/resource/js" var="js"/>
  
    <meta charset="utf-8">
    <title>KINIFIHER</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="${css}/bootstrap.css" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="${css}/style.css" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="${css}/font-awesome.css" rel="stylesheet">
		<!--[if IE 7]>
			<link href="${css}/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
  
  </head>
<body >
<!-- 
	Upper Header Section 
-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a href="#"><span class="icon-twitter"></span></a>
					<a href="#"><span class="icon-facebook"></span></a>
					<a href="#"><span class="icon-youtube"></span></a>
					<a href="#"><span class="icon-tumblr"></span></a>
				</div><b> welcome ${pageContext.request.userPrincipal.name}</b> 
			    
				<a class="active" href="<c:url value="/"/>"> <span class="icon-home"></span> Home</a> 
<!-- 				<a href="#"><span class="icon-user"></span> My Account</a>  -->
				<c1:if test="${pageContext.request.userPrincipal.name== null}">
				<a href="<c:url value="/user"/>"><span class="icon-edit"></span> Free Register </a> 
				</c1:if>
				<a href="<c:url value="/contactus"/>"><span class="icon-envelope"></span> Contact us</a>
<!-- 				<a href="cart.html"><span class="icon-shopping-cart"></span> 2 Item(s) - <span class="badge badge-warning"> $</span></a> -->
			    <c1:if test="${pageContext.request.userPrincipal.name!= null}">
              
			    <a href="<c:url value="/j_spring_security_logout"/>"><span class="icon-user"></span> Logout</a> 
			</c1:if>
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> 
		<img src="${img }/final.png" alt="bootstrap sexy shop">
	</a>
	</h1>
	</div>
	<div class="span4">
	
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) : 7204241401  </strong><br><br></p>
	<c:url value="/dispproid" var="disp"/>
         <form:form action="${disp}" method="post">
			  <input type="text" name="search" placeholder="Search" class="search-query span2" >
			</form:form>
	 <a href="<c:url value="/viewcart"/>"    class="cart-button">
	<span class="btn btn-mini">${items} <span class="icon-shopping-cart"></span></span>

	</div>
</div>
</header>

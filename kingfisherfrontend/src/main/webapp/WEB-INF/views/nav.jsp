<!--
Navigation Bar Section 
-->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
		<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
			  <li class="active"><a href="<c:url value="/"/>"><span class="icon-home"></span>HOME	</a></li>
			  <li class=""><a href="<c:url value="/allproducts"/>">PRODUCTS</a></li>
			  <c1:if test="${pageContext.request.userPrincipal.name!= null}">
		<security:authorize access="hasRole('ROLE_ADMIN')">
			  <li class=""><a href="<c:url value="/addproduct"/>">ADD PROUDCT</a></li>
			  <li class=""><a href="<c:url value="/category"/>">ADD CATEGORY</a></li>
			   <li class=""><a href="<c:url value="/addseller"/>">ADD SUPPLIER</a></li>
			 </security:authorize>
			 </c1:if>
			</ul>
		</div>
	  </div>
	  </html>
		</div>
	  </div>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>


 <%@ include file= "header.jsp"%> 
 
<!--
Lower Header Section 
--><body >

</header>

<!--
Navigation Bar Section 
-->
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
			  <li class=""><a href="<c:url value="/product"/>">ADD PRODUCT</a></li>
			  <li class=""><a href="<c:url value="/category"/>">ADD CATEGORY</a></li>
			   <li class=""><a href="<c:url value="/seller"/>">ADD SUPPLIER</a></li>
			 </security:authorize>
			 </c1:if>
			</ul>
			
			
			${msg}
					<c1:if test="${logout!=null}">${logout} 
					</c1:if>
					<c1:if test="${pageContext.request.userPrincipal.name== null}">
			<c1:url value="/j_spring_security_check"  var="a"/>
			<ul class="nav pull-right">
			<li class="dropdown">
				<a data-toggle="dropdown" class="dropdown-toggle" href=""><span class="icon-lock"></span> Login <b class="caret"></b></a></c1:if>
				<div class="dropdown-menu">
				<form:form class="form-horizontal loginFrm" action="${a}" method="post">

				  <div class="control-group">
					<input type="text" class="span2" id="inputEmail" placeholder="Email" name="j_username">
				  </div>
				  <div class="control-group">
					<input type="password" class="span2" id="inputPassword" placeholder="Password" name="j_password" >
				  </div>
				  <div class="control-group">
					<label class="checkbox"> 
					<input type="checkbox"> Remember me
					</label>
					<input type="submit" class="shopBtn btn-block" value="Sign in">
				  </div>
				</form:form>
				</div>
			</li>
			</ul>
		  </div>
		</div>
	  </div>
	</div>
<!-- 
Body Section 
-->
			

	<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
<h3>CATEGORIES</h3>
	<ul class="nav nav-list">
		<c1:forEach items="${categories}" var="cat">
					
      <li><a href="<c1:url value="/dispcategory/${cat.getCat_id()}"/>"><span class="icon-chevron-right"></span> ${cat.getCat_name()}</a></li>
					

         </c1:forEach>
	
<!-- 		<li style="border:0"> &nbsp;</li> -->
<!-- 		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li> -->
	</ul>
</div><br><br>
<div class="well well-small">
<h3>SORT BY PRICE</h3>
	<ul class="nav nav-list">
		
					
      <li><a href="<c1:url value="/disrate/"/>"><span class="icon-chevron-right"></span>100 - 500 </a></li>
		<li><a href="<c1:url value="/disrate1/"/>"><span class="icon-chevron-right"></span>500 - 1500 </a></li>
		<li><a href="<c1:url value="/disrate2/"/>"><span class="icon-chevron-right"></span>1500 - 2500 </a></li>			

         
	
<!-- 		<li style="border:0"> &nbsp;</li> -->
<!-- 		<li> <a class="totalInCart" href="cart.html"><strong>Total Amount  <span class="badge badge-warning pull-right" style="line-height:18px;">$448.42</span></strong></a></li> -->
	</ul>
</div>
		
		
	</div>
	<div class="span9">
	
<!--
New Products
-->
	<div class="well well-small" >
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="${img}/b4.jpg" alt="Chania">
    </div>

 

    <div class="item">
      <img src="${img}/b2.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="${img}/b5.jpg" alt="Flower">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  
	
		
	
	
	
<!-- 
Clients 
-->
<section c lass="our_client">
	
	
	</div>
</section>

<!--
Footer
-->

</div><!-- /container -->

<div class="copyright">
<div class="container">
	
<center>	<span>Copyright &copy; KINIFISHER<br> </span></center>
</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.easing-1.3.min.js"></script>
    <script src="${js}/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="${js}/shop.js"></script>
  </body>
</html>
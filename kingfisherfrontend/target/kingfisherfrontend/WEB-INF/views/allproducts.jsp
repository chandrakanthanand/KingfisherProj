<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
 <%@ include file= "header.jsp"%> 
 <%@ include file= "nav.jsp"%> 



<body >

 <div class="container">
<!--
Navigation Bar Section 
-->

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
</div>
<br><br><br>
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
	<h3>New Products </h3>
	<hr class="soften"/>
		<div class="row-fluid">
		<div id="newProductCar" class="carousel slide">
            <div class="carousel-inner">
			<div class="item active">
			  <ul class="thumbnails">
			  <c1:forEach var="pro" items="${products}">
				<li class="span3">
				<div class="thumbnail">
				
					<a class="zoomTool" href="<c:url value="/addtocart/${pro.getP_id()}"/>" title="add to cart"><span class="icon-shopping-cart"></span> Add to cart</a>
					<a href="#" class="tag"></a>
					<a href="<c:url value="/viewpro/${pro.getP_id()}"/>" title="quick view">
					<img src="${img}/${pro.getP_id()}.jpg" alt="bootstrap-ring"></a>
					<h3>${pro.getP_Name()}            &nbsp;  &nbsp;  &nbsp; ${pro.getPrice()}</h3>
					
				</div></c1:forEach>
				</li>

				</li>
			  </ul>
			  </div>		
				</div>
		   </div>
		  <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a><!-- Cycling of images-->
            <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
		  </div>
		  </div>
				</div></div>
				</div>
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
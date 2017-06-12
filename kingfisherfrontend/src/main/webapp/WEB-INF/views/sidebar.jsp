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
<br><br>
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

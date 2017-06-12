
<html>
<head>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@ include file= "header.jsp"%> 

 </head>
 <body>
  <%@ include file= "nav.jsp"%>
  
  <div class="well well-big" >
 
  <div class="container">

            <div class="row">

                <div class="col-lg-8 col-lg-offset-2">
                 
 <table style="align:left" >  
					<tr>
						<td><c:url value="/addproduct" var="a" />
						 <form:form method="POST" action="${a}" commandName="product" enctype="multipart/form-data">

								<form:input type="hidden" path="p_id" />
								<label>Product Name:</label></td>
						<td><form:input text="text" path="p_Name" /><br></td>
					</tr>
					<tr>
						<td><label>Product price:</label></td>
						<td><form:input text="text" path="price" /></td>
					</tr>
					<tr>
						<td><label>Product Quantity:</label></td>
						<td><form:input text="text" path="Que" /></td>
					</tr>
					<tr>
						<td><label for="category">Category</label></td>
						<c1:forEach var="c" items="${cat}">
							<td><form:radiobutton path="category.cat_id"
									value="${c.getCat_id()}" />${c.getCat_name()}</td>
						</c1:forEach>
					</tr>
					<td><label for="seller">Seller</label></td>
					<c1:forEach var="s" items="${sel}">
						<td><form:radiobutton path="seller.id" value="${s.getId()}" />${s.getName()}
						</td>
					</c1:forEach>
					</tr>
				<form:input path="pimg" type="file" name="image" value="upload file"/>
					<tr colspan="2">
						<td align="center"><input type="submit" value="save" /></td>
					</tr>
					</form:form>
				</table>
				<table style="border: 1px solid black">
					<tr style="background-color: #eee">
					<th style="border: 1px solid black">Image</th>
						<th style="border: 1px solid black">Product ID</th>
						<th style="border: 1px solid black">Product Name</th>
						<th style="border: 1px solid black">Price</th>
						.
						<th style="border: 1px solid black">Quantity</th>
						<th style="border: 1px solid black">Category Name</th>
						<th style="border: 1px solid black">Seller name</th>
					</tr>
					<tbody>
						<c1:forEach items="${pro}" var="p">
							<tr><td style="border: 1px solid black"><img src="<c:url value='/resource/images/${p.getP_id()}.jpg'/>", width=50px, height=200px></td>
								<td style="border: 1px solid black">${p.getP_id()}</td>
								<td style="border: 1px solid black">${p.getP_Name()}</td>
								<td style="border: 1px solid black">${p.getPrice()}</td>
								<td style="border: 1px solid black">${p.getQue()}</td>
								<td style="border: 1px solid black">${p.category.getCat_name()}</td>
								<td style="border: 1px solid black">${p.seller.getName()}</td>
								<td style="border: 1px solid black"><a
									href="<c1:url value="/editproduct/${p.getP_id()}"/>"
									class="btn btn-info">Edit</a></td>
								<td style="border: 1px solid black"><a
									href="<c1:url value="/deleteproduct/${p.getP_id()}"/>"
									class="btn btn-danger">Delete</a></td>
							</tr>
						</c1:forEach>
				</table>



			</div>

		</div>

	</div>
</div>
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="validator.js"></script>
<script src="contact.js"></script>
</body>

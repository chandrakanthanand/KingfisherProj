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
                  
                 <td> <c:url value="/addcategory" var="a"/>
                 
                  <form:form method="POST" action="${a}" commandName="cat">
                  
                  <label>Category Name</label></td>
                  <form:input type="hidden" path="Cat_id" />
                 <td> <form:input text="text" path="cat_name"/><br></td>
                 </tr>
                   <tr>
                   <td><label>Category Discription</label></td>
                  <td><form:input text="text" path="cat_des"/></td></tr>
                  <tr colspan="2">
                  <td align="center">
                  <input type="submit" value="save"/></td>
                  </tr>
                   </form:form>
					</table>
					<br>
					<br>
					
					<table style="border: 1px solid black" >
					<tr style=" background-color: #eee ">
					<th style="border: 1px solid black" >Category ID</th>
					<th style="border: 1px solid black">Category Name</th>
					<th style="border: 1px solid black">Category Description</th>
					</tr>
				
					
					
					<center><tbody>
					<c1:forEach items="${categories}" var="cat">
					<tr style="border: 1px solid black">
					<td style="border: 1px solid black">${cat.getCat_id()}</td>
					<td style="border: 1px solid black">${cat.getCat_name()}</td>
					<td style="border: 1px solid black">${cat.getCat_des()}</td>
					<td style="border: 1px solid black"><a href="<c1:url value="/edditcategory/${cat.getCat_id()}"/>" class="btn btn-info">Edit</a></td>
                    <td style="border: 1px solid black"><a href="<c1:url value="/deletecategory/${cat.getCat_id()}"/>" class="btn btn-danger">Delete</a></td>

                   </tr>
                   </c1:forEach>
                   </table></center>
                   
                </div>

            </div>

        </div>
        </div>
       

        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="validator.js"></script>
        <script src="contact.js"></script>
    </body>
 </html>
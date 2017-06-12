 
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
                 <td> <c:url value="/addseller" var="a"/>
                  <form:form method="POST" action="${a}" commandName="seller">
                  <lable>seller Name</lable></td>
                  <form:input type="hidden" path="id" />
                 <td> <form:input text="text" path="name"/><br></td>
                 </tr>
                   <tr>
                   <td><lable>seller Address</lable></td>
                  <td><form:input text="text" path="add"/></td></tr>
                  <tr>
                   <td><lable>seller phone no:</lable></td>
                  <td><form:input text="text" path="phone"/></td></tr>
                  <tr colspan="2">
                  <td align="center">
                  <input type="submit" value="save"/></td>
                  </tr>
                   </form:form>
					</table>
					<br>
					<table style="border: 1px solid black" >
					<tr style=" background-color: #eee ">
					<th style="border: 1px solid black" >Seller ID</th>
					<th style="border: 1px solid black">Seller Name</th>
					<th style="border: 1px solid black">Seller Address</th>
					<th style="border: 1px solid black">Seller Phone No.</th>
					
					</tr>
				
					
					
					<tbody>
					<c1:forEach items="${sell}" var="sel" >
					<tr>
					<td style="border: 1px solid black">${sel.getId()}</td>
					<td style="border: 1px solid black">${sel.getName()}</td>
					<td style="border: 1px solid black">${sel.getAdd()}</td>
                    <td style="border: 1px solid black">${sel.getPhone()}</td>
                    <td style="border: 1px solid black"><a href="<c1:url value="/edditseller/${sel.getId()}"/>" class="btn btn-info">Edit</a></td>
                    <td style="border: 1px solid black"><a href="<c1:url value="/deleteseller/${sel.getId()}"/>" class="btn btn-danger">Delete</a></td>
                   </tr>
                   </c1:forEach>
                   </table>
					
					
                   
     </div>           </div>

            </div>

        </div>

        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="validator.js"></script>
        <script src="contact.js"></script>
    </body>
 
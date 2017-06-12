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
    
 <table >  
                  <tr>
                 <td> <c:url value="/adduser" var="a"/>
                  <form:form method="POST" action="${a}" commandName="user">
                 
                  <form:input type="hidden" path="u_Id" />
                  <label>Email Address</label></td>
                 <td> <form:input type="email" path="u_email"/><br></td>
                 </tr>
                   <tr>
                   <td><label class="radio-inline">Gender</label></td>
                  <td>Male<form:radiobutton path="u_gender"/> &nbsp &nbsp Female<form:radiobutton path="u_gender"/></td></tr>
<%--                    <td>Female<form:radiobutton path="u_gender"/></td></tr> --%>
                  <tr>
                  <tr>
                   <td><label>Name</label></td>
                  <td><form:input text="text" path="u_name"/></td></tr>
                  <tr>
                   <td><label>phone no:</label></td>
                  <td><form:input type="number" path="u_phno"/></td></tr>
                  <tr>
                   <td><label>Password</label></td>
                  <td><form:input type="password" path="u_psw"/></td></tr>
<!--                   <td><label>Address</label></td> -->
<%--                   <td><form:input text="text" path="u_add"/></td> --%>
                  </tr>
<!--                   <tr> -->
                  
                  
                   </table>
                   <br>
                   <br><table >  
                  <tr>
                 <td> 
                  <form:input type="hidden" path="billing.bill_id" />
                  <label>House Noumber</label></td>
                 <td> <form:input text="text" path="billing.houseno"/><br></td>
                 </tr>
                   <tr>
                   <td><label>Country</label></td>
                  <td><form:input text="text" path="billing.country"/></td></tr>
                  <tr>
                  <tr>
                   <td><label>City</label></td>
                  <td><form:input text="text" path="billing.city"/></td></tr>
                  <tr>
                   <td><label>Pincode</label></td>
                  <td><form:input type="number" path="billing.pincode"/></td></tr>
                  
                  <tr rowspan="2">
                  <td style:"align=center">
                  <input type="submit" value="save"/></td>
                  </tr>
                  
                   </table>
                   </div>
                   </div> </form:form>
                   </div>
                   </div>
                  </body>
                   </html>
                   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerManagementpage</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" 
crossorigin="anonymous">
</head>
<body>
<form action="userlist" method="post">
<h3 align="center">CUSTOMER LIST</h3>
<hr>
<a class="btn btn-primary btn-sm" href="userform">Add Customer</a><hr>
<table class="table table-striped table-hover">
 <tr><th>Id</th>
 <th>First Name</th><th>Last Name</th><th>Street</th><th>Address</th><th>City</th><th>State</th><th>Email</th><th>Phone</th><th>Action</th>
 </tr>
 <c:forEach var="Customer" items="${display}">
 <tr>
 <td><c:out value="${Customer.id }"/></td>
 <td><c:out value="${Customer.firstname }"/></td>
 <td><c:out value="${Customer.lastname }"/></td>
 <td><c:out value="${Customer.street }"/></td>
 <td><c:out value="${Customer.address }"/></td>
 <td><c:out value="${Customer.city }"/></td>
 <td><c:out value="${Customer.state }"/></td>
 <td><c:out value="${Customer.email }"/></td>
 <td><c:out value="${Customer.phone }"/></td>
 <td><a href="delete?id=${Customer.id}">Delete</a>|<a href="edit?id=${Customer.id}">Edit</a></td>
 </tr>
 </c:forEach>
</table></form>
</body>
</html>
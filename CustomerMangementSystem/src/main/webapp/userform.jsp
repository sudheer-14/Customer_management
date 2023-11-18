<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.customer.model.Customer" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customerdetails</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
 rel="stylesheet"
  integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
 crossorigin="anonymous">
</head>
<body>
<c:if test="${list==null}">
<form action="insert" method="post">
</c:if>
<c:if test="${list!=null}">
<form action="update" method="post">
</c:if>
<h2 align="center">
<c:if test="${list==null}">
ADD CUSTOMER</c:if>
<c:if test="${list!=null}">
EDIT CUSTOMER</c:if>
</h2>
<br><br>

<h4><b>Customer Details</b></h4><hr><br>
<div class="row g-3 align-items-center" align="center">
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="First name" aria-label="First name" name="firstname" value="${list.firstname}">
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="Last name" aria-label="Last name" name="lastname" value="${list.lastname}">
  </div>
</div><br>
<div class="row g-3 align-items-center" align="center">
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="Street" aria-label="Street" name="street" value="${list.street}">
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="Address" aria-label="Address" name="address" value="${list.address}">
  </div>
</div><br>
<div class="row g-3 align-items-center" align="center">
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="City" aria-label="City" name="city" value="${list.city}">
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="State" aria-label="State" name="state" value="${list.state}">
  </div>
</div><br>
<div class="row g-3 align-items-center" align="center">
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="Email" aria-label="Email" name="email" value="${list.email}">
  </div>
  <div class="col-md-4">
    <input type="text" class="form-control" placeholder="Phone" aria-label="Phone" name="phone" value="${list.phone}">
  </div>
</div>
<br>
<div class="col-md-4">
<input type="hidden" class="form-control"></div>
 <div class="col-md-8" align="right">
    <button type="submit" class="btn btn-primary">Submit</button>
  </div>
</body>
</form>
</html>
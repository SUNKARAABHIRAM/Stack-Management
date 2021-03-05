<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.table{
 border:10px;
 margin-left:200px;
 }
 th,td{
 font-size:30px;
 width:70px;
 }
 td{
 text-align:center;
 } 
 
 
 #purpose{
 padding-left:150px;
 }
</style> -->
<meta charset="utf8" />
    <title>Usages</title>
    <link rel="stylesheet" href="css/main.css" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
      crossorigin="anonymous"
    />
</head>
<body>
<br><br>
<div class="container">
<div id="content">
<table class="table">
<thead class="thead-dark">
<tr>
<th>
User
</th>
<th>
Purpose
</th>
<th>Start Time</th>
<th>End Time</th>
</tr>
</thead>
<c:forEach var="usage" items="${usages}">
<tr>

<td>${usage.user}</td>
<td>${usage.purpose}</td>
<td>${usage.starttime}</td>
<td>${usage.endtime}</td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
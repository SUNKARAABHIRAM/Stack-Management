<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1">
<title>Stack Management</title>
<style type="text/css">

/* <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
 */
 
 .table{
 border:10px;
 margin-left:200px;
 }
 th,td{
 font-size:30px;
 width:200px;
 }
 td{
 text-align:center;
 }
 </style> -->
 <meta charset="utf8" />
    <title>Home</title>
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
    <style>
     #fm{
font-size:100px;
margin-left:70px;
margin-top:200px;
} 

#search{
margin-left:200px;
}
    #addInstance{
 background-color:#2C3E50 ;
 color:white;
 font-size:25px;
 margin-top:-100px;
 margin-left:1325px;
 }
    </style>
</head>
<body>
<span id="fm">Stack Management</span><br><br>
<form action="instances/instance" method="get" id="search">
<input type="text" required="required" name="name"/>
<input type="submit" value="search"/>
</form>
<button id="addInstance" onclick="window.location.href='/register'">Add Instance</button><br><br><br>
<div class="container">
<div id="content">
<table class="table">
<thead class="thead-dark">
<tr>
<th>Instance</th>
<th>Status</th>
<th>Release Instance</th>
<th>Action</th>
<th>Remove Instance</th>
<th>History</th>
</tr>
</thead>
<c:forEach var="instance" items="${instances}">
<tr>
<td>${instance.name}</td>
<td>${instance.state}</td>
<td><a href="/releaseInstance/${instance.name}">release</a></td>
<td><a href="/instanceState/${instance.name}">view</a>|<a href="/update/${instance.name}">update</a></td>
<td><a href="/instance/${instance.name}">remove</a></td>
<td><a href="/usage/${instance.name}">History</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
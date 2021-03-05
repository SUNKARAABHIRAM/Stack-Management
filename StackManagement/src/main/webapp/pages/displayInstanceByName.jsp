<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8" />
    <title>Instance By Name</title>
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
    /></head>
<body>
<br><br>
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
<tr>
<td>${instance.name}</td>
<td>${instance.state}</td>
<td><a href="/releaseInstance/${instance.name}">release</a></td>
<td><a href="/instanceState/${instance.name}">view</a>|<a href="/update/${instance.name}">update</a></td>
<td><a href="/instance/${instance.name}">remove</a></td>
<td><a href="/usage/${instance.name}">History</a></td>
</tr>
</table>
</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Instance</title>
</head>
<body>
<form:form action="instances/instance" method="post" modelAttribute="instance">
<tr>
                    <td><form:label path="Name">Name</form:label></td>
                    <td><form:input path="Name" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="state">State</form:label></td>
                    <td><form:input path="state" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="team">
                      Team</form:label></td>
                    <td><form:input path="team" required="required"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<form:form action="/usage" method="post" modelAttribute="inusage">
<tr>
                    <td><form:label path="instanceName">Instance</form:label></td>
                    <td><form:input path="instanceName" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="user">User</form:label></td>
                    <td><form:input path="user" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="purpose">
                      Purpose</form:label></td>
                    <td><form:input path="purpose" required="required"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
</form:form>
</body>
</html>
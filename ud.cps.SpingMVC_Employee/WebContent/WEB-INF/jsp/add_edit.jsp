<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Edit Employee</title>
</head>
<body>
    <div align="center">
<h1>Add/Edit Employee111</h1>
<form:form method="POST" action="./save">
   <table>
    <tr>

        <td><form:hidden path="ID" /></td>
    </tr>
    <tr>
        <td><form:label path="EmployeeID">EmployeeID</form:label></td>
        <td><form:input path="EmployeeID" /></td>
    </tr>
    <tr>
        <td><form:label path="FirstName">FirstName</form:label></td>
        <td><form:input path="FirstName" /></td>
    </tr>
       <tr>
        <td><form:label path="LastName">LastName</form:label></td>
        <td><form:input path="LastName" /></td>
    </tr>
       <tr>
        <td><form:label path="DoB">DoB</form:label></td>
        <td><form:input path="DoB" /></td>
    </tr>
       <tr>
        <td><form:label path="Gender">Gender</form:label></td>
        <td><form:input path="Gender" /></td>
    </tr>
       <tr>
        <td><form:label path="Department">Department</form:label></td>
        <td><form:input path="Department" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
        </form:form>
    </div>
</body>
</html>
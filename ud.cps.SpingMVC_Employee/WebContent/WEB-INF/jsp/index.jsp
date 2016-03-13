<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Manager Home</title>
</head>
<body>
	<div align="center">
				<h1>Employee List</h1>
				<h3>
					<a href="./newEmployee">New Employee</a>
				</h3>
				<table border="0">
					<thead>
						<tr>
							<th>Employee ID</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Date of Birth</th>
							<th>Gender</th>
							<th>Department</th>
							<th>Editing</th>
							<th>Deletion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="employee" items="${listEmployee}"
							varStatus="status">
						<tr>
							<td>${employee.getEmployeeID()}</td>
							<td>${employee.getFirstName()}</td>
							<td>${employee.getLastName()}</td>
							<td>${employee.getDoB()}</td>
							<td>${employee.getGender()}</td>
							<td>${employee.getDepartment()}</td>
							<td><a href="./editEmployee?id=${employee.getID()}">Edit</a></td>
							<td><a href="./delete?id=${employee.getID()}">Delete</a></td>

						</tr>
						</c:forEach>
					</tbody>
				</table>
			
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
    <div align="center">
        <table border="1">
            <tr>
                <td colspan="2" align="center"><h2>Submitted Employee Information</h2></td>
            </tr>
            <!-- <tr>
                <td colspan="2" align="center">
                    <h3>Thank you for registering! Here's the review of your details:</h3>
                </td>
            </tr> -->
            <tr>
                <td>Employee ID:</td>
                <td>${employee.EmployeeID}</td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td>${employee.FirstName}</td>
            </tr>
             <tr>
                <td>Last Name:</td>
                <td>${employee.LastName}</td>
            </tr>
             <tr>
                <td>Date of Birth:</td>
                <td>${employee.DoB}</td>
            </tr>
             <tr>
                <td>Gender:</td>
                <td>${employee.Gender}</td>
            </tr>
             <tr>
                <td>Department:</td>
                <td>${employee.Department}</td>
            </tr>
 
        </table>
    </div>
</body>
</html>
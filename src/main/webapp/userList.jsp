<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>

<html  lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>User list</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        body {
            background: #f5f5f5
        }

        .blue {
            background-color: #00b5ec !important;
        }
    </style>
</head>
<body>
<h2>List of users</h2>
<a href="addUser" class="btn"><button type="button" class="btn btn-primary">Add user</button></a>
<table class="table table-stripped">
    <thead>
        <tr>
            <td>Id</td>
            <td>Login</td>
            <td>Password</td>
            <td>Email</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Address</td>
            <td>Status</td>
            <td>Phone no</td>
            <td>Discount</td>
            <td>Role</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
    </thead>
        <c:if test="${users != null}">
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userID}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.email}</td>
                    <td>${user.userName}</td>
                    <td>${user.userSurname}</td>
                    <td>${user.address}</td>
                    <td>${user.userStatus}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.discount}</td>
                    <td>${user.role.roleName}</td>
                    <td><a href="user?id=${user.userID}" class="btn btn-warning">Edit</a></td>
                    <td><a href="userDelete?id=${user.userID}" class="btn btn-danger">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

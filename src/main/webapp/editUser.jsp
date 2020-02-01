<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Edit user by ADMIN-CONSOLE</title>
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
<main role="main" class="container">
    <div class="my-3 p-3 bg-white rounded box-shadow">
        <h4 class="text-center mb-4 mt-1" style="font-weight: bold">ADMIN CONSOLE: EDIT USER</h4>
        <hr>

        <c:if test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <div class="alert alert-warning">
                    <h6>${error.header}</h6>
                    <h8>${error.message}</h8>
                </div>
            </c:forEach>
        </c:if>

        <form action="editUser" method="POST">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userID" class="form-control" placeholder="User ID" type="number" value="${user.userID}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userLogin" class="form-control" placeholder="Login" type="text" value="${user.login}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userEmail" class="form-control" placeholder="Email" type="text" value="${user.email}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="userPassword" class="form-control"  placeholder="Password" type="text" value="${user.password}"
                           aria-required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userName" class="form-control" placeholder="Name" type="text" value="${user.userName}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userSurname" class="form-control" placeholder="Surname" type="text" value="${user.userSurname}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userAddress" class="form-control" placeholder="Address" type="text" value="${user.address}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userTelephone" class="form-control" placeholder="Telephone" type="text" value="${user.phoneNumber}" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userDiscount" class="form-control" placeholder="Discount ratio" type="number" value="${user.discount}" required min="0" max="99">
                </div>
            </div>
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary <c:if test="${user.userStatus == 'BANNED'}">active</c:if>">
                    <input type="radio" name="userStatus" id="option1" autocomplete="off" value="BANNED" <c:if test="${user.userStatus == 'BANNED'}">checked</c:if>>BANNED
                </label>
                <label class="btn btn-secondary <c:if test="${user.userStatus == 'NORMAL_CLIENT'}">active</c:if>">
                    <input type="radio" name="userStatus" id="option2" autocomplete="off" value="NORMAL_CLIENT" <c:if test="${user.userStatus == 'NORMAL_CLIENT'}">checked</c:if>>NORMAL_CLIENT
                </label>
                <label class="btn btn-secondary <c:if test="${user.userStatus == 'KEY_CLIENT'}">active</c:if>">
                    <input type="radio" name="userStatus" id="option3" autocomplete="off" value="KEY_CLIENT" <c:if test="${user.userStatus == 'KEY_CLIENT'}">checked</c:if>>KEY_CLIENT
                </label>
                <label class="btn btn-secondary <c:if test="${user.userStatus == 'EMPLOYEE'}">active</c:if>">
                    <input type="radio" name="userStatus" id="option4" autocomplete="off" value="EMPLOYEE" <c:if test="${user.userStatus == 'EMPLOYEE'}">checked</c:if>>EMPLOYEE
                </label>
            </div>

            <c:if test="${listRole != null}">
                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <c:forEach items="${listRole}" var="role">
                            <label class="btn btn-secondary <c:if test="${user.role.roleName == role.roleName}">active</c:if>">
                                <input type="radio" name="userRole" value="${role.roleName}" <c:if test="${user.role.roleName == role.roleName}">checked</c:if>>${role.roleName}
                            </label>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="form-group"></div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block blue">Save change</button>
            </div>
            <div>
                <p class="text-center"><a href="users" class="btn">Back user list</a></p>
            </div>
        </form>
    </div>
</main>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

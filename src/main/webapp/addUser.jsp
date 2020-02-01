<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Add user by ADMIN-CONSOLE</title>
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
        <h4 class="text-center mb-4 mt-1" style="font-weight: bold">ADMIN CONSOLE: ADD USER</h4>
        <hr>

        <c:if test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <div class="alert alert-warning">
                    <h6>${error.header}</h6>
                    <h8>${error.message}</h8>
                </div>
            </c:forEach>
        </c:if>

        <form action="addUser" method="POST">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userLogin" class="form-control" placeholder="Login" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userEmail" class="form-control" placeholder="Email" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="userPassword" class="form-control" placeholder="Password" type="text"
                           aria-required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userName" class="form-control" placeholder="Name" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userSurname" class="form-control" placeholder="Surname" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userAddress" class="form-control" placeholder="Address" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userTelephone" class="form-control" placeholder="Telephone" type="text" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="userDiscount" class="form-control" placeholder="Discount ratio" type="number" required
                           min="0" max="99">
                </div>
            </div>
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary active">
                    <input type="radio" name="userStatus" id="option1" autocomplete="off" value="BANNED" checked>BANNED
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="userStatus" id="option2" autocomplete="off" value="NORMAL_CLIENT">NORMAL_CLIENT
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="userStatus" id="option3" autocomplete="off" value="KEY_CLIENT">KEY_CLIENT
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="userStatus" id="option4" autocomplete="off" value="EMPLOYEE">EMPLOYEE
                </label>
            </div>

            <c:if test="${listRole != null}">
                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <c:forEach items="${listRole}" var="role">
                            <label class="btn btn-secondary">
                                <input type="radio" name="userRole" value="${role.roleName}">${role.roleName}
                            </label>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="form-group"></div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block blue"> Sign up</button>
            </div>
            <div>
                <p class="text-center"><a href="index" class="btn">Back to login page</a></p>
            </div>
        </form>
    </div>
</main>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>

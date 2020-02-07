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
    <title>Add car by ADMIN-CONSOLE</title>
    <style>
        body {
            background: #f5f5f5
        }

        .blue {
            background-color: #00b5ec !important;
        }
    </style>
</head>
<main role="main" class="container">
    <div class="my-3 p-3 bg-white rounded box-shadow">
        <h4 class="text-center mb-4 mt-1" style="font-weight: bold">ADMIN CONSOLE: ADD CAR</h4>
        <hr>

        <c:if test="${errors != null}">
            <c:forEach items="${errors}" var="error">
                <div class="alert alert-warning">
                    <h6>${error.header}</h6>
                    <h8>${error.message}</h8>
                </div>
            </c:forEach>
        </c:if>

        <form action="addCar" method="POST">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="mark" class="form-control" placeholder="Mark" type="text" required>
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="model" class="form-control" placeholder="Model" type="text" required>
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="generation" class="form-control" placeholder="Generation" type="text">
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="yearProduction" class="form-control" placeholder="Year production" type="number"
                           max="2020" min="2000" step="1" required>
                </div>

                <c:if test="${carType != null}">
                    <select class="custom-select" name="carType">
                        <option selected>Select car type</option>
                        <c:forEach items="${carType}" var="type">
                            <option value="${type}">${type}</option>
                        </c:forEach>
                    </select>
                </c:if>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="registrationNumber" class="form-control" placeholder="Registration number" type="text"
                           minlength="4" maxlength="9" required>
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="fuelLevel" class="form-control" placeholder="Fuel level" type="number" min="0" max="1"
                           step="0.05" required>
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="carConditionNote" class="form-control" placeholder="Car condition note" type="text"
                           maxlength="500">
                </div>

                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa"></i> </span>
                    </div>
                    <input name="photo" class="form-control" placeholder="Link car photo" type="text">
                </div>

                <c:if test="${carStatus != null}">
                    <select class="custom-select" name="carStatus">
                        <option selected>Select car status</option>
                        <c:forEach items="${carStatus}" var="status">
                            <option value="${status}">${status}</option>
                        </c:forEach>
                    </select>
                </c:if>

                <%--equipment version--%>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="equipmentVersion" class="form-control" placeholder="Equipment version" type="text">
                </div>
            </div>
            <c:if test="${featureList != null}">
                <h6>Features:</h6>
                <c:forEach items="${featureList}" var="feature">
                    <div class="checkbox">
                        <label><input type="checkbox" name="feature" value="${feature}">${feature}</label>
                    </div>
                </c:forEach>
            </c:if>
            <div class="form-group"></div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block blue">Add car</button>
            </div>
            <div>
                <p class="text-center"><a href="carList" class="btn">Back to car list</a></p>
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

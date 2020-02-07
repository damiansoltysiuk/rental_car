<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>

<html  lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Car list</title>
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
<h2>List of cars</h2>
<a href="addCar" class="btn"><button type="button" class="btn btn-primary">Add car</button></a>
<table class="table table-stripped">
    <thead>
    <tr>
        <td>Car ID</td>
        <td>Mark</td>
        <td>Model</td>
        <td>Generation</td>
        <td>Year production</td>
        <td>Car type</td>
        <td>Registration number</td>
        <td>Fuel level</td>
        <td>Equipment version</td>
        <td>More info</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <c:if test="${cars != null}">
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.carID}</td>
                <td>${car.mark}</td>
                <td>${car.model.name}</td>
                <td>${car.model.generation}</td>
                <td>${car.productionYear}</td>
                <td>${car.model.carType}</td>
                <td>${car.registrationNumber}</td>
                <td>${car.fuelLevel}</td>
                <td>${car.model.equipmentVersion.equipmentName}</td>
                <td><a href="carInfo?id=${car.carID}" class="btn btn-info">More info</a></td>
                <td><a href="car?id=${car.carID}" class="btn btn-warning">Edit</a></td>
                <td><a href="carDelete?id=${car.carID}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
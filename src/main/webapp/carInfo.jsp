<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Car info ${car.mark} ${car.model.name} ${car.registrationNumber}</title>
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
<h4 style="text-align: center">Car info: ${car.mark} ${car.model.name} ${car.registrationNumber}</h4>
<hr>
<h6 style="text-align: center">Car</h6>
<hr>
<p>ID : ${car.carID}</p>
<p>Mark : ${car.mark}</p>
<p>Year production : ${car.productionYear}</p>
<p>Registration number : ${car.registrationNumber}</p>
<p>Fuel level : ${car.fuelLevel}</p>
<p>Condition note : ${car.carConditionNote}</p>
<p>Status : ${car.carStatus}</p>

<hr>
<h6 style="text-align: center">Model</h6>
<hr>
<p>ID : ${car.model.modelID}</p>
<p>Name : ${car.model.name}</p>
<p>Generation : ${car.model.generation}</p>
<p>Photo directory : ${car.model.fotoDirectory}</p>
<p>Car type : ${car.model.carType}</p>

<hr>
<h6 style="text-align: center">Equipment version</h6>
<hr>
<p>ID : ${car.model.equipmentVersion.equipmentVersionID}</p>
<p>Name : ${car.model.equipmentVersion.equipmentName}</p>
<p>Description : ${car.model.equipmentVersion.equipmentDescription}</p>

<hr>
<div>
    <p class="text-center"><a href="carList" class="btn">Back to car list</a><br/>
    <a href="car?id=${car.carID}" class="btn">Edit car</a></p>
</div>
</body>
</html>

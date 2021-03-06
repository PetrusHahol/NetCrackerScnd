<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@ include file="../css/style.css" %>
        li {
            list-style-type: none;
        }
    </style>
    <script type="text/javascript" src="../js/validations.js"></script>

</head>
<body link="black"
      alink="#00008b"
      vlink ="black">

<div class = "cloud">

    <a href = "/Controller?command=LogOut" class="My_button">LogOut</a>
    <a href = "http://vk.com/pet1us">
        <img class = "Vk_photo" src="/static/media/vk.png" />
    </a>
    <a href = "/Controller?command=main" class="user">${login}</a>
    <p  class="name">${firstname}</p>
    <p  class="name">${secondname}</p>

</div>
<c:choose>
    <c:when test = "${message != null}">
        <script>alert('${message}')</script>
    </c:when>
</c:choose>

<div class = "FormLocate">
    <form class = "SignIn" action="Controller?command=updateFlight&id=${flight.getId()}&reg=true" method="POST" onsubmit = "return validation_addFlight();">
        <div class =  "FormPosition">
            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="from"  value = "${flight.getFrom()}" required>
                <p class = "FieldLocate">From</p>
            </div>
            <div class = "FieldArea">
                <input  class = "FormsLocate" type="text" name="to" value = "${flight.getTo()}" required>
                <p class = "FieldLocate">To</p>
            </div>
            <div class = "FieldArea">
                <input class = "FormsLocate" type="text" name="flight_date"
                       value="${flight.getDate().get(flight_date)}.${flight.getDate().get(flight_month)}.${flight.getDate().get(flight_year)}" required>
                <p class = "FieldLocate">When in format</p>
                <p class = "FieldLocate">"02.05.2009"</p>
            </div>
            <div class = "ButtonPosition3">
                <input class = "SubmitButton3" type="submit" value="Update flight" />
            </div>
        </div>
    </form>
</div>

</body>
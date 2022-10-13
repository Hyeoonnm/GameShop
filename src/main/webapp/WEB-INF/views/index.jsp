<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script type="text/javascript"
            src="/resources/js/bootstrap.bundle.min.js"></script>

    <style>
        img {
            width : 100%;
            height : 300px;
        }
    </style>
</head>
<body>
<h1>GameShop 2022</h1>

<c:if test="${sessionScope.member == null}">
    <div>
        <a href="login">로그인</a>
    </div>
</c:if>

<c:if test="${sessionScope.member != null}">
    <div>
        <div>환영합니다. ${sessionScope.member.name} 님~!!!</div>
    </div>
    <div>
        <a href="logout">로그아웃</a>
    </div>
</c:if>

<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
    <div class="carousel-indicators">

        <c:forEach var="attach" items="${item.attachs}" varStatus="status">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${status.index}" class="${status.index == 0 ? 'active' : ''}"
                aria-current="true" aria-label="Slide 1"></button>
        </c:forEach>

    </div>
    <div class="carousel-inner">

        <c:forEach var="attach" items="${item.attachs}" varStatus="status">
        <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
            <img src="/upload/${attach.filename}" class="d-block w-100" alt="...">
        </div>
        </c:forEach>

    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>


<ul>
    <li><a href="game/list">게임 관리</a></li>
    <li><a href="publisher/list">게임회사 관리</a></li>
</ul>
</body>
</html>
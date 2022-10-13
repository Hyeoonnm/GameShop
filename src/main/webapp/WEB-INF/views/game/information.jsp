<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 2022-09-05
  Time: 오후 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세정보</title>
</head>
<body>

<div>
    <label>게임명 : </label>
    <p>${item.title}</p>
</div>

<div>
    <label>배급사 : </label>
    <p>${item.publisher}</p>
</div>

<div>
    <label>가격 : </label>
    <p>${item.price}</p>
</div>

<div>
    <label>출시일</label>
    <p>${item.regDate}</p>
</div>

<div>
    <a href="../list">
        <button type="button">취소</button>
    </a>
</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div>
    <div>
        <h3>게임 세부정보</h3>
    </div>

    <div>
        <label>게임번호:</label>
        <div>${item.id}</div>
    </div>

    <div>
        <label>제목:</label>
        <div>${item.title}</div>
    </div>

    <div>
        <label>게임사:</label>
        <div>${item.publisherId}</div>
    </div>

    <div>
        <label>게임소개:</label>
        <div>${item.contents}</div>
    </div>

    <div>
        <label>출시일자:</label>
        <div><fmt:formatDate value="${item.pubDate}" pattern="yyyy년 MM월 dd일"/></div>
    </div>

    <div>
        <label>등록자:</label>
        <div>${item.memberId}</div>
    </div>

    <div>
        <label>등록일시:</label>
        <div><fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일"/></div>
    </div>

    <div>
        <div>
            <ul>

                <c:if test="${item.attachs.size() < 1}">
                    <li>첨부파일이 없습니다.</li>
                </c:if>

                <c:forEach var="attach" items="${item.attachs}">
                    <li><img src="/upload/${attach.filename}"></li>
                </c:forEach>

            </ul>
        </div>
    </div>

    <div>
        <a href="../list">
            <button>목록</button>
        </a>
    </div>

    <c:if test="${sessionScope.member.id == item.memberId}">
        <div>
            <a href="../delete/${item.id}">
                <button>삭제</button>
            </a>
        </div>

        <div>
            <a href="../update/${item.id}">
                <button>변경</button>
            </a>
        </div>
    </c:if>

</div>
</body>
</html>
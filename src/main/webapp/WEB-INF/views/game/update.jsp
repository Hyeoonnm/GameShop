<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/resources/js/bootstrap.bundle.min.js"></script>

    <link href="/resources/summernote/summernote.min.css" rel="stylesheet">
    <script src="/resources/summernote/summernote.min.js"></script>

    <script src="/resources/summernote/lang/summernote-ko-KR.js"></script>

    <script>
        $(function () {
            $('#summernote').summernote({
                lang: 'ko-KR' // default: 'en-US'
            });
            $("#files .delete").click(function () {
                const id = $(this).data("id"); // 데이터셋중에 아이디를 읽어옴
                const button = $(this);

                $.ajax({
                    type: 'GET',
                    url: '../delete_attach/' + id,
                    success: function (result) {
                        console.log(result);
                        button.closest("li").remove();
                    }
                });
            });
        });

        $("#attachs").on("click", ".delete", function() {
            const div = $(this).closest(".input-group");
            div.remove();
        });

        $("#add").click(function() {
            const div = $("<div>");
            div.addClass("input-group");
            div.addClass("mb-3");

            const input = $("<input>");

            input.attr("type", "file");
            input.attr("name", "attach");
            input.addClass("form-control");
            input.addClass("form-control-sm");

            const button = $("<button>");
            button.attr("type", "button");
            button.addClass("btn");
            button.addClass("btn-sm");
            button.addClass("btn-outline-danger");
            button.addClass("delete");
            button.text("삭제");

            div.append(input);
            div.append(button);

            $("#attachs").append(div);
        });

    </script>
</head>
<body>
<div class="container">
    <div>
        <h3>게임정보 변경</h3>
    </div>

    <div>
        <form method="post">
            <div class="form-group">
                <label class="form-label">게임코드: ${item.id}</label>
            </div>

            <div class="form-group">
                <label class="form-label">게임명:</label>
                <input type="text" name="title" value="${item.title}" class="form-control">
            </div>

            <div class="form-group">
                <label class="form-label">게임회사:</label>
                <select name="publisherId" class="form-select form-select-sm">
                    <option value="0">알수없음</option>
                    <c:forEach var="publisher" items="${list}">
                        <option value="${publisher.id}" ${publisher.id == item.publisherId ? 'selected' : ''}>${publisher.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label class="form-label">가격:</label>
                <input type="number" name="price" value="${item.price}" class="form-control">
            </div>

            <div class="form-group">
                <label class="form-label">출시일:</label>
                <input type="date" name="pubDate" value="${item.pubDateFormat}" class="form-control">
            </div>

            <div class="form-group">
                <label class="form-label">등록일: ${item.regDate}</label>
            </div>

            <div>
                <div>
                    <ul id="files">
                        <c:if test="${item.attachs.size() < 1}">
                            <li> 첨부파일이 없습니다</li>
                        </c:if>

                        <c:forEach var="attach" items="${item.attachs}">
                            <div>
                                <p>첨부파일 ${attach.filename}</p>
                                <li>
                                    <button type="button" class="btn btn -sm btn-danger delete" data-id="${attach.id}">삭제</button>
                                </li>
                            </div>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <div class="form-group">
                <label>첨부파일:<button type="button" id="add" class="btn btn-sm btn-primary">추가</button></label>
                <div id="attachs">

                    <div class="form-group">
                        <label class="form-label">게임소개:</label>
                        <textarea name="contents" id="summernote">${item.contents}</textarea>
                    </div>

                    <div class="form-group mt-3">
                        <button class="btn btn-sm btn-primary">변경</button>
                        <a href="../list">
                            <button type="button" class="btn btn-sm btn-secondary">취소</button>
                        </a>
                    </div>
        </form>
    </div>
</div>
</body>
</html>
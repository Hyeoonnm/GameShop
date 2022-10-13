<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<h3>게임회사 목록</h3>
		</div>
		
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>기업명</th>
						<th>영문명</th>
						<th>관리</th>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="4">검색 된 데이터가 없습니다</td>					
						</tr>
					</c:if>					
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.id}</td>
							<td>${item.name} <a href="http://${item.url}" target="_blank"><button>Go</button></a></td>
							<td>${item.nameEng}</td>
							<td><a href="delete/${item.id}">삭제</a> <a href="update/${item.id}">변경</a></td>
						</tr>
					</c:forEach>					
				</tbody>
			</table>
		</div>
		
		<div>
			<a href="add">등록</a>
		</div>
		
		<div>
			<a href="..">처음으로</a>
		</div>
	</div>
</body>
</html>
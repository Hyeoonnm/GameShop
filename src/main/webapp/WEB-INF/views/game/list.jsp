<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div>
			<h3>게임 목록</h3>
		</div>
		
		<div>
			<table class="table table-sm table-hover table-striped">
				<thead class="table-dark">
					<tr>
						<th>게임번호</th>
						<th>게임명</th>
						<th>게임회사</th>
						<th>가격</th>
						<th>출시일</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>관리</th>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">검색 된 게임이 없습니다</td>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${item.id}</td>
							<td><a href="detail/${item.id}">${item.title}</a></td>
							<td>${item.publisher}</td>
							<td>${item.price}</td>
							<td><fmt:formatDate value="${item.pubDate}" pattern="yyyy-MM-dd"/></td>
							<td>${item.name} (${item.memberId})</td>
							<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd"/></td>							
							<td>
								<c:if test="${sessionScope.member.id == item.memberId}">
									<a href="delete/${item.id}" class="btn btn-sm btn-outline-danger">삭제</a> <a href="update/${item.id}" class="btn btn-sm btn-outline-primary">변경</a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>					
			</table>
			<div>
				<ul class="pagination pagination-sm justify-content-center">
					<li class="page-item"><a href="?page=1" class="page-link">처음</a></li>
					<li class="page-item"><a href="?page=${pager.prev}" class="page-link">이전</a></li>
					<c:forEach var="page" items="${pager.list}">
						<li class="page-item"><a href="?page=${page}" class="page-link ${page eq pager.page ? 'active' : ''}">${page}</a></li>
					</c:forEach>
					<li class="page-item"><a href="?page=${pager.next}" class="page-link">다음</a></li>
					<li class="page-item"><a href="?page=${pager.last}" class="page-link">마지막</a></li>
				</ul>
			</div>
		</div>
		<div>
			<div>
				<a href="add" class="btn btn-primary btn-sm mb-2">등록</a>
			</div>
			<div>
				<a href="dummy" class="btn btn-success btn-sm mb-2">대량 등록</a>
			</div>
			<div>
				<a href="init" class="btn btn-danger btn-sm mb-2">초기화</a>
			</div>
			<div>
				<a href=".." class="btn btn-secondary btn-sm mb-2">처음으로</a>
			</div>
		</div>		
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>
			<form method="post">
				<div>
					<label>회사명:</label>
					<input type="text" name="name" value="${item.name}">
				</div>
				
				<div>
					<label>영문명:</label>
					<input type="text" name="nameEng" value="${item.nameEng}">
				</div>
				
				<div>
					<label>홈페이지:</label>
					<input type="text" name="url" placeholder="http://를 제외하고 입력하세요" value="${item.url}">
				</div>
				
				<div>
					<button>변경</button>
					<a href="../list"><button type="button">취소</button></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
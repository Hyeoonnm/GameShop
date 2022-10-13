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
			<h3>로그인</h3>
		</div>
		<div>
			<form method="post">
				<div>
					<label>아이디:</label>
					<input type="text" name="id">
				</div>
				
				<div>
					<label>비밀번호:</label>
					<input type="password" name="passwd">
				</div>
				
				<div>
					<button>로그인</button>
					<a href="/"><button type="button">취소</button></a>
				</div>
			</form>
		</div>
		<div>
			<div>
				<a href="signup">회원가입</a>
			</div>
		</div>
	</div>
</body>
</html>
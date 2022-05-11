<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<style>
.login-dark {
	height: 400px;
}

.login-dark form {
	max-width: 450px;
	width: 200%;
	background-color: #1e2833;
	padding: 40px;
	border-radius: 4px;
	transform: translate(-50%, -50%);
	position: absolute;
	top: 20%;
	left: 50%;
	color: #fff;
	box-shadow: 3px 3px 4px rgba(0, 0, 0, 0.2);
	margin-top: 150px;
}

.login-dark .illustration {
	text-align: center;
	padding: 15px 0 20px;
	font-size: 50px;
	color: #2980ef;
}

.login-dark form .form-control {
	background: none;
	border: none;
	border-bottom: 1px solid #434a52;
	border-radius: 0;
	box-shadow: none;
	outline: none;
	color: inherit;
}

.login-dark form .btn-primary {
	font-size: 5px;
	background: #214a80;
	border: none;
	border-radius: 4px;
	padding: 5px;
	box-shadow: none;
	margin-top: 5px;
	text-shadow: none;
	outline: none;
}

.login-dark form .btn-primary:hover, .login-dark form .btn-primary:active
	{
	background: #214a80;
	outline: none;
}

.login-dark form .forgot {
	display: block;
	text-align: center;
	font-size: 12px;
	color: #6f7a85;
	opacity: 0.9;
	text-decoration: none;
}

.login-dark form .forgot:hover, .login-dark form .forgot:active {
	opacity: 1;
	text-decoration: none;
}

.login-dark form .btn-primary:active {
	transform: translateY(1px);
}
</style>

<title>비밀번호 찾기</title>
</head>

<body style="background: #232529;">
	<div class="login-dark">
		<form action="memberHashPwFindAction.RC" method="post">
			<div class="">비밀번호 찾기</div>
			<hr>
			<div class="form-group">
				<label>아이디</label> <input type="text" name="mID" size="40"
					maxlength="12" class="form-control" placeholder="회원 아이디 입력"
					required="required">
				<!-- required="required" : 반드시 입력 -->
			</div>
			<div class="form-group">
				<label>이메일 입력</label> <input type="text" name="mEMAIL" id="mEMAIL"
					size="40" class="form-control"
					placeholder="(ex)&nbsp; SoulRest@naver.com" required="required">
			</div>
			<div>
				<input type="submit" class="btn btn-danger" value="비밀번호 찾기">
			</div>
		</form>
	</div>

</body>
</html>
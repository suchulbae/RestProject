<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

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
<title>비밀번호 찾기 결과</title>
</head>
<body style="background: #232529;">
<body style="margin-top: 50px;">
	<div class="login-dark">
	<form>
			<div class="form-grouph">비밀번호 찾기 결과</div>
			<hr>
			<div class="form-group">
				<div class="">회원님의 임시 비밀번호는</div>
				<input type="text" class="form-control"
					value="${random_password }&nbsp; 입니다"readonly="readonly" />
			</div>


			<!-- <a href="memberLogin.RC">[로그인]</a> --> 
			
			
			<button class="btn btn-danger" onclick="location.href='memberLogin.RC'; return false;">로그인</button>
			<button class="btn btn-danger" onclick="location.href='memberHashPwChangeForm.RC?mID=${mID }'; return false;">비밀번호변경</button>
	</div>
	</form>
</body>
</html>
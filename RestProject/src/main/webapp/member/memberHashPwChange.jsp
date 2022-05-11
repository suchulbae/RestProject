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
	height: 500px;
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
	margin-top: 180px;
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
<title>비밀번호 변경</title>

<!-- 유효성 체크 -->
<script type="text/javascript">
	function check() {

		// 비밀번호 값 데이터 정규화 공식
		const regPass = /^[a-zA-Z0-9]{8,12}$/;

		// 변수 사용
		let pre_pwd = document.f.pre_password;
		let new_pwd = document.f.new_password;
		let confirm_pwd = document.f.confirm_password;

		// '이전 비밀번호' 유효성 검사 - 정규화 공식 이용
		if (!pre_pwd.value.trim()) { // 이전 비밀번호가 입력되지않았으면
			alert("이전 비밀번호를 입력하세요.");
			pre_pwd.focus(); // 커서를 깜박거림
			return false;
		} else if (!regPass.test(pre_pwd.value.trim())) { // 비밀번호가 정규화공식에 맞지않으면
			alert("비밀번호는 8~12자의 영어 대소문자와 숫자로만 입력가능합니다.");
			return pre_pwd.select();
		} else

		// '새 비밀번호' 유효성 검사 - 정규화 공식 이용
		if (!new_pwd.value.trim()) { // 새 비밀번호가 입력되지않았으면
			alert("새 비밀번호를 입력하세요.");
			new_pwd.focus(); // 커서를 깜박거림
			return false;
		} else if (!regPass.test(new_pwd.value.trim())) { // 비밀번호가 정규화공식에 맞지않으면
			alert("비밀번호는 8~12자의 영어 대소문자와 숫자로만 입력가능합니다.");
			return new_pwd.select();
		} else

		// '새 비밀번호 확인' 유효성 검사 - 정규화 공식 이용
		if (!confirm_pwd.value.trim()) { // 새 비밀번호확인 입력되지않았으면
			alert("새 비밀번호 확인을 입력하세요.");
			confirm_pwd.focus(); // 커서를 깜박거림
			return false;
		} else if (!regPass.test(confirm_pwd.value.trim())) { // 비밀번호가 정규화공식에 맞지않으면
			alert("비밀번호는 8~12자의 영어 대소문자와 숫자로만 입력가능합니다.");
			return confirm_pwd.select();
		} else

		// '이전비밀번호'와 '새 비밀번호'가 일치하는지 확인하여 다르게 입력하도록 유도
		if (pre_pwd.value.trim() == new_pwd.value.trim()) {
			alert("새 비밀번호가 이전비밀번호와 일치합니다. 새 비밀번호를 다시 입력해주세요.");
			return new_pwd.select();
		} else

		// '새 비밀번호'와 '새 비밀번호 확인'이 일치하는지 확인하여 같게 입력하도록 유도
		if (new_pwd.value.trim() != confirm_pwd.value.trim()) {
			alert("입력하신비밀번호와 일치하지 않습니다. 새 비밀번호 확인을 다시 입력해주세요.");
			return confirm_pwd.select();
		}
		// 위의 조건이 모두 거짓이면(=유효성 검사를 만족하면) submit()함
		document.f.submit();// document 생략가능

	}
</script>
</head>
<body style="background: #232529;">
	<div class="login-dark">
		<form action="memberHashPwChangeAction.RC" method="post" name="f" >
			<h2>비밀번호 변경</h2>
			<hr>
			<div class="form-group">
				이전 비밀번호 입력 <input type="hidden" name="mID" 
					value="<%=request.getParameter("mID")%>"> <input
					type="password" name="pre_password" maxlength="12" class="form-control"
					placeholder="8~12자 영문과 숫자조합을 입력하세요." required="required">
			</div>
			<div class="form-group">
				새 비밀번호 입력 <input type="password" name="new_password" maxlength="12" class="form-control"
					placeholder="8~12자 영문과 숫자조합을 입력하세요." required="required">
			</div>
			<div class="form-group">
				새 비밀번호 확인 <input type="password" name="confirm_password" class="form-control"
					maxlength="12" placeholder="새 비밀번호와 동일하게 입력해주세요."
					required="required">
			</div>
			<button class="btn btn-danger" onclick="check(); return false;">변경하기</button>
	</form>
	</div>
</body>
</html>
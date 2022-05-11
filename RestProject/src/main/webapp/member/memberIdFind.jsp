<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/memberIdFind.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<style>

</style>

<title>아이디 찾기</title>
</head>
<body style="background: #232529;">
<div class="login-dark">
	<form action="memberIdFindAction.RC" method="post" >
		<div>
			<div class="form-grouph">아이디 찾기</div>
			<hr>
			<div class="form-group">
				<lable>이메일 입력</lable>
				 <input type="text" name="mEMAIL" class="form-control"
					placeholder="ex)SoulRest@naver.com" required="required"/>
			</div>
			
			<input type="submit" class="btn btn-danger" value="찾기">
		
	</div>
</form>
</div>
</body>
</html>
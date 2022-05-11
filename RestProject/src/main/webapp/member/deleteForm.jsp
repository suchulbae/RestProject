<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberDELETEAction.RC" method="post" >
		<div>
			<h2>아이디 찾기</h2>
			<hr>
			<div class="form-group">
				<lable>아이디 입력</lable>
				 <input type="text" name="mID" class="form-control"
					placeholder="아이디를  입력해주세요" required="required"/>
				 <input type="password" name="mPW" class="form-control"
					placeholder="비밀번호를  입력해주세요" required="required"/>
			</div>
			
			
			
			
			
			<input type="submit" class="btn btn-primary btn-block" value="확인">
		
	</div>
</form>
</body>
</html>
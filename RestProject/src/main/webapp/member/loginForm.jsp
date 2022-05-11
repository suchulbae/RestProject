<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String cookId =""; // ★★ null로 초기화하면 안됨
Cookie[] cookies = request.getCookies();

if(cookies != null && cookies.length > 0){ // 쿠키객체가 비어있지 않으면
	for(int i=0; i <cookies.length; i++){
		if(cookies[i].getName().equals("mID")){
			cookId = cookies[i].getValue(); // 쿠키값(=사용자 아이디)을 얻어와 cookId 변수에 저장
			break;
		}
	}
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/loginFormstyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<title>로그인</title>
   
<style>

</style>
</head>
<body style="background: black;">
<div class="login-dark">
   <form action="memberLoginAction.RC" method="post" name="loginForm">
		<input type="hidden" name="mGRADE">
		<div class="form-grouph">로그인</div>
		<hr>
        <div class="form-group">
			<label>아이디 </label>
        	<input type="text" class="form-control" name="mID" value="<%=cookId %>" placeholder="아이디 입력필수"> 
        </div>
        <div class="form-group">
			<label>비밀번호</label>
        	<input type="password" class="form-control"  name="mPW" size="31" placeholder="비밀번호입력(필수)">
        </div>
        <div class="form-group">
       <label><input type="checkbox" name="remember"> 아이디 저장
        </label>
        </div>
			<div class="form-group" align="center">
            <input type="submit" class="btn btn-danger"  value=" 로그인" />
        </div>
        <hr>
		<div class="small text-center">아이디를 잃어버렸습니까?&nbsp;<a href="memberIdFindForm.RC">찾기!</a></div>
		<div class="small text-center">비밀번호를 잃어버렸습니까?&nbsp;<a href="memberHashPwFindForm.RC">찾기!</a></div>
		<div class="small text-center">사용자계정이 없습니까?&nbsp;<a href="memberJoin.RC">회원가입!</a></div>
		<hr>	
    </form>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
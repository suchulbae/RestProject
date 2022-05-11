<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/style.css">
<title>회원수정완료</title>
</head>
<body style="margin-top: 120px; background: #f8f9fa">
	<div>
		<%-- <h3>[${u_name}]회원님의 정보 수정이 완료되었습니다.</h3> --%>
		<h3 style="font-size: 22px;margin-left: 10%;">${sessionScope.mNAME}&emsp;회원님의 정보 수정이
			완료되었습니다.</h3>

		<button onclick="location.href='memberView.RC';" style="margin-left: 20%;"
			class="btn btn-primary btn-block btn" value="">확인</button>


	</div>
</body>
</html>
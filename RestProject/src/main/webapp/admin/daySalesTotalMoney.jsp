<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>하루 매출 총 합계</title>
</head>
<body>
	<h2>${sessionScope.meal_order_date }일의 매출</h2>
	<h3>총 매출금액: ${sessionScope.daySalesTotalMoney }원 입니다.</h3>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">

<!-- <link rel="stylesheet" href="css/style.css"> -->

<title>밀키트 상세 정보보기</title>
</head>
<body>
	<%-- <section>
		<!-- ----------- 메뉴 상세 정보보기 ---------------------------------->
		<h3>${mealKitInfo.meal_name}</h3>
		<table>
			<tr> <!-- [관리자 모드] : 업로드하는 폴더이름 images -->
				<img src="${pageContext.request.contextPath}/assets/img/mealKit/${mealKitInfo.meal_image}" />
			</tr>
			<tr>
				<td>
					<h4>제목 상세 정보</h4> : ${mealKitInfo.meal_detail}
				</td>
			</tr>
			
			<tr>
				<td>가격 : ${mealKitInfo.meal_price}원</td>
			</tr>
			<tr>
				<td>
					<a href="mealKitCartAdd.KIOSK?meal_id=${mealKitInfo.meal_id}&meal_name=${mealKitInfo.meal_name}">
					<h3>[장바구니 담기]</h3>
					</a>
				</td>
			</tr>
		</table>
	</section> --%>
</body>
</html>
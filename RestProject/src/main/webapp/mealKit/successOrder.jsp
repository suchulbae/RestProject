<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>사용자의 주문내역</title>

<link rel="stylesheet" href="assets/css/mealKitMemberList.css"> 

</head>
<body>
	<div>
		<jsp:include page="mealKitHeader.jsp" />
	</div>
	
	<section class="center">
		<c:if
			test="${sessionScope.mealKitList != null && sessionScope.mealKitList.size() > 0 }">
			<h3 style="text-align: center;">${sessionScope.mNAME}님의 주문내역입니다.</h3>
			<form action="post">
				<table>
					<tr>
						<th>번호</th>
						<th>메뉴명</th>
						<th>가격</th>
						<th>수량</th>
					</tr>

					<c:forEach var="mealKit" items="${sessionScope.mealKitList}"
						varStatus="status">
						<tr>
							<td>${meal_status.index+1}</td>
							<td>${mealKit.meal_id}</td>
							<td>${mealKit.meal_price}</td>
							<td>${mealKit.quantity}</td>
						</tr>
					</c:forEach>

					<tr>
						<td colspan="4">합계 금액: ${sessionScope.meal_totalMoney}원</td>
					</tr>

					<tr>
						<td colspan="4">할인 금액:
							-${sessionScope.totalMoney-sessionScope.saleTotalMoney}원</td>
					</tr>

					<tr>
						<td colspan="4">결제 금액: ${sessionScope.saleTotalMoney}원</td>
					</tr>

					<tr>
						<td colspan="4">
							<jsp:include page="${pageContext.request.contextPath}/orderStatus.jsp" />
						</td>
					</tr>

				</table>
			</form>
		</c:if>

		<c:if test="${sessionScope.mealKitList == null }">
			<h3>${sessionScope.mNAME}님의 주문내역이 없습니다.</h3>
		</c:if>
	</section>

	<div>
		<jsp:include page="mealKitFooter.jsp" />
	</div>
</body>
</html>
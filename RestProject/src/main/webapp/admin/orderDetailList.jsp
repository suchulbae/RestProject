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

<title>밀키트 주문 상세 정보 리스트</title>

<link rel="stylesheet" href="assets/css/mealKitAdminForm.css">

</head>
<body>
	<section>
		<c:if test="${orderDetailList ne null && orderDetailList.size() > 0}">
			<h3 style="text-align: center;">주문번호 : ${orderDetailList.get(0). meal_order_num}</h3>

			<table class="table">
				<tr>
					<td>밀키트 번호</td>
					<td>밀키트 ID</td>
					<td>밀키트 명</td>
					<td>밀키트 주문 수량</td>
				</tr>

				<tr>
					<c:forEach var="orderDetail" items="${orderDetailList}"
						varStatus="status">
						<td>${meal_order_status.index+1}</td>
						<td>${orderDetail.meal_id}</td>

						<td>${orderDetail.meal_name}</td>
						<td>${orderDetail.meal_quantity}</td>
				</tr>
				</c:forEach>


			</table>

		</c:if>

		<c:if test="${orderDetailList eq null}">
			밀키트 주문 상세 정보가 없습니다.
		</c:if>

	</section>
</body>
</html>
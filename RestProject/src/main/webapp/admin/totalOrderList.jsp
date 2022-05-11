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
	
<title>전체 밀키트 주문내역 리스트</title>

<link rel="stylesheet" href="assets/css/mealKitAdminForm.css"> 	
<style>
a{
text-decoration: none;
}
</style>
</head>
<body>
	<section>
		<!-- 1. ************************************************************* -->
		<c:if test="${totalOrderList ne null && totalOrderList.size() > 0}">

			<!-- 1-1. [주문 대기] ******************************************************** -->
			<div>
				<h3 style="text-align: center">주문 대기</h3>
			</div>
			<table class="center">
				<c:set var="doneLoop" value="false" />
			
				<c:forEach var="order" items="${totalOrderList}" varStatus="status">
					
					<c:if test="${not doneLoop}">
						<c:choose>
							<c:when test="${order.meal_order_status eq 'order'}">
								<tr>
									<th>밀키트 주문 번호</th>
									<th>고객 ID</th>
									<th>고객 EMAIL</th>
									<th>주문 시간</th>
									<th>주문 상태</th>
									<th>총 금액</th>
								</tr>
								<c:set var="doneLoop" value="true" />
							</c:when>
						</c:choose>
					</c:if>
				</c:forEach>

					<form action="post">
						<c:forEach var="order" items="${totalOrderList}" varStatus="status">
							<c:if test="${order.meal_order_status eq 'order'}">
								<tr>
									<td><b> <a
											href="orderDetail.ADM?meal_order_num=${order.meal_order_num }&mID=${order.mID }">
												${order.meal_order_num }</a>
									</b></td>
									<td>${order.mID}</td>
									<td>${order.mEMAIL}</td>
									<td>${order.meal_order_date}</td>
									<td>주문 승인 대기 </td>
									<td>${order.meal_totalmoney}원</td>
								</tr>
							</c:if>
						</c:forEach>
					</form>
			</table>

		<br>
		<br>
		<br>

		<!-- 1-2. [주문 승인] : get  ******************************************************** -->
		<div>
			<h3 style="text-align: center">주문 승인</h3>
		</div>
		<table class="center">
			<c:set var="doneLoop2" value="false" />
			<c:forEach var="order" items="${totalOrderList}" varStatus="status">
				<c:if test="${not doneLoop2 && order.meal_order_status eq 'get'}">
					<c:choose>
						<c:when test="${order.meal_order_status eq 'get'}">
							<tr>
								<th>밀키트 주문 번호</th>
								<th>고객 ID</th>
								<th>고객 EMAIL</th>
								<th>주문 시간</th>
								<th>주문 상태</th>
								<th>총 금액</th>
							</tr>
							<c:set var="doneLoop2" value="true" />
						</c:when>

						<c:otherwise>
                        주문 승인된 밀키트 리스트가 존재하지 않습니다.
                        <c:set var="doneLoop2" value="true" />
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>

			<form action="post">
				<c:forEach var="order" items="${totalOrderList}" varStatus="status">
					<c:if test="${order.meal_order_status eq 'get'}">
						<tr>
							<td><b> <a
									href="orderDetail.ADM?meal_order_num=${order.meal_order_num }&mID=${order.mID }">
										${order.meal_order_num } </a>
							</b></td>
							<td>${order.mID}</td>
							<td>${order.mEMAIL}</td>
							<td>${order.meal_order_date}</td>
							<td>주문 승인 상태</td>
							<td>${order.meal_totalmoney}원</td>
						</tr>
					</c:if>
				</c:forEach>
			</form>
		</table>

		<br>
		<br>
		<br>

		<!-- 1-3. [주문 취소] : cancel  ******************************************************** -->
		<div>
			<h3 style="text-align: center">주문 취소</h3>
		</div>
		<table class="center">
			<c:set var="doneLoop3" value="false" />

			<c:forEach var="order" items="${totalOrderList}" varStatus="status">
				<c:if test="${not doneLoop3 && order.meal_order_status eq 'cancel'}">
					<c:choose>
						<c:when test="${order.meal_order_status eq 'cancel'}">
							<tr>
								<th>밀키트 주문 번호</th>
								<th>고객 ID</th>
								<th>고객 EMAIL</th>
								<th>주문 시간</th>
								<th>주문 상태</th>
								<th>총 금액</th>

							</tr>
							<c:set var="doneLoop3" value="true" />
						</c:when>

						<c:otherwise>
                        주문 승인된 밀키트 리스트가 존재하지 않습니다.
                        <c:set var="doneLoop3" value="true" />
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>

			<form action="post">
				<c:forEach var="order" items="${totalOrderList}" varStatus="status">
					<c:if test="${order.meal_order_status eq 'cancel'}">
						<tr>
							<td><b> <a
									href="orderDetail.ADM?meal_order_num=${order.meal_order_num }&mID=${order.mID }">
										${order.meal_order_num } </a>
							</b></td>
							<td>${order.mID}</td>
							<td>${order.mEMAIL}</td>
							<td>${order.meal_order_date}</td>
							<td>주문 취소</td>
							<td>${order.meal_totalmoney}원</td>
						</tr>
					</c:if>
				</c:forEach>
			</form>
		</table>

		<br>
		<br>
		<br>

		</c:if>

		<!-- 2. ************************************************************* -->
		<c:if test="${totalOrderList eq null}">
			주문한 밀키트 내역이 존재하지 않습니다.
		</c:if>
	</section>
</body>
</html>
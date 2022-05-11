<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

<script type="text/javascript">
	function window_onload() {
		
		setInterval('win_refresh()', 10000);
	}

	function win_refresh() {
		
		location.href = "resvRealTimeOrder.RSV";
	}
</script>

</head>
<body onload="javascript:window_onload()">
	<c:if test="${sessionScope.latestResvOrder ne null}">


		<strong> 주문상태 : <c:choose>
				<c:when test="${sessionScope.latestResvOrder.order_status eq 'order'}">예약 대기 상태</c:when>
				<c:when test="${sessionScope.latestResvOrder.order_status eq 'get'}">예약  완료</c:when>
				<c:otherwise>주문 취소</c:otherwise>
			</c:choose>
		</strong>
	</c:if>

	<c:if test="${sessionScope.latestResvOrder eq null}">
		관리자가 확인하지 않았습니다.
	</c:if>
</body>
</html>










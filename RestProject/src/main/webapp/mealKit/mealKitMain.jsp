<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">

<title>mealKit 주문</title>
</head>
<body class="main">

	<div><jsp:include page="mealKitHeader.jsp" /></div>
		<div><jsp:include page="mealMenuList.jsp" /></div>
	<section>
		<c:if test="${showMealKit ne null }">
		
			<div>
				<jsp:include page="${showMealKit }" /> 

				<c:choose>
					<c:when test="${mID eq null and showmealKit eq null }">
							<jsp:include page="/mealKit/mealKitKisokMainImage.jsp" />
							
						</c:when>

					<%--<c:when test="${mID ne null and showMealKit ne null }">

						<div style="text-align: center;">[${sessionScope.mGRADE }]CEO님 환영합니다!!</div> 
					</c:when>--%>
				</c:choose>

			</div>
		</c:if>
	</section>

	<jsp:include page="mealKitFooter.jsp" />

</body>
</html>


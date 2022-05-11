<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">

<title>mealKitConfirm 메인</title>
</head>
<body class="main">

	<jsp:include page="adminHeader.jsp" />

	<section>
		<c:if test="${showAdmin ne null }">
			<div>
				<jsp:include page="${showAdmin }" />

				<c:choose>

					<c:when test="${mGRADE ne null and showAdmin ne null }">

					</c:when>
				</c:choose>

			</div>
		</c:if>
	</section>

	<jsp:include page="adminFooter.jsp" />

</body>
</html>

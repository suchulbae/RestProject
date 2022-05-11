<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">

<title>admin 메인</title>
</head>
<body class="main">

	<jsp:include page="adminHeader.jsp" />
		<jsp:include page="mealkitMenu.jsp" />
	<section>
		<c:if test="${showAdmin ne null }">
			<div>
				<jsp:include page="${showAdmin }" />

				<c:choose>
					<%-- <c:when test="${mGRADE eq null and showAdmin eq null }">
							<jsp:include page="/admin/mealKitMainImage.jsp" />
						</c:when> --%>

					<c:when test="${mGRADE ne null and showAdmin ne null }">

						<%--<div style="text-align: center;">[${sessionScope.mGRADE }]CEO님 환영합니다!!</div> --%>
					</c:when>
				</c:choose>

			</div>
		</c:if>
	</section>

	<jsp:include page="adminFooter.jsp" />

</body>
</html>
<%-- <body class="main">
	<div>
		<jsp:include page="adminHeader.jsp" />
		<section>
			<c:if test="${showAdmin ne null }">
				<div>
					<jsp:include page="${showAdmin }" />
					
					<c:choose>
						<c:when test="${mGRADE eq null and showAdmin eq null }">
							<jsp:include page="/admin/loginForm.jsp" />
						</c:when>
						
						<c:when test="${mGRADE ne null and showAdmin ne null }">
							<div align="center">[${sessionScope.mGRADE }]CEO님 환영합니다!!</div>
						</c:when>
					</c:choose>
					
				</div>
			</c:if>
		</section>
		<jsp:include page="adminFooter.jsp" />
	</div> 
</body>
</html>
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>


	<jsp:include page="reservationHeader.jsp" />
					<br><br>
				<div style="text-align:center">
		
			<jsp:include page="reservationMenuList.jsp" />
			</div>
	
	

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


</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>밀키트 메인 창입니다.</title>
<link rel="stylesheet" href="assets/css/mealKit.css"> 

</head>
<body>

<jsp:include page="adminHeader.jsp" />
<!--  
<section class="main_image">
    <img src="assets/img/hero-bg.jpg">
</section>
-->
<section>
			<c:if test="${showAdmin ne null }">
				<div>
					<jsp:include page="${showAdmin }" />
					
					<c:choose>
						<c:when test="${mGRADE eq null and showAdmin eq null }">
							<jsp:include page="/admin/mealKitMainImage.jsp" />
						</c:when>
						
						<c:when test="${mGRADE ne null and showAdmin ne null }">
							<div style="background-color: red; height: 50px;" align="center">[${sessionScope.mGRADE }]CEO님 환영합니다!!</div>
							
							<!-- <section class="main_image">
							    <img src="assets/img/hero-bg.jpg">
							</section> -->
							
							<%-- <section>
								<jsp:include page="mealKitAddForm.jsp"/>
							</section> --%>
							
						</c:when>
					</c:choose>
				</div>
			</c:if>
	</section>
	
<jsp:include page="adminFooter.jsp" />

</body>
</html>
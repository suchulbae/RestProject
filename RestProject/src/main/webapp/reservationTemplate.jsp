<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>SoulRest 예약</title>
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="carousel.css" rel="stylesheet">
</head>
<body>
	<div><jsp:include page="reservationMenu/reservationHeader.jsp" /></div>
	<section>
	
	<br><br>
				<div style="text-align:center">
				<!-- jsp: jsp:include 액션테그에서는 상대경로로 설정 주의(${pageContext.request.contextPath}사용 하면 오류 발생-->
			<jsp:include page="reservationMenu/reservationMenuList.jsp" />
			</div>
			</section>
			
			<c:if test="${showRsvMenu eq null}">
				<jsp:include page="reservationMenu/reservationDEFAULT.jsp" />
			
			
			</c:if>
				<c:if test="${showRsvMenu ne null}">
				<div style="text-align:center">
			<jsp:include page="${showRsvMenu }" />
			
			</div>
					</c:if>
</body>
</html>
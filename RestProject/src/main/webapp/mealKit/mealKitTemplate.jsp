<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
	


<title>Insert title here</title>
</head>
<body>

	<div><jsp:include page="mealKitHeader.jsp" /></div>
		<div><jsp:include page="mealMenuList.jsp" /></div>
	<section>
		
			<c:if test="${showMealKit ne null}">
			
					<jsp:include page="${showMealKit }" />
			
			</c:if>
	
	
		
	</section>
	<div><jsp:include page="mealKitFooter.jsp" /></div>
	
</body>
</html>
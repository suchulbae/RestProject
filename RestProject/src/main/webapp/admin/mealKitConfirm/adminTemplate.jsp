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
<section>
	<div>
		<%-- <jsp:include page="adminMealKit.jsp" /> --%>
	</div>

	<c:if test="${adminMealKit ne null}">
		<div>
			<jsp:include page="${adminMealKit }" />
			
		</div>
	</c:if>

	<c:if test="${adminMealKit eq null }">
		<div></div>
	</c:if>
	</section>
</body>
</html>	

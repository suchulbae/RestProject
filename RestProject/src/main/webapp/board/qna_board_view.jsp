<%@page import="vo.boardDTO.PageInfo"%>
<%@page import="vo.boardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
BoardDTO article = (BoardDTO) request.getAttribute("article");
String nowPage = (String) request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SoulRest</title>
<style type="text/css">
.image-container {
	max-width: 300px;
}

img {
	width: 100%;
	max-width: 100%;
}
table{
	height:900px;
}
</style>
</head>

<body style="background: black; margin-top: 100px">


	<!-- 게시판 수정 -->
	<div>
		<jsp:include page="memberHeader.jsp" />
	</div>

	
	<table class="table table-borderless table-dark w-auto"
		id="basicInfoArea" style="margin: auto">
		<tr>
		<td><h4 style="color: white; text-align: left; font-size: 20px">고객후기</h4></td>
		</tr>
		<tr>
			<td colspan="2">제 목 : <%=article.getBOARD_SUBJECT()%></td>
		</tr>

		<tr class="star-rating space-x-4 mx-auto">

			<td>별 점 : <c:if test="${article.boardRating == 5}">
					<label for="5-stars" class="star pr-4">★★★★★</label>
				</c:if> <c:if test="${article.boardRating == 4}">
					<label for="4-stars" class="star">★★★★</label>
				</c:if> <c:if test="${article.boardRating == 3}">
					<label for="3-stars" class="star">★★★</label>
				</c:if> <c:if test="${article.boardRating == 2}">
					<label for="2-stars" class="star">★★</label>
				</c:if> <c:if test="${article.boardRating == 1}">
					<label for="1-star" class="star">★</label>
				</c:if></td>
		</tr>

		<tr>
			<td>후기사진</td>
		</tr>

		<tr>
			<td>
				<%
				if (!(article.getBOARD_FILE() == null)) {
				%> <img src="boardUpload/${article.BOARD_FILE  }"
				class="image-container"> <%
 }
 %>
			</td>
		</tr>

		<tr>
			<td>후기내용</td>
		</tr>
		<tr>
			<td><textarea id="articleContentArea" cols="40" rows="15"
					style="background-color: #222529; color: white;"
					required="required">
		<%=article.getBOARD_CONTENT()%></textarea></td>
		</tr>

		<tr id="commandList">
					<c:choose>
					<c:when test="${mID eq null}">
						<td align="center">
 
					</c:when>
					<c:otherwise>
					
					<td colspan="4" align="center">
					<a class="btn btn-secondary" href="boardReplyForm.RC?board_num=<%=article.getBOARD_NUM()%>&page=<%=nowPage%>">
					답변 </a>&emsp;
					
						<a class="btn btn-secondary"
							href="boardModifyForm.RC?board_num=<%=article.getBOARD_NUM()%>">
							수정 </a> &emsp;
							<a class="btn btn-secondary" href="boardDeleteForm.RC?board_num=<%=article.getBOARD_NUM()%>&page=<%=nowPage%>">
							삭제 </a>&emsp;
					</c:otherwise>
				</c:choose>
				 <a class="btn btn-secondary" href="boardList.RC?page=<%=nowPage%>">목록보기</a>&emsp;</td>
		</tr>
	</table>

	<div>
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>
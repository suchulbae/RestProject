<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
session = request.getSession();
String mID = (String) session.getAttribute("mID"); //오브젝트타입이라 스트링으로 변환
String nowPage = (String) request.getAttribute("page");//리뷰페이지목록보기
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<link rel="stylesheet" href="css/boardwrite.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="css/star-rating.css" media="all" rel="stylesheet"
	type="text/css" />
<style>
textarea {
	background: #232529;
}
</style>
<title>SoulRest</title>
</head>
<body style="background: black; margin-top:500px ">

	<div>
		<jsp:include page="memberHeader.jsp" />
	</div>

	<div class="login-dark" >
		<form action="boardWritePro.RC" method="post"
			enctype="multipart/form-data" name="boardform">
			<div class="">리뷰작성</div>
			<hr>
			<div class="form-group">
				<label>고객아이디</label> <input type="text" name="BOARD_NAME"
					class="form-control" id="BOARD_NAME" value="<%=mID%>"
					required="required" readonly />
			</div>

			<div class="form-group">
				<label>비밀번호</label> <input name="BOARD_PASS" type="password"
					class="form-control" id="BOARD_PASS" required="required" />
			</div>

			<div class="form-group">
				<label>제 목</label> <input name="BOARD_SUBJECT" type="text"
					class="form-control" id="BOARD_SUBJECT" required="required"
					style="color: black; background-color: #ebf0fd;">
			</div>
			<label>내용</label>
			<div class="form-group">

				<textarea id="BOARD_CONTENT" name="BOARD_CONTENT" cols="62"
					rows="15" required="required"
					style="color: black; background-color: #ebf0fd;"></textarea>
			</div>

			<div class="form-group">
				<label>이미지 첨부</label> <input name="BOARD_FILE" type="file"
					class="form-control" id="BOARD_FILE" required="required" />
			</div>
			<div class="form-group"></div>

			<input type="hidden" name="rate" id="rate" value="0" />

			<div class="review_rating">

				<c:if test="${mID ne null}">
					<b>${mID}&nbsp;</b>님
					</c:if>
				<div class="title_star">별점을 선택해 주세요.</div>
				<div name="myform" id="myform">
					<fieldset>
						<input type="radio" name="boardRating" value="5" id="rate1"><label
							for="rate1">⭐</label> <input type="radio" name="boardRating"
							value="4" id="rate2"><label for="rate2">⭐</label> <input
							type="radio" name="boardRating" value="3" id="rate3"><label
							for="rate3">⭐</label> <input type="radio" name="boardRating"
							value="2" id="rate4"><label for="rate4">⭐</label> <input
							type="radio" name="boardRating" value="1" id="rate5"><label
							for="rate5">⭐</label>
					</fieldset>
				</div>
			</div>
			<div>
				<input class="btn btn-secondary" type="submit" value="등록"> <input
					class="btn btn-secondary" type="reset" value="다시쓰기" /> <a 
					href="${pageContext.request.contextPath}/boardList.RC"
					class="btn btn-secondary">리뷰목록보기</a>
			</div>
		</form>
	</div>
	<!-- 게시판 등록 -->
</body>
<div>
	<jsp:include page="footer.jsp" />
</div>
</html>
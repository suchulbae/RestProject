

<%@page import="vo.boardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
BoardDTO article = (BoardDTO)request.getAttribute("article");
String nowPage = (String) request.getAttribute("page");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SoulRest</title>
<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
<style type="text/css">
h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
}

.td_left {
	width: 150px;
}

.td_right {
	width: 300px;
}

#commandCell {
	text-align: center;
}


</style>
<link rel="stylesheet" href="css/boardwrite.css">
<link href="css/star-rating.css" media="all" rel="stylesheet"
	type="text/css" />
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
<script>src="js/js.js"</script>
</head>
<body style="background: black; margin-top:500px ">
	<div>
		<jsp:include page="memberHeader.jsp" />
	</div>
	<!-- 게시판 등록 -->

			<div class="login-dark">
		<form action="boardModifyPro.RC" method="post" name="modifyform">
			<input type="hidden" name="BOARD_NUM"
				value="<%=article.getBOARD_NUM()%>" />
				<div class="">리뷰수정</div>
				<hr>
			<div class="form-group">
				<label>고객아이디</label> <input type="text" name="BOARD_NAME"
						id="BOARD_NAME" value="<%=article.getBOARD_NAME()%>" readonly="readonly"/>
	
			</div>
					<div class="form-group">
				<label>비밀번호</label> 
							<input name="BOARD_PASS" type="password" class="form-control"
						id="BOARD_PASS" />
			
			</div>

			<div class="form-group">
				<label>제 목</label> <input name="BOARD_SUBJECT" type="text"
					class="form-control" value="<%=article.getBOARD_SUBJECT()%>" id="BOARD_SUBJECT" 
					style="color: black; background-color: #ebf0fd;"/>
			
			</div>
				<label>내용</label>
			<div class="form-group">

				<textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15"<%=article.getBOARD_CONTENT()%>
					style="color: black; background-color: #ebf0fd;"></textarea>
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
				</div>
				
				
				
			<div>
				<a href="javascript:modifyboard()" class="btn btn-secondary">수정</a>&emsp; 
		<a 
					href="${pageContext.request.contextPath}/boardList.RC"
					class="btn btn-secondary">리뷰목록보기</a>
	
		</div>

		</form>



</div>
		<div>
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>
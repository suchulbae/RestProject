<%@page import="vo.boardDTO.BoardDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	BoardDTO article = (BoardDTO) request.getAttribute("article");
	String nowPage = (String) request.getAttribute("page");
	session = request.getSession();
	String mID = (String) session.getAttribute("mID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>SoulRest</title>
<script language="javascript">
	
</script>
<style type="text/css">
</style>

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

</head>
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
<body style="background: black; margin-top: 30px">
	<!-- 게시판 답변 -->

	<div>
		<jsp:include page="memberHeader.jsp" />
	</div>


	<section id="writeForm">
		<h4 style="color: white; text-align: center;">답변 남기기</h4>
		<form action="boardReplyPro.RC" method="post" name="boardform">
			<input type="hidden" name="page" value="<%=nowPage%>" /> <input
				type="hidden" name="BOARD_NUM" value="<%=article.getBOARD_NUM()%>">
			<input type="hidden" name="BOARD_RE_REF"
				value="<%=article.getBOARD_RE_REF()%>"> <input type="hidden"
				name="BOARD_RE_LEV" value="<%=article.getBOARD_RE_LEV()%>">
			<input type="hidden" name="BOARD_RE_SEQ"
				value="<%=article.getBOARD_RE_SEQ()%>">
			<table class="table table-hover table-dark w-auto"
				style="margin: auto">
				<tr>
					<td><label for="BOARD_NAME">회원아이디</label></td>
					<td><input type="text" name="BOARD_NAME" id="BOARD_NAME"
						value="<%=mID%>" readonly="readonly"/></td>
				</tr>
				<tr>
					<td><label for="BOARD_PASS">비밀번호</label></td>
					<td><input name="BOARD_PASS" type="password" id="BOARD_PASS" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_SUBJECT">제 목</label></td>
					<td class="td_right"><input name="BOARD_SUBJECT" type="text"
						id="BOARD_SUBJECT" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="BOARD_CONTENT">내 용</label></td>
					<td><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15"></textarea></td>
				</tr>
				<tr id="commandCell">
					<td colspan="2" align="center"><input class="btn btn-secondary"
						type="submit" value="등록" />&emsp; <input class="btn btn-secondary"
						type="reset" value="수정" />&emsp;
					<input class="btn btn-secondary" type = "button" value = "뒤로가기" onClick ="javascript:history.go(-1)"/></td>
				</tr>
			</table>

		</form>
		<jsp:include page="footer.jsp" />
	</section>
</body>
</html>
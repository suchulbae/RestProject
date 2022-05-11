<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	int board_num=(Integer)request.getAttribute("board_num");
    String nowPage = (String)request.getAttribute("page");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>SoulRest</title>
<style>


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
	<div>
		<jsp:include page="memberHeader.jsp"/>
	</div>
	
<body style="background: black; margin-top:30px">
<section id = "passForm">
<form name="deleteForm" action="boardDeletePro.RC?board_num=<%=board_num %>" 
	method="post">
<input type = "hidden" name = "page" value = "<%=nowPage %>"/>
<table class="table table-hover table-dark w-auto" style="margin: auto">
<h4 style="color: white; text-align: center;">회원리뷰삭제하기</h4>
<tr>
	<td>
		<label>글 비밀번호 : </label>
	</td>
	<td>
		<input name="BOARD_PASS" type="password">
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input class="btn btn-secondary" type="submit" value = "삭제"/>
		&emsp;
		<input class="btn btn-dark" type = "button" value = "뒤로가기" onClick ="javascript:history.go(-1)"/>&emsp;
		<a href="boardList.RC?page=<%=nowPage%>"class="btn btn-secondary">목록보기</a></td>
</tr>
</table>
</form>
</section>



	<jsp:include page="footer.jsp"/>
</body>
</html>
<%@page import="vo.boardDTO.PageInfo"%>
<%@page import="vo.boardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	ArrayList<BoardDTO> articleList = (ArrayList<BoardDTO>) request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Review</title>
</head>

<body style="background: black">
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

	<jsp:include page="memberHeader.jsp" />

	<div class="container" style="margin-top: 80px">

		<h4 style="color: white;">Review</h4>

		<table class="table table-hover table-dark">

			<%
				if (articleList != null && listCount > 0) {
			%>
			<tr class="scope=col">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>별점</th>
				<th>조회수</th>
				<%
					for (int i = 0; i < articleList.size(); i++) {
				%>
			
			<tr class="scope=col">
				<td class=""><%=articleList.get(i).getBOARD_NUM()%></td>

				<td class="">
					<%
						if (articleList.get(i).getBOARD_RE_LEV() != 0) {
					%> <%
 	for (int a = 0; a <= articleList.get(i).getBOARD_RE_LEV() * 2; a++) {
 %> &nbsp; <%
 	}
 %> <%
 	} else {
 %> <%
 	}
 %> <a
					href="boardDetail.RC?board_num=<%=articleList.get(i).getBOARD_NUM()%>&page=<%=nowPage%>">
						<%=articleList.get(i).getBOARD_SUBJECT()%>
				</a>
				</td>
				<td><%=articleList.get(i).getBOARD_NAME()%></td>
				<td><%=articleList.get(i).getBOARD_DATE()%></td>
				<td><%=articleList.get(i).getboardRating()%>&nbsp;점</td>
				<td><%=articleList.get(i).getBOARD_READCOUNT()%></td>
				
			</tr>
			<%
				}
			%>
		</table>
		<nav>
			<ul class="pagination justify-content-center" id="pageList">
				<%
					if (nowPage <= 1) {
				%>
				<%
					} else {
				%>
				<li class="page-item"><a class="btn btn-dark"
					href="boardList.RC?page=<%=nowPage - 1%>">이전</a></li>&nbsp;
				<%
					}
				%>

				<%
					for (int a = startPage; a <= endPage; a++) {
							if (a == nowPage) {
				%>
				<li class="page-item"><a class="btn btn-dark"
					href="boardList.RC?page=<%=a%>"><%=a%></a></li>&nbsp;
				<%
					} else {
				%>
				<li class="page-item"><a class="btn btn-dark"
					href="boardList.RC?page=<%=a%>"><%=a%> </a></li>&nbsp;
				<%
					}
				%>
				<%
					}
				%>
				<%
					if (nowPage >= maxPage) {
				%>
				<%
					} else {
				%>

				<li class="page-item"><a class="btn btn-dark"
					href="boardList.RC?page=<%=nowPage + 1%>">다음</a></li>
				<%
					}
				%>

			</ul>
			<nav>
				</nav>
		</nav>
	</div>

	</section>
	<%
		} else {
	%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
	<%
		}
	%>
	<ul class="pagination justify-content-center"> 
		<c:choose>
 <c:when test="${mID eq null}">
 						
		<li class="page-item"><a href="memberLogin.RC"
			class="btn btn-secondary">로그인후 리뷰작성하기</a></li>
						
			
				
</c:when>
<c:otherwise>
<li class="page-item"><a href="boardWriteForm.RC"
			class="btn btn-secondary"> 리뷰작성하기</a></li>
</c:otherwise>
</c:choose>
	</ul>
	<jsp:include page="footer.jsp" />

</body>

</html>
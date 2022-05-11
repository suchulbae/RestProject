<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>
<%
String openInit = "false";
if(request.getParameter("openInit") != null){
	openInit = request.getParameter("openInit"); // openInit = "true"가 됨
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
 

	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">


<title>중복체크</title>
</head>



<style>

.login-dark {
   height: 500px;
    background-color:#000;
   background-size: cover;
   background-position: top right;
}

.login-dark form {
   max-width: 450px;
   width: 200%;
   background-color:rgba(0, 0, 0, 0.7);
   padding: 40px;
   border-radius: 4px;
   transform: translate(-50%, -50%);
   position: absolute;
   left: 50%;
   color: #fff;
   box-shadow: 3px 3px 4px rgba(0, 0, 0, 0.2);
   margin-top: 150px;
}

.login-dark .illustration {
   text-align: center;
   padding: 15px 0 20px;
   font-size: 50px;
   color: #2980ef;
}

.login-dark form .form-control {
   background: none;
   border: none;
   border-bottom: 1px solid #434a52;
   border-radius: 0;
   box-shadow: none;
   outline: none;
   color: inherit;
}

.login-dark form .btn-primary {
   font-size: 5px;
   background: #214a80;
   border: none;
   border-radius: 4px;
   padding: 5px;
   box-shadow: none;
   margin-top: 5px;
   text-shadow: none;
   outline: none;
}

.login-dark form .btn-primary:hover, .login-dark form .btn-primary:active
   {
   background: #214a80;
   outline: none;
}

.login-dark form .forgot {
   display: block;
   text-align: center;
   font-size: 12px;
   color: #6f7a85;
   opacity: 0.9;
   text-decoration: none;
}

.login-dark form .forgot:hover, .login-dark form .forgot:active {
   opacity: 1;
   text-decoration: none;
}

.login-dark form .btn-primary:active {
   transform: translateY(1px);
}
</style>
<script type="text/javascript">
// 사용자가 회원가입폼(opener인 부모창)에서 입력한 id가 자동 셋팅됨
function init() {
	if(<%=openInit%>){ // openInit = "true"이면

		document.getElementById("idCheck") = opener.document.getElementById("mID").value;

	}
}

function useId(chk_id) {
	opener.document.getElementById("mID").value = chk_id.trim(); 
	window.close();
}

</script>



<!-- [아이디중복확인] 창이 열리면 onload 이벤트에 의해 init()함수가 호출되어 실행됨 -->
<body onload="init()" style="background: black;">
<div class="login-dark">
   <form action="idCheckProcess.jsp" method="post" name="f">
		<div class="form-grouph">아이디 중복체크</div>
		<hr>
        <div class="form-group">	
		<label>아이디 	<input type="submit" onclick="check(); return false;" class="btn btn-danger"
					value="조회하기"  /></label>
		<input type="text" class="form-control" name="idCheck" id="idCheck" /> 
		</div>
		<a style="font-size: "></a>
		<%
request.setCharacterEncoding("UTF-8");
String chk_id = request.getParameter("chk_id");

//if(request.getParameter("chk_id") != null && !request.getParameter("chk_id").trim().equals("")){
if(chk_id != null && !chk_id.trim().equals("")){
	String useable = request.getParameter("useable");
	
	out.println("<hr>"); // 수평선 출력
	
	if(useable.equals("NO")){ // 같은아이디가 존재하기때문에 사용할 수 없음
		out.println("<h4 style='font-size: 16px;'>" + chk_id + "&nbsp; 는(은) 중복된 아이디 입니다. 다시 입력해 주세요.</h4>");
	}else{
		out.println("<h4 style='font-size: 16px;' class='form-grouph'>" + chk_id + "&nbsp; 는(은) 사용 가능한 아이디 입니다.");
/* 		out.println("<a href='javascript:useId(\"" + chk_id + "\")'>사용하기</a> </h4>"); */
		out.println("<a href='javascript:useId(\"" + chk_id + "\")'></h4>");
		out.println("<input class='btn btn-danger' value='사용하기'></a>");
	}
}
%>
	</form>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<!-- 순서 중요 (아이디 중복을 확인한 결과를 받고 나서 java로 처리해야함) -->

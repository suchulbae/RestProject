<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<link rel="stylesheet" href="css/loginFormstyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- DAUM API 적용 (DAUM에서 제공하는 주소 겁색을 사용하기 위해 반드시 포함)  -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function findAddr() {
		// 카카오 지도 발생 -> 주소 입력 후 [검색] -> 찾는 주소 [선택]
		new daum.Postcode({
			oncomplete : function(data) { // [선택]시 입력값 세팅
				console.log(data);
				document.getElementById("postcode").value = data.zonecode; // zonecode : 우편번호

				var roadAddr = data.roadAddress; // 도로명 주소
				var jibunAddr = data.jibunAddress; // 지번 주소

				if (roadAddr != '') { // 도로명주소가 있으면 도로명 주소를 등록하고
					document.getElementById("address1").value = roadAddr;
				} else { // 도로명주소가 없고 지번주소만 있으면 지번주소를 등록함
					document.getElementById("address1").value = jibunAddr;
				}

				// 만약 지번주소 대신 무조건 도로명 주소만 입력하고 싶다면
				// document.getElementById("address1").value = data.roadAddress;
				// document.getElementById("address1").value = roadAddr;

				// 도로명주소나 지번주소를 선택후 상세주소 필드에 커서를 두어 바로 입력가능한 상태로 만듦
				document.getElementById("address2").focus();
			}
		}).open();
	}

	// 유효성 검사
	function check() {
		// 아이디와 비밀번호 값 데이터 정규화 공식
		const regIdPass = /^[a-zA-Z0-9]{8,12}$/;

		// 이름 정규화 공식
		const regName = /^[가-힣a-zA-Z]{2,}$/;

		/*
		  - / / 안에 있는 내용은 정규표현식 검증에 사용되는 패턴이 이 안에 위치함
		  - / /i 정규표현식에 사용된 패턴이 대소문자를 구분하지 않도록 i를 사용함
		  - ^ 표시는 처음시작하는 부분부터 일치한다는 표시임
		  - [0-9a-zA-Z] 하나의 문자가 []안에 위치한 규칙을 따른다는 것으로 숫자와 알파벳 소문지 대문자인 경우를 뜻 함
		  - 이 기호는 0또는 그 이상의 문자가 연속될 수 있음을 말함

		     출처: https://solbel.tistory.com/375 [개발자의 끄적끄적]
		 */

		// 이메일 정규화 공식
		const regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		// 휴대전화 정규화 공식
		const regCall = /^\d{3}\d{3,4}\d{4}$/; //-제외
		//const regCall = /^\d{3}-\d{3,4}-\d{4}$/; //-포함

		// 아이디 유효성 검사 - 정규화 공식 이용
		// if(document.f.u_id.value.trim() == false){
		if (!document.f.mID.value.trim()) { // 아이디가 입력되지않았으면
			alert("아이디를 입력하세요.");
			document.f.mID.focus(); // 커서를 깜박거림
			return false; // submit()이 안됨 (true를 받아야지 submit()됨)
		} else if (!regIdPass.test(document.f.mID.value.trim())) { // id가 정규화 공식에 맞지않으면
			alert("아이디는 8~12자의 영어 대소문자와 숫자로만 입력가능합니다.");
			return document.f.mID.select(); // 입력한 부분에 블록 설정되어 바로 수정가능한 상태로 만듦
		} else

		// 비밀번호 유효성 검사 - 정규화 공식 이용
		if (!document.f.mPW.value.trim()) {
			alert("비밀번호를 입력하세요.");
			document.f.mPW.focus(); // 커서를 깜박거림
			return false;
		} else if (!regIdPass.test(document.f.mPW.value.trim())) {
			alert("비밀번호는 8~12자의 영어 대소문자와 숫자로만 입력가능합니다.");
			return document.f.mPW.select(); // 입력한 부분에 블록 설정되어 바로 수정가능한 상태로 만듦
		} else

		// 이름 유효성 검사 - 정규화 공식 이용
		if (!document.f.mNAME.value.trim()) {
			alert("이름을 입력하세요.");
			document.f.mNAME.focus(); // 커서를 깜박거림
			return false;
		} else if (!regName.test(document.f.mNAME.value.trim())) {
			alert("이름이 잘못 입력되었습니다.(영어 대소문자와 한글만 입력가능합니다.)");
			return document.f.mNAME.select(); // 입력한 부분에 블록 설정되어 바로 수정가능한 상태로 만듦
		} else

		// 이메일 유효성 검사 - 정규화 공식 이용
		if (!document.f.mEMAIL.value.trim()) {
			alert("이메일을 입력하세요.");
			document.f.mEMAIL.focus(); // 커서를 깜박거림
			return false;
		} else if (!regEmail.test(document.f.mEMAIL.value.trim())) {
			alert("이메일 형식이 올바르지 않습니다.");
			return document.f.mEMAIL.select(); // 입력한 부분에 블록 설정되어 바로 수정가능한 상태로 만듦
		} else

		// 휴대폰 번호 유효성 검사 - 정규화 공식 이용
		if (!document.f.mPHONE.value.trim()) {
			alert("휴대폰 번호를 입력하세요.");
			document.f.mPHONE.focus(); // 커서를 깜박거림
			return false;
		} else if (!regCall.test(document.f.mPHONE.value.trim())) {
			alert("휴대폰번호가 잘못 입력되었습니다. (-)없이 숫자만 입력하세요");
			return document.f.mPHONE.select(); // 입력한 부분에 블록 설정되어 바로 수정가능한 상태로 만듦
		} else

		/*
		  postcode(우편번호)와 address1은 "DAUM API"로 사용하여 검색한 내용을 바로 셋팅하므로
		  유효성 검사가 필요없음
		 */

		// address2(상세주소) 유효성 검사 - 정규화 공식 사용 X
		if (!document.f.address2.value.trim()) {
			alert("상세주소를 입력하세요.");
			document.f.address2.focus(); // 커서를 깜박거림
			return false;
		}

		// 위의 조건이 모두 거짓이면(=유효성 검사를 만족하면) submit()함
		document.f.submit();// document 생략가능
	}
</script>


<title>SoulRest</title>
</head>


<body>

	<nav class="navbar navbar-expand-lg navbar-light me-lg-0">
		<div class="container-fluid">
			<a class="navbar-brand" href="memberMain.jsp"><img
				src="info/logo.jpg"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="memberMain.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">문의</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="memberLogout.RC">Logout</a></li>
							<li><a class="dropdown-item"
								href="memberHashPwChangeForm.RC"> 비밀번호 찾기</a></li>

							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">고객센터</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">회원정보/변경</a>
					</li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<!-- Page Content-->


	<div class="p-4 p-lg-4 bg-light rounded-3">
		<div class="signup-form" style="margin-left: 50px;">
			<form action="memberUpdate.RC" method="post" name="f">

				<h2>회원정보 수정</h2>
				<p class="mb-0">
					<b>${member.mNAME}</b>&emsp;고객님
				</p>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="mID"
						value="${member.mID}" readonly="readonly" required="required">
				</div>
				<div class="col-lg-3">
					<label>이름</label> <br> <input type="text" class="form-control"
						name="mNAME" value="${member.mNAME}"
						placeholder="한글 또는 영문만 입력하세요.(특수문자 제외)" required="required">
				</div>
				<div class="col-lg-3">
					<label>이메일</label> <br> <input type="text" name="mEMAIL"
						class="form-control" value="${member.mEMAIL}"
						placeholder="(ex)&nbsp; SoulRest@naver.com" required="required">
				</div>
				<div class="col-lg-3">
					<label>휴대전화</label> <br> <input type="text"
						class="form-control" name="mPHONE" value="${member.mPHONE}"
						placeholder="(-)없이 숫자만 입력하세요" required="required">

				</div>
				<div class="col-lg-4">
					<label>주소</label> <input type="text" class="form-control"
						name="postcode" value="${addr.postcode}" placeholder="우편번호만입력"
						required="required"> <input type="button" value="우편번호 찾기"
						onclick="findAddr();" required="required" /> <input type="text"
						class="form-control" name="address1" value="${addr.address1}"
						placeholder="주소" required="required" /> <input type="text"
						class="form-control" name="address2" value="${addr.address2}"
						placeholder="상세주소" required="required" />
				</div>
				<div class="col-lg-3">
					<br> <input type="submit"
						class="btn btn-primary btn-block btn" onclick="check();"
						value="수정하기" />
				</div>

			</form>

		</div>

	</div>
	<p class="small text-center">
		By clicking the Sign Up button, you agree to our <br> <a href="#">Terms
			&amp; Conditions</a>, and <a href="#">Privacy Policy</a>
	</p>
</body>
</html>
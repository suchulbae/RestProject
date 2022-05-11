<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/joinFormstyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<title>회원가입</title>
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
</script>
	<script type="text/javascript">
	// 유효성 검사
	function check() {
		// 아이디와 비밀번호 값 데이터 정규화 공식
		const regIdPass = /^[a-zA-Z0-9]{8,12}$/;

		// 이름 정규화 공식
		const regName = /^[가-힣a-zA-Z]{2,}$/;

		// 이메일 정규화 공식
		/*
		/ / 안에 있는 내용은 정규표현식 검증에 사용되는 패턴이 이 안에 위치함
		/ /i 정규표현식에 사용된 패턴이 대소문자를 구분하지 않도록 i를 사용함
		^ 표시는 처음시작하는 부분부터 일치한다는 표시임
		[0-9a-zA-Z] 하나의 문자가 []안에 위치한 규칙을 따른다는 것으로 숫자와 알파벳 소문지 대문자인 경우를 뜻 함
		이 기호는 0또는 그 이상의 문자가 연속될 수 있음을 말함
		 */
		const regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i

		// 휴대번호 정규화 공식
		const regCall = /^\d{3}\d{3,4}\d{4}$/; //-제외
		//const regCall = /^\d{3}-\d{3,4}-\d{4}$/; //-포함

		// 아이디 유효성 검사 - 정규화 공식 이용
		if (!document.f.mID.value.trim()) { // if(document.f.u_id.value.trim() == false)
			alert("아이디를 입력하세요.");
			//f.u_id.focus(); //document 생략 가능
			document.f.mID.focus(); // 커서를 깜박거림 
			return false;
		} else if (!regIdPass.test(document.f.mID.value.trim())) {
			alert("아이디는 8~12자 영어와 대소문자와 숫자로만 입력가능합니다.");
			return document.f.mID.select(); // 입력한 부분에 블록 설정되어 바로 수정 가능한 상태로 만듦
		} else

		// 비밀번호 유효성 검사 - 정규화 공식 이용
		if (!document.f.mPASSWORD.value.trim()) { // if(document.f.u_password.value.trim() == false)
			alert("비밀번호를 입력하세요.");
			document.f.mPASSWORD.focus(); // 커서를 깜박거림
			return false;
		} else if (!regIdPass.test(document.f.mPASSWORD.value.trim())) {
			alert("비밀번호는 8~12자 영어와 대소문자와 숫자로만 입력가능합니다.");
			return document.f.mPASSWORD.select(); // 입력한 부분에 블록 설정되어 바로 수정 가능한 상태로 만듦
		} else

		// 이름 유효성 검사 - 정규화 공식 이용
		if (!document.f.mNAME.value.trim()) { // if(document.f.u_name.value.trim() == false)
			alert("이름을 입력하세요.");
			document.f.mNAME.focus(); // 커서를 깜박거림
			return false;
		} else if (!regName.test(document.f.mNAME.value.trim())) { // 정규화 공식에 따라 변경
			alert("이름이 잘못 입력되었습니다.(영어 대소문자와 한글만 입력가능합니다.)");
			return document.f.mNAME.select(); // 입력한 부분에 블록 설정되어 바로 수정 가능한 상태로 만듦
		} else

		// 이메일 유효성 검사 - 정규화 공식 이용
		if (!document.f.mEMAIL.value.trim()) { // if(document.f.u_email.value.trim() == false)
			alert("이메일을 입력하세요.");
			document.f.mEMAIL.focus(); // 커서를 깜박거림
			return false;
		} else if (!regEmail.test(document.f.mEMAIL.value.trim())) { // 정규화 공식에 따라 변경
			alert("이메일 형식이 올바르지 않습니다.");
			return document.f.mEMAIL.select(); // 입력한 부분에 블록 설정되어 바로 수정 가능한 상태로 만듦
		} else
	
			if (!document.f.mPHONE.value.trim()) { // if(document.f.u_call.value.trim() == false)
				alert("휴대폰번호를 입력하세요.");
				document.f.mPHONE.focus(); // 커서를 깜박거림
				return false;
			} else if (!regCall.test(document.f.mPHONE.value.trim())) { // 정규화 공식에 따라 변경
				alert("휴대폰번호가 잘못 입력되었습니다. 숫자로만 입력해주세요.");
				return document.f.mPHONE.select(); // 입력한 부분에 블록 설정되어 바로 수정 가능한 상태로 만듦
			} else

	
		/*
		postcode(우편번호)와 address1은 "DAUM API"로 사용하여 검색한 내용을 바로 셋팅하므로
		유효성 검사가 필요없음
		 */
		// address2(상세주소) 검사 - 정규화 공식 이용X
		if (!document.f.address2.value.trim()) { // if(document.f.u_address2.value.trim() == false)
			alert("상세주소를 입력하세요.");
			document.f.address2.focus(); // 커서를 깜박거림
			return false;
		}

		// 위의 조건이 모두 거짓이면 = 유효성 검사를 만족하면 
		document.f.submit();
	}
</script>
<style>

</style>
</head>

<body style="background: black;">

	<div class="login-dark">
		<form action="memberJoinAction.RC" method="post" name="f">
			<input type="hidden" name="mGRADE" value="Familly">
			<div class="form-grouph">회원가입</div>
			<hr>
			<div class="form-group">
				<label>아이디&nbsp;&nbsp;<input type="button" name="mIDck" class="btn-primary"
					id="mIDck" value="중복확인"
					onclick="window.open('${pageContext.request.contextPath}/idCheck/idCheck.jsp?openInit=true', '아이디중복확인', 'top=10, left=10, width=500, height=300')" /></label>
				<input type="text" class="form-control" name="mID" id="mID"
					placeholder="아이디 입력필수" required="required">
			</div>


			<div class="form-group">
				<label>비밀번호</label> <input type="password" class="form-control"
					name="mPW" id="mPW" placeholder="8~12자 영문과 숫자조합을 입력하세요."
					required="required">
			</div>

			<div class="form-group">
				<label>이름</label> <input type="text" class="form-control"
					name="mNAME" id="mNAME" placeholder="한글 또는 영문만 입력하세요.(특수문자 제외)"
					required="required">
			</div>
			<div class="form-group">
				<label>이메일</label> <input type="text" class="form-control"
					name="mEMAIL" id="mEMAIL" size="40"
					placeholder="(ex)&nbsp; SoulRest@naver.com" required="required">
			</div>
			<div class="form-group">
				<label>휴대전화</label> <input type="text" class="form-control"
					name="mPHONE" id="mPHONE" placeholder="(-)없이 숫자만 입력하세요"
					required="required">

			</div>
			<div class="form-group">
				<label>주소</label>&nbsp;<input type="button" value="우편번호 찾기" class="btn-primary"
					onclick="findAddr();" required="required" /> <input type="text"
					class="form-control" name="postcode" id="postcode"
					placeholder="우편번호만입력" required="required"> <input
					type="text" class="form-control" name="address1" id="address1"
					placeholder="주소" required="required" /> <label>상세주소입력</label> <input
					type="text" class="form-control" name="address2" id="address2"
					placeholder="상세주소" required="required" />
			</div>
			<div class="form-group" align="center">
				<input type="submit" onclick="check(); return false;" class="btn btn-danger"
					value="가입하기"  />
			</div>

			<div class="small text-center">
				이미계정이 있습니까? &nbsp;<a
					href="${pageContext.request.contextPath}/memberLogin.RC">로그인</a>
			</div>
		</form>
	</div>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
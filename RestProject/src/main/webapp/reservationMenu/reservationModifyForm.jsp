<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String now = (String) request.getAttribute("now");
String nowTime1 = (String) request.getAttribute("nowTime1");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon"
	href="/docs/5.1/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg"
	color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<meta name="theme-color" content="#7952b3">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
	   <script src="./assets/js/time.js"></script>
<style type="text/css">
p {
	font-family: 'Apple SD Gothic Neo Bold';
	src: url('Apple SD Gothic Neo Bold.ttf') format('truetype');
}


.menuimg{
  width: 150PX;
  height: 100PX;
  object-fit: cover;
}


body {
	font-family: 'Apple SD Gothic Neo Bold';
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
	
.date{
    font-size: 12px; 
    color: rgb(0, 0, 0);  /* 흰색 */
}
.time{
    font-size: 12px;
    color: rgb(0, 0, 0);  /*보라색 */
}	
	
	
}
</style>
<title>예약장바구니</title>
</head>
<script type="text/javascript">
	function checkAll(theForm) {
		if (theForm.remove.length == undefined) {
			theForm.remove.checked = theForm.allCheck.checked;
		} else {
			for (var i = 0; i < theForm.remove.length; i++) {
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}

	function checkQtyUp(menuID) {
		location.href = "resvMenuCartQtyUp.RSV?menuID="
				+ encodeURIComponent(menuID);
	}

	function checkQtyDown(menuID, qty) {
		if (qty != 1) {
			location.href = "resvMenuCartQtyDown.RSV?menuID="
					+ encodeURIComponent(menuID);
		}
	}
	/*
	 * [삭제]-----------------------------------------------------------------------------
	 */
	function removeCartAll() {
		if (confirm("정말로 모두 삭제하시겠습니까?\n삭제 후 다시 복원되지 않습니다.") == true) {
			location.href = "resvMenuCartRemoveAll.RSV";
		} else {
			return false;
		}
	}

	function removeCart(menuID) {
		if (confirm("정말로 메뉴를 삭제하시겠습니까?\n삭제 후 다시 복원되지 않습니다.") == true) {
			location.href = "resvMenuCartRemove.RSV?menuID="
					+ encodeURIComponent(menuID);
		} else {
			return false;
		}
	}
</script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/shortRent.css">
<link type="text/css" href="${pageContext.request.contextPath}/css/jquery.simple-dtpicker.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.simple-dtpicker.js"></script>
<script type="text/javascript">
$(function(){
	$("#resvDATE").appendDtpicker({			
		locale: "ko",	
		timeFormat: 'h:mm',
        interval: 60,
        minTime: '10',
        maxTime: '17',
        defaultTime: '10',
        startTime: '10',
        dynamic: false,
        dropdown: true,
        scrollbar: true
	});

	/* $('#return_date').appendDtpicker({			
		locale: "ko",	
		timeFormat: 'h:mm',
        interval: 60,
        minTime: '10',
        maxTime: '17',
        defaultTime: '11',
        startTime: '13',
        dynamic: false,
        dropdown: true,
        scrollbar: true
	}); */
});
</script>

<script type="text/javascript">
function dateChk(){
	// DATE 객체
	var NOW_DATE = new Date(); 

	// UTC 시간 계산
	const UTC = NOW_DATE.getTime() + (NOW_DATE.getTimezoneOffset() * 60 * 1000); 

	// UTC to KST (UTC + 9시간)
	const KR_TIME_DIFF = 9 * 60 * 60 * 1000;
	const KR_DATE = new Date(UTC + (KR_TIME_DIFF));

	// 개별 데이터 확인 실시
	var YYYY = KR_DATE.getFullYear(); // 연 (4자리)    		
	var MM = ("00"+(KR_DATE.getMonth()+1)).slice(-2); // 월 (2자리)
	var DD = ("00"+KR_DATE.getDate()).slice(-2); // 일 (2자리)
	var HH24 = ("00"+KR_DATE.getHours()).slice(-2); // 시간 (24시간 기준, 2자리)
	var MI = ("00"+KR_DATE.getMinutes()).slice(-2); // 분 (2자리)
	var SS = ("00"+KR_DATE.getSeconds()).slice(-2); // 초 (2자리)
	
	var todayDatetime=YYYY+MM+DD+HH24+MI;
	var resvDATE= document.getElementById("resvDATE").value;
	//var return_date= document.getElementById("return_date").value;
	const rentalTime = resvDATE.substring(11,13);
	//const returnTime = return_date.substring(11,13);
	const rentalDatetime=resvDATE.replace("-","").replace(":","").replace(" ","").replace("-","");
	//const returnDatetime=return_date.replace("-","").replace(":","").replace(" ","").replace("-","");
	
	if(todayDatetime > rentalDatetime || todayDatetime > returnDatetime){
			alert("현재 시간 이후만 예약가능합니다.");
			return false; 
	}
	
	else if(rentalTime<10 || returnTime<10){
			alert("10시에서 18시까지만 예약이 가능합니다. 이외 시간예약은 고객센터에 문의해주세요.");
			return false;
	}
	else f.submit();
	
};
</script>

<div><jsp:include page="reservationHeader.jsp" /></div>
<section></section>




<section class="py-5 text-center container-fluid bg-Secondary shadow-lg">
	<div class="row py-lg-5 bg-Secondary ">
		<div class="col-lg-6 col-md-8 mx-auto bg-Secondary ">
			<br> <br> <br>
			<h1 class="fw-light">예약시간 변경</h1>
			<p class="lead text-muted">변경할 예약시간을 입력해주세요!.</p>
			<p>
				<a href="${pageContext.request.contextPath}/reservationInfoViewList.RSV"
					class="btn btn-primary my-2">뒤로</a> <a
					href="memberMain.jsp" class="btn btn-secondary my-2">홈으로가기</a>
			</p>
			<br> <br>
		</div>
	</div>
</section>

<br>


	<form action="reservationModify.RSV" method="post" name="f">
	<input type="hidden" name="order_num" value=${order_num }>
		<table class="table table-sm text-center">

			<tr>
				<th><h2>예약변경</h2></th>
			</tr>
		</table>


		
		


		<div class="px-6 py-5 my-5 text-center">
			<table class="table" >
		
		
						<tr>
						
						 <td colspan="6" align="right">주문번호 : ${order_num }<td>
						 <td> 현재 예약 시간 <br>${resvDATE }</td>
					
					 <td colspan="6" align="center">변경할 예약시간 <br><input type="text" name="resvDATE" id="resvDATE" min='' value=/> <input type="submit" value="예약수정" class="btn btn-success"  onclick="dateChk();return false;"/>  
				<!--<input type="time" name="resvTIME" min='' /> -->    </td>
				
				       
				       
				</tr>
		
			</table>
		
			
		</div>
			
	
	</form>
	   <span>

   </span>

	






<footer class="text-muted py-5">
	<div class="container">
		<p class="float-end mb-1">
			<a href="#">Back to top</a>
		</p>
		<p class="mb-1">SoulRest is &copy; gsb,pbg,bsc</p>

	</div>
</footer>


<script src="/docs/5.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>


</body>
</body>
</html>
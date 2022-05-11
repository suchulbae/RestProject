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
.noTable {color:red; padding-left:5px; font-style:italic;}

        
        
.new {color:skyblue; padding-left:5px; font-style:italic;}
.blink {
      -webkit-animation: blink 1.0s linear infinite;
        }
@keyframes blink {
       /*0% 부터 100% 까지*/ 
        0% { color:#00a0e9;}
        100% {color:#000; }
        /*from부터 to 까지         
        from {color:#00a0e9;}
        to {color:#000;} 
        */
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
	$("#resvDATE").appendDtpicker({		//resvDATE라는 파라미터 값으로 전송된다
		locale: "ko",	
		timeFormat: 'h:mm',
        interval: 60,
        minTime: '9', // 최소시간
        maxTime: '20', // 최대영업시간
        defaultTime: '12',
        startTime: '12',
        dynamic: false,//하나의 타입만 시간타입만
        dropdown: true,//내리면 시간값이 드롭다운 형태로 보이면서
        scrollbar: true // 스크롤 바 형태로 보이게 하는부분
	});


});
</script>

<script type="text/javascript">
function dateChk(){
	
	//text 로 온값 시간으로 변환
	// DATE 객체
	var NOW_DATE = new Date(); 

	// UTC 시간 계산
	const UTC = NOW_DATE.getTime() + (NOW_DATE.getTimezoneOffset() * 60 * 1000); 
	
	// UTC to KST (UTC + 9시간)
	const KR_TIME_DIFF = 9 * 60 * 60 * 1000;
	const KR_DATE = new Date(UTC + (KR_TIME_DIFF));
	
	// 개별 데이터 확인 실시
	//년월일시초 담기
	var YYYY = KR_DATE.getFullYear(); // 연 (4자리)    		
	var MM = ("00"+(KR_DATE.getMonth()+1)).slice(-2); // 월 (2자리)
	var DD = ("00"+KR_DATE.getDate()).slice(-2); // 일 (2자리)
	var HH24 = ("00"+KR_DATE.getHours()).slice(-2); // 시간 (24시간 기준, 2자리)
	var MI = ("00"+KR_DATE.getMinutes()).slice(-2); // 분 (2자리)
	var SS = ("00"+KR_DATE.getSeconds()).slice(-2); // 초 (2자리)
	
	var todayDatetime=YYYY+MM+DD+HH24+MI;//오늘시간
	var resvDATE= document.getElementById("resvDATE").value;
	//var return_date= document.getElementById("return_date").value;
	const rentalTime = resvDATE.substring(11,13);
	//const returnTime = return_date.substring(11,13);
	const rentalDatetime=resvDATE.replace("-","").replace(":","").replace(" ","").replace("-","");
	//const returnDatetime=return_date.replace("-","").replace(":","").replace(" ","").replace("-","");
	

	
	if(todayDatetime > rentalDatetime || todayDatetime > returnDatetime){
			alert("오늘 이후만 예약가능합니다.");
			return false; 
	}
	
	else if(rentalTime<10 || returnTime<10){
			alert("12시에서 20시 30 분 까지만 예약이 가능합니다. 이외 시간예약은 고객센터에 문의해주세요.");
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
			<h1 class="fw-light">Reservation view</h1>
			<p class="lead text-muted">예약메뉴장바구니 내역입니다.</p>
			<p>
				<a href="${pageContext.request.contextPath}/reservationMenuList.RSV"
					class="btn btn-primary my-2">다른메뉴 예약으로 돌아가기</a> <a
					href="memberMain.jsp" class="btn btn-secondary my-2">홈으로가기</a>
			</p>
			<br> <br>
		</div>
	</div>
</section>

<br>
<br>
<c:if test="${cartList != null && cartList.size()>0 }">

	<form action="resvMenuCartOrder.RSV" method="post" name="f">
	
		<table class="table table-sm">

			<tr>
				<th><h2>Cart</h2></th>
			</tr>
		</table>


		
		


		<div class="px-6 py-5 my-5 text-center">
			<table class="table" >
				<tr>
					<td><input type="checkbox" name="allCheck"
						onclick="checkAll(this.form)" /></td>
					<td>MenuID</td>
					<td>image</td>
					<td>Menu</td>
					<td>PRICE</td>
					<td>인원/메뉴수량</td>
					<td><input type="button" class="btn btn-secondary btn-sm"
						value="AllDelete" onclick="removeCartAll();" /></td>


				</tr>
				<c:forEach var="cart" items="${cartList}" varStatus="status">
					<tr>
						<td><input type="checkbox" name="remove"
							value="${cart.encoding_menuID}" /></td>
					 <td>${status.count}</td>
				<td><img  class="menuimg" src="${pageContext.request.contextPath}/images/${cart.image}" width="150px"></td>
					 <td>${cart.menuNAME}</td>
					<td>
                        ${cart.resvPRICE}원 <input type="hidden" name="priceList" value="${cart.resvPRICE}">
                     </td>
                     <td>
					 <a href="javascript:checkQtyUp('${cart.menuID}')"> <!-- ★★ 함수 호출시 주의 사항 : 함수('숫자 타입이 아닌 경우'), 함수(숫자 타입) --> 
                       <ion-icon name="caret-up-outline"></ion-icon>							
                     </a> 
                      <br> 
                        ${cart.qty} <!-- 현재 수량 --> 
                     <input type="hidden" name="qtyList" value="${cart.qty}"> 
                     <br> 
                     <a href="javascript:checkQtyDown('${cart.menuID}', ${cart.qty})"><!-- ★★ 함수 호출시 주의 사항 : 함수('숫자 타입이 아닌 경우'), 함수(숫자 타입) -->
                        <ion-icon name="caret-down-outline"></ion-icon>
                     </a>
                     </td>
                     
                     <td><input type="button" class="btn btn-secondary btn-sm"
						value="Delete" onclick="removeCart('${cart.menuID}');" /></td>
                     
					</tr>
					
				</c:forEach>
						<tr>
					
						
						 <td colspan="6" align="right">  
						<c:if test="${todaylimitTable > 0 }"><span class="new  blink"> <small>오늘 남은좌석 ${todaylimitTable} 자리 입니다</small></span> </c:if>
					&nbsp;&nbsp;
					
						<c:if test="${todaylimitTable <= 0 }"><span class="noTable"> <small>다른요일 예약해주세요 오늘 남은좌석 ${todaylimitTable} 자리 입니다 </small></span> </c:if>
					&nbsp;&nbsp;
					
					<input type="text" name="resvDATE" id="resvDATE" min='<%=now%>' value=""/>
				    </td>
					 
				
		
				
				         <td></td>
				       
				</tr>
				<tr>
			 <td colspan="6" align="right"><b>Total : ￦${totalMoney} </b>
				 <input type="hidden" name="totalMoney" value="${totalMoney}">
				         </td>
				                      <td> </td> 
					</tr>
					
					
					    <tr>
                  <td colspan="6" align="right">
                  
                  
                
               
              		<%-- <button type="button" class="btn btn-success"  onclick="location.href='resvMenuCartOrder.RSV?totalMoney=${totalMoney}&resvDATE=${resvDATE}&resvTIME=${resvTIME}'">예약하기</button> --%>
              		<input type="submit" value="예약하기" class="btn btn-success"  onclick="dateChk();return false;"/>  
              		<td></td>
               </tr>
			</table>
		
			
		</div>
			
	
	</form>
	   <span>

   </span>

	
</c:if>





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
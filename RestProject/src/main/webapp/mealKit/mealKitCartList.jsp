<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
/*
 * [전체 체크박스] 
 */
function checkAll(theForm) {//장바구니항목을 선택하는 체크박스가 1개일 때(즉, 개상품이 1개만 담겼을 때) length는 undefined가 된다.(이유?length는 배열에만 존재한다.)
   if(theForm.remove.length == undefined){//체크하면 true, 체크해제하면false
      theForm.remove.checked = theForm.allCheck.checked;
   }else{//장바구니 항목을 선택하는 체크박스가 여러 개일 때(=배열객체(remove가 배열이 됨)일 때. 즉, 개상품이 2개이상 담겼을 때)
      for(var i=0; i<theForm.remove.length; i++){
         theForm.remove[i].checked = theForm.allCheck.checked;
      }
   }
}
/*
 * [장바구니 항목 수량 증가/감소 요청]
 */
function checkQtyUp(meal_id){
      location.href="mealKitCartQtyUp.KIOSK?meal_id=" + encodeURIComponent(meal_id);
}

function checkQtyDown(meal_id, meal_qty){
   if(meal_qty != 1){//현재 수량이 1보다 클 때만 수량을 감소시킴
      location.href="mealKitCartQtyDown.KIOSK?meal_id=" + encodeURIComponent(meal_id);
   }
}
/*
 * [삭제]-----------------------------------------------------------------------------
 */
function removeCartAll() {
   if(confirm("정말로 모두 삭제하시겠습니까?") == true){
      location.href="mealKitCartRemoveAll.KIOSK";
   }else{
      return false;
   }
}

function removeCart(meal_id){
   if(confirm("정말로 밀키트를 삭제하시겠습니까?") == true){
      location.href="mealKitCartRemove.KIOSK?meal_id=" + encodeURIComponent(meal_id);//모든 문자를 "utf-8"인코딩하는 함수
   }else{
      return false;
   }
}
</script>









<div><jsp:include page="mealKitHeader.jsp" /></div>
<section></section>




<section class="py-5 text-center container-fluid bg-Secondary shadow-lg">
	<div class="row py-lg-5 bg-Secondary ">
		<div class="col-lg-6 col-md-8 mx-auto bg-Secondary ">
			<br> <br> <br>
			<h1 class="fw-light">Reservation view</h1>
			<p class="lead text-muted">밀키트 장바구니 내역입니다.</p>
			<p>
				<a href="${pageContext.request.contextPath}/mealKit.KIOSK"
					class="btn btn-primary my-2">밀키트 홈으로 가기</a> <a
					href="memberMain.jsp" class="btn btn-secondary my-2">홈으로가기</a>
			</p>
			<br> <br>
		</div>
	</div>
</section>

<br>
<br>
  <c:if test="${mealcartList != null && mealcartList.size()>0 }">

   <form method="post" name="f">
	
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
					<td>밀키트 번호</td>
					<td>image</td>
					<td>Menu</td>
					<td>PRICE</td>
					<td>밀키트 수량</td>
					<td><input type="button" class="btn btn-secondary btn-sm"
						value="AllDelete" onclick="removeCartAll();" /></td>


				</tr>
				<c:forEach var="cart" items="${mealcartList}" varStatus="status">
					<tr>
						<td><input type="checkbox" name="remove"
							value="${cart.encoding_meal_id}" /></td>
					 <td>${status.count}</td>
				<td><img  class="menuimg" src="${pageContext.request.contextPath}/assets/img/mealKit/${cart.meal_image}"  width="150px"></td>
					 <td>${cart.meal_name}</td>
					<td>
                        ${cart.meal_price}원 <input type="hidden" name="priceList" value=" ${cart.meal_price}">
                     </td>
                     <td>
					 <a href="javascript:checkQtyUp('${cart.meal_id}')"> <!-- ★★ 함수 호출시 주의 사항 : 함수('숫자 타입이 아닌 경우'), 함수(숫자 타입) --> 
                       <ion-icon name="caret-up-outline"></ion-icon>							
                     </a> 
                      <br> 
                        ${cart.meal_qty} <!-- 현재 수량 --> 
                     <input type="hidden" name="qtyList" value="${cart.meal_qty}"> 
                     <br> 
                     <a href="javascript:checkQtyDown('${cart.meal_id}', ${cart.meal_qty})"><!-- ★★ 함수 호출시 주의 사항 : 함수('숫자 타입이 아닌 경우'), 함수(숫자 타입) -->
                        <ion-icon name="caret-down-outline"></ion-icon>
                     </a>
                     </td>
                     
                     <td><input type="button" class="btn btn-secondary btn-sm"
						value="Delete" onclick="removeCart('${cart.meal_id}');" /></td>
                     
					</tr>
					
				</c:forEach>
					
				<tr>
			 <td colspan="6" align="right"><b>Total : ￦${meal_totalMoney} </b>
				 <input type="hidden" name="totalMoney" value="${meal_totalMoney}">
				         </td>
				                      <td> </td> 
					</tr>
					
					
					    <tr>
                  <td colspan="6" align="right">
                  
                  
                
               
              
              	
              		       <a href="mealKitCartOrder.KIOSK?meal_totalMoney=${meal_totalMoney}" class="btn btn-success">구매하기</a></td> 
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약메뉴보기</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" aria-label="Tenth navbar example">
    <div class="container-fluid">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/memberMain.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled">Disabled</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown08">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
		<c:if test="${sessionScope.rsvMenuList != null && sessionScope.rsvMenuList.size() > 0 }">
 <div class="container col-xl-10 col-xxl-8 px-4 py-5 ">
    <div class="row align-items-center g-lg-5 py-5">
      <div class="col-lg-7 text-center text-lg-start">
        <h1 class="display-4 fw-bold lh-1 mb-3">주문이 완료 되었습니다.</h1>
        <p class="col-lg-10 fs-4">관리자가 최대한 빠른 속도로 확인후 안내드리겠습니다.</p>
      </div>
      
      
   
      
      <div class="col-md-10 mx-auto col-lg-5 mx-auto text-center" >
        <div class="p-4 p-md-5 border rounded-3 bg-light shadow-lg">
          <div class="form-floating mb-3">
          
              <h1 class="fw-light ">${sessionScope.mNAME} </h1>
              
              
              <small class="text-muted">${sessionScope.mGRADE } 회원님</small>
          </div>
   
       
         <c:forEach var="resvMENU" items="${sessionScope.rsvMenuList}" varStatus="status">
         <p class="col-lg-10 fs-4 text-center"><b>OrderNumber</b> &nbsp;${status.index+1}번 </p>
  			
  		<p class="text-muted"><b>예약메뉴</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${resvMENU.menuNAME}</p>
  		<p class="text-muted"><b>예약금액</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${resvMENU.resvPRICE}</p>
  		
  		</c:forEach>
  		<p class="text-muted"><b>합계금액</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${sessionScope.totalMoney}</p>
  		<small class="text-muted">${sessionScope.mGRADE } 등급</small><br>
  		<p class="text-muted"><b>할인금액</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${sessionScope.totalMoney-sessionScope.saleTotalMoney}</p>
  				
  					<p class="text-muted"><b>예약시간</b> &nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.resvDATE}</p>
  				<h4>최종 결제 금액</h4>
  				<br>
  		<p class="text-muted"><b>결제 금액</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${sessionScope.saleTotalMoney}</p>
  		<jsp:include page="reservationMenu/resvOrderStatus.jsp" />
  		<br>
  		
         <a href="${pageContext.request.contextPath}/memberMain.jsp" class="btn btn-primary my-2 shadow-lg">홈으로가기</a>
          <hr class="my-4">
          <small class="text-muted">thanks.</small>
     
     
     
     
      </div>
    </div>
  </div>
</div>
</c:if>
		<c:if test="${sessionScope.rsvMenuList == null }">
			<h3>${sessionScope.mID}님의 주문내역이 없습니다.</h3>
		</c:if>


</body>
</html>
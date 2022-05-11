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

		<c:if test="${resvOrderDetailList != null && resvOrderDetailList.size() > 0 }">
 <div class="container col-xl-10 col-xxl-8 px-4 py-5 ">
    <div class="row align-items-center g-lg-5 py-5">
      <div class="col-lg-7 text-center text-lg-start">
      

        <h1 class="display-4 fw-bold lh-1 mb-3"> 예약확인 페이지입니다.</h1>
        <p class="col-lg-10 fs-4">내용확인후 처리 부탁드립니다 관리자님.</p>
  
        
           
  
    
        
          <a href="${pageContext.request.contextPath}/restManageOrder.ADM" class="btn btn-primary my-2 shadow-lg">뒤로가기</a>
      </div>
      
      
   
      
      <div class="col-md-10 mx-auto col-lg-5 mx-auto text-center" >
        <div class="p-4 p-md-5 border rounded-3 bg-light shadow-lg">
          <div class="form-floating mb-3">
          		<h1 class="text-muted">고객성함 </h1>
          		  <hr class="my-4">
              <h1 class="fw-light ">${memberInfo.mID}</h1><p class="text-muted"><small>님의 정보입니다</small> </p>
              
              
              <small class="text-muted">${memberInfo.mGRADE } 님</small>
          </div>
   			<h1 class="text-muted">고객정보</h1>
   			  <hr class="my-4">
   						${memberAddressInfo.address1} &nbsp;
						${memberAddressInfo.address2} &nbsp;
   			
   			  <hr class="my-4">
       		<br><br>
         <c:forEach var="resvMENU" items="${resvOrderDetailList}" varStatus="status">
         
         <p class="fw-light "> 예약번호 &nbsp;${status.index+1}번 </p>
           <hr class="my-4">
  		<p class="text-muted"><b>MENUID</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${resvMENU.menuID}</p>
  		<p class="text-muted"><b>예약메뉴</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${resvMENU.menuNAME}</p>
		<p class="text-muted"><b>인원/수량</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${resvMENU.quantity}</p>
  		  <hr class="my-4">
  			<p class="text-muted"><b>예약시간</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;${resvMENU.resvDATE}</p>
  		</c:forEach>
  
  		  <hr class="my-4 shadow-lg">
    

      				   <a class="btn btn-primary my-2 shadow-lg" href="restOrderGet.ADM?order_num=${order_num}">예약승인</a>
                     &nbsp;
                     <a  class="btn btn-primary my-2 shadow-lg" href="restOrderCancle.ADM?order_num=${order_num}">예약취소</a>
      
          
          <hr class="my-4">
          
          <small class="text-muted">thanks.</small>
     	  <hr class="my-4 shadow-lg">
        
     
     
      </div>
    </div>
  </div>
</div>
</c:if>
		<c:if test="${resvOrderDetailList == null }">
			<h3> 예약내역이 없습니다.</h3>
		</c:if>


</body>
</html>
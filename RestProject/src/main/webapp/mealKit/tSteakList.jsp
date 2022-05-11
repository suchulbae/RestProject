<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<section>
	
			<c:if test="${tSteakList != null && tSteakList.size() > 0}">

		
		
		
		
		

		
		
	
		<section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">MealKit 주문하기</h1>
        <p class="lead text-muted">최고의 요리를 밀키트로 모시겠습니다.</p>
        <p>
          <a href="${pageContext.request.contextPath}/mealKit.KIOSK" class="btn btn-primary my-2">밀키트 홈으로</a>
          <a href="#" class="btn btn-secondary my-2">홈으로</a>
        </p>
      </div>
    </div>
  </section>
		
		
		
	
		 <div class="album py-5 bg-light">
    <div class="container">
		<div class="col">
		   <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		
		<!-- 향상된포문과 유사 -->
		<c:forEach var="tSteak" items="${tSteakList}" varStatus="status">
		<c:if test="${tSteak.meal_status eq 'y'}">
	

 

   
        
          <div class="card shadow-sm">
            <a href="mealKitCartAdd.KIOSK?meal_id=${tSteak.meal_id}&meal_name=${tSteak.meal_name}">
          <img
	src="${pageContext.request.contextPath}/assets/img/mealKit/${tSteak.meal_image}" class="card-img" alt="..."></a> 

            <div class="card-body">
              <h2><p class="card-text">${tSteak.meal_name}.</p></h2>
              <br/>
              <small>${tSteak.meal_detail}</small>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="mealKitCartAdd.KIOSK?meal_id=${tSteak.meal_id}&meal_name=${tSteak.meal_name}" class="btn btn-sm btn-outline-secondary">주문하기</a>
                </div>
            <small> <small class="text-muted">가격:${tSteak.meal_price}원</small></small>
              </div>
            </div>
          </div>
     
	
		
	
		
		
		
		
		
		
		
		
		
		</c:if>
		</c:forEach>
		
		
		
		
			</div>
		</div>
		</div>
		   </div>	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		</c:if>

	<c:if test="${tSteakList == null}">
	<section>예약가능한 코스가 없습니다.</section>
	
	
	
	
	</c:if>


		

</section>
</body>
</html>
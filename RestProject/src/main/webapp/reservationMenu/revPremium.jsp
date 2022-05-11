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
	
		<c:if test="${resvMenuList2 !=null && resvMenuList2.size()>0 }">
		
		

		<main>

  <div id="myCarousel" class="carousel slide shadow-lg" data-bs-ride="carousel" >
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="./images/STEAK1.jpg" class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>

        <div class="container">
          <div class="carousel-caption text-start">
            <h1>DARLING POINT STRIP.</h1>
            <p> 깊고 담백한 풍미가 가득한 육즙과 제대로 두툼한 채끝 등심 스테이크.</p>
            <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/reservationMenuList.RSV"> 코스예약 보기</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>

        <div class="container">
          <div class="carousel-caption">
            <h1>PrimiumSide.</h1>
            <p>아스파라거스와 미니 양배추 구운 통고구마와 슬라이스감자.</p>
            <p><a class="btn btn-lg btn-primary" href="reservationMenuListB.RSV">프리미엄 사이드 보러가기</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
         <svg class="bd-placeholder-img" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/></svg>

        <div class="container">
          <div class="carousel-caption text-end">
            <h1>Caesar Salad.</h1>
            <p>시저 샐러드 Caesar Salad 는 잎채소 샐러드의 일종으로, 로메인상추와 크루통이며, 달걀, 올리브유, 레몬 즙, 마늘, 우스터셔 소스, 후추를 드레싱으로 사용하여 만듭니다.</p>
            <p><a class="btn btn-lg btn-primary" href="reservationMenuListC.RSV"> 샐러드 보러가기</a></p>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>
  </main>


		

		
		
		
		
		
		
		
		
	
		<section class="py-5 text-center container">
    <div class="row py-lg-5">
      <div class="col-lg-6 col-md-8 mx-auto">
        <h1 class="fw-light">PremiumSide예약하기</h1>
        <p class="lead text-muted">최고의 시간,최고의 코스요리로 모시겠습니다.</p>
        <p>
          <a href="${pageContext.request.contextPath}/reservationMenu.RSV" class="btn btn-primary my-2">예약 안내 페이지로</a>
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
		<c:forEach var="course" items="${resvMenuList2}" varStatus="status">
		
		<c:if test="${course.m_status eq 'y'}">
		
	

 

   
        
          <div class="card shadow-sm">
            <a href="reservationOrder.RSV?menuID=${course.menuID}">
           <img src="${pageContext.request.contextPath}/images/${course.image}" class="card-img" alt="..."></a> 

            <div class="card-body">
              <h2><p class="card-text">${course.menuNAME}.</p></h2>
              <br/>
              <small>${course.menuDETAIL}</small>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
        <a href="reservationOrder.RSV?menuID=${course.menuID}" class="btn btn-sm btn-outline-secondary">예약하기</a>
                </div>
            <small> <small class="text-muted">가격:${course.resvPRICE}원</small></small>
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

	<c:if test="${resvMenuList2 == null}">
	<section>예약가능한 코스가 없습니다.</section>
	
	
	
	
	</c:if>


		

</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>밀키트 구매 메인화면입니다.</title>
</head>
<body>
  
 <section class="py-5 text-center container-fluid bg-light  ">
    <div class="row py-lg-5 bg-light ">
      <div class="col-lg-6 col-md-8 mx-auto bg-light">
      
        <h1 class="fw-light">Soulrest MealKit</h1>
        <p class="lead text-muted">레스토랑 최고의 제품을 판매중입니다.</p>
        <p>
                <a href="${pageContext.request.contextPath}/steak.KIOSK" class="btn btn-primary my-2">밀키트 예약하기</a>
          <a href="memberMain.jsp" class="btn btn-secondary my-2">홈으로가기</a>
        </p>
  
      </div>
    </div>
  </section>

   <div class="b-example-divider "></div>

  <div class="container col-xxl-8 px-4 py-5 ">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
      <div class="col-10 col-sm-8 col-lg-6">
        <img src="./images/mealkitIMG.jpg" class="d-block mx-lg-auto img-fluid shadow p-3 mb-5 bg-body rounded" alt="Bootstrap Themes" width="700" height="500" loading="lazy">
      </div>
      <div class="col-lg-6">
        <h1 class="display-5 fw-bold lh-1 mb-3">Do Eat!</h1>
        <p class="lead">레스토랑 최고의 음식을 MealKIt로 맛보세요.  밀키트를 직접 제조·판매합니다. 밀키트 제조 후 바로 직배송하기 때문에 높은 신선도를 자랑합니다. QR코드를 통해 밀키트 제조 과정을 확인할 수도 있습니다..</p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start">
                 <a href="${pageContext.request.contextPath}/steak.KIOSK" class="btn btn-primary my-2">밀키트 예약하기</a>
          <a href="memberMain.jsp" class="btn btn-secondary my-2">홈으로가기</a>
        </div>
      </div>
    </div>
  </div>

  <div class="b-example-divider"></div>
  
    <div class="b-example-divider"></div>
<section class="py-5 text-center container-fluid bg-light ">
  
  
  
  
  
  
  
</section>

</body>
</html>
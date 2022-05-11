<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>예약메뉴보기</title>

  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="./assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="./assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="./assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="./assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="./assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="./assets/css/style.css" rel="stylesheet">



</head>
<body>
  <!-- ======= Portfolio Details Section ======= -->
    <section id="portfolio-details" class="portfolio-details">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper">
              <div class="swiper-wrapper align-items-center">

                <div class="swiper-slide">
                 <img src="${pageContext.request.contextPath}/images/${rsvMenuInfo.image}" />
                </div>

        

              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>${rsvMenuInfo.menuID}</h3>
              <ul>
                <li><strong>메뉴</strong>:${rsvMenuInfo.menuNAME}</li>
                <li><strong>PRICE</strong>:${rsvMenuInfo.resvPRICE} 원</li>
        		<li></li>
        		<br>
              <small><small><small><li><strong>메뉴등록일</strong>:${rsvMenuInfo.resvORDERDATE} </li></small></small></small>
          
              </ul>
            </div>
            <div class="portfolio-description ">
              <h2>메뉴설명</h2>
              <p><small><small>
                ${rsvMenuInfo.menuDETAIL}.</small></small>
              </p>
            </div>
            <br>
        <button type="button" class="btn btn-primary btn-lg" onclick="location.href='resvMenuCartAdd.RSV?menuID=${rsvMenuInfo.menuID}&menuNAME=${rsvMenuInfo.menuNAME}' "><small>예약메뉴 추가</small></button>
            																																									
          
           
          </div>

        </div>

      </div>
    </section><!-- End Portfolio Details Section -->
</body>
</html>
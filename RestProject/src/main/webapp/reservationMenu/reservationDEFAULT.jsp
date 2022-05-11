<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <style type="text/css">
 

p{font-family:'Apple SD Gothic Neo Bold'; 
src: url('Apple SD Gothic Neo Bold.ttf') format('truetype');

}
body{
  font-family: 'Apple SD Gothic Neo Bold';
}
     .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
 </style>
    <title>reservation</title>
  </head>
  
  
  
  
 
  
 <section class="py-5 text-center container-fluid bg-light">
    <div class="row py-lg-5 bg-light">
      <div class="col-lg-6 col-md-8 mx-auto bg-light">
         <br>
        <br>
        <h1 class="fw-light">Soulrest reservation</h1>
        <p class="lead text-muted">최고의 시간을 위해 저희 레스토랑은 예약을 도와드립니다.</p>
        <p>
          <a  href="${pageContext.request.contextPath}/reservationMenuList.RSV" class="btn btn-primary my-2">코스 예약하기</a>
          <a href="memberMain.jsp" class="btn btn-secondary my-2">홈으로가기</a>
        </p>
        <br>
        <br>
      </div>
    </div>
  </section>
  
  
  
  
  
  
  
  
  
  

  <div class="b-example-divider"></div>

  <div class="container my-5">
    <div class="row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg">
      <div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
        <h1 class="display-4 fw-bold lh-1"> Just.Eat! T-BONE STEAK </h1>
        <p class="lead">부드러운 안심과 풍미가 진한 등심을 함께 즐길 수 있는
               피렌체 오리지널 스타일의 프리미엄 스테이크. </p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start mb-4 mb-lg-3">
                  <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/reservationMenuList.RSV"> 코스예약 보기</a></p>
 
        </div>
      </div>
      <div class="col-lg-4 offset-lg-1 p-0 overflow-hidden shadow-lg">
          <img class="rounded-lg-3" src="info/steak.jpg" alt="" width="720">
      </div>
    </div>
  </div>
  
  
    <div class="b-example-divider"></div>

  <div class="px-4 pt-5 my-5 text-center border-bottom">
    <h1 class="display-4 fw-bold">Write Review!</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">리뷰를 작성해주세요 더많은 피드백을해주시면 반영하여 더발전된 SoulRest가 되겠습니다.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center mb-5">
        <button type="button" class="btn btn-primary btn-lg px-4 me-sm-3"  onclick="location.href='boardList.RC' " >Write Review</button>
       
      </div>
    </div>
    <div class="overflow-hidden" style="max-height: 30vh;">
      <div class="container px-5">
        <img src="info/review.jpg" class="img-fluid border rounded-3 shadow-lg mb-4" alt="Example image" width="700" height="500" loading="lazy">
      </div>
    </div>
  </div>
  
  
  
  


  <div class="b-example-divider"></div>

  <div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5 ">
      <div class="col-10 col-sm-8 col-lg-6">
        <img src="assets/img/portfolio/portfolio-dessert-1-1.jpg" class="d-block mx-lg-auto shadow-lg img-fluid" alt="Bootstrap Themes" width="700" height="500" loading="lazy ">
      </div>
      <div class="col-lg-6">
        <h1 class="display-5 fw-bold lh-1 mb-3">Berliner Pfannkuchen/Krapfen</h1>
        <p class="lead">유기농 밀과 신선한 우유로 만든 크라펜입니다.</p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start">
           <a  href="${pageContext.request.contextPath}/reservationMenuListB.RSV" class="btn btn-primary my-2"> 예약하기</a>
        </div>
      </div>
    </div>
  </div>



















  












</main>

<footer class="text-muted py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Back to top</a>
    </p>
    <p class="mb-1">SoulRest  is &copy; gsb,pbg,bsc</p>
   
  </div>
</footer>


    <script src="/docs/5.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      
  </body>
</body>
</html>
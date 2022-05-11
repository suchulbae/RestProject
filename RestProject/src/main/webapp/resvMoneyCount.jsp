<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


    <style>
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

    
 <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">

    

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
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

    
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
  </head>
  <body>
    
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="memberMain.jsp"> HOME</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="navbar-nav">
    <div class="nav-item text-nowrap">
  
    </div>
  </div>
</header>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/restSalesNomalMonth.ADM">
              <span data-feather="home"></span>
             예약매출관리
            </a>
          </li>
         
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/restManageOrder.ADM">
              <span data-feather="shopping-cart"></span>
              고객예약내역보기
            </a>
          </li>
     
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/restMenuAddForm.ADM">
              <span data-feather="bar-chart-2"></span>
              메뉴추가
            </a>
          </li>
            <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="users"></span>
            <small><small>${mGRADE}님환영합니다.<small><small>
            </a>
          </li>

   
      </div>
    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">SoulDashboard</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group me-2">
     
          </div>
          <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
            <span data-feather="calendar"></span>
            This week
          </button>
        </div>
      </div>

      <canvas class="my-4 w-100" id="myChart"   data-user1="${todayTotalMoney }" data-user7="${minusdayMoney6 }"  data-user6="${minusdayMoney5 }"   data-user5="${minusdayMoney4 }"       data-user4="${minusdayMoney3 }" data-user3="${minusdayMoney2 }"data-user2="${minusdayMoney }"width="900" height="380"></canvas>

      <h2>실시간 오늘 매출입니다.</h2> <h3>오늘 총매출은${todayTotalMoney } 원 입니다.</h3>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">ID</th>
              <th scope="col">EMAIL</th>
              <th scope="col">주문일</th>
              <th scope="col">예약한날짜</th>
               <th scope="col">예약금액</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="resvTodayView" items="${resvTodayView}" varStatus="status">
            <tr>
            	<td>${resvTodayView.order_num}</td>
            	<td>${resvTodayView.mID }</td>
            	<td>${resvTodayView.mEMAIL }</td>
            	<td>${resvTodayView.resvORDERDATE}</td>
            	<td>${resvTodayView.resvDATE }</td>
             <td>${resvTodayView.totalMoney}</td>
             <td></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      
      
      
  <h2>실시간 이번주 매출입니다.</h2> <h3>이번주 총매출은${totalMoney }원 입니다</h3>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">ID</th>
              <th scope="col">EMAIL</th>
              <th scope="col">주문일</th>
              <th scope="col">예약한날짜</th>
               <th scope="col">예약금액</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach var="resvTotalview" items="${resvTotalview}" varStatus="status">
            <tr>
            	<td>${resvTotalview.order_num}</td>
            	<td>${resvTotalview.mID }</td>
            	<td>${resvTotalview.mEMAIL }</td>
            	<td>${resvTotalview.resvORDERDATE}</td>
            	<td>${resvTotalview.resvDATE }</td>
             <td>${resvTotalview.totalMoney}</td>
             <td></td>
            </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      
    </main>
  </div>
</div>















    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script>
      
  <script src="dashboard.js"></script>
  </body>
</html>

    <script src="/docs/5.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

      <script src="offcanvas.js"></script>
  </body>
</html>
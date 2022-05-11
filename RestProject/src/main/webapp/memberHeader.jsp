<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>SoulRest.com</title>
</head>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title></title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: Maxim - v4.7.0
  * Template URL: https://bootstrapmade.com/maxim-free-onepage-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top d-flex align-items-center">
		<div class="container d-flex justify-content-between">
			<div class="logo">
				<h1>
					<a href="memberMain.jsp"><img src="assets/img/logo.png"></a>
				</h1>
				<!-- Uncomment below if you prefer to use an image logo -->
				<!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
			</div>
			<nav id="navbar" class="navbar">
				<ul>
					<li><a class="nav-link scrollto active" href="#hero">Home</a></li>
					<li><a class="nav-link scrollto" href="#services">Services</a></li>
					<li><a class="nav-link scrollto" href="#portfolio">Portfolio</a></li>

					<li><a class="nav-link scrollto" href="#faq">F.A.Q</a></li>
					<c:choose>
						<c:when test="${mNAME eq null}">
							<li><a
								href="${pageContext.request.contextPath}/memberLogin.RC">Login</a></li>
							<li><a
								href="${pageContext.request.contextPath}/memberJoin.RC">SignUp</a></li>
							<li><a
								href="${pageContext.request.contextPath}/boardList.RC">Review</a></li>

						</c:when>


						<c:when test="${mGRADE eq 'Admin'}">
							<li><a
								href="${pageContext.request.contextPath}/restMenuAddForm.ADM"><small><small>메뉴넣기</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/reservationInfoViewList.RSV"><small><small>예약내역보기
									</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/restManageOrder.ADM"><small><small>예약정보관리</small></small></a></li>
			
			
							<li><a
								href="${pageContext.request.contextPath}/restSalesNomalMonth.ADM"
								><small><small>매출 관리</small></small></a></li>
			
							<li><a
								href="${pageContext.request.contextPath}/mealKitManage.ADM"
								target="blank_1"><small><small>밀키트 관리</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/boardList.RC"><small><small>Review</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/memberLogout.RC"><small><small>LogOut</small></small></a></li>
							<li style="color: white;"><small><small>${mGRADE}님환영합니다.<small><small></li>
						
						</c:when>

						<c:when test="${mGRADE eq 'Chief'}">
							<li><a
								href="${pageContext.request.contextPath}/reservationInfoViewList.RSV"><small><small>예약내역보기
									</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/menuManage.CH"
								target="blank_1">메뉴정보관리</a></li>
							<li><a
								href="${pageContext.request.contextPath}/boardWriteForm.RC">Review</a></li>
							<li><a
								href="${pageContext.request.contextPath}/memberLogout.RC">LogOut</a></li>
							<li style="color: white;"><small><small>${mGRADE}님환영합니다.</small></small></li>
						</c:when>

						<c:otherwise>
	
            		<li><a
								href="${pageContext.request.contextPath}/reservationMenu.RSV"><small><small>예약하기
									</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/reservationInfoViewList.RSV"><small><small>예약내역보기
									</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/memberView.RC"><small><small>회원정보관리
									</small></small></a></li>
							     <li><a href="${pageContext.request.contextPath}/boardList.RC"><small><small>Review</small></small></a></li>
							<li><a
								href="${pageContext.request.contextPath}/memberLogout.RC">LogOut</a></li>
							<li style="color: white;"><small><small>${mID}님환영합니다.</small></small></li>

						</c:otherwise>
					</c:choose>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- ======= End navbar ======= -->
		</div>
	</header>
	<!-- ======= End Header ======= -->
</body>
</html>
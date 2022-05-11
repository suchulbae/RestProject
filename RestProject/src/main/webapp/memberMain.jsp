<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="vo.boardDTO.BoardDTO"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %> 
<%@page import="vo.boardDTO.PageInfo"%>
<%@page import="vo.boardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SoulRest</title>
</head>
<body>
	<jsp:include page="memberHeader.jsp" />

	<section id="hero"
		class="d-flex flex-column justify-content-center align-items-center">
		<div class="container text-center text-md-left" data-aos="fade-up">
			<h1>Welcome to SoulRest</h1>
			<h2>한끼에 정성과 가치를 정통다이닝 식당입니다.</h2>
			<a href="${pageContext.request.contextPath}/reservationMenu.RSV" class="btn-get-started scrollto">get reservation</a>
		</div>
	</section>
	<!-- ======= End Hero ======= -->
		<main id="main">
	 <!-- ======= Services Section ======= -->
    <section id="services" class="services section-bg">
      <div class="container">

        <div class="section-title" data-aos="fade-up">
          <h2>Services</h2>
          <p>저희 매장에선 현재 아래 서비스를 제공중입니다.</p>
        </div>

        <div class="row">
          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up">
            <div class="icon-box icon-box-pink">
              <div class="icon"><i class="bx bx-tachometer"></i></div>
              <h4 class="title"><a href="${pageContext.request.contextPath}/reservationMenu.RSV">회원제 예약</a></h4><!-- 예약 메뉴 보여주기 -->
              <p class="description">고객님들의 소중한 시간과 프라이빗한 공간을 
              제공하기위해 현재 예약제 운영중입니다</p>
            </div>
          </div>

          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="100">
            <div class="icon-box icon-box-cyan">
              <div class="icon"><i class="bx bx-file"></i></div>
              <h4 class="title"><a href="">회원제 할인</a></h4>
              <p class="description">이용량이 많으실경우 더욱 특별한 서비스를 제공을 하고있습니다.</p>
            </div>
          </div>
			
          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="200">
            <div class="icon-box icon-box-green">
             <div class="icon"><i class="bx bx-file"></i></div>
          
           
               
                   <h4 class="title"><a href="${pageContext.request.contextPath}/boardList.RC">리뷰</a></h4>
                 
              <p class="description">고객님의 소중한 의견 최대한 반영하겠습니다.</p>
            
              
            </div>
          </div>

          <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="300">
            <div class="icon-box icon-box-blue">
              <div class="icon"><i class="bx bx-world"></i></div>
              <h4 class="title"><a href=""></a>세계각국의 전문요리사대기</h4>
              <p class="description">최고의 요리사가 엄선된 재료로 요리중입니다.</p>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Services Section -->
    
    
	<!-- 메인 음식과 영상 소개 부분 -->
		<!-- ======= Features Section ======= -->
		<section id="features" class="features">
			<div class="container">

				<div class="row">
					<div class="col-lg-4 mb-5 mb-lg-0" data-aos="fade-right">
						<ul class="nav nav-tabs flex-column">
							<li class="nav-item"><a class="nav-link active show"
								data-bs-toggle="tab" href="#tab-1">
									<h2>BRAND SoulRest </h2>

										<h4>WE ARE TEAM SoulRest</h4>
									<p>조리전 대표메뉴 토마호크의 모습입니다.
								</p>
							</a></li>
							<li class="nav-item mt-2"><a class="nav-link"
								data-bs-toggle="tab" href="#tab-2">
									<h4>조리후 사진</h4>
									<p>저희 대표메뉴 중 하나인 토마호크 스테이크입니다.</p>
							</a></li>
							<li class="nav-item mt-2"><a class="nav-link"
								data-bs-toggle="tab" href="#tab-3">
									<h4>토마호크 손질 영상</h4>
									<p>현재 조리중인 조리영상입니다.</p>
							</a></li>
							<li class="nav-item mt-2"><a class="nav-link"
								data-bs-toggle="tab" href="#tab-4">
									<h4></h4>
									<p></p>
							</a></li>
						</ul>
					</div>
					<div class="col-lg-7 ml-auto" data-aos="fade-left">
						<div class="tab-content">
							<div class="tab-pane active show" id="tab-1">
								<figure>
									<img src="images/toma/toma1.jpg" alt="" class="img-fluid">
								</figure>
							</div>
							<div class="tab-pane" id="tab-2">
								<figure>
									<img src="images/toma/toma2.jpg" alt="" class="img-fluid">
								</figure>
							</div>
							<div class="tab-pane" id="tab-3">
								<figure>
									<video height="300" width="800" controls>
										<source src="media/toma.mp4" type="">
									</video>
								</figure>
							</div>
							<div class="tab-pane" id="tab-4">
								<figure>
									<img src="images/toma/toma1.jpg" alt="" class="img-fluid">
								</figure>
							</div>
						</div>
					</div>
				</div>

			</div>
		</section>
		<!-- ======= End Features Section ======= -->
		
		
  <div class="b-example-divider"></div>
    <section id="services" class="services bg-light">
  <div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">
      <div class="col-10 col-sm-8 col-lg-6">
      <img src="images/reservation.jpg " class=" shadow p-3 mb-5 bg-body rounded" alt="" width="700" height="500" loading="lazy">
      </div>
      <div class="col-lg-6">
        <h1 class="display-5 fw-bold lh-1 mb-3 ">현재 저희는 예약제 운영중입니다</h1>
        <p class="lead">고객님들의 소중한 시간과 프라이빗한 공간을 제공하기위해 현재 예약제 운영중입니다.</p>
        <div class="d-grid gap-2 d-md-flex justify-content-md-start">
           <a href="${pageContext.request.contextPath}/reservationMenu.RSV" class="btn btn-primary btn-lg px-4 me-md-2 shadow-lg">예약하러가기</a>
      
          <button type="button" class="btn btn-outline-secondary btn-lg px-4 shadow-lg"><a
								href="${pageContext.request.contextPath}/mealKit.KIOSK" target="blank">밀키트 구매</a></button>
        </div>
      </div>
    </div>
  </div>
   </section><!-- End Services Section -->
  <div class="b-example-divider"></div>
		


		
	
	<!-- 리뷰에 대한 부분 -->
		<!-- ======= Testimonials Section ======= -->
<section id="testimonials" class="testimonials">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h1>review board</h1>
					<p></p>
				</div>

				<div class="testimonials-slider swiper" data-aos="fade-up"
					data-aos-delay="100">
					<div class="swiper-wrapper">

						
	
<%
request.setCharacterEncoding("utf-8");
//리뷰 while문으로 반복문 처리 후 게시판 내용 불러와서 변수에담아 출력한 부분 

	// 1. DB 연결 -------------------------------------------------
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	
	// 정보를 담은 메소드로 호출 하기 	
		
	try {
		Context initCtx = new InitialContext(); // 톰캣자체에 있는 Context객체를 가져옴
		// Resource에 정의된 Context를 Object타입으로 얻어와 Context으로 강제 형변환
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		
		// name으로 커넥션 풀인 DataSource 객체를 얻어와
		DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB"); // "jdbc/MySQLDB" : META-INF/context.xml에 설정한 name 값을 가져와야함
		
		con = ds.getConnection(); // 커넥션 풀에서 Connection객체를 얻어와
		
		//con.setAutoCommit(false); // <리턴하기전에> Connection객체의 트랙잭션을 '자동커밋' 되지않도록 하기위해 "false"설정을 해줘야함
		                            // select문을 사용하기 때문에 필요없음
		
		// 2. SQL문 실행 후 결과 -----------------------------------------------                            
		
		String sql = "	select BOARD_NAME,BOARD_SUBJECT,BOARD_CONTENT ,BOARD_DATE from  board order by board_date desc limit 0,5";

		
		pstmt = con.prepareStatement(sql);
	
		rs = pstmt.executeQuery();
		
		while(rs.next()){ // 같은 id가 있으면 리다이렉트 방식으로 요청함(기존의 request 사용X)
		
			String BOARD_NAME=rs.getString("BOARD_NAME");
			String BOARD_SUBJECT=rs.getString("BOARD_SUBJECT");
			String BOARD_CONTENT=rs.getString("BOARD_CONTENT");
			String BOARD_DATE=rs.getString("BOARD_DATE");
			
			
			
		%>		<div class="swiper-slide">
							<div class="testimonial-item">
								<p>
								<br><%=BOARD_CONTENT %></i>
								</p>
								
								
								<img src="assets/img/testimonials-1.png"
									class="testimonial-img" alt="">  	 
								<h3><%=BOARD_SUBJECT %> <br>
								후기작성일 : <%=BOARD_DATE %></h3>
								<br>
								<h4><%=BOARD_NAME %> 고객님</h4>  
								
								
							</div>
						</div>
						
		<% }
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		// 3. DB 해제 ----------------------------------------------- 
		try{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

%>
			</div>
					<div class="swiper-pagination"></div>
				</div>

			</div>
							</div>
							
						</div>
						<!-- ======= End testimonial item ======= -->
	
	
		<!-- 밀키트나 아님 음식 전체에 술에 대한 콜키지에 대한 부분 -->
		<!-- ======= Portfolio Section ======= -->
		<section id="portfolio" class="portfolio section-bg">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>메뉴소개</h2>
					<p>직접 재배한 건강한 식재료를 바탕으로 계절에 맞는 음식을 조리합니다.</p>
				</div>

				<div class="row" data-aos="fade-up">
					<div class="col-lg-12 d-flex justify-content-center">
						<ul id="portfolio-flters">
							<li data-filter="*" class="filter-active">전체요리</li>
							<li data-filter=".filter-soup">스프</li>
							<li data-filter=".filter-bread">빵</li>
							<li data-filter=".filter-salad">샐러드</li>
							<li data-filter=".filter-mainDish">메인디시</li>
							<li data-filter=".filter-dessert">디저트</li>
							<li data-filter=".filter-tea">차</li>
							<li data-filter=".filter-wine">와인</li>
						</ul>
					</div>
				</div>

				<div class="row portfolio-container" data-aos="fade-up">

					<%-- 스프(soup)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-soup">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-soup-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유기농 단호박 스프입니다.</h4>
								<p>※계절에 따라 스프 메뉴가 달라질 수 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-soup-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="직접 재배한 단호박으로 만든 스프입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 스튜(stew)-2 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-soup">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-stew-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유기농 토마토로 만든 스튜입니다.</h4>
								<p>※계절에 따라 스튜 메뉴가 달라질 수 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-stew-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="직접 재배한 유기농 토마토입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 빵(bread)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-bread">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-bread-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유기농 밀과 우유로 만든 바게트입니다.</h4>
								<p>※저희가 직접만들고 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-bread-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="숙성이 완료된 바게트 반죽입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 빵(bread)-2 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-bread">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-bread-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유기농 호밀로 만든 호밀빵입니다.</h4>
								<p>※100% 호일이라 입자가 거칠 수 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-bread-2-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="갖 나온 호밀빵입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 샐러드(salad)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-salad">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-salad-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>직접 재배한 채소로 만든 샐러드입니다.</h4>
								<p>※원하시는 채소는 미리 말씀해주세요.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-salad-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="저희 농장 중 한 곳 사진입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 샐러드(salad)-2 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-salad">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-salad-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>직접 재배한 채소로 만든 샐러드입니다.</h4>
								<p>※치즈 추가 가능합니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-salad-2-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="저희 이렇게 재배합니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 샐러드-3 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-salad">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-salad-3.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>최고급 트러플로 만든 샐러드입니다.</h4>
								<p>※트러플의 수급이 불안정 할 수 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-salad-3-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="최고급 프랑스산 트러플입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 샐러드-4 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-salad">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-salad-4.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>재배한 시금치로 만든 파스타입니다.</h4>
								<p>※파스타 샐러드는 추가 금액이 발생할 수 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-salad-4-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="유기농 밀과 달걀로 생면 파스타입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 메인디시(mainDish)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-mainDish">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-main-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>1++등급 한우의 토마호크입니다.</h4>
								<p>※굽기 조절이 가능합니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-main-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="48시간동안 저희만의 방법으로 숙성을 거친 상태입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 메인디시(mainDish)-2 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-mainDish">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-main-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>영국 해안에서 공수한 달팽이입니다.</h4>
								<p>※물량 수급이 어려울 경우 다른 메뉴로 대체됩니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-main-2-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="에스까르고 조리과정입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 메인디시(mainDish)-3 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-mainDish">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-main-3.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>1++등급 한우의 채끝부위입니다.</h4>
								<p>※기본 굽기는 미디움-웰던으로 제공해드립니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-main-3-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="48시간동안 저희만의 방법으로 숙성을 거친 상태입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 디저트(dessert)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-dessert">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-dessert-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유기농 밀과 우유로 만든 크라펜입니다.</h4>
								<p></p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-dessert-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="크라펜을 만드는 과정입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 디저트(dessert)-2 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-dessert">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-dessert-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유일하게 전문점에서 받는 초코케익입니다.</h4>
								<p>※다른 케익으로 변경 가능합니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-dessert-2-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="오래된 케익전문점 블랑제리입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 차(tea) --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-tea">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-tea-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>경남 하동의 유기농 녹차입니다.</h4>
								<p>※계절에 따라 제주도에서 공수받습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-tea-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="경남 하동의 녹차밭 사진입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 물 --%>
<!-- 					<div class="col-lg-4 col-md-6 portfolio-item filter-tea">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-water-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>이탈리아 알프스 빙하수입니다.</h4>
								<p>※계절에 따라 알래스카에서 공수 받을 수도 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-water-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="알프스의 수원지입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div> -->
					
					<%-- 커피(coffee)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-tea">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-co-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>유기농 케냐 AA 원두를 사용합니다.</h4>
								<p>※원두 수급이 원할하지 않을 수도 있습니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-co-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title=""><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 콜드브루(coffee)-2 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-tea">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-co-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>48시간 천천히 내린 커피입니다.</h4>
								<p>※기본 원두는 에티오피아 수프리모를 사용합니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-co-2-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title=""><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 화이트 와인(wine)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-wine">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-wine-1.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>에스까르고와 어울이는 화이트와인입니다.</h4>
								<p>※콜키지는 병당 30000만원입니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-wine-1-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="공수 받는 와인 생산지입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>
					
					<%-- 레드 와인(wine)-1 --%>
					<div class="col-lg-4 col-md-6 portfolio-item filter-wine">
						<div class="portfolio-wrap">
							<img src="assets/img/portfolio/portfolio-wine-2.jpg" class="img-fluid"
								alt="">
							<div class="portfolio-info">
								<h4>고기와 어울리는 레드와인입니다.</h4>
								<p>※콜키지는 병당 30000만원입니다.</p>
								<div class="portfolio-links">
									<a href="assets/img/portfolio/portfolio-wine-2-1.jpg"
										data-gallery="portfolioGallery" class="portfolio-lightbox"
										title="공수 받는 와인의 오크통입니다."><i class="bx bx-plus"></i></a> <a
										href="portfolio-details.html" title="More Details"><i
										class="bx bx-link"></i></a>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</section>
		<!-- ======= End Portfolio Section ======= -->
	

	
		<!-- ======= Steps Section ======= -->
		<!-- 예약 부분  -->
	<!--  	<section id="steps" class="steps section-bg">
			<div class="container">
			<h2>예약하기</h2>
				<div class="row no-gutters">
					<div class="col-lg-4 col-md-6 content-item" data-aos="fade-in">
						<span>01</span>
						<h4></h4>
						<p></p>
					</div>
					<div class="col-lg-4 col-md-6 content-item" data-aos="fade-in"
						data-aos-delay="100">
						<span></span>
						<h4></h4>
						<p></p>
					</div>

					<div class="col-lg-4 col-md-6 content-item" data-aos="fade-in"
						data-aos-delay="200">
						<span>03</span>
						<h4></h4>
						<p></p>
					</div>

					<div class="col-lg-4 col-md-6 content-item" data-aos="fade-in"
						data-aos-delay="300">
						<span>04</span>
						<h4></h4>
						<p></p>
					</div>

					<div class="col-lg-4 col-md-6 content-item" data-aos="fade-in"
						data-aos-delay="400">
						<span>05</span>
						<h4> </h4>
						<p></p>
					</div>

					<div class="col-lg-4 col-md-6 content-item" data-aos="fade-in"
						data-aos-delay="500">
						<span>06</span>
						<h4></h4>
						<p></p>
					</div>
				</div>
			</div>
		</section>-->
		<!-- ======= End Steps Section ======= -->

		

		<!-- 주차장이나 알러지 음식이나 고객 맞춤에 식재료 표기 구분 -->
		  
		

		

		</section>

		<!-- ======= End Testimonials Section ======= -->



		<!-- 메인 쉐프와 ceo 사진에 대한 인물 사진을 추가하는 부분 -->
      <!-- ======= Team Section ======= -->
     <!--  <section id="team" class="team">
         <div class="container">
            <div class="section-title" data-aos="fade-up">
               <h2>쉐프</h2>
               <p>각 분야에서 최고의 요리사들이 당신을 기다리고 있습니다.</p>
            </div>

            <div class="row">

               <div class="col-xl-3 col-lg-4 col-md-6" data-aos="fade-up">
                  <div class="member">
                     <img src="assets/img/team/team-1.jpg" class="img-fluid" alt="">
                     <div class="member-info">
                        <div class="member-info-content">
                           <h4>Tim Cook</h4>
                           <span>Main Chief</span>
                        </div>
                        <div class="social">
                           <a href="https://guide.michelin.com/kr/ko" title="2022년 미쉐린 가이드 추천쉐프입니다."><i class="bi bi-trophy"></i></a> 
                           <a href="https://twitter.com/?lang=ko" target="blank-1"><i class="bi bi-twitter"></i></a> 
                           <a href="https://ko-kr.facebook.com/" target="blank-2"><i class="bi bi-facebook"></i></a> 
                           <a href="https://www.instagram.com/" target="blank-3"><i class="bi bi-instagram"></i></a> 
                        </div>
                     </div>
                  </div>
               </div>

               <div class="col-xl-3 col-lg-4 col-md-6" data-aos="fade-up"
                  data-aos-delay="100">
                  <div class="member">
                     <img src="assets/img/team/team-2.jpg" class="img-fluid" alt="">
                     <div class="member-info">
                        <div class="member-info-content">
                           <h4>Sarah Jhonson</h4>
                           <span>Beef Main Chief</span>
                        </div>
                        <div class="social">
                           <a href="https://twitter.com/?lang=ko" target="blank-1"><i class="bi bi-twitter"></i></a> 
                           <a href="https://ko-kr.facebook.com/" target="blank-2"><i class="bi bi-facebook"></i></a> 
                           <a href="https://www.instagram.com/" target="blank-3"><i class="bi bi-instagram"></i></a> 
                           <a href="https://kr.linkedin.com/" target="blank-4"><i class="bi bi-linkedin"></i></a>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="col-xl-3 col-lg-4 col-md-6" data-aos="fade-up"
                  data-aos-delay="200">
                  <div class="member">
                     <img src="assets/img/team/team-3.jpg" class="img-fluid" alt="">
                     <div class="member-info">
                        <div class="member-info-content">
                           <h4>William Anderson</h4>
                           <span>Escargot Main Cheif</span>
                        </div>
                        <div class="social">
                           <a href="https://twitter.com/?lang=ko" target="blank-1"><i class="bi bi-twitter"></i></a> 
                           <a href="https://ko-kr.facebook.com/" target="blank-2"><i class="bi bi-facebook"></i></a> 
                           <a href="https://www.instagram.com/" target="blank-3"><i class="bi bi-instagram"></i></a> 
                           <a href="https://kr.linkedin.com/" target="blank-4"><i class="bi bi-linkedin"></i></a>
                        </div>
                     </div>
                  </div>
               </div>

               <div class="col-xl-3 col-lg-4 col-md-6" data-aos="fade-up"
                  data-aos-delay="300">
                  <div class="member">
                     <img src="assets/img/team/team-4.jpg" class="img-fluid" alt="">
                     <div class="member-info">
                        <div class="member-info-content">
                           <h4>Amanda Jepson</h4>
                           <span>Pasta Main Chief</span>
                        </div>
                        <div class="social">
                           <a href="https://twitter.com/?lang=ko" target="blank-1"><i class="bi bi-twitter"></i></a> 
                           <a href="https://ko-kr.facebook.com/" target="blank-2"><i class="bi bi-facebook"></i></a> 
                           <a href="https://www.instagram.com/" target="blank-3"><i class="bi bi-instagram"></i></a> 
                           <a href="https://kr.linkedin.com/" target="blank-4"><i class="bi bi-linkedin"></i></a>
                        </div>
                     </div>
                  </div>
               </div>

            </div>

         </div>
      </section> -->
      <!-- ======= End Team Section ======= -->

   <!-- F.A.Q 부분으로 하면 문제 없을 것 같다. -->
      <!-- ======= F.A.Q Section ======= -->
      <section id="faq" class="faq section-bg">
         <div class="container">

            <div class="section-title" data-aos="fade-up">
               <h2><span style="color:red; font-weight:bold"><a href="memberMain.jsp"><img src="assets/img/logo2.png"></a></span> 레스토랑: FAQ 및 고객 리뷰</h2>
               <p><h5>안녕하세요.</h5> <a href="memberMain.jsp"><img src="assets/img/logo2.png"></a>레스토랑에 오신 것을 환영합니다! <br>
               우리는 특별한 날에 완벽한 최고의 요리만을 고객에게 제공하고자 하는 셰프 팀입니다! <br>
               이 페이지에서는 자주 묻는 질문에 답하고 고객이 우리의 식사와 서비스에 대해 말하는 내용을 보여줄 것입니다. 
               </p>
            </div>

            <div class="faq-list">
               <ul>
               
                  <li data-aos="fade-up"><i class="bx bx-help-circle icon-help"></i>
                     <a data-bs-toggle="collapse" class="collapse"
                     data-bs-target="#faq-list-1">SoulRest 레스토랑은 언제까지 영업하나요? 
                        <i class="bx bx-chevron-down icon-show"></i><i
                        class="bx bx-chevron-up icon-close"></i>
                  </a>
                     <div id="faq-list-1" class="collapse show"
                        data-bs-parent=".faq-list">
                        <p>
                        SoulRest Restaurant은 일반적으로 매일 오전 12시부터 오후 8시까지 영업하며 오후 2시 30분부터 5시 30분까지 3시간의 Break Time이 있습니다. <br>
                        따라서 귀하와 귀하의 가족이 점심, 오후 간식, 저녁 및 늦은 저녁 식사를 원하는 경우 SoulRest 레스토랑을 이용할 수 있습니다
                        </p>
                     </div></li>
                     
                  <li data-aos="fade-up" data-aos-delay="400"><i
                     class="bx bx-help-circle icon-help"></i> <a
                     data-bs-toggle="collapse" data-bs-target="#faq-list-5"
                     class="collapsed">SoulRest 레스토랑의 식사는 진짜 1++ 인가요?<i
                        class="bx bx-chevron-down icon-show"></i><i
                        class="bx bx-chevron-up icon-close"></i>
                  </a>
                     <div id="faq-list-5" class="collapse" data-bs-parent=".faq-list">
                     <p>   
                     예! 우리 소들은 무리와 함께 자유롭게 돌아다니며 스트레스를 받지 않는 넓은 목초지에서 항상 잘 보살핌을 받고 있습니다. <br>
                        그들은 또한 클로버, 풀, 포브의 일반적인 식사 외에도 건초, 사일리지, 농축 알약 및 곡물과 같은 천연 보충 사료를 먹습니다. <br>
                        따라서 여기 SoulRest 레스토랑에서 우리와 함께 식사할 때 귀하에게 제공되는 식사는 온 가족을 위해 건강하고 영양가가 높다는 것을 확신할 수 있습니다!<br>
                     </p>
                     </div></li>
               
                  

                  <li data-aos="fade-up" data-aos-delay="100"><i
                     class="bx bx-help-circle icon-help"></i> <a
                     data-bs-toggle="collapse" data-bs-target="#faq-list-2"
                     class="collapsed">SoulRest 레스토랑은 식사 준비에 GMO를 사용합니까?
                        <i class="bx bx-chevron-down icon-show"></i><i
                        class="bx bx-chevron-up icon-close"></i>
                  </a>
                     <div id="faq-list-2" class="collapse" data-bs-parent=".faq-list">
                        <p>아닙니다. 저희는 고객님의 건강을 생각하기 때문에 항상 고품질의 자연식만을 사용하여 음식을 만들고 있는지 확인합니다. <br>
                        식사의 영양 성분 차이, 장기 손상, 잠재적인 알레르기 반응과 같은 유전자 변형 유기체의 많은 부정적인 부작용을 감안할 때 저희는 식사와 함께 자연식을 선택했습니다. <br>
                        이것이 바로 우리가 가지고 있는 모든 재료가 신선하고 건강하게 제공되는 식사를 보장하기 위해 농부 
                        팀에 의해 자연적으로 재배된 이유이며 미래에 잠재적인 질병을 일으키지 않습니다. </p>
                     </div></li>

                  <li data-aos="fade-up" data-aos-delay="200"><i
                     class="bx bx-help-circle icon-help"></i> <a
                     data-bs-toggle="collapse" data-bs-target="#faq-list-3"
                     class="collapsed">SoulRest 레스토랑은 식사에 MSG를 사용합니까?
                        <i class="bx bx-chevron-down icon-show"></i><i
                        class="bx bx-chevron-up icon-close"></i>
                  </a>
                     <div id="faq-list-3" class="collapse" data-bs-parent=".faq-list">
                        <p>아닙니다. 
                        MSG가 식사에 풍부한 감칠맛을 선사하는 ‘맛의 왕’이라는 평판에도 불구하고 Soul Restaurant에서는 사용하지 않기로 결정했습니다. <br>
                        음식이 너무 짜지 않고 건강하게 유지되고 추가 재료를 사용하지 않고도 자연스럽게 맛이 나오길 원하기 때문입니다. <br>
                        또한 우리가 이것을 하는 또 다른 이유는 MSG가 건강광인 일부 사람들에게 부정적인 의미를 갖는 경향이 있기 때문입니다. <br>
                        이것은 모든 사람들이 식사에 대해 훌륭한 경험을 할 수 있도록 저희 레스토랑이 포괄적으로 유지되도록 하기 위한 것입니다. </p>
                     </div></li>

                  <li data-aos="fade-up" data-aos-delay="300"><i
                     class="bx bx-help-circle icon-help"></i> <a
                     data-bs-toggle="collapse" data-bs-target="#faq-list-4"
                     class="collapsed">SoulRest 레스토랑은 비건 채식을 제공합니까?
                     <i class="bx bx-chevron-down icon-show"></i><i
                        class="bx bx-chevron-up icon-close"></i>
                  </a>
                     <div id="faq-list-4" class="collapse" data-bs-parent=".faq-list">
                        <p>위에서 언급했듯이 그렇습니다. 
                        우리는 또한 고기를 좋아하지 않거나 먹을 수 없는 사람을 위해 건강한 비건 샐러드와 두부와 같은 기타 육류 대체품을 제공합니다. <br>
                        우리는 모두가 여기 레스토랑에서 시간을 즐길 수 있는 기회를 갖기를 원하기 때문입니다. 그래서 채식주의자를 위한 식사를 제공합니다. <br>
                        우리는 식사에 포함되는 것이 채식주의자에게 식사 장소를 제공할 뿐만 아니라 배고픔을 만족시키기 위해 영양가 있고 맛있는 식사를 원하는 모든 사람에게 제공할 것이라고 믿습니다. <br>
                        고객의 식사 선호도를 알기 위해 항상 식단과 고기를 먹을지 여부를 묻습니다. <br>
                        우리는 주문 단계 초기에 이 작업을 수행하여 귀하가 선택하는 식사가 귀하에게 좋은지, 고기 또는 고기 기름을 샐러드에 적용하고 싶은지 알 수 있습니다.
                        </p>
                     </div></li>
               </ul>
            </div>

         </div>
      
      </section>
      <!-- ======= End F.A.Q Section ======= -->
<!-- 식당의 위치나 주소에 대해서 구분하는 공간 -->
		<!-- ======= Contact Section ======= -->
		<section id="contact" class="contact">
			<div class="container">

				<div class="section-title" data-aos="fade-up">
					<h2>오시는길</h2>
					<p>지금, 매장에 방문하셔서 사랑하는 사람들과 함께 질좋은 스테이크와 신선한 샐러드를 즐겨보세요</p>
				</div>

				<div class="row no-gutters justify-content-center"
					data-aos="fade-up">

					<div class="col-lg-5 d-flex align-items-stretch">
						<div class="info">
							<div class="address">
								<i class="bi bi-geo-alt"></i>
								<h4>Location:</h4>
								<p>대한민국 대구광역시 달서구 달구벌대로 251안길 15</p>
							</div>
							<div class="email mt-4">
								<i class="bi bi-envelope"></i>
								<h4>Email:</h4>
								<p>SoulRest@naver.com</p>
							</div>
							<div class="phone mt-4">
								<i class="bi bi-phone"></i>
								<h4>Call:</h4>
								<p>010 0000 0000</p>
							</div>
						</div>
					</div>
					<div class="col-lg-5 d-flex align-items-stretch">
						<iframe style="border: 0; width: 100%; height: 270px;"
							src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3233.8605749118633!2d128.5076967609231!3d35.85242218707872!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3565e539748d77cf%3A0xc9a0370fd6c120fa!2z7JiB64Ko6riw7Iig7KeB7JeF7KCE66y47ZWZ6rWQ!5e0!3m2!1sko!2sbg!4v1649641866611!5m2!1sko!2sbg"
							frameborder="0" allowfullscreen></iframe>
					</div>
				</div>
				

			</div>
		</section>
		<!-- ======= End Contact Section ======= -->

   </main>
   <!-- ======= End main ======= -->

   <jsp:include page="memberFooter.jsp" />
</body>



</html>
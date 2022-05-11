<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
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
            <a class="nav-link active" aria-current="page" >MealKitMenu</a>
          </li>
     	<li class="nav-item"><a
						href="${pageContext.request.contextPath}/mealKit.KIOSK"
						class="nav-link px-2 link-dark">홈 밀키트</a></li>

					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/salad.KIOSK"
						class="nav-link px-2 link-dark">샐러드</a></li>

					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/pasta.KIOSK"
						class="nav-link px-2 link-dark">파스타</a></li>

					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/Tsteak.KIOSK"
						class="nav-link px-2 link-dark">티본 스테이크</a></li>

					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/esca.KIOSK"
						class="nav-link px-2 link-dark">에스카르고</a></li> 
						
					<li class="nav-item"><a
					href="${pageContext.request.contextPath}/steak.KIOSK"
					class="nav-link px-2 link-dark">안심 스테이크</a></li>
					
			
			
			
			
			
			
						
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
  <div>
  <br><br>
</div>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
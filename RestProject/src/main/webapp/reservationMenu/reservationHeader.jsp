<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

String now=(String)request.getAttribute("now");
String now2=(String)request.getAttribute("now");
%>

<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>예약</title>

  <body>
     <nav class="navbar navbar-expand-lg navbar-light me-lg-0">
  <div class="container-fluid">
    <a class="navbar-brand" href="memberMain.jsp"><img src="info/logo.jpg"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="memberMain.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">문의</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="memberLogout.RC">Logout</a></li>
            <li><a class="dropdown-item" href=""> </a></li>
           
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">예약내역조회</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">예약</a>
        </li>
      </ul>


    </div>
  </div>
</nav>


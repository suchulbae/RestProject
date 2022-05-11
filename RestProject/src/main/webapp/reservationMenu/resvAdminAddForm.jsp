<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>
	<div><jsp:include page="reservationHeader.jsp" /></div>
	
		<br><br>
				<div style="text-align:center">
		
			<jsp:include page="reservationMenuList.jsp" />
			</div>
			<!--  c:if로 거르기 -->
			
  <div class="px-4 py-5 my-5 text-center">

   	 <h2 class="pb-2 border-bottom">InsertMenu</h2>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">추가하실 메뉴를 넣어주세요.</p>
      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
       
       <form action="RestMenuAdd.ADM" method="post" name="addForm" enctype="multipart/form-data">
      <table class="table">
         <tr>
      
      <th colspan="10" class="table-active">Insert !</th>
 
    </tr>
    <tr>
       <th>menuID</th>
       <td>
       	  <input type="text"name= "menuID" class="form-control" placeholder="MenuID" aria-label="Username" required="required">
       	</td>
       </tr>
   		<tr>
       		<th> 카테고리</th>
       	<td>
		<select name="category" class="form-select form-select-sm" aria-label=".form-select-sm example">

  			<option  value="Course">Course</option>
 				<option value="PREMIUMSIDES">PREMIUMSIDES</option>
 			 <option value="SALAD">SALAD</option>
			</select>
       	
       	
       	
       	</td>
       	 </tr>
       	
       	<tr>
       	
      	<th>메뉴명</th>
			<td> 
			<input type="text"name="menuNAME" class="form-control" placeholder="menuNAME" required="required">
			</td>
       
       
       </tr>
       
       
            	<tr>
       	
      	<th>메뉴설명</th>
			<td> 
			<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label"></label>
  <textarea class="form-control" name ="menuDETAIL" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
			</td>
       
       
       </tr>
       <tr>
       <th>판매 가능 여부</th>
       <td>
       <div class="form-check">
  <input class="form-check-input" type="radio" name="m_status" id="exampleRadios1" value="y" checked>
  <label class="form-check-label" for="exampleRadios1">
  <small> 판매가능</small>
  </label>
  </div>
       </td>
       
          <td>
       <div class="form-check">
  <input class="form-check-input" type="radio" name="m_status" id="exampleRadios1" value="n" checked>
  <label class="form-check-label" for="exampleRadios1">
	 <small>판매불가</small>
  </label>
  </div>
       </td>
       
       </tr>
       <tr>
       <th>가격</th>
      <td> <input type="number" name="resvPRICE" id="resvPRICE" step="100" min="0" max="200000" required="required"></td>
       </tr>
     <tr>
     	<th></th>
 
       <td><div class="mb-3">
  <label for="formFileSm" class="form-label">메뉴이미지</label>
  <input name="image" class="form-control form-control-sm" id="formFileSm" type="file">
</div>
       </td>
      
       </tr>
       
       <tr>
       <td colspan="2">
       	<input type="submit" value="메뉴등록">
					<input type="reset" value="다시작성">
       </tr>
       
       
       </table>
       
       
       
       
       
       
       
    	</form>
        
      </div>
    </div>
  </div>
			

				
		
			
			
		
	










</body>
</html>
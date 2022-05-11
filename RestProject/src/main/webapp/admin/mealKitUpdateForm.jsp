<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/mealKitAdminForm.css"> 	
<title>밀키트 수정 폼</title>

</head>
<body>
	<section>
		<header>
			<h2 style="text-align: center;">밀키트 수정</h2>
		</header>
		<form action="mealKitUpdate.ADM" method="post" name="mealKitUpdateForm"
			enctype="multipart/form-data">
			
			<table class="center">
				<tr>
					<th colspan="2"></th>
				</tr>
				<tr>
					<th>밀키트 ID</th>
					<td>
						<input type="text" name="meal_id" id="meal_id" value="${mealKitUpdate.meal_id}" required="required" readonly="readonly">
						
					</td>
				</tr>
				<tr>
					<th>밀키트 카테고리</th>
					<td>
						<c:if test="${mealKitUpdate.meal_category ne null and mealKitUpdate.meal_category eq 'salad'}">
						<select name="meal_category" class="form-select" aria-label="Default select example">
								<option value="salad" selected>샐러드</option>
								<option value="pasta">파스타</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="esca">에스카르고</option>
								<option value="steak">안심 스테이크</option>
						</select>
						</c:if>
						
						<c:if test="${mealKitUpdate.meal_category ne null and mealKitUpdate.meal_category eq 'pasta'}">
						<select name="meal_category" class="form-select" aria-label="Default select example">
								<option value="salad">샐러드</option>
								<option value="pasta" selected>파스타</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="esca">에스카르고</option>
								<option value="steak">안심 스테이크</option>
						</select>
						</c:if>
						
						<c:if test="${mealKitUpdate.meal_category ne null and mealKitUpdate.meal_category eq 'steak'}">
						<select name="meal_category" class="form-select" aria-label="Default select example">
								<option value="salad">샐러드</option>
								<option value="pasta">파스타</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="esca">에스카르고</option>
								<option value="steak">안심 스테이크</option>
						</select>
						</c:if>
						
						<c:if test="${mealKitUpdate.meal_category ne null and mealKitUpdate.meal_category eq 'Tsteak'}">
						<select name="meal_category" class="form-select" aria-label="Default select example">
								<option value="salad">샐러드</option>
								<option value="pasta">파스타</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="esca" selected>에스카르고</option>
								<option value="steak">안심 스테이크</option>
						</select>
						</c:if>
						
						<c:if test="${mealKitUpdate.meal_category ne null and mealKitUpdate.meal_category eq 'esca'}">
						<select name="meal_category" class="form-select" aria-label="Default select example">
								<option value="salad">샐러드</option>
								<option value="pasta">파스타</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="esca">에스카르고</option>
								<option value="steak" selected>안심 스테이크</option>
						</select>
						</c:if>
					</td>
					<%-- <c:if test="${mealkitUpdate.meal_category ne null and mealkitUpdate.meal_category eq 'salad'}">
						<input type="radio" name="meal_category" value="salad" checked="checked"> 트러플 샐러드
						<input type="radio" name="meal_category" value="pasta"> 뇨끼 파스타
						<input type="radio" name="meal_category" value="steak"> 안심 스테이크
						<input type="radio" name="meal_category" value="Tsteak"> 티본 스테이크
						<input type="radio" name="meal_category" value="esca"> 에스카르고
					</c:if> --%>
					
				</tr>
				
				<tr>
					<th>밀키트 이름</th>
					<td><input type="text" name="meal_name" id="meal_name"
						value="${mealKitUpdate.meal_name}" required="required"></td>
				</tr>	
				<tr>
					<th>밀키트 가격</th>
					<td><input type="number" name="meal_price" id="meal_price"
						value="${mealKitUpdate.meal_price}" step="5000" min="0" max="1000000"
						required="required"></td>
				</tr>
				<tr>
					<th>밀키트 설명</th>
					<td>
						<textarea name="meal_detail" id="meal_detail" rows="10" cols="25"
							wrap="off" required="required">${mealKitUpdate.meal_detail}</textarea>
					</td>
				</tr>
				
				<tr>
					<th>밀키트 판매가능</th>
					<td><c:if
							test="${mealKitUpdate.meal_status ne null and mealKitUpdate.meal_status eq 'y'}">
							<input type="radio" name="meal_status" id="meal_status" value="y"
								checked="checked"> 판매 가능
					<input type="radio" name="meal_status" id="meal_status" value="n"> 판매 불가
					</c:if> <c:if
							test="${mealKitUpdate.meal_status ne null and mealKitUpdate.meal_status eq 'n'}">
							<input type="radio" name="meal_status" id="meal_status" value="y"> 판매 가능
					<input type="radio" name="meal_status" id="meal_status" value="n"
								checked="checked"> 판매 불가
					</c:if></td>
				</tr>
				
				<tr>
					<th>밀키트 이미지</th>
					<td class="mb-3">
						<label for="formFile" class="form-label"></label>
						<input class="form-control" type="file" id="meal_image"
							name="meal_image"> 
						<!-- <input type="file" name="meal_image" id="meal_image"> -->
						
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-danger">밀키트 수정</button>
						<button type="reset" class="btn btn-success">밀키트 다시 작성</button>
					</td>
				</tr>
			</table>
		</form>	
	</section>
</body>
</html>
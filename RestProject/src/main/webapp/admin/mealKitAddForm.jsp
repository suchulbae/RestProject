<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/mealKitAdminForm.css"> 	

<title>밀키트추가 폼</title>
</head>
<body>
	<div>
		<section>
			<header>
				<h2 style="text-align: center;">밀키트 등록</h2>
			</header>
			<form action="mealKitAdd.ADM" method="post" name="addForm"
				enctype="multipart/form-data">

				<table class="center">

					<tr>
						<th colspan="2"></th>
					</tr>
					<tr>
						<th>밀키트 ID</th>
						<td><input type="text" name="meal_id" id="meal_id"
							required="required"></td>
					</tr>

					<tr>
						<th>밀키트 카테고리</th>
						<td><select name="meal_category" class="form-select"
							aria-label="Default select example">
								
								<option value="salad" selected>샐러드</option>
								<option value="pasta">파스타</option>
								<option value="steak">안심 스테이크</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="esca">에스카르고</option>
						</select> <!-- 				
						<select name="meal_category">
								<option value="default">밀키트를 선택해주세요.</option>
								<option value="salad">트러플 샐러드</option>
								<option value="pasta">뇨끼 파스타</option>
								<option value="steak">안심 스테이크</option>
								<option value="Tsteak">티본 스테이크</option>
								<option value="escaesca">에스카르고</option>
						</select>
						
							<input type="radio" name="meal_category" value="salad">트러플 샐러드
							<input type="radio" name="meal_category" value="pasta">뇨끼 파스타
							<input type="radio" name="meal_category" value="steak">안심 스테이크 
							<input type="radio" name="meal_category" value="Tsteak">티본 스테이크
							<input type="radio" name="meal_category" value="escaesca">에스카르고
						--></td>
					</tr>

					<tr>
						<th>밀키트 이름</th>
						<td><input type="text" name="meal_name" id="meal_name"
							required="required"></td>
					</tr>

					<tr>
						<th>밀키트 가격</th>
						<td><input type="number" name="meal_price" id="meal_price"
							step="5000" min="0" max="1000000" required="required"></td>
					</tr>

					<tr>
						<th>밀키트 설명</th>
						<td><textarea name="meal_detail" id="meal_detail" rows="10"
								cols="25" wrap="off" style="text-align: left;"
								required="required"></textarea></td>
					</tr>

					<tr>
						<th>밀키트 품절 여부</th>
						<td><input type="radio" name="meal_status" id="meal_status"
							value="y" checked="checked"> 판매 가능 <input type="radio"
							name="meal_status" id="meal_status" value="n"> 판매 불가</td>
					</tr>

					<tr>

						<th>밀키트 이미지</th>
						<td class="mb-3"><label for="formFile" class="form-label"></label>
							<input class="form-control" type="file" id="meal_image"
							name="meal_image" required="required"></td>
					</tr>

					<tr>
						<td colspan="2">
							<button type="submit" class="btn btn-danger">밀키트 등록</button>
							<button type="reset" class="btn btn-success">밀키트 다시 작성</button> <!-- <input type="submit" value="밀키트 등록"> 
						<input type="reset" value="밀키트 다시 작성"> -->
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>
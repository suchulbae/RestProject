<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
<title>등록 된 밀키트 확인 창</title>
<link rel="stylesheet" href="assets/css/mealKitAdminList.css"> 
</head>
<body>
	<div class="section">
		<section class="form">
			<c:if
				test="${mealKitAdminList != null && mealKitAdminList.size() > 0 }">
				<table class="center">
					<c:forEach var="mealKit" items="${mealKitAdminList }"
						varStatus="status">
						<td>
							<div class="card mb-3" style="max-width: 100%;">
								<div class="row g-0">
									<div class="col-md-4">
										<img src="assets/img/mealKit/${mealKit.meal_image }"
											class="img-fluid rounded-start">
									</div>
									<div class="col-md-8">
										<div class="card-body">
											<h6 class="card-title">밀키트 ID: ${mealKit.meal_id }</h6>
											<h6 class="card-title">밀키트 카테고리: ${mealKit.meal_category }</h6>
											<h6 class="card-title">밀키트 이름: ${mealKit.meal_name }</h6>
											<h6 class="card-title">밀키트 가격: ${mealKit.meal_price }원</h6>
											<h6 class="card-title">밀키트 등록날짜: ${mealKit.meal_date }</h6>
											<h6 class="card-title">밀키트 이미지: ${mealKit.meal_image }</h6>
											<h6 class="card-title">밀키트 설명</h6>
											<p class="card-text">${mealKit.meal_detail }</p>
											<p class="card-text">
												<small class="text-muted"> 밀키트 판매 여부: <c:if
														test="${mealKit.meal_status eq 'y' }">가능</c:if> <c:if
														test="${mealKit.meal_status eq 'n' }">품절</c:if>
												</small>
											</p>
											<h5 class="card-title">
												<a href="mealKitUpdateForm.ADM?meal_id=${mealKit.meal_id }"
													style="color: black;"> [밀키트 수정]</a> <a
													href="mealKitDelete.ADM?meal_id=${mealKit.meal_id }&meal.category=${mealKit.meal_category}"
													style="color: black;"> [밀키트 삭제]</a>
											</h5>
										</div>
									</div>
								</div>
							</div>
						</td>
						<c:if test="${((status.index+1) mod 1) == 0}">
							</tr>
							<tr>
						</c:if>
					</c:forEach>
					</tr>
				</table>
			</c:if>
			<c:if test="${mealKitAdminList == null }">
				<div style="text-align: center;">
					등록된 밀키트가 존재하지 않습니다. <br> 밀키트를 등록해주세요.
				</div>
			</c:if>
		</section>
	</div>
</body>
</html>


<%-- 	               <div></div><img src="assets/img/mealKit/${mealKit.meal_image }"><br>
	               <div><img src="assets/img/mealKit/${mealKit.meal_image }"></div><br> --%>


<%--             
	               <c:if test="${mealKitAdminList != null && mealKitAdminList.size() > 0 }">
		<table class="card mb-3" style="width: 15rem;">
				<c:forEach var="mealKit" items="${mealKitAdminList }" varStatus="status">
	            <td>
	               밀키트 ID: ${mealKit.meal_id }<br>
	               밀키트 카테고리: ${mealKit.meal_category }<br>
	               밀키트 이름: ${mealKit.meal_name }<br>
	               밀키트 가격: ${mealKit.meal_price }원<br>
	               밀키트 설명<br> ${mealKit.meal_detail }<br>
	                
	               밀키트 판매 여부: 
	               			<c:if test="${mealKit.meal_status eq 'y' }">가능</c:if>
	                        <c:if test="${mealKit.meal_status eq 'n' }">품절</c:if><br>
	               
	               밀키트 등록날짜: ${mealKit.meal_date }<br>
	               밀키트 이미지: ${mealKit.meal_image }<br>
	               
	               <a href="mealKitUpdateForm.ADM?meal_id=${mealKit.meal_id }">
	               <b>[밀키트 수정]</b></a>
	               
	               &nbsp;&nbsp;&nbsp;
	               <a href="mealKitDelete.ADM?meal_id=${mealKit.meal_id }&meal.category=${mealKit.meal_category}">
	               <b>[밀키트 삭제]</b></a> 
	               <br><br><br>
	            </td>
	            <c:if test="${((status.index+1) mod 2) == 0}">
	               </tr>
	               <tr>
	            </c:if>
        	</c:forEach>
         </tr>
    </table>
   </c:if>
	   <c:if test="${mealKitAdminList == null }">
	      <div style="text-align: center;">등록된 밀키트가 존재하지 않습니다. 밀키트를 등록해주세요.</div>
	   </c:if> 
	   </div>
   </div>
</section>
--%>


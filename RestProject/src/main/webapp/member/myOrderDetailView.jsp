<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<section id = "section">
		<c:if test="${myOrderDetailList ne null && myOrderDetailList.size()>0 }">
		
		
		
		
				<table>
					<tr>
					<th colspan="4">
						<h2>주문번호에 대한 주문 상세 내역</h2>
					</th>
					</tr>
					
				<tr>
					<th colspan="4">
						<h2>주문번호: ${myOrderDetailList.get(0).order_num}</h2>
					</th>
				</tr>
					<tr>
						<th>메뉴번호</th>
						<th>메뉴명</th>
						<th>주문수량</th>
						<th>금액</th>
						
					
					
					</tr>
					<tr>
					<c:forEach var="orderDetail" items="${myOrderDetailList }"varStatus="status">
							<td>${status.count }</td>
							<td>${orderDetail.m_name }</td>
							<td>${orderDetail.quantity }</td>
							<td>${orderDetail.m_price*orderDetail.quantity }원</td>
					
					<c:if test="${(status.count mod 1)eq 0 }">
						</tr>
						<tr>
					
					
					</c:if>
					
					</c:forEach>
					
					
					</tr>
				</table>
				<section>
				구매금액:${beforeSaleTotalMoney }<br>
				할인금액:${beforeSaleTotalMoney-saleTotalMoney }원<br>
				결제금액:${saleTotalMoney }원<br>
				
				</section>
			
		</c:if>
		<c:if test="${myOrderDetailList eq null}">
			<div>주문 번호에 대한 주문내역 정보가 없습니다.</div>
	
		</c:if>
</section>
</body>
</html>
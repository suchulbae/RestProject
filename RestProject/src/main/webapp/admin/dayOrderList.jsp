<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>오늘 주문한 리스트</title>

<link rel="stylesheet" href="assets/css/mealKitAdminForm.css"> 	

</head>
<body>
   
<section>
   <!-- *************************** 1. *************************** -->
   <c:if test="${dayOrderList ne null && dayOrderList.size() > 0}">
   
   <!-- *************************** 1-1. [주문 대기] *************************** -->
      <div>
         <h3 style="text-align: center">주문 대기</h3>
      </div>
      <table class="table w-auto">
         <c:set var="doneLoop" value="false" />
         <c:set var="done" value="false" />
            <c:forEach var="order" items="${dayOrderList}" varStatus="status">
            
               <c:if test="${not doneLoop && not done}">
                  <c:choose>
                     <c:when test="${!status.last && order.meal_order_status eq 'order'}">
                        <tr>
                           <th>주문 번호</th>
                           <th>고객 ID</th>
                           <th>고객 EMAIL</th>
                           <th>주문 시간</th>
                           <th>주문 상태</th>
                           <th>총 금액</th>
                           <th>주문'승인/취소'</th>
                        </tr>
                        <c:set var="doneLoop" value="true" />
                        <c:set var="done" value="true" />
                     </c:when>
                     
                     <c:when test="${status.last && (order.meal_order_status eq 'get' || order.meal_order_status eq 'cancle') }">
                        아직 주문 대기 리스트가 없습니다.
                        <c:set var="doneLoop" value="true" />
                     </c:when>
                  </c:choose>
               </c:if>
            </c:forEach>   
            
         <c:if test="${done}">
         <form action="post">
            <c:forEach var="order" items="${dayOrderList}" varStatus="status">
               <c:if test="${order.meal_order_status eq 'order'}">
                  <tr>
                     <th>
                         <a href="orderDetail.ADM?meal_order_num=${order.meal_order_num }&mID=${order.mID }">
                                    ${order.meal_order_num }</a></th>
                     <td>${order.mID}</td>
                     <td>${order.mEMAIL}</td>
                     <td>${order.meal_order_date}</td>
                     <td>주문 승인 대기 상태</td>
                     <td>${order.meal_totalmoney}원</td>
                     <td><!-- order_num으로 주문내역정보를 조회하여 주문상태를 get 또는 cancel로 변경하기 위해  -->
                     <a href="orderGet.ADM?meal_order_num=${order.meal_order_num}">주문승인</a>
                     &nbsp;
                     <a href="orderCancel.ADM?meal_order_num=${order.meal_order_num}">주문취소</a>
                     </td>
                  </tr>
               </c:if>
            </c:forEach>
         </form>
      </table>
      </c:if>
      <br><br><br>
      
      <!-- *************************** 1-2. [주문 승인] : get *************************** -->
      <div>
         <h3 style="text-align: center">주문 승인</h3>
      </div>
      <table class="center">
         <c:set var="doneLoop2" value="false" />
         
            <c:forEach var="order" items="${dayOrderList}" varStatus="status">
               <c:if test="${not doneLoop2 && order.meal_order_status eq 'get'}">
                  <c:choose>
                     <c:when test="${order.meal_order_status eq 'get'}">
                        <tr`	>
                           <th>주문 번호</th>
                           <th>고객 ID</th>
                           <th>고객 EMAIL</th>
                           <th>주문 시간</th>
                           <th>주문 상태</th>
                           <th>총 금액</th>
                           
                        </tr>
                        <c:set var="doneLoop2" value="true" />
                     </c:when>
                     
                     <c:otherwise>
                        아직 주문 승인된 리스트가 없습니다.
                        <c:set var="doneLoop2" value="true" />
                     </c:otherwise>
                  </c:choose>
               </c:if>
            </c:forEach>   
            
         <form action="post">
            <c:forEach var="order" items="${dayOrderList}" varStatus="status">
               <c:if test="${order.meal_order_status eq 'get'}">
                  <tr>
                     <td>
                        <b> 
                              <a href="orderDetail.ADM?meal_order_num=${order.meal_order_num }&mID=${order.mID }">
                                 ${order.meal_order_num }
                              </a>
                           </b>

                     </td>
                     <td>${order.mID}</td>
                     <td>${order.mEMAIL}</td>
                     <td>${order.meal_order_date}</td>
                     <td>주문 승인 상태</td>
                     <td>${order.meal_totalmoney}원</td>
                  </tr>
               </c:if>
            </c:forEach>
         </form>
      </table>
      
      <br><br><br>
      
      <!-- *************************** 1-3. [주문 취소] : cancel *************************** -->
      <div>
         <h3 style="text-align: center">주문 취소</h3>
      </div>
      <table class="center">
         <c:set var="doneLoop3" value="false" />
         
            <c:forEach var="order" items="${dayOrderList}" varStatus="status">
               <c:if test="${not doneLoop3 && order.meal_order_status eq 'cancel'}">
                  <c:choose>
                     <c:when test="${order.meal_order_status eq 'cancel'}">
                        <tr>
                           <th>주문 번호</th>
                           <th>고객 ID</th>
                           <th>고객 EMAIL</th>
                           <th>주문 시간</th>
                           <th>주문 상태</th>
                           <th>총 금액</th>
                           
                        </tr>
                        <c:set var="doneLoop3" value="true" />
                     </c:when>
                     
                     <c:otherwise>
                        아직 주문 취소된 리스트가 없습니다.
                        <c:set var="doneLoop3" value="true" />
                     </c:otherwise>
                  </c:choose>
               </c:if>
            </c:forEach>   
            
         <form action="post">
            <c:forEach var="order" items="${dayOrderList}" varStatus="status">
               <c:if test="${order.meal_order_status eq 'cancel'}">
                  <tr>
                     <td>
                        <b> 
                              <a href="orderDetail.ADM?meal_order_num=${order.meal_order_num }&mID=${order.mID }">
                                 ${order.meal_order_num }
                              </a>
                                 </b>

                     </td>
                     <td>${order.mID}</td>
                     <td>${order.mEMAIL}</td>
                     <td>${order.meal_order_date}</td>
                     <td>주문 취소</td>
                     <td>${order.meal_totalmoney}원</td>
                  </tr>
               </c:if>
            </c:forEach>
         </form>
      </table>
      
      <br><br><br>
      
   </c:if>
   
   <!-- 2. ************************************************************* -->
   <c:if test="${dayOrderList eq null}">
      <p style="text-align: center;">주문한 밀키트 내역이 없습니다.</p>
   </c:if>
   </section>
</body>
</html>
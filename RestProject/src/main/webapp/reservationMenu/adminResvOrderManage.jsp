<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<style>

a{
text-decoration: none;
}

</style>
</head>
<body>
  <div class="b-example-divider"></div>

  <div class="bg-dark text-secondary px-4 py-5 text-center">
    <div class="py-5">
      <h1 class="display-5 fw-bold text-white"> 예약내역관리 </h1>
      <div class="col-lg-6 mx-auto">
        <p class="fs-5 mb-4">${sessionScope.mGRADE }관리자님 예약 내역확인해주세요.</p>
        <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
          <a href="memberMain.jsp" class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">홈으로</a>
  
        </div>
      </div>
    </div>
  </div>

  <div class="b-example-divider mb-0"></div>
	

		<c:if test="${todayResvList ne null && todayResvList.size() > 0}">	
			 	<h2 class="pb-2 border-bottom">예약대기</h2>
		

      <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
   
      <table class="table">
      
         <c:set var="doneLoop" value="false" />
      	 <c:set var="done" value="false" />
       <c:forEach var="order" items="${todayResvList}" varStatus="status">    
       
       
       
        <c:if test="${not doneLoop && not done}">
       		<c:choose>
       			<c:when test="${ order.order_status eq 'order' }">
       			<tr>
       			<th>예약 번호</th>
       			<th> ID </th>
       			<th>EMAIL</th>
       			<th>예약 시간</th>
       			<th>예약 상태</th>
       			<th>총 금액</th>
       			<th>예약 '승인/취소'</th>
       			
       			
       			
       			</tr>
       			
       			     <c:set var="doneLoop" value="true" />
                        <c:set var="done" value="true" />
       				</c:when>
       			
       			
       			
                     <c:when test="${status.last && (order.order_status eq 'get' || order.order_status eq 'cancle') }">
                        아직 예약 대기 리스트가 없습니다.
                        <c:set var="doneLoop" value="true" />
       			  </c:when>
       			
       			
       			
       			
       			
       			
       			
       			
       			
       		
       	</c:choose>
       	</c:if>
       
        </c:forEach>
        
        
        
    	<c:if test="${done}">
       <form action="post">
      	  <c:forEach var="order" items="${todayResvList}" varStatus="status">
      	     <c:if test="${order.order_status eq 'order'}">
      			<tr>
      			<td>
      		 <b> <a href="restManageOrderDetail.ADM?order_num=${order.order_num }&mID=${order.mID }&order_status${order.order_status}">
                         ${order.order_num }</a></b>
      			
      			</td>
      			<td>${order.mID }</td>
      			<td>${order.mEMAIL }</td>
      			<td>${order.resvDATE}</td>
      			<td>예약 승인 대기 상태</td>
                <td>${order.totalMoney}원</td>
                <td>
      				   <a href="restOrderGet.ADM?order_num=${order.order_num}">예약승인</a>
                     &nbsp;
                     <a href="restOrderCancle.ADM?order_num=${order.order_num}">예약취소</a>
      			</td>
      	</tr>
      	 </c:if>
      </c:forEach>
     	
      </form>
     </c:if>
      
      </table>
       </div>

 		<div>
 		<h3>예약승인</h3>
 		</div>
 		 <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
 		 <table class="table">
 		<c:set var="doneLoop2" value ="false"/>	
    		  <c:forEach var="order" items="${todayResvList}" varStatus="status">
    		 <c:if test="${not doneLoop2 && order.order_status eq 'get'}">
    		  <c:choose>
    			<c:when test="${order.order_status eq 'get'}">
    				<tr>
                  <th>예약 번호</th>
       			<th> ID </th>
       			<th>EMAIL</th>
       			<th>예약 시간</th>
       			<th>예약 상태</th>
       			<th>총 금액</th>
       			<th>예약'취소'</th>
                           
                        </tr>
    			     <c:set var="doneLoop2" value="true" />
    			</c:when>
    		</c:choose>
    		</c:if>
    		</c:forEach>
			 <form action="post">
			<c:forEach var="order" items="${todayResvList}" varStatus="status">
			 <c:if test="${order.order_status eq 'get'}">
				<tr>
                     <td>
                        <b> 
                              <a href="restManageOrderDetail.ADM?order_num=${order.order_num }&mID=${order.mID }">
                                 ${order.order_num }
                              </a>
                           </b>

                     </td>
               		<td>${order.mID }</td>
      			<td>${order.mEMAIL }</td>
      			<td>${order.resvDATE}</td>
      			<td>예약 승인  상태</td>
                <td>${order.totalMoney}원</td>
                  <td>  <a href="restOrderCancle.ADM?order_num=${order.order_num}">예약취소</a>
      			</td>
                  </tr>
			
				</c:if>
			</c:forEach>
			</form>
		
			</table>
				</div>
			<br><br>
			<div>
			   <h3>예약 취소</h3>
			</div>
			 <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
			 <table class="table">
			 <c:set var="doneLoop3" value="false" />
			
			
			<c:forEach var="order" items="${todayResvList}" varStatus="status">
               <c:if test="${not doneLoop3 && order.order_status eq 'cancel'}">
                  <c:choose>
                     <c:when test="${order.order_status eq 'cancel'}">
                        <tr>
                           <th>예약 번호</th>
                           <th>고객 ID</th>
                           <th>고객 EMAIL</th>
                           <th>예약 시간</th>
                           <th>예약 상태</th>
                           <th>총 금액</th>
                           
                        </tr>
                        <c:set var="doneLoop3" value="true" />
                     </c:when>
                     
                     <c:otherwise>
                        아직 예약 취소된 리스트가 없습니다.
                        <c:set var="doneLoop3" value="true" />
                     </c:otherwise>
                  </c:choose>
               </c:if>
            </c:forEach>   
			
			 <form action="post">
            <c:forEach var="order" items="${todayResvList}" varStatus="status">
               <c:if test="${order.order_status eq 'cancel'}">
                  <tr>
                     <td>
                        <b> 
                                      <a href="restManageOrderDetail.ADM?order_num=${order.order_num }&mID=${order.mID }">
                                 ${order.order_num }
                              </a>
                                 </b>

                     </td>
                     <td>${order.mID}</td>
                     <td>${order.mEMAIL}</td>
                     <td>${order.resvDATE}</td>
                     <td>예약 취소</td>
                     <td>${order.totalMoney}원</td>
                  </tr>
               </c:if>
            </c:forEach>
         </form>
      </table>
			</div>
			</c:if>			
		
			 <c:if test="${todayResvList eq null}">
      <p>아직 예약한 메뉴내역이 없습니다.</p>
   </c:if>
 
			
		
	










</body>
</html>
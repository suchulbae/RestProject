<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.Calendar" %>
      
<%
Calendar cal = Calendar.getInstance();

String yearR = request.getParameter("year");//아래에서 입력한 2021
String monthR = request.getParameter("month");//아래에서 입력한 10

//값을 파라미터로 전송받지 않았을 때, 기본값(현재 시스템의 날짜. 만약 2022년 4월)
int year = cal.get(Calendar.YEAR);//현재 시스템의 날짜 //2022
int month = cal.get(Calendar.MONTH);//3이 드러감(why?Calendar의 월은 0부터 시작하므로)

if(yearR != null && monthR != null && !yearR.trim().equals("") && !monthR.trim().equals("")){
   year = Integer.parseInt(yearR);
   month = Integer.parseInt(monthR)-1;//★★★ 중요 : Calendar의 월은 0~11이므로 -1를 반드시 해줘야한다!!
   
}

//달력 시작 시점 지정, 세팅한 시점부터 값을 결정
cal.set(year, month, 1);//돌려주는 타입이 void()이므로 =으로 받을 필요가 없다!

//Calendar.DAY_OF_WEEK : 그 달의 시작일의 요일을 알 수 있다.(1~7 사이의 정수를 리턴 : 1:월 ~ 7:토)
int dayOfweek = cal.get(Calendar.DAY_OF_WEEK);//월의 시작일의 요일을 정수로 리턴(2022년 4월 1일 금요일이면 6을 리턴)

//달력 마지막 날 지정(예 : 30일 또는 31일 또는 2월달은 26/28 리턴함)
int lastday = cal.getActualMaximum(Calendar.DATE);//2022년 4월이라면 30을 리턴 

/* ------------------------------------------------------------------------------------------------------*/
//◀ 이전 버튼
int before_year = year;
int before_month = month;//★★★ 중요 : before_month값은 month(월 0~11)이므로 그대로 저장 
if(before_month == 0){// ◀ 이전 버튼 클릭하여 월이 0(=1월)이 되면
   before_year = before_year -1;//년도를 1감소
   before_month = 12;//12월로 
}

//▶ 다음 버튼
int after_year = year;
int after_month = month+2;//★★★ 중요 : after_month값은 month(월 0~11) -> 2를 더하여 월2~13으로 만들어 저장해야 함
if(after_month == 13){// ▶ 다음 버튼 클릭하여 월이 13이 되면
   after_year = after_year +1;//년도를 1증가
   after_month = 1;//1월로 
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script type="text/javascript">
function showPopupDay(year, month, day) {//'일 매출 합계' 팝업창
   //window.open("팝업주소", "팝업창 이름", "팝업창 설정");
   window.open("calendarDaySalesManage.ADM?year="+year+"&month="+(month+1)+"&day="+day, "일 매출 합계", "width=500, height=300, left=100, top=60");
}

function showPopupMonth(year, month) {//'월 매출 합계' 팝업창
   //window.open("팝업주소", "팝업창 이름", "팝업창 설정");
   window.open("calendarMonthSalesManage.ADM?year="+year+"&month="+(month+1), "월 매출 합계", "width=500, height=300, left=100, top=60");
}
</script>

<title>달려으로 매출 관리</title>

<link rel="stylesheet" href="assets/css/mealKitAdminForm.css"> 	

</head>
<body>

<table class="center">
<tr>
   <td>
   <th>
      <button type="button" onclick="location.href='calendarSalesManage.ADM?year=<%=before_year%>&month=<%=before_month%>'">◀</button>
      <%=year%>년<%=month+1%>월
      <button type="button" onclick="location.href='calendarSalesManage.ADM?year=<%=after_year%>&month=<%=after_month%>'">▶</button>
   </th>
   <td>
   </tr>
   </table>
   <table class="center">
   <tr>
      <th style="color:red">일</th>
      <th>월</th>
      <th>화</th>
      <th>수</th>
      <th>목</th>
      <th>금</th>
      <th style="color:blue">토</th>
   </tr>
   
   <tr>
      <%
      int count = 0;//한줄에 7칸씩 출력하기 위해 count변수 선언함
      //★★ 1일 출력되기 전에 빈칸 출력 
      //dayOfweek(일1 ~ 토7) : 월의 시작 요일을 정수로 리턴(2022년 4월 1일 금요일이면 6를 리턴)
      for(int i=1; i < dayOfweek ;i++){
         out.print("<td></td>");//빈칸 만들기 5번 실행됨 
         count++;//count가 5가 되면 반복문 끝 
      }
      
      //날짜를 출력 
      int day;//일
      for(day=1; day <= lastday ; day++){//lastday(월의 마지막날):4월이면 30
         count++;//빈칸(5)+30 = 35
      %>
         <td>
            <form name="f">
               <input type="button" value="<%=day%>" onclick="showPopupDay(<%=year%>,<%=month%>,<%=day%>);"style="width: 90%; height: 50px; font-weight: bold; font-size: 25px;">
               <input type="hidden" name="${year}">
               <input type="hidden" name="${month}">
               <input type="hidden" name="${day}">
            </form>
         </td>
      <%   
         //한 줄에 7칸씩 출력하기 위해 
         if(count%7 == 0 ){
            out.print("</tr><tr>");//</tr>로 줄 마무리하고 <tr>로 다시 새로운 줄 시작 
         }
      }//2번째 for문 끝
      %>
   </tr> <!-- 마지막 줄 마무리 -->
</table>

 <br>
 
<div style="text-align: center;"> <!-- 입력한 년과 월에 대해 달력 표시하기 위해서 '위쪽자바코드'에서 처리되어 다시 달력에 나타난다. -->
   <form action="calendarSalesManage.ADM" name="f" method="post">
      <div> <!-- 입력한 년과 월로 [검색]하여 달력이 표시되도록  -->
         <input type="text" name="year" placeholder="년(YYYY)을 입력하세요">년
         <input type="text" name="month" placeholder="월(MM)을 입력하세요.">월
         <input type="submit" value="검색">
      </div>
   </form>
</div>

<br>

<div>
   <form action="calendarSalesManage.ADM" name ="f" method="post">
      <div style="text-align: center;">
         <input type="button" value="월 매출 조회" onclick="showPopupMonth(<%=year%>,<%=month%>)" style="width: 15%; height: 50px; font-weight: bold; font-size: 25px;" />
      </div>
   </form>
</div>



</body>
</html>
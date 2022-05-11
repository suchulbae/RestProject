function setClock(){
    var dateInfo = new Date(); 
    var hour = modifyNumber(dateInfo.getHours());
    var min = modifyNumber(dateInfo.getMinutes());
    var sec = modifyNumber(dateInfo.getSeconds());
    var year = dateInfo.getFullYear();
    var month = dateInfo.getMonth()+1; //monthIndex를 반환해주기 때문에 1을 더해준다.
    var date = dateInfo.getDate();
    var day = dateInfo.getDay();
    var week = new Array('<span style="color:#de1951;">일요일</span>', '<span style="color:#819ca9;">월요일</span>', '<span style="color:#819ca9;">화요일</span>', '<span style="color:#819ca9;">수요일</span>',
   '<span style="color:#819ca9;">목요일</span>' , '<span style="color:#819ca9;">금요일</span>', '<span style="color:#5471d2;">토요일</span>');
   
    document.getElementById("date").innerHTML = year + "년 " + month + "월 " + date + "일 " + week[day];
    
    document.getElementById("time").innerHTML = hour + ":" + min  + ":" + sec;

        
    
}
function modifyNumber(time){
    if(parseInt(time)<10){
        return "0"+ time;
    }
    else
        return time;
}
window.onload = function(){
    setClock();
    setInterval(setClock,1000); //1초마다 setClock 함수 실행
}
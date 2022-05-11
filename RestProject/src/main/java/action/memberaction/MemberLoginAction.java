package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.memberSVC.MemberGradeService;
import svc.memberSVC.MemberLoginService;


import vo.ActionForward;
import vo.MemberDTO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		
		
		//dto 객체 생성
		
		//파라미터로 온 id 비번 저장할 dto 
		MemberDTO member= new MemberDTO();
		
		String mID =request.getParameter("mID");
		String mPW =request.getParameter("mPW");
	
		String remember =request.getParameter("remember");
		
		
		member.setmID(mID);//mID dto member에 저장
		member.setmPW(mPW); //mID DTO 에 저장
		
		
		//로그인 서비스 처리해줄 메서드 가진 매서드,객체 생성 
		MemberLoginService memberLoginService = new MemberLoginService();
		boolean isloginSuccess = memberLoginService.login(member); // boolean타입으로 전달 받음
		
		MemberDTO memberInfo = null;
		
		// if(!isloginSuccess){
		if(isloginSuccess == false) { // 로그인에 실패하면
			response.setContentType("text/html; charset=UTF-8"); // 응답할 타입
			
			// ★★ 주의 : jsp가 아니므로 직접 생성해야함
			PrintWriter out = response.getWriter(); // 화면에 출력 (자바이기 때문에 직접 출력 스트림을 생성해줘야함)
			
			out.println("<script>");
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')"); // 경고창을 띄우고
			out.println("location.href ='memberLogin.RC'"); // 다시 '로그인 폼보기'요청을 함
			out.println("</script>");
			
		}else { // 로그인에 성공하면 
			// 회원의 정보를 가져옴
			memberInfo = memberLoginService.getMemberInfo(mID);
			
			if(memberInfo == null) { // 멤버 정보로 계정 유효성 검사 정보가 없을시 비회원
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('존재하지 않는 계정입니다..')");
				out.println("location.href='memberLogin.RC'");
				out.println("</script>");
			}else {//둘다 아닐경우 즉 회원이면
				//쿠키에 정보 저장
				Cookie cookie= new Cookie("mID",mID);
				System.out.println("쿠키 객체 생성");
				
				if(remember !=null) {//아이디 저장체크
					response.addCookie(cookie);//쿠키 생성
				}else {
					cookie.setMaxAge(0);//체크안했을경우 쿠키 없애기
					
					response.addCookie(cookie);
				}
				
				
				
				
				memberInfo= MemberGradeService.updateGrade(memberInfo);
				HttpSession session = request.getSession();
				session.setAttribute("mID", mID);// 세션에 저장
				session.setAttribute("mPW", mPW);//세션에 저장
				
				
				
				//session영역에 추가하는 이유? 향후 등급을 보고 세일정도를 결정하므로
				
				session.setAttribute("mGRADE",memberInfo.getmGRADE()); // 등급 저장
				session.setAttribute("mNAME",memberInfo.getmNAME() );//이름 저장
				session.setAttribute("mEMAIL",memberInfo.getmEMAIL() ); // 이메일 저장
				
				
				
				
				session.setMaxInactiveInterval(1*60*60);//세션수명시간 추후 결정가능
				
				//세션에 저장된 정보 포워딩
				forward = new ActionForward("memberMain.jsp",true);
				
				
				
			}
		
		}
		
		
		
		
		
		
		return forward;
	}

}
package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.memberSVC.MemberDELETEservice;
import vo.ActionForward;
import vo.MemberDELETE;
import vo.MemberDTO;

public class MemberDELETEAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String mID =request.getParameter("mID");
		
		String mPW =request.getParameter("mPW");
		
	
	
		
		MemberDELETE delete= new MemberDELETE(mID,mPW); //dto 로 전달 저장후 추후 dao에서 서버요청처리
		
		
		//비즈니스 로직 생성
		MemberDELETEservice memberDELETEservice = new MemberDELETEservice();
		boolean isDELETEsuccess = memberDELETEservice.deleteMember(delete); //메서드 실행후 결과값으로판단
		
		if(isDELETEsuccess== false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('삭제를 실패했습니다. 다시 시도해주세요');");
			out.println("history.back();");
			out.println("</script>");
			
		}else {
		HttpSession session = request.getSession();
			
		
			session.removeAttribute("mID");
			session.removeAttribute("mPW");
			session.removeAttribute("mGRADE");
			session.removeAttribute("mNAME");
			
			session.removeAttribute("totalMoney");
			
			session.removeAttribute("cartList");
			session.removeAttribute("saleTotalMoney");
			session.removeAttribute("latestOrder");
			
			String cookieId = "";
			Cookie cookie = new Cookie("mID", cookieId);
			cookie.setMaxAge(0);
		
			response.addCookie(cookie);
			
			response.setContentType("text/html;charset=utf-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('회원 탈되에 성공했습니다. 그동안 감사했습니다.');");
	         out.println("location.href ='memberMain.jsp';");
	         out.println("</script>");
			
		}






return forward;
}



}

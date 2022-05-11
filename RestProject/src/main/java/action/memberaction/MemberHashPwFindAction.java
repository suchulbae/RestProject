package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.memberSVC.MemberHashPwFindService;
import util.SHA256;
import vo.ActionForward;
import vo.MemberDTO;

public class MemberHashPwFindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null; 
		
		
		String mID=request.getParameter("mID");
		String mEMAIL=request.getParameter("mEMAIL");
		
		MemberHashPwFindService memberHashPwFindService = new MemberHashPwFindService(); 
		MemberDTO memberInfo = memberHashPwFindService.findHashPw(mID, mEMAIL);
		
		if(memberInfo==null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 또는 이메일정보가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			String random_password = SHA256.getRandomPassword(8);// 8자리 랜덤 임시 비밀번호를 생성하여
			System.out.println("random_password : " + random_password);
		
			boolean isSetHashPwSuccess = memberHashPwFindService.setHashPw(mID, mEMAIL,random_password);
			if(isSetHashPwSuccess == false){
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 또는 이메일정보가 일치하지 않습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}else {
				request.setAttribute("mID", mID);
				request.setAttribute("random_password", random_password);
				
				request.setAttribute("showPage", "member/findHashPwComplete.jsp");
				forward = new ActionForward("memberTemplate.jsp", false); // 디스패치 방식으로 보냄
			}
			
		}
		
		
		
		
		return forward;
	}

}

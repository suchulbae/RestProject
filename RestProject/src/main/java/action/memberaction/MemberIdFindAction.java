package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.memberSVC.MemberIdFindService;
import vo.ActionForward;
import vo.MemberDTO;


public class MemberIdFindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		
		
		//이메일로 비교
		String mEMAIL =request.getParameter("mEMAIL");// mEMAIL로 받아서 서비스로 전달후
		MemberIdFindService memberIdFindService =new MemberIdFindService(); //DAO에서요청 하기위한 서비스
		
		MemberDTO memberInfo = memberIdFindService.findId(mEMAIL);
		
		if(memberInfo == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('존재하지 않는 계정입니다.');");
			out.println("history.back();");
			out.println("</script>");
			
		}else{ //성공시
			String mID = memberInfo.getmID();
			request.setAttribute("mID", mID);
			request.setAttribute("showPage", "member/findIdComplete.jsp");
			
			forward = new ActionForward("memberTemplate.jsp", false); // 최종적인 이동경로
		}
		
		return forward;
	}

}

package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.memberSVC.MemberViewService;
import vo.ActionForward;
import vo.Address;
import vo.MemberDTO;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward=null;
		/*
		 *  세션 속성에 저장된  id로 로그인 확인
		 */
		HttpSession session = request.getSession();
		String viewId= (String) session.getAttribute("mID");
		
		if(viewId == null) { //  세션에 id 가없는상태
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.');"); 
			out.println("location.href ='memberLogin.RC'");
			out.println("</script>");
			
		}else {
			
			MemberViewService memberViewService = new MemberViewService();
			MemberDTO memberInfo = memberViewService.getMemberInfo(viewId);//getMemberInfo(viewId);메서드 실행한값을 memberInfo에
			Address memberAddrInfo = memberViewService.getAddressInfo(viewId);
			
			
			request.setAttribute("member",memberInfo);
			request.setAttribute("addr", memberAddrInfo);
			request.setAttribute("showPage", "member/memberView.jsp");
			
			forward = new ActionForward("memberViewTemplate.jsp", false);
			
			
			
		}
		
		
		
		
		
		return forward;
	}

}

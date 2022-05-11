package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.memberSVC.MemberJoinService;
import vo.ActionForward;
import vo.Address;
import vo.MemberDTO;

public class MemberJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
		String mID =request.getParameter("mID");
		String mGRADE=request.getParameter("mGRADE");
		String mPW =request.getParameter("mPW");
		String mNAME =request.getParameter("mNAME");
		String mEMAIL =request.getParameter("mEMAIL");
		String mPHONE =request.getParameter("mPHONE");
		
		
	
		
		
		int postcode = Integer.parseInt(request.getParameter("postcode")); // ★ 우편번호는 int타입
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		System.out.println("[JoinAction]");
		
		System.out.println("mID : " + mID);  //확인용
		
		
		MemberDTO member = new MemberDTO(mID,mGRADE,mPW,mNAME,mEMAIL,mPHONE);
		Address addr = new Address(mID, postcode, address1, address2);
		
		MemberJoinService memberJoinService  = new MemberJoinService();
		boolean isJoinSuccess = memberJoinService .join(member,addr);
		
		
				if(isJoinSuccess == false) {
					
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					
					out.println("<script>");
					out.println("alert('회원등록을 실패했습니다. 다시 시도해주세요');");
					out.println("history.back();");
					out.println("</script>");
					
				}else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					
					out.println("<script>");
					out.println("alert('회원등록을 성공했습니다. 반갑습니다!');");
					
					out.println("</script>");
					
					forward = new ActionForward("memberLogin.RC", true); // [방법2] 리다이렉트 방식으로 포워딩(DB를 수정했기 때문)
				}
		
		
		

		
		
		return forward;
	}



}

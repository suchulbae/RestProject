package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.memberSVC.MemberUpdateService;
import vo.ActionForward;
import vo.Address;
import vo.MemberDTO;

public class memberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		// 요청값 받기
		String mID = request.getParameter("mID");
		String mNAME = request.getParameter("mNAME");
		String mEMAIL = request.getParameter("mEMAIL");
		String mPHONE = request.getParameter("mPHONE");

		int postcode = Integer.parseInt(request.getParameter("postcode"));
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");

		/// 변수에 담은값 dto 로
		
		
		MemberDTO member= new MemberDTO();
		member.setmID(mID);
		member.setmNAME(mNAME);
		member.setmEMAIL(mEMAIL);
		member.setmPHONE(mPHONE);
		
		Address addr= new Address(mID, postcode, address1, address2); 
		
		MemberUpdateService memberUpdateService = new MemberUpdateService();
		boolean memberUpdateSuccess = memberUpdateService.memberUpdate(member,addr);
		
		
		if(memberUpdateSuccess== false) {
			
		     response.setContentType("text/html;charset=utf-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('회원정보 수정에 실패 했습니다 .');");
	         out.println("history.back();");
	         out.println("</script>");
	         
	      }else{
	    	   HttpSession session=request.getSession();
		         session.setAttribute("mNAME", mNAME);
		         
		         request.setAttribute("mNAME", mNAME);
		         
		         request.setAttribute("showPage", "member/memberUpdateComplete.jsp");
		         forward=new ActionForward("memberTemplate.jsp",false);
	    	  
	    	  
	    	  
	    	  
	      }
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		return forward;
	}

}

package action.memberaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

import svc.memberSVC.MemberHashPwChangeService;
import vo.ActionForward;
import vo.MemberPwChange;


public class MemberHashPwChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward =null;
		
		//받은요청 불러오기
		String mID = request.getParameter("mID");//사용자에게 요청된 아이디
		String pre_password = request.getParameter("pre_password");// 이전 비밀번호와
		String new_password = request.getParameter("new_password");// 새 비밀번호를 얻어와
		
		
		MemberPwChange memberPwChange = new MemberPwChange(mID, pre_password, new_password);
		
		MemberHashPwChangeService memberHashPwChangeService = new MemberHashPwChangeService ();
		boolean isChangePwSuccess = memberHashPwChangeService.changePw(memberPwChange);
		
		if(isChangePwSuccess == false) {
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();//화면에 출력(★★주의 : jsp가 아니므로 직접 생성해야함 )
			out.println("<script>");
			out.println("alert('비밀번호 변경에 실패했습니다. 다시 시도해주세요.')");
			out.println("history.back()");//다시 '로그인 폼보기' 요청
			out.println("</script>");
		}else {
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();//화면에 출력(★★주의 : jsp가 아니므로 직접 생성해야함 )
			out.println("<script>");
			out.println("alert('비밀번호 변경에 성공했습니다. 다시 로그인해 주세요.')");
			out.println("location.href='memberLogin.RC';");//[요청방법-1] 팝업창 뜨면서 이동됨!!(<=이방법 권장!!)
			out.println("</script>");
		}
		
		
		
		
		
		
		
		
		
		
		return forward;
	}

}

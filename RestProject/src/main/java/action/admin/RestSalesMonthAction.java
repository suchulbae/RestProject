package action.admin;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.admin.MonthResvSalesService;
import vo.ActionForward;

public class RestSalesMonthAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String y = request.getParameter("year");
		System.out.println("year:" + y);

		String m = request.getParameter("month");
		System.out.println("month:" + m);
		
		
		
		String resvMonth= null;
		
		if(m.length() == 1) {
			resvMonth = y + "-0"+ m;
		}else {
			resvMonth = y + "-" + m;
		}
		
		MonthResvSalesService monthResvSalesService =  new MonthResvSalesService ();
		
		
		int resvMonthTotalMoney =  monthResvSalesService.getresvMonthTotalMoney(resvMonth);
		
		

		if (resvMonthTotalMoney == -1) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보를 불러오는데 실패했습니다. 다시 시도해주세요.');");
			out.println("history.back()';");
			out.println("</script>");

		} else {
			HttpSession session = request.getSession();
			
			//월매출 보내기
			session.setAttribute("resvMonth", resvMonth);
			session.setAttribute("resvMonthTotalMoney", resvMonthTotalMoney);
				
				
			forward = new ActionForward("adminDashBoard.jsp", false);
		}

		return forward;
		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}

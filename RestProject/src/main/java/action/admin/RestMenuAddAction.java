package action.admin;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.admin.ResvMenuAddService;
import svc.reservation.ReservationViewService;
import vo.ActionForward;
import vo.reservationDTO.ResvMenuDTO;

public class RestMenuAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int maxSize = 1024 * 1024 * 5;

		String uploadFolder = "/images";
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath(uploadFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		// 요청받은 제품의 상세정보 받아서 기존에 있는거인지 판단

		String menuID = multi.getParameter("menuID");
		ReservationViewService reservationViewService = new ReservationViewService();
		ResvMenuDTO resvCheckMenu = reservationViewService.getResvMenuView(menuID);

		String category = multi.getParameter("category");
		String menuNAME = multi.getParameter("menuNAME");

		int resvPRICE = Integer.parseInt(multi.getParameter("resvPRICE"));

		String menuDETAIL = multi.getParameter("menuDETAIL");
		String m_status = multi.getParameter("m_status");

		String image = multi.getOriginalFileName("image");

		if (resvCheckMenu == null) { // 셀렉트했을때 없다면
			// dto에 담은담 서비스로 dao에 넣으면 아주간단

			ResvMenuDTO newResvMenu = new ResvMenuDTO(menuID, category, menuNAME, menuDETAIL, m_status, resvPRICE,
					image);
			ResvMenuAddService resvMenuAddService = new ResvMenuAddService();
			boolean isAddResvMenuSuccess = resvMenuAddService.addResvMenu(newResvMenu);

			if (isAddResvMenuSuccess) {
				if (category.equals("Course")) {
					forward = new ActionForward("reservationMenuList.RSV", true);

				} else if (category.equals("PREMIUMSIDES")) {
					forward = new ActionForward("reservationMenuListB.RSV", true);
				} else if (category.equals("SALAD")) {
					forward = new ActionForward("reservationMenuListC.RSV", true);
				}
			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('메뉴 등록이 실패했습니다.')");
				out.println("history.back();");
				out.println("</script>");

			}

		} else {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록하려는 메뉴가 이미 존재합니다.')");
			out.println("history.back();"); //
			out.println("</script>");
		}

		return forward;
	}

}

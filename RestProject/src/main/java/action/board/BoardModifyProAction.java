package action.board;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.memboard.BoardModifyProService;
import vo.ActionForward;
import vo.boardDTO.BoardDTO;

public class BoardModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		//유효성 검사
		if (request.getParameter("boardRating")== null || request.getParameter("BOARD_CONTENT")== null || 	request.getParameter("BOARD_SUBJECT")==null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정하시려는 부분을 채워주세요');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			int board_num=Integer.parseInt(request.getParameter("BOARD_NUM"));
	
		int boardRating= Integer.parseInt(request.getParameter("boardRating"));
		
		
	
		
		
		
		System.out.println(boardRating);
		BoardDTO article=new BoardDTO();
		
		BoardModifyProService boardModifyProService = new BoardModifyProService();
		boolean isRightUser=boardModifyProService.isArticleWriter(board_num, request.getParameter("BOARD_PASS"));
		
		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('글목록 비밀번호를 확인해주세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setBOARD_NUM(board_num);
			article.setBOARD_SUBJECT(request.getParameter("BOARD_SUBJECT"));
			article.setBOARD_CONTENT(request.getParameter("BOARD_CONTENT")); 
			article.setboardRating(Integer.parseInt(request.getParameter("boardRating")));
			isModifySuccess = boardModifyProService.modifyArticle(article);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정에 실패 하셨습니다 ');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardDetail.RC?board_num="+article.getBOARD_NUM()); 
			}

		}
		}
		return forward;
	}

}
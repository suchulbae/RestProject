package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.memboard.BoardDetailService;
import vo.ActionForward;
import vo.boardDTO.BoardDTO;


public class BoardReplyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 	ActionForward forward = new ActionForward();
	   		String nowPage = request.getParameter("page");
	   		int board_num=Integer.parseInt(request.getParameter("board_num"));
	   		BoardDetailService boardDetailService = new BoardDetailService();
	   		BoardDTO article=boardDetailService.getArticle(board_num);	
	   		request.setAttribute("article", article);
	   		request.setAttribute("page", nowPage);
	   		forward.setPath("/board/qna_board_reply.jsp");
	   		return forward;
	   		
	}
	 
}
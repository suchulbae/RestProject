package action.board;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.memboard.BoardListService;
import vo.ActionForward;
import vo.boardDTO.BoardDTO;
import vo.boardDTO.PageInfo;


 public class BoardListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<BoardDTO> articleList=new ArrayList<BoardDTO>();
	  	int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService boardListService = new BoardListService();
		int listCount=boardListService.getListCount(); 
		articleList = boardListService.getArticleList(page,limit); 
		
   		int maxPage=(int)((double)listCount/limit+0.95); // 최대 페이지
   		
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;
   		
   		
   		
   		///  페이지 바꿀때 사용되는 부분
   		PageInfo pageInfo = new PageInfo();
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward= new ActionForward();
   		forward.setPath("/board/qna_board_list.jsp");
   		return forward;
   		
	 }
	 
 }
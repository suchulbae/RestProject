package action.board;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;

import svc.memboard.BoardWriteService;
import vo.ActionForward;
import vo.boardDTO.BoardDTO;


public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward=null;
		
	
		
		ServletContext context = request.getServletContext();
		String saveFolder="/boardUpload";
		String realFolder=context.getRealPath(saveFolder);
		
		int fileSize=5*1024*1024;
		

		realFolder=context.getRealPath(saveFolder);   		
		MultipartRequest multi=new MultipartRequest(request,
				realFolder,
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
	
		
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBOARD_NAME(multi.getParameter("BOARD_NAME"));
		boardDTO.setBOARD_PASS(multi.getParameter("BOARD_PASS"));
		boardDTO.setBOARD_SUBJECT(multi.getParameter("BOARD_SUBJECT"));
		boardDTO.setBOARD_CONTENT(multi.getParameter("BOARD_CONTENT"));
		boardDTO.setBOARD_FILE(
		multi.getFilesystemName("BOARD_FILE"));
		boardDTO.setboardRating(Integer.parseInt(multi.getParameter("boardRating")));
	
		BoardWriteService boardWriteProService = new BoardWriteService();
		boolean isWriteSuccess = boardWriteProService.registArticle(boardDTO);

		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('잘못입력하셨습니다 다시입력해주세요')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.RC");
		}

		return forward;
		
		
	}

}

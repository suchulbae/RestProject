package svc.memboard;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.boardDAO.BoardDAO;
import vo.boardDTO.BoardDTO;


public class BoardReplyProService {

	public boolean replyArticle(BoardDTO article) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		insertCount = boardDAO.insertReplyArticle(article);
		
		if(insertCount > 0){
			commit(con);
			isReplySuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isReplySuccess;
		
	}

}

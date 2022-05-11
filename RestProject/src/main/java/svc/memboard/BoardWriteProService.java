package svc.memboard;

import java.sql.Connection;

import dao.boardDAO.BoardDAO;
import vo.boardDTO.BoardDTO;

import static db.JdbcUtil.*;
public class BoardWriteProService {

	public boolean registArticle(BoardDTO BoardDTO) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(BoardDTO);
		
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

}

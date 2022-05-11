package svc.memboard;

import java.sql.Connection;

import dao.boardDAO.BoardDAO;
import vo.boardDTO.BoardDTO;

import static db.JdbcUtil.*;

public class BoardDetailService {

	public BoardDTO getArticle(int board_num) throws Exception{
		// TODO Auto-generated method stub
		
		BoardDTO article = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int updateCount = boardDAO.updateReadCount(board_num);
		
		if(updateCount > 0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		article = boardDAO.selectArticle(board_num);
		close(con);
		return article;
		
	}

}

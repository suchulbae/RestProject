package svc.memboard;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.boardDAO.BoardDAO;
import vo.boardDTO.BoardDTO;


public class BoardListService {

	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		listCount = boardDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<BoardDTO> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<BoardDTO> articleList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		articleList = boardDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}

}

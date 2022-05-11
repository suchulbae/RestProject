package dao.boardDAO;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import vo.boardDTO.BoardDTO;


public class BoardDAO {

	DataSource ds;
	Connection con;
	private static BoardDAO boardDAO;

	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDAO getInstance(){
		if(boardDAO == null){
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}

	
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{


			System.out.println("getConnection");
			pstmt=con.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println("getListCount 오류: " + e);			
		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	//�� ��� ����.	
	public ArrayList<BoardDTO> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_list_sql="select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc limit ?,10";
		ArrayList<BoardDTO> articleList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		int startrow=(page-1)*10; 

		try{
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();

			while(rs.next()){
				board = new BoardDTO();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				board.setboardRating(rs.getInt("boardRating"));
				articleList.add(board);
			}

		}catch(Exception e){
			System.out.println("getBoardList 오류 : " + e);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}

	//�� ���� ����.
	public BoardDTO selectArticle(int board_num){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO BoardDTO = null;

		try{
			pstmt = con.prepareStatement(
					"select * from board where BOARD_NUM = ?");
			pstmt.setInt(1, board_num);
			rs= pstmt.executeQuery();

			if(rs.next()){
				BoardDTO = new BoardDTO();
				BoardDTO.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				BoardDTO.setBOARD_NAME(rs.getString("BOARD_NAME"));
				BoardDTO.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				BoardDTO.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				BoardDTO.setBOARD_FILE(rs.getString("BOARD_FILE"));
				BoardDTO.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				BoardDTO.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				BoardDTO.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				BoardDTO.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				BoardDTO.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				BoardDTO.setboardRating(rs.getInt("boardRating"));
			}
		}catch(Exception e){
			System.out.println("getDetail 오류: " + e);
		}finally{
			close(rs);
			close(pstmt);
		}

		return BoardDTO;

	}


	public int insertArticle(BoardDTO article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num =0;
		String sql="";
		int insertCount=0;

		try{
			pstmt=con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;

			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,"+
					"BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,"+
					"BOARD_DATE,boardRating) values(?,?,?,?,?,?,?,?,?,?,now(),?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, article.getBOARD_FILE());
			pstmt.setInt(7, num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, article.getboardRating());

			insertCount=pstmt.executeUpdate();

		}catch(Exception e){
			System.out.println("boardInsert 오류 : "+e);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	//글답변
	public int insertReplyArticle(BoardDTO article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_max_sql="select max(board_num) from board";
		String sql="";
		int num=0;
		int insertCount=0;
		int re_ref=article.getBOARD_RE_REF();
		int re_lev=article.getBOARD_RE_LEV();
		int re_seq=article.getBOARD_RE_SEQ();

		try{
			pstmt=con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())num =rs.getInt(1)+1;
			else num=1;
			sql="update board set BOARD_RE_SEQ=BOARD_RE_SEQ+1 where BOARD_RE_REF=? ";
			sql+="and BOARD_RE_SEQ>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			int updateCount=pstmt.executeUpdate();

			if(updateCount > 0){
				commit(con);
			}

			re_seq = re_seq + 1;
			re_lev = re_lev+1;
			sql="insert into board (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,";
			sql+="BOARD_CONTENT, BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,";
			sql+="BOARD_READCOUNT,BOARD_DATE) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getBOARD_NAME());
			pstmt.setString(3, article.getBOARD_PASS());
			pstmt.setString(4, article.getBOARD_SUBJECT());
			pstmt.setString(5, article.getBOARD_CONTENT());
			pstmt.setString(6, ""); 
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0);
			insertCount = pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			close(rs);
			close(pstmt);
			
		}

		return insertCount;

	}

	//글수정
	public int updateArticle(BoardDTO article){
		System.out.println(article.getBOARD_SUBJECT());
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql="update board set BOARD_SUBJECT=?,BOARD_CONTENT=?,boardRating=? where BOARD_NUM=?";

		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getBOARD_SUBJECT());
			pstmt.setString(2, article.getBOARD_CONTENT());
			pstmt.setInt(3, article.getboardRating());
			pstmt.setInt(4, article.getBOARD_NUM());
		
		
	
			
			updateCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("boardModify : " + e);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}

	//글삭제
	public int deleteArticle(int board_num){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from board where BOARD_num=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, board_num);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("boardDelete 오류: "+e);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}

	public int updateReadCount(int board_num){

		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql="update board set BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 where BOARD_NUM = "+board_num;

		try{
			pstmt=con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("setReadCountUpdate 오류 : "+e);
		}
		finally{
			close(pstmt);

		}

		return updateCount;

	}

	//글쓴이 확인
	public boolean isArticleBoardWriter(int board_num,String pass){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String board_sql="select * from board where BOARD_NUM=?";
		boolean isWriter = false;

		try{
			pstmt=con.prepareStatement(board_sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			rs.next();

			if(pass.equals(rs.getString("BOARD_PASS"))){
				isWriter = true;
			}
		}catch(SQLException e){
			System.out.println("isBoardWriter  : "+e);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}

}

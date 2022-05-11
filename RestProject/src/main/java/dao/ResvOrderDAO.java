package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import vo.reservationDTO.ResvOrder;

public class ResvOrderDAO {
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ResvOrderDAO() {}

	private static ResvOrderDAO resvOrderDAO;

	public static ResvOrderDAO getInstance() {
		if (resvOrderDAO == null) {
			resvOrderDAO = new ResvOrderDAO();
		}

		return resvOrderDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}


	
	public ResvOrder selectLatestResvOrder(String mID) {
		ResvOrder latestResvOrder = null;
		
		String sql ="SELECT * FROM ReservationOrder_table WHERE mID=? ORDER BY resvORDERDATE DESC LIMIT 1";
		
		
		try {
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mID);
	
			rs = pstmt.executeQuery();

			
			if(rs.next()) {
				
				latestResvOrder = new ResvOrder(rs.getInt("order_num"),rs.getString("mID"),
						rs.getString("mEMAIL"),rs.getTimestamp("resvORDERDATE"),rs.getString("order_status"),rs.getInt("totalmoney"),rs.getString("resvDATE"));
				
				
			}
			
			
			
		}catch(Exception e){
			System.out.println("ResvOrderDAO 안에 selectLatestResvOrder 에러: " + e);
			
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return latestResvOrder;
	}
	
	
	
	
	
	
}

package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.reservationDTO.ResvMenuDTO;
import vo.reservationDTO.ResvOrder;
import vo.reservationDTO.ResvOrderDetail;

public class AdminDAO {
	private Connection con;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private AdminDAO() {
	}

	private static AdminDAO adminDAO;// 반드시 static이여야 한다.

	public static AdminDAO getInstance() {
		if (adminDAO == null) {// 없을때 생성
			adminDAO = new AdminDAO();
		}

		return adminDAO;// 기존 memberDAO리턴
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertNewResvMenu(ResvMenuDTO newResvMenu) {
		int insertNewResvMenuCount = 0;

		String sql = "INSERT INTO RESERVATION_MENU VALUES(?, ?, ?, ?, ?, ?, NOW(), ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newResvMenu.getMenuID());
			pstmt.setString(2, newResvMenu.getCategory());
			pstmt.setString(3, newResvMenu.getMenuNAME());

			pstmt.setString(4, newResvMenu.getMenuDETAIL());
			pstmt.setString(5, newResvMenu.getM_status());
			pstmt.setInt(6, newResvMenu.getResvPRICE());

			pstmt.setString(7, newResvMenu.getImage());

			insertNewResvMenuCount = pstmt.executeUpdate();

		} catch (Exception e) {

			System.out.println("admin dao 에 insertNewResvMenu 에러" + e);

		} finally {

			close(pstmt);
		}

		return insertNewResvMenuCount;
	}

	public ArrayList<ResvOrder> selectTodayOrder(String today) {
		ArrayList<ResvOrder> todayResvList = null;

		// 예약 최신순
		String sql = "SELECT * FROM ReservationOrder_table WHERE DATE(resvORDERDATE)=? ORDER BY resvORDERDATE DESC";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, today);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				todayResvList = new ArrayList<ResvOrder>();

				do {
					todayResvList.add(new ResvOrder(rs.getInt("order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
							rs.getTimestamp("resvORDERDATE"), rs.getString("order_status"), rs.getInt("totalMoney"),
							rs.getString("resvDATE")));
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("selectTodayOrder 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return todayResvList;
	}

	public ArrayList<ResvOrderDetail> selectOrderDetail(int order_num) {

		ArrayList<ResvOrderDetail> resvOrderDetail = null;

		String sql = "SELECT * FROM ResOrderDetail_table WHERE order_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				resvOrderDetail = new ArrayList<ResvOrderDetail>();

				do {
					resvOrderDetail.add(new ResvOrderDetail(rs.getInt("datail_index"), rs.getString("menuID"),
							rs.getInt("order_num"), rs.getInt("quantity"), rs.getString("menuNAME"),
							rs.getInt("resvPRICE"), rs.getString("resvDATE")));
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("selectOrderDetailList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return resvOrderDetail;
	}

	public int resvOrderGet(int order_num) {
		int updateOrderGetCount = 0;
		String sql = "update ReservationOrder_table set order_status='get' where order_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			updateOrderGetCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateOrderGet 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return updateOrderGetCount;
	}

	public int resvOrderCancel(int order_num) {
		int updateOrderCancelCount = 0;

		String sql = "update ReservationOrder_table set order_status='cancel' where order_num=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			updateOrderCancelCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateOrderCancel 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return updateOrderCancelCount;

	}

	public int selectMonthTotalMoney(String resvMonth) {
		int resvMonthTotalMoney = -1;

		String sql = "select sum(totalMoney) as monthSalesTotalMoney from ReservationOrder_table where order_date like ? and order_status='get'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, resvMonth + "%");

			rs = pstmt.executeQuery();

			if (rs.next()) {
				resvMonthTotalMoney = rs.getInt("monthSalesTotalMoney");
				resvMonthTotalMoney = rs.getInt("TotalMoney");

			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		return resvMonthTotalMoney;
	}

	public ArrayList<ResvOrder> selectResvMonth() {
		ArrayList<ResvOrder> resvMonthView = null;
		// 일매출 조회
		String sql = "SELECT *  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate() and order_status='get' group by resvDATE";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resvMonthView = new ArrayList<ResvOrder>();
				do {
					resvMonthView.add(new ResvOrder(rs.getInt("order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
							rs.getDate("resvORDERDATE"), rs.getInt("totalMoney"), rs.getString("resvDATE")

					));
				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("adminDAO 오류 selectResvMonth" + e);
		}

		return resvMonthView;
	}

	public ArrayList<ResvOrder> getMonthTotal() {
		ArrayList<ResvOrder> resvTotalview = null;
		// 주간 매출 조회
		String sql = "SELECT * FROM ReservationOrder_table WHERE order_status='get'and  resvDATE BETWEEN DATE_ADD(NOW(),INTERVAL -1 WEEK  ) AND NOW()";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				resvTotalview = new ArrayList<ResvOrder>();
				do {
					resvTotalview.add(new ResvOrder(rs.getInt("order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
							rs.getDate("resvORDERDATE"), rs.getInt("totalMoney"), rs.getString("resvDATE")

					));
				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("adminDAO 오류 selectResvMonth" + e);
		}

		return resvTotalview;
	}
	/* ------------------------------- [매출조회] ------------------------------- */

	public int selectDaySalesTotalMoney(String meal_order_date) {
		int daySalesTotalMoney = -1;

		String sql = "SELECT sum(meal_totalMoney) as daySalesTotalMoney from meal_order_table where date(meal_order_date)=? and meal_order_status='get'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, meal_order_date);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				daySalesTotalMoney = rs.getInt("daySalesTotalMoney");

			}
		} catch (Exception e) {
			System.out.println("daySalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		return daySalesTotalMoney;
	}

	// 월 매출관리
	public int selectMonthSalesTotalMoney(String order_month) {
		int monthSalesTotalMoney = -1; // '일 총매출이'이 0이 될 수 있으므로 (-1로 초기화하여 -1을 리턴받으면 실패로 간주하기 위해서...)

		String sql = "select sum(meal_totalmoney) as monthSalesTotalMoney from meal_order_table where meal_order_date like ? and meal_order_status='get'";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, order_month + "%");// '2022-04%', '2022-12%'

			rs = pstmt.executeQuery();

			if (rs.next()) {
				monthSalesTotalMoney = rs.getInt("monthSalesTotalMoney");// 반드시 별칭 사용
				// monthSalesTotalMoney = rs.getInt("TotalMoney");// 오류(사용하고 싶다면 sql문의 별칭 삭제)

			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		return monthSalesTotalMoney;
	}

	public int getminusdayMoney() {
		int minusdayMoney = 0;
		String sql = "SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-1 and order_status='get'";
	

		try {
			pstmt = con.prepareStatement(sql);
		

			rs = pstmt.executeQuery();

			if (rs.next()) {
				 minusdayMoney = rs.getInt("minusTotalMoney");
			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		
		return minusdayMoney;
	}

	public int getminusdayMoney2() {
		int minusdayMoney2 = 0;
		String sql = "SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-2 and order_status='get'";
	

		try {
			pstmt = con.prepareStatement(sql);
		

			rs = pstmt.executeQuery();

			if (rs.next()) {
				 minusdayMoney2 = rs.getInt("minusTotalMoney");
			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		
		return minusdayMoney2;
	}

	public int getminusdayMoney3() {
		int minusdayMoney3 = 0;
		String sql = "SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-3 and order_status='get'";
	

		try {
			pstmt = con.prepareStatement(sql);
		

			rs = pstmt.executeQuery();

			if (rs.next()) {
				 minusdayMoney3 = rs.getInt("minusTotalMoney");
			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		
		return minusdayMoney3;
	}

	public int getminusdayMoney4() {
		int minusdayMoney4 = 0;
		String sql = "SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-4 and order_status='get'";
	

		try {
			pstmt = con.prepareStatement(sql);
		

			rs = pstmt.executeQuery();

			if (rs.next()) {
				 minusdayMoney4 = rs.getInt("minusTotalMoney");
			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		
		return minusdayMoney4;
	}

	public int getminusdayMoney5() {
		int minusdayMoney5 = 0;
		String sql = "SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-5 and order_status='get'";
	

		try {
			pstmt = con.prepareStatement(sql);
		

			rs = pstmt.executeQuery();

			if (rs.next()) {
				 minusdayMoney5 = rs.getInt("minusTotalMoney");
			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		
		return minusdayMoney5;
	}

	public int getminusdayMoney6() {
		int minusdayMoney6 = 0;
		String sql = "SELECT sum(totalMoney) as minusTotalMoney  FROM ReservationOrder_table WHERE  DATE(resvDATE)=curdate()-6 and order_status='get'";
	

		try {
			pstmt = con.prepareStatement(sql);
		

			rs = pstmt.executeQuery();

			if (rs.next()) {
				 minusdayMoney6 = rs.getInt("minusTotalMoney");
			}
		} catch (Exception e) {
			System.out.println("selectMonthSalesTotalMoney 에러: " + e);
		} finally {
			close(pstmt);
		}

		
		return minusdayMoney6;
	}
}

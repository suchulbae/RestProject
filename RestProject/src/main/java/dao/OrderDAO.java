package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.Order;
import vo.OrderDetail;

public class OrderDAO {
	// 멤버변수 (전역변수 : 전체 메서드에서 사용이 가능)
	Connection con = null;// private Connection con = null; 생략가능
	PreparedStatement pstmt = null;// private PreparedStatement pstmt = null; 생략가능
	ResultSet rs = null;// private ResultSet rs = null; 생략가능

	/********************* 싱글톤(=singleton) 생성방법 시작 *********************/

	/**
	 * 싱글톤(=singleton) 생성방법 시작 싱글톤(=singleton): OrderDAO객체 단 1개만 생성 이유: 외부 클래스에서
	 * "처음생성된 OrderDAO객체를 공유해서 사용하도록 하기 위해서" 이다.
	 */

	/**
	 * 1.생성자는 무조건 private : 외부 클래스에서 생성자를 호출 불가하여 직접적으로 객체 생성 불가능
	 */
	private OrderDAO() {
	}

	private static OrderDAO orderDAO;// 2.반드시 static이여야 한다.

	/**
	 * 2.메서드가 static인 이유? 객체 생성하기 전에 이미 메모리에 올라간 getInstance()메서드를 통해서만 OrderDAO객체를
	 * 1개만 만들수 있도록 하기 위해서
	 */

	public static OrderDAO getInstance() {// 1.static이면
		if (orderDAO == null) {// OrderDAO 객체가 없으면
			orderDAO = new OrderDAO();// 객체생성
		}

		return orderDAO;// 기존 MenuDAO객체의 주소를 리턴
	}

	/********************* 싱글톤(=singleton) 생성방법 끝 *********************/

	public void setConnection(Connection con) { // Connection 객체를 받아 DB연결
		this.con = con;
	}

	public Order selectLatestOrder(String mID) {
		Order latestOrder = null;
		
		String sql = "SELECT * FROM meal_order_table WHERE mID=? ORDER BY meal_order_date DESC LIMIT 1";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mID);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				latestOrder = new Order(rs.getInt("meal_order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
						rs.getTimestamp("meal_order_date"), // ★★주의:sql문에서 order_date를 대신 timestamp로 처리
						rs.getString("meal_order_status"), rs.getInt("meal_totalMoney"));
			}
		} catch (Exception e) {
			System.out.println("[OrderDAO] selectLatestOrder 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return latestOrder;
	}

	public ArrayList<Order> selectMyOrderList(String mID, String mEMAIL) {
		ArrayList<Order> myOrderList = null;
		
		String sql = "SELECT * FROM meal_order_table WHERE mID=? AND mEMAIL=? ORDER BY meal_order_date DESC";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mID);
			pstmt.setString(2, mEMAIL);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				myOrderList = new ArrayList<Order>();// 기본값으로 채워진 myOrderList로

				do {
					// 조회한 각 주문내역 결과로 채운 Order객체를 추가함
					myOrderList.add(new Order(rs.getInt("meal_order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
							rs.getTimestamp("meal_order_date"), // sql문에서 order_date를 date대신 Timestamp로
							rs.getString("meal_order_status"), rs.getInt("meal_totalMoney")));

				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("[OrderDAO] selectMyOrderList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return myOrderList;
	}

	public ArrayList<OrderDetail> selectMyOrderDetailList(int meal_order_num) {
		ArrayList<OrderDetail> myOrderDetailList = null;
		
		String sql = "SELECT * FROM meal_orderdetail_table WHERE meal_order_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, meal_order_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				myOrderDetailList = new ArrayList<OrderDetail>();

				do {
					myOrderDetailList.add(
							new OrderDetail(rs.getInt("meal_datail_index"), rs.getString("meal_id"), rs.getInt("meal_order_num"),
									rs.getInt("meal_quantity"), rs.getString("meal_name"), rs.getInt("meal_price")));
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("[OrderDAO] selectMyOrderDetailList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return myOrderDetailList;
	}

	/* ------------------------------------------ [관리자 모드] ------------------------------------------ */

	// 실시간 주문관리 - 오늘 날짜로 주문한 리스트를 조회하여 반환
	public ArrayList<Order> selectDayOrderList(String simpleDate_today) {
		ArrayList<Order> dayOrderList = null;
		
		String sql = "SELECT * FROM meal_order_table WHERE DATE(meal_order_date)=? ORDER BY meal_order_date DESC";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, simpleDate_today);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dayOrderList = new ArrayList<Order>();

				do {
					dayOrderList.add(new Order(rs.getInt("meal_order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
							rs.getTimestamp("meal_order_date"), rs.getString("meal_order_status"), rs.getInt("meal_totalMoney")));
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("[OrderDAO] selectDayOrderList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return dayOrderList;
	}

	// 밀키트 주문 번호(order_num)에 대한 '주문 상세 리스트를 반환'
	public ArrayList<OrderDetail> selectOrderDetailList(int meal_order_num) {
		ArrayList<OrderDetail> orderDetailList = null;
		
		String sql = "SELECT * FROM meal_orderdetail_table WHERE meal_order_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, meal_order_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				orderDetailList = new ArrayList<OrderDetail>();

				do {
					orderDetailList.add(
							new OrderDetail(rs.getInt("meal_datail_index"), rs.getString("meal_id"), rs.getInt("meal_order_num"),
									rs.getInt("meal_quantity"), rs.getString("meal_name"), rs.getInt("meal_price")));
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("[OrderDAO] selectOrderDetailList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return orderDetailList;
	}

	// 밀키트 주문번호(meal_order_num)로 해당 밀키트 주문을 찾아서 order(주문대기) -> get(주문승인)상태로 변경
	public int updateOrderGet(int meal_order_num) {
		int updateOrderGetCount = 0;
		
		String sql = "update meal_order_table set meal_order_status='get' where meal_order_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, meal_order_num);
			updateOrderGetCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("[OrderDAO] updateOrderGet 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return updateOrderGetCount;
	}

	// 밀키트 주문번호(meal_order_num)로 해당 밀키트 주문을 찾아서 order(주문대기) -> cancel(주문취소)상태로 변경
	public int updateOrderCancel(int meal_order_num) {
		int updateOrderCancelCount = 0;
		
		String sql = "update meal_order_table set meal_order_status='cancel' where meal_order_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, meal_order_num);
			updateOrderCancelCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("[OrderDAO] updateOrderCancel 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return updateOrderCancelCount;
	}
	
	// 전체주문관리 - 고객들이 주문한 전체 밀키트 주문 리스트를 조회하여 반환
	public ArrayList<Order> selectTotalOrderList() {
		ArrayList<Order> totalOrderList = null;
		
		// 가장 최근 주문한 밀키트를 제일 위에 표시
		String sql = "select * from meal_order_table order by meal_order_date DESC";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				totalOrderList = new ArrayList<Order>();// 기본값으로 채워진

				do {
					totalOrderList.add(new Order(rs.getInt("meal_order_num"), rs.getString("mID"), rs.getString("mEMAIL"),
							rs.getTimestamp("meal_order_date"),
							rs.getString("meal_order_status"), rs.getInt("meal_totalMoney")));
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("[OrderDAO] selectTotalOrderList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return totalOrderList;
	}

	

	
}

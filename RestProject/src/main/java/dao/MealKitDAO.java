package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vo.MealKit;

public class MealKitDAO {
	// 멤버변수 (전역변수 : 전체 메서드에서 사용이 가능)
	Connection con = null;// private Connection con = null; 생략가능
	PreparedStatement pstmt = null;// private PreparedStatement pstmt = null; 생략가능
	ResultSet rs = null;// private ResultSet rs = null; 생략가능

	/********************* 싱글톤(=singleton) 생성방법 시작 *********************/

	/**
	 * 싱글톤(=singleton) 생성방법 시작 싱글톤(=singleton): MealKitDAO객체 단 1개만 생성 이유: 외부 클래스에서
	 * "처음생성된 MealKitDAO객체를 공유해서 사용하도록 하기 위해서" 이다.
	 */

	/**
	 * 1.생성자는 무조건 private : 외부 클래스에서 생성자를 호출 불가하여 직접적으로 객체 생성 불가능
	 */
	private MealKitDAO() {
	}

	private static MealKitDAO mealKitDAO;// 2.반드시 static이여야 한다.

	/**
	 * 2.메서드가 static인 이유? 객체 생성하기 전에 이미 메모리에 올라간 getInstance()메서드를 통해서만
	 * MealKitDAO객체를 1개만 만들수 있도록 하기 위해서
	 */

	public static MealKitDAO getInstance() {// 1.static이면
		if (mealKitDAO == null) {// MealKitDAO 객체가 없으면
			mealKitDAO = new MealKitDAO();// 객체생성
		}

		return mealKitDAO;// 기존 mealKitDAO객체의 주소를 리턴
	}

	/********************* 싱글톤(=singleton) 생성방법 끝 *********************/

	public void setConnection(Connection con) { // Connection 객체를 받아 DB연결
		this.con = con;
	}

	// 샐러드 밀키트 부분입니다.
	public ArrayList<MealKit> selectSaladList() {
		ArrayList<MealKit> saladList = null;

		String sql = "select * from meal_table where meal_category = 'salad'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				saladList = new ArrayList<MealKit>();

				do {
					saladList.add(new MealKit(rs.getString("meal_id"), rs.getString("meal_category"),
							rs.getString("meal_name"), rs.getInt("meal_price"), rs.getString("meal_detail"),
							rs.getString("meal_status"), rs.getDate("meal_date"), rs.getString("meal_image")));

				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("[MealKitDAO]selectSaladList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return saladList;
	}

	// 파스타 밀키트 부분입니다.
	public ArrayList<MealKit> selectPastaList() {
		ArrayList<MealKit> pastaList = null;

		String sql = "select * from meal_table where meal_category = 'pasta'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pastaList = new ArrayList<MealKit>();

				do {
					pastaList.add(new MealKit(rs.getString("meal_id"), rs.getString("meal_category"),
							rs.getString("meal_name"), rs.getInt("meal_price"), rs.getString("meal_detail"),
							rs.getString("meal_status"), rs.getDate("meal_date"), rs.getString("meal_image")));

				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("[MealKitDAO]selectPastaList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return pastaList;
	}

	// 안심스테이크 밀키트 부분입니다.
	public ArrayList<MealKit> selectSteakList() {
		ArrayList<MealKit> steakList = null;

		String sql = "select * from meal_table where meal_category = 'steak'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				steakList = new ArrayList<MealKit>();

				do {
					steakList.add(new MealKit(rs.getString("meal_id"), rs.getString("meal_category"),
							rs.getString("meal_name"), rs.getInt("meal_price"), rs.getString("meal_detail"),
							rs.getString("meal_status"), rs.getDate("meal_date"), rs.getString("meal_image")));

				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("[MealKitDAO]selectSteakList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return steakList;
	}

	// 티본스테이크 밀키트 부분입니다.
	public ArrayList<MealKit> selectTsteakList() {
		ArrayList<MealKit> TsteakList = null;

		String sql = "select * from meal_table where meal_category = 'Tsteak'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				TsteakList = new ArrayList<MealKit>();

				do {
					TsteakList.add(new MealKit(rs.getString("meal_id"), rs.getString("meal_category"),
							rs.getString("meal_name"), rs.getInt("meal_price"), rs.getString("meal_detail"),
							rs.getString("meal_status"), rs.getDate("meal_date"), rs.getString("meal_image")));

				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("[MealKitDAO]selectTsteakList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return TsteakList;
	}

	// 에스카르고 밀키트 부분입니다.
	public ArrayList<MealKit> selectEscaList() {
		ArrayList<MealKit> escaList = null;

		String sql = "select * from meal_table where meal_category = 'esca'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				escaList = new ArrayList<MealKit>();

				do {
					escaList.add(new MealKit(rs.getString("meal_id"), rs.getString("meal_category"),
							rs.getString("meal_name"), rs.getInt("meal_price"), rs.getString("meal_detail"),
							rs.getString("meal_status"), rs.getDate("meal_date"), rs.getString("meal_image")));

				} while (rs.next());

			}

		} catch (Exception e) {
			System.out.println("[MealKitDAO]selectEscaList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return escaList;
	}
	
	// 밀키트 상세 정보 조회
	public MealKit selectMealKitInfo(String meal_id) {
		MealKit mealKitInfo = null;
		
		String sql = "select * from meal_table where meal_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, meal_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				mealKitInfo = new MealKit(rs.getString("meal_id"), 
										rs.getString("meal_category"), 
										rs.getString("meal_name"),
					
										rs.getInt("meal_price"),
					
										rs.getString("meal_detail"), 
										rs.getString("meal_status"),
					
										rs.getDate("meal_date"),
					
										rs.getString("meal_image"));
			}

		} catch (Exception e) {
			System.out.println("[MealKitDAO]selectMealKitInfo 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return mealKitInfo;
	}

	// 새로운 밀키트 추가
	public int insertNewMeal(MealKit newMealKit) {
		int insertNewMealCount = 0;
		
		String sql = "insert into meal_table values(?, ?, ?, ?, ?, ?, now(), ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMealKit.getMeal_id());
			pstmt.setString(2, newMealKit.getMeal_category());
			pstmt.setString(3, newMealKit.getMeal_name());

			pstmt.setInt(4, newMealKit.getMeal_price());

			pstmt.setString(5, newMealKit.getMeal_detail());
			pstmt.setString(6, newMealKit.getMeal_status());
			pstmt.setString(7, newMealKit.getMeal_image());

			insertNewMealCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("[MealKitDAO]insertNewMeal 에러: " + e);
		} finally {
			close(pstmt);
		}
		
		return insertNewMealCount;
	}
	
	// 밀키트 수정
	public int updateMealKit(MealKit newMeal) {
		int updateMealCount = 0;
		
		String sql = "update meal_table set meal_category=?, meal_name=?, meal_price=?, meal_detail=?, meal_status=?, meal_date=now()";
		
		if (newMeal.getMeal_image() != null) {
			sql += ", image=? '" + newMeal.getMeal_image() + "'";
		}
		//System.out.println("[update] 올리는 이미지 파일명 : " + newMeal.getMeal_image());
		sql += " where meal_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);// 이미지 유지 방법

			pstmt.setString(1, newMeal.getMeal_category());
			pstmt.setString(2, newMeal.getMeal_name());
			
			pstmt.setInt(3, newMeal.getMeal_price());
			
			pstmt.setString(4, newMeal.getMeal_detail());
			pstmt.setString(5, newMeal.getMeal_status());
			pstmt.setString(6, newMeal.getMeal_id());
			
			updateMealCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("[MealKitDAO]updateMeal 에러: " + e);
		} finally {
			close(pstmt);
		}
		
		return updateMealCount;
	}
	
	// 밀키트 삭제
	public int deleteMeal(String meal_id) {
		int deleteMealCount = 0;
		
		String sql = "delete from meal_table where meal_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, meal_id);

			deleteMealCount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("[MealKitDAO]deleteMeal 에러: " + e);
		} finally {
			close(pstmt);
		}
		
		return deleteMealCount;
	}

	public int insertMealKitInfo(String mID, String mEMAIL, ArrayList<MealKit> mealKitList, int saleTotalMoney) {
		int insertOrderMealKitCount = 0;
		
		 PreparedStatement pstmt2 = null;
	     ResultSet rs2 = null;
	        
	     PreparedStatement pstmt3 = null;
	        
		
	   //1. [사용자모드]:주문 테이블(order_table)에 'order(주문대기)'상태로 주문을 넣으면, [관리자모드] : '실시간주문관리'에서 order_status를 'get(주문승인)' 또는 'cancel(주문취소)'로 변경해줘야 함
	        String sql = "insert into meal_order_table(mid, memail, meal_order_date, meal_order_status, meal_totalmoney) values(?,?,now(),'order', ?)";
	        
	        try {
	              pstmt = con.prepareStatement(sql);
	              
	              pstmt.setString(1, mID);
	              pstmt.setString(2, mEMAIL);
	              pstmt.setInt(3, saleTotalMoney);
	           
	              pstmt.executeUpdate();
	           
	              //2. 주문 테이블(order_table)에서 사용자의 '가장 최근 주문번호'를 얻어와 (방금 1에서 insert한 주문번호 조회)
	              pstmt2 = con.prepareStatement("select max(meal_order_num) from meal_order_table where mID=?");
	              pstmt2.setString(1, mID);
	              rs2 = pstmt2.executeQuery();
	              
	              if(rs2.next()) {//최근 주문 번호가 있으면
	                 for(int i=0; i<mealKitList.size(); i++) {//주문한 내역을 하나씩 가져와
	                    //주문상세테이블(orderDetail_table)에다시 insert함(주문번호 클릭하면 '주문상세보기' 정보)
	                    pstmt3 = con.prepareStatement("insert into meal_orderdetail_table(meal_id, meal_order_num, meal_quantity, meal_name, meal_price) value(?,?,?,?,?)");
	                    
	                    MealKit mealKit = mealKitList.get(i);
	                    pstmt3.setString(1, mealKit.getMeal_id());/*메뉴 id*/
	                    
	                    pstmt3.setInt(2, rs2.getInt("MAX(meal_order_num)"));//★★ 주의 : 1에서 insert한 가장 최근 주문번호 /*주문 번호*/
	                    pstmt3.setInt(3, mealKit.getQuantity());/*주문 수량*/
	                    pstmt3.setString(4, mealKit.getMeal_name());/*메뉴명*/
	                    pstmt3.setInt(5, mealKit.getMeal_price());/*메뉴 가격*/
	                    
	                    insertOrderMealKitCount = pstmt3.executeUpdate();
	                    
	                 }
	              }
	              System.out.println("insertOrderMealKitCount : " + insertOrderMealKitCount);
	              
	        } catch (Exception e) {
	           System.out.println("[MealKitDAO]insertOrderMealKit 에러: " + e);
	        } finally {
	           // close(rs);
	           // close(rs2);
	           close(pstmt);
	           close(pstmt2);
	           close(pstmt3);
	        }
		return insertOrderMealKitCount;
	}

	
}

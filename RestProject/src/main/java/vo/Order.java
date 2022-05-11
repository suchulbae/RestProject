package vo;

import java.util.Date;

public class Order {
	private int meal_order_num;/*주문 번호*/
	private String mID;/*주문한 사용자의 id*/
	private String mEMAIL;/*주문한 사용자의 u_email*/
	private Date meal_order_date;/*주문한 날짜(하루매출조회)*/
	private String meal_order_status;/*사용자 모드-상태:order(구매하기-주문한 상태) / 관리자모드 - 상태 : get(주문승인), cancel(주문취소) */
	private int meal_totalmoney;/*주문한 밀키트 총 금액*/
	
	// 기본생성자
	public Order() {
		// super();
	}

	public Order(int meal_order_num, String mID, String mEMAIL, Date meal_order_date, String meal_order_status,
			int meal_totalmoney) {
		super();
		this.meal_order_num = meal_order_num;
		this.mID = mID;
		this.mEMAIL = mEMAIL;
		this.meal_order_date = meal_order_date;
		this.meal_order_status = meal_order_status;
		this.meal_totalmoney = meal_totalmoney;
	}

	public int getMeal_order_num() {
		return meal_order_num;
	}

	public void setMeal_order_num(int meal_order_num) {
		this.meal_order_num = meal_order_num;
	}

	public String getmID() {
		return mID;
	}

	public void setmID(String mID) {
		this.mID = mID;
	}

	public String getmEMAIL() {
		return mEMAIL;
	}

	public void setmEMAIL(String mEMAIL) {
		this.mEMAIL = mEMAIL;
	}

	public Date getMeal_order_date() {
		return meal_order_date;
	}

	public void setMeal_order_date(Date meal_order_date) {
		this.meal_order_date = meal_order_date;
	}

	public String getMeal_order_status() {
		return meal_order_status;
	}

	public void setMeal_order_status(String meal_order_status) {
		this.meal_order_status = meal_order_status;
	}

	public int getMeal_totalmoney() {
		return meal_totalmoney;
	}

	public void setMeal_totalmoney(int meal_totalmoney) {
		this.meal_totalmoney = meal_totalmoney;
	}
	
	
}

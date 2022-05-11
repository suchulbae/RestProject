package vo;

import java.util.Date;

public class MealKit {
	private String meal_id;
	private String meal_category;
	private String meal_name;
	private int meal_price;
	private String meal_detail;
	private String meal_status;
	private Date meal_date;
	private String meal_image;

	private int quantity;

	// 기본생성자
	public MealKit() {
	}

	// MealKitCartOrderAction에 필요한 부분으로 다시 생성
	public MealKit(String meal_id, String meal_category, String meal_name, int meal_price, int quantity) {
		super();
		this.meal_id = meal_id;
		this.meal_category = meal_category;
		this.meal_name = meal_name;
		this.meal_price = meal_price;
		this.quantity = quantity;
	}

	// quantity 제외한 생성자: meal_date는 오늘날짜인 now()로 처리함
	public MealKit(String meal_id, String meal_category, String meal_name, int meal_price, String meal_detail,
			String meal_status, Date meal_date, String meal_image) {
		super();
		this.meal_id = meal_id;
		this.meal_category = meal_category;
		this.meal_name = meal_name;
		this.meal_price = meal_price;
		this.meal_detail = meal_detail;
		this.meal_status = meal_status;
		this.meal_date = meal_date;
		this.meal_image = meal_image;
	}

	// meal_date와 quantity 제외한 생성자
	public MealKit(String meal_id, String meal_category, String meal_name, int meal_price, String meal_detail,
			String meal_status, String meal_image) {
		super();
		this.meal_id = meal_id;
		this.meal_category = meal_category;
		this.meal_name = meal_name;
		this.meal_price = meal_price;
		this.meal_detail = meal_detail;
		this.meal_status = meal_status;
		this.meal_image = meal_image;
	}

	public String getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(String meal_id) {
		this.meal_id = meal_id;
	}

	public String getMeal_category() {
		return meal_category;
	}

	public void setMeal_category(String meal_category) {
		this.meal_category = meal_category;
	}

	public String getMeal_name() {
		return meal_name;
	}

	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}

	public int getMeal_price() {
		return meal_price;
	}

	public void setMeal_price(int meal_price) {
		this.meal_price = meal_price;
	}

	public String getMeal_detail() {
		return meal_detail;
	}

	public void setMeal_detail(String meal_detail) {
		this.meal_detail = meal_detail;
	}

	public String getMeal_status() {
		return meal_status;
	}

	public void setMeal_status(String meal_status) {
		this.meal_status = meal_status;
	}

	public Date getMeal_date() {
		return meal_date;
	}

	public void setMeal_date(Date meal_date) {
		this.meal_date = meal_date;
	}

	public String getMeal_image() {
		return meal_image;
	}

	public void setMeal_image(String meal_image) {
		this.meal_image = meal_image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

}

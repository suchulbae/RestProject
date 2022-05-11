package vo;

public class OrderDetail {
	private int meal_datail_index;
	private String meal_id; /* 메뉴 id */
	private int meal_order_num; /* 주문 번호 */
	private int meal_quantity; /* 주문 수량 */
	private String meal_name; /* 메뉴명 */
	private int meal_price; /* 메뉴 가격 */

	// 기본 생성자
	public OrderDetail() {
		super();
	}

	public OrderDetail(int meal_datail_index, String meal_id, int meal_order_num, int meal_quantity, String meal_name) {
		super();
		this.meal_datail_index = meal_datail_index;
		this.meal_id = meal_id;
		this.meal_order_num = meal_order_num;
		this.meal_quantity = meal_quantity;
		this.meal_name = meal_name;
	}

	public OrderDetail(int meal_datail_index, String meal_id, int meal_order_num, int meal_quantity, String meal_name,
			int meal_price) {
		super();
		this.meal_datail_index = meal_datail_index;
		this.meal_id = meal_id;
		this.meal_order_num = meal_order_num;
		this.meal_quantity = meal_quantity;
		this.meal_name = meal_name;
		this.meal_price = meal_price;
	}

	public int getMeal_datail_index() {
		return meal_datail_index;
	}

	public void setMeal_datail_index(int meal_datail_index) {
		this.meal_datail_index = meal_datail_index;
	}

	public String getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(String meal_id) {
		this.meal_id = meal_id;
	}

	public int getMeal_order_num() {
		return meal_order_num;
	}

	public void setMeal_order_num(int meal_order_num) {
		this.meal_order_num = meal_order_num;
	}

	public int getMeal_quantity() {
		return meal_quantity;
	}

	public void setMeal_quantity(int meal_quantity) {
		this.meal_quantity = meal_quantity;
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
	
	
}

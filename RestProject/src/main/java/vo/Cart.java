package vo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

public class Cart {
	// 멤버변수
	private String meal_id;// 밀키트 아이디
	private String meal_category;
	private String meal_name;
	private int meal_price;
	private String meal_image;
	private Date meal_date;
	private int meal_qty;// 수량
	private String encoding_mId;// ★★ 인코딩된 m_id 추가

	// 기본생성자 public Cart() {}

	public String getEncoding_meal_id() {
		try {
			encoding_mId = URLEncoder.encode(meal_id, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return encoding_mId;
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

	public String getMeal_image() {
		return meal_image;
	}

	public void setMeal_image(String meal_image) {
		this.meal_image = meal_image;
	}

	public Date getMeal_date() {
		return meal_date;
	}

	public void setMeal_date(Date meal_date) {
		this.meal_date = meal_date;
	}

	public int getMeal_qty() {
		return meal_qty;
	}

	public void setMeal_qty(int meal_qty) {
		this.meal_qty = meal_qty;
	}

	public String getEncoding_mId() {
		return encoding_mId;
	}

	public void setEncoding_mId(String encoding_mId) {
		this.encoding_mId = encoding_mId;
	}

}

package svc.admin;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.AdminDAO;

public class ResvOrderCancelService {

	public boolean orderCancel(int order_num) {
		
		Connection con = getConnection();
		
		AdminDAO adminDAO = AdminDAO.getInstance();
		
		adminDAO.setConnection(con);
		
		
		
		
		int updateOrderGetCount = adminDAO.resvOrderCancel(order_num);
		
		
		boolean isOrderGetResult = false;

		if (updateOrderGetCount > 0) {
			isOrderGetResult = true;
			commit(con);
		} else {
			rollback(con);
		}

		
		
		
		close(con);
		
		
		
		
		return isOrderGetResult;
	}

}

package vnua.fita.sbcrudrestful.util;

public class MySQL {
	public static final String GET_ALL_ORDER = "SELECT o.order_id,o.order_date,o.total_amount,o.address,o.phone,o.note,o.status,u.username,e.empName,od.quantity,od.price\r\n"
			+ "FROM orders o JOIN user u ON o.user_id = u.user_id\r\n"
			+ "            JOIN order_detail od ON o.order_id = od.order_id\r\n"
			+ "            JOIN employee e ON od.empNo = e.empNo";
}

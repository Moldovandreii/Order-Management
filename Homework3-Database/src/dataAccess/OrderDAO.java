package dataAccess;

import java.sql.*;
import model.*;

public class OrderDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	private DataAccess da = new DataAccess();
	
	public void insertOrder(String toAdd) {
		da.insert(Order.class, con, toAdd);
	}
	
	public void deleteOrder(int id) {
		da.delete(Order.class, con, id);
	}
	
	public void updateClient(Order o) {
		da.update(o, con);
	}
	
	public Order findById(int id) {
		String[] rez = da.findById(Order.class, con, id);
		Order o = new Order(rez[0], rez[1], rez[2], rez[3]);
		return o;
	}
	
	public String[][] selectAll(){
		return da.selectAll(Order.class, con);
	}
	
	public int nrRows() {
		return da.nbOfRows(Order.class, con);
	}
	
	public static void main(String args[]) throws SQLException {
		OrderDAO od = new OrderDAO();
		String toAdd = "('6', '4', '3', '2')";
		//od.insertOrder(toAdd);
		
		//od.deleteOrder(6);
		
		//Order o = new Order(3,1,2,4);
		//od.updateClient(o);
		
		Order o = od.findById(3);
		System.out.println(o.getSize());
	}
}


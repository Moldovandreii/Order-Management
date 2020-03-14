package dataAccess;

import java.sql.*;
import model.*;

public class ClientDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	private DataAccess da = new DataAccess();
	
	public void insertClient(String toAdd) {
		da.insert(Client.class, con, toAdd);
	}
	
	public void deleteClient(int id) {
		da.delete(Client.class, con, id);
	}
	
	public void updateClient(Client c) {
		da.update(c, con);
	}
	
	public Client findById(int id) {
		String[] rez = da.findById(Client.class, con, id);
		Client c = new Client(rez[0], rez[1], rez[2]);
		return c;
	}
	
	public String[][] selectAll(){
		return da.selectAll(Client.class, con);
	}
	
	public int nrRows() {
		return da.nbOfRows(Client.class, con);
	}
	
	public static void main(String args[]) throws SQLException {
		ClientDAO cd = new ClientDAO();
		String toAdd = "('3', 'Bogdan', '22')";
		//cd.insertClient(toAdd);
		//cd.deleteClient(9);
		//Client c1 = new Client(3,"Bogdan", 25);
		//cd.updateClient(c1);
		//Client c = cd.findById(3);
		String[][] rez = cd.selectAll();
		System.out.println(rez[5][1]);
		System.out.println(cd.nrRows());
	}
}


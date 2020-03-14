package dataAccess;

import java.sql.*;
import model.*;

public class ProductDAO {
	
	private Connection con = ConnectionFactory.getConnection();
	private DataAccess da = new DataAccess();
	
	public void insertProduct(String toAdd) {
		da.insert(Product.class, con, toAdd);
	}
	
	public void deleteProduct(int id) {
		da.delete(Product.class, con, id);
	}
	
	public void updateProduct(Product p) {
		da.update(p, con);
	}
	
	public Product findById(int id) {
		String[] rez = da.findById(Product.class, con, id);
		Product p = new Product(rez[0], rez[1], rez[2]);
		return p;
	}
	
	public String[][] selectAll(){
		return da.selectAll(Product.class, con);  
	}
	
	public int nrRows() {
		return da.nbOfRows(Product.class, con);
	}
	
	public static void main(String args[]) throws SQLException {
		ProductDAO pd = new ProductDAO();
		String toAdd = "('6', 'whey', '34')";
		//pd.insertProduct(toAdd);
		
		//pd.deleteProduct(3);
		
		Product p1 = new Product(3, "Carte", 33);
		pd.updateProduct(p1);
		
		Product p = pd.findById(3);
		System.out.println(p.getQuantity());
	}
}

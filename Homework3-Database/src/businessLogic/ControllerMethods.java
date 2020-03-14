package businessLogic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import dataAccess.*;
import model.Client;
import model.Product;
import validator.ClientValidator;

public class ControllerMethods {
	
	private ClientDAO cd = new ClientDAO();
	private ProductDAO pd = new ProductDAO();
	private OrderDAO od = new OrderDAO();

	public void insertClientF(String clientNameVal, String clientAgeVal, String clientName, String clientAge) {
		int nrRows = cd.nrRows() + 1;
		ClientValidator cv = new ClientValidator();
		Client c = new Client(Integer.toString(nrRows), clientNameVal, clientAgeVal);
		cv.validate(c);
		String toAdd = ("(" + nrRows + ", " + clientName + ", " + clientAge + ")");
		cd.insertClient(toAdd);
	}
	
	public void deleteClientF(String clientId) {
		clientId = clientId.substring(1, clientId.length()-1);
		int idClient = Integer.parseInt(clientId);
		cd.deleteClient(idClient);
	}
	
	public void updateClientF(String clientId, String clientName, String clientAge) {
		clientId = clientId.substring(1, clientId.length()-1);
		clientName = clientName.substring(1, clientName.length()-1);
		clientAge = clientAge.substring(1, clientAge.length()-1);
		Client c = new Client(clientId, clientName, clientAge);
		cd.updateClient(c);
	}
	
	public Client findClientF1(String clientId) {
		clientId = clientId.substring(1, clientId.length()-1);  
		int idClient = Integer.parseInt(clientId);
		Client c = cd.findById(idClient);
		return c;
	}
	
	public void insertProductF(String productName, String productQuantity) {
		int nrRows = pd.nrRows() + 1;
		String toAdd = ("(" + nrRows + ", " + productName + ", " + productQuantity + ")");
		pd.insertProduct(toAdd);
	}
	
	public void deleteProductF(String productId) {
		productId = productId.substring(1, productId.length()-1);
		int idProduct = Integer.parseInt(productId);
		pd.deleteProduct(idProduct);
	}
	
	public void updateProductF(String productId, String productName, String productQuantity) {
		productId = productId.substring(1, productId.length()-1);
		productName = productName.substring(1, productName.length()-1);
		productQuantity = productQuantity.substring(1, productQuantity.length()-1);
		Product p = new Product(productId, productName, productQuantity);
		pd.updateProduct(p);
	}
	
	public String makeOrderF1(int orderedQuantity, int productQuantity, String clientName, String productName) {
		if(orderedQuantity > productQuantity)
		{
			String s = "We are sorry " + clientName + ", not enough stock, only " + productQuantity + " " + productName + " left   \uD83D\uDE1E  ";
			return s;
		}
		return "bad";
	}
	
	public String makeOrderF2(int orderedQuantity, int productQuantity, String clientName, String productName, int clientIdCurr, int productIdCurr) {
		if(orderedQuantity <= productQuantity)
		{
			int orderID = od.nrRows() + 1;
			String toAdd = "('" + orderID + "', " + "'" + clientIdCurr + "', " + "'" + productIdCurr+ "', " + "'" + orderedQuantity + "')";
			od.insertOrder(toAdd);
			Product p = new Product(productIdCurr, productName, productQuantity - orderedQuantity);
			pd.updateProduct(p);
			String s = "Your order has been processed   \u263A";
			return s;
		}
		return "bad";
	}
	
	public void makeOrderF3(int billNumber, String clientName, int orderedQuantity, String productName) {
		try {
			File file = new File("bill" + billNumber + ".txt");
			billNumber++;
			if(file.exists())
			{
				file.createNewFile();
			}
			PrintWriter pw = new PrintWriter(file);
			pw.println("Client " + clientName + " has ordered " + orderedQuantity + " " + productName);
			pw.close();
		}catch(IOException E){
			E.printStackTrace();
		}
	}
	
	
	
	
}

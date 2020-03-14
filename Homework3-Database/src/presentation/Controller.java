package presentation;
import dataAccess.*;
import businessLogic.ControllerMethods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import model.Client;
import model.Product;
import model.Order;
import validator.ClientValidator;

public class Controller { 

	private View view;
	private ClientDAO cd = new ClientDAO();
	private ProductDAO pd = new ProductDAO();
	private OrderDAO od = new OrderDAO();
	private ControllerMethods cm = new ControllerMethods();
	private int billNumber = 1;
	
	public Controller(View view) {
		this.view = view;
		view.addActionListener(new NextToProduct(), new PrevFromPr(), new NextFromPr(), new PrevFromOrder(), new InsertClient(), new DeleteClient(), new UpdateClient(), new FindClient(), new InsertProduct(), new DeleteProduct(), new UpdateProduct(), new FindProduct(), new MakeOrder());
	}
	
	class NextToProduct implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			view.getCardLayout().show(view.getDefaultPanel(), "2");
		}
	}
	
	class PrevFromPr implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getCardLayout().show(view.getDefaultPanel(), "1");
		}
	}
	
	class NextFromPr implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getCardLayout().show(view.getDefaultPanel(), "3");
		}
	}
	
	class PrevFromOrder implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			view.getCardLayout().show(view.getDefaultPanel(), "2");
		}
	}
	
	class InsertClient implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			int nrRows = cd.nrRows() + 1;
			ClientValidator cv = new ClientValidator();
			Client c = new Client(Integer.toString(nrRows), view.getClientNameVal(), view.getClientAgeVal());
			cv.validate(c);
			//String toAdd = ("(" + view.getClientId() + ", " + view.getClientName() + ", " + view.getClientAge() + ")");
			String toAdd = ("(" + nrRows + ", " + view.getClientName() + ", " + view.getClientAge() + ")");
			cd.insertClient(toAdd);
			view.setNewInfoCl();
		} */
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String clientNameVal = view.getClientNameVal();
			String clientAgeVal = view.getClientAgeVal();
			String clientName = view.getClientName();
			String clientAge = view.getClientAge();
			cm.insertClientF(clientNameVal, clientAgeVal, clientName, clientAge);
			view.setNewInfoCl();
		}
		
	}
	
	class DeleteClient implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			String clientId = view.getClientId();
			clientId = clientId.substring(1, clientId.length()-1);
			int idClient = Integer.parseInt(clientId);
			cd.deleteClient(idClient);
			view.setNewInfoCl();
		}*/
		@Override
		public void actionPerformed(ActionEvent e) {
			String clientId = view.getClientId();
			cm.deleteClientF(clientId);
			view.setNewInfoCl();
		}
	}
	
	class UpdateClient implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			String clientId = view.getClientId();
			clientId = clientId.substring(1, clientId.length()-1);
			String clientName = view.getClientName();
			clientName = clientName.substring(1, clientName.length()-1);
			String clientAge = view.getClientAge();
			clientAge = clientAge.substring(1, clientAge.length()-1);
			Client c = new Client(clientId, clientName, clientAge);
			cd.updateClient(c);
			view.setNewInfoCl();
		}*/
		@Override
		public void actionPerformed(ActionEvent e) {
			String clientId = view.getClientId();
			String clientName = view.getClientName();
			String clientAge = view.getClientAge();
			cm.updateClientF(clientId, clientName, clientAge);
			view.setNewInfoCl();
		}
	}
	
	
	
	class FindClient implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String clientId = view.getClientId();
			clientId = clientId.substring(1, clientId.length()-1);
			int idClient = Integer.parseInt(clientId);
			if(view.getClientId().isEmpty() == false && (idClient != 0))
			{
				Client c = cd.findById(idClient);
				view.newInfoFindCl(c);
			}
			else if(idClient == 0)
			{
				view.setNewInfoCl();
			}
		}
	}
	
	class InsertProduct implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			int nrRows = pd.nrRows() + 1;
			//String toAdd = ("(" + view.getProductId() + ", " + view.getProductName() + ", " + view.getProductQuantity() + ")");
			String toAdd = ("(" + nrRows + ", " + view.getProductName() + ", " + view.getProductQuantity() + ")");
			pd.insertProduct(toAdd);
			view.setNewInfoPr();
		}*/
		@Override
		public void actionPerformed(ActionEvent e) {
			String productName = view.getProductName();
			String productQuantity = view.getProductQuantity();
			cm.insertProductF(productName, productQuantity);
			view.setNewInfoPr();
		}
	}
	
	class DeleteProduct implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			String productId = view.getProductId();
			productId = productId.substring(1, productId.length()-1);
			int idProduct = Integer.parseInt(productId);
			pd.deleteProduct(idProduct);
			view.setNewInfoPr();  	
		}*/
		@Override
		public void actionPerformed(ActionEvent e) {
			String productId = view.getProductId();
			cm.deleteProductF(productId);
			view.setNewInfoPr();  	
		}
	}
	
	class UpdateProduct implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			String productId = view.getProductId();
			productId = productId.substring(1, productId.length()-1);
			String productName = view.getProductName();
			productName = productName.substring(1, productName.length()-1);
			String productQuantity = view.getProductQuantity();
			productQuantity = productQuantity.substring(1, productQuantity.length()-1);
			Product p = new Product(productId, productName, productQuantity);
			pd.updateProduct(p);
			view.setNewInfoPr();
		}*/
		@Override
		public void actionPerformed(ActionEvent e) {
			String productId = view.getProductId();
			String productName = view.getProductName();
			String productQuantity = view.getProductQuantity();
			cm.updateProductF(productId, productName, productQuantity);
			view.setNewInfoPr();
		}
	}
	
	class FindProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String productId = view.getProductId();
			productId = productId.substring(1, productId.length()-1);
			int idProduct = Integer.parseInt(productId);
			if(view.getProductId().isEmpty() == false && (idProduct != 0))
			{
				Product p = pd.findById(idProduct);
				view.newInfoFindPr(p);
			}
			else if(idProduct == 0)
			{
				view.setNewInfoPr();  
			}
			
		}
	}
	
	class MakeOrder implements ActionListener{

		/*@Override
		public void actionPerformed(ActionEvent e) {
			int orderedQuantity = view.getOrderedQuantity();
			String clientName = view.getComboName();
			String productName = view.getComboProduct();
			int productQuantity = view.getProdQuantity(productName); 
			
			if(orderedQuantity > productQuantity)
			{
				String s = "We are sorry " + clientName + ", not enough stock, only " + productQuantity + " " + productName + " left   \uD83D\uDE1E  ";
				view.setMessage(s);
			}
			
			else
			{
				int orderID = od.nrRows() + 1;
				String toAdd = "('" + orderID + "', " + "'" + view.getClientId(clientName) + "', " + "'" + view.getProductId(productName) + "', " + "'" + orderedQuantity + "')";
				od.insertOrder(toAdd);
				Product p = new Product(view.getProductId(productName), productName, productQuantity - orderedQuantity);
				pd.updateProduct(p);
				view.setNewInfoPr();
				view.refreshOrder();
				view.setMessage("Your order has been processed   \u263A");
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
		}*/
		@Override
		public void actionPerformed(ActionEvent e) {
			int orderedQuantity = view.getOrderedQuantity();
			String clientName = view.getComboName();
			String productName = view.getComboProduct();
			int productQuantity = view.getProdQuantity(productName); 
			
			if(orderedQuantity > productQuantity)
			{
				String s = cm.makeOrderF1(orderedQuantity, productQuantity, clientName, productName);
				view.setMessage(s);
			}
			
			else
			{
				int clientIdCurr = view.getClientId(clientName);
				int productIdCurr = view.getProductId(productName);		
				String s = cm.makeOrderF2(orderedQuantity, productQuantity, clientName, productName, clientIdCurr, productIdCurr);
				view.setNewInfoPr();
				view.refreshOrder();
				view.setMessage(s);
				cm.makeOrderF3(productIdCurr, clientName, orderedQuantity, productName); 
			}
		}
	}
	
	public static void main(String[] args) {
		View view = new View();
		Controller contr = new Controller(view);
	}
}

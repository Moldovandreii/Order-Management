package presentation;
import dataAccess.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableColumn;

import com.mysql.cj.jdbc.ha.RandomBalanceStrategy;
import model.Client;
import model.Product;

public class View extends JFrame {
	private ClientDAO cd = new ClientDAO();
	private ProductDAO pd = new ProductDAO();
	private JFrame frame = new JFrame();
	private JPanel defaultPanel = new JPanel();
	private JPanel clientPanel = new JPanel();
	private JPanel productPanel = new JPanel();
	private JPanel orderPanel = new JPanel();
	private JPanel clientInfo = new JPanel();
	private JPanel productInfo = new JPanel();
	private JButton nextFromPr = new JButton("---> Next");
	private JButton prevFromPr = new JButton("<--- Client");
	private JButton nextToProduct = new JButton("---> Product");
	private JButton insertClient = new JButton("Add Client");
	private JButton deleteClient = new JButton("Remove Client");
	private JButton updateClient = new JButton("Update Client");
	private JButton findClient = new JButton("Find Client");
	private JButton insertProduct = new JButton("Add Product");
	private JButton deleteProduct = new JButton("Remove Product");
	private JButton updateProduct = new JButton("Update Product");
	private JButton findProduct = new JButton("Find Product");
	private JButton makeOrder = new JButton("Order");
	private JButton prevFromOrder = new JButton("<--- Prev");
	private JLabel clientToOrder = new JLabel("Name:");
	private JLabel productToOrder = new JLabel("Product:");
	private JLabel quantityToOrder = new JLabel("Quantity");
	private JLabel message = new JLabel("");
	private JTextField quantityToOrderTxt = new JTextField();
	private JComboBox clientList;
	private JComboBox productList;
	private JLabel clientID = new JLabel("Client ID");
	private JLabel clientName = new JLabel("Client Name");
	private JLabel clientAge = new JLabel("Client Age");
	private JLabel productID = new JLabel("Product ID");
	private JLabel productName = new JLabel("Product Name");
	private JLabel productQuantity = new JLabel("Product quantity");
	private JTextField clientIdTxt = new JTextField();
	private JTextField clientNameTxt = new JTextField();
	private JTextField clientAgeTxt = new JTextField();
	private JTextField productIdTxt = new JTextField();
	private JTextField productNameTxt = new JTextField();
	private JTextField productQuantityTxt = new JTextField();
	JScrollPane jspCl;
	JScrollPane jspPr;
	String[][] tableCl;
	String[][] tablePr;
	String[] clientNames;
	String[] productNames;
	JLabel spaceO1;
	JLabel spaceO2;
	JLabel spaceO3;
	JPanel panelO1;
	JPanel panelO2;
	private CardLayout cl = new CardLayout();
	
	public View() {
		frame.setSize(1200,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		defaultPanel.setLayout(cl);
		clientPanel.setLayout(new FlowLayout());
		productPanel.setLayout(new FlowLayout());
		orderPanel.setLayout(new FlowLayout());
		defaultPanel.add(clientPanel, "1");
		defaultPanel.add(productPanel, "2");
		defaultPanel.add(orderPanel, "3");
		cl.show(defaultPanel, "1");
		
		JPanel clOp = new JPanel();
		clOp.setLayout(new FlowLayout());
		JPanel clBut = new JPanel();  
		clBut.setLayout(new FlowLayout());
		clientID.setFont(new Font("Serif", Font.PLAIN, 20));
		clientName.setFont(new Font("Serif", Font.PLAIN, 20));
		clientAge.setFont(new Font("Serif", Font.PLAIN, 20));
		clientIdTxt.setPreferredSize(new Dimension(45,30));
		clientNameTxt.setPreferredSize(new Dimension(150,30));
		clientAgeTxt.setPreferredSize(new Dimension(45,30));
		insertClient.setPreferredSize(new Dimension(110,40));
		deleteClient.setPreferredSize(new Dimension(120,40));
		updateClient.setPreferredSize(new Dimension(110,40));
		findClient.setPreferredSize(new Dimension(110,40));
		nextToProduct.setPreferredSize(new Dimension(150,40));
		nextToProduct.setFont(new Font("Serif", Font.PLAIN, 20));
		JLabel space1 = new JLabel("        ");
		space1.setFont(new Font("Serif", Font.PLAIN, 50));
		JLabel space2 = new JLabel("        ");
		space2.setFont(new Font("Serif", Font.PLAIN, 50));
		JLabel space3 = new JLabel("    ");
		space3.setFont(new Font("Serif", Font.PLAIN, 70));
		clOp.add(space1);
		clOp.add(clientID);
		clOp.add(clientIdTxt);
		clOp.add(clientName);
		clOp.add(clientNameTxt);
		clOp.add(clientAge);
		clOp.add(clientAgeTxt);
		clBut.add(space2);
		clBut.add(insertClient);
		clBut.add(deleteClient);
		clBut.add(updateClient);
		clBut.add(findClient);
		clientPanel.add(clOp);
		clientPanel.add(clBut);
		clientInfo.setLayout(new FlowLayout());
		clientInfo.add(space3);
		tableCl = cd.selectAll();
		String[] clientHeader = {"id", "name", "age"};
		JTable clInfo = new JTable(tableCl, clientHeader);
		jspCl = new JScrollPane(clInfo);
		jspCl.setPreferredSize(new Dimension(750,350));
		clientInfo.add(jspCl);
		clientPanel.add(clientInfo); 
		clientPanel.add(nextToProduct);
		
		JPanel prOp = new JPanel();
		prOp.setLayout(new FlowLayout());
		JPanel prBut = new JPanel();  
		prBut.setLayout(new FlowLayout());
		productID.setFont(new Font("Serif", Font.PLAIN, 20));
		productName.setFont(new Font("Serif", Font.PLAIN, 20));
		productQuantity.setFont(new Font("Serif", Font.PLAIN, 20));
		productIdTxt.setPreferredSize(new Dimension(45,30));
		productNameTxt.setPreferredSize(new Dimension(150,30));
		productQuantityTxt.setPreferredSize(new Dimension(45,30));
		insertProduct.setPreferredSize(new Dimension(110,40));
		deleteProduct.setPreferredSize(new Dimension(140,40));
		updateProduct.setPreferredSize(new Dimension(140,40));
		findProduct.setPreferredSize(new Dimension(110,40));
		nextFromPr.setPreferredSize(new Dimension(150,40));
		nextFromPr.setFont(new Font("Serif", Font.PLAIN, 20));
		prevFromPr.setPreferredSize(new Dimension(150,40));
		prevFromPr.setFont(new Font("Serif", Font.PLAIN, 20));
		JLabel space4 = new JLabel("        ");
		space4.setFont(new Font("Serif", Font.PLAIN, 50));
		JLabel space5 = new JLabel("        ");
		space5.setFont(new Font("Serif", Font.PLAIN, 50));
		JLabel space6 = new JLabel("    ");
		space6.setFont(new Font("Serif", Font.PLAIN, 70));
		prOp.add(space4);
		prOp.add(productID);
		prOp.add(productIdTxt);
		prOp.add(productName);
		prOp.add(productNameTxt);
		prOp.add(productQuantity);
		prOp.add(productQuantityTxt);
		prBut.add(space5);
		prBut.add(insertProduct);  
		prBut.add(deleteProduct);
		prBut.add(updateProduct);
		prBut.add(findProduct);
		productPanel.add(prOp);
		productPanel.add(prBut);
		productInfo.setLayout(new FlowLayout());
		productInfo.add(space6);
		productInfo.add(prevFromPr);
		tablePr = pd.selectAll();
		String[] productHeader = {"id", "name", "quantity"};
		JTable prInfo = new JTable(tablePr, productHeader);
		jspPr = new JScrollPane(prInfo);
		jspPr.setPreferredSize(new Dimension(750,350));
		productInfo.add(jspPr);
		productPanel.add(productInfo); 
		productPanel.add(nextFromPr);
		
		spaceO1 = new JLabel("        ");
		spaceO1.setPreferredSize(new Dimension(1465,130));
		spaceO2 = new JLabel("        ");
		spaceO2.setPreferredSize(new Dimension(1165,30));
		spaceO3 = new JLabel("        ");
		spaceO3.setPreferredSize(new Dimension(1165,200));
		panelO1 = new JPanel();
		panelO1.setLayout(new FlowLayout());
		panelO2 = new JPanel();
		panelO2.setLayout(new FlowLayout());
		clientToOrder.setFont(new Font("Serif", Font.PLAIN, 20));
		productToOrder.setFont(new Font("Serif", Font.PLAIN, 20));
		quantityToOrder.setFont(new Font("Serif", Font.PLAIN, 20));
		message.setFont(new Font("Serif", Font.PLAIN, 20));
		makeOrder.setFont(new Font("Serif", Font.PLAIN, 20));
		prevFromOrder.setFont(new Font("Serif", Font.PLAIN, 20));
		makeOrder.setPreferredSize(new Dimension(100,30));
		prevFromOrder.setPreferredSize(new Dimension(125,30));
		quantityToOrderTxt.setPreferredSize(new Dimension(65,30));
		clientNames = new String[cd.nrRows()];
		for(int i=0; i<cd.nrRows(); i++)
		{
			clientNames[i] = tableCl[i][1];
		}
		clientList = new JComboBox(clientNames);
		clientList.setPreferredSize(new Dimension(90,30));
		productNames = new String[pd.nrRows()];
		for(int i=0; i<pd.nrRows(); i++)
		{
			productNames[i] = tablePr[i][1];
		}
		productList = new JComboBox(productNames);
		productList.setPreferredSize(new Dimension(90,30));
		orderPanel.add(spaceO1);
		orderPanel.add(clientToOrder);
		orderPanel.add(clientList);
		orderPanel.add(productToOrder);
		orderPanel.add(productList);
		orderPanel.add(quantityToOrder);
		orderPanel.add(quantityToOrderTxt);
		orderPanel.add(makeOrder);
		orderPanel.add(spaceO2);
		panelO1.add(message);
		orderPanel.add(panelO1);
		orderPanel.add(spaceO3);
		panelO2.add(prevFromOrder);
		orderPanel.add(panelO2);
		
		frame.setContentPane(defaultPanel);
		frame.setVisible(true);
	}
	
	public void setNewInfoCl() {
		clientInfo.remove(jspCl);
		tableCl = cd.selectAll();
		String[] clientHeader = {"id", "name", "age"};
		JTable clInfo = new JTable(tableCl, clientHeader);
		jspCl = new JScrollPane(clInfo);
		jspCl.setPreferredSize(new Dimension(750,350));
		clientInfo.add(jspCl);
		cl.show(defaultPanel, "2");
		cl.show(defaultPanel, "1");
		orderPanel.removeAll();
		clientNames = new String[cd.nrRows()];
		for(int i=0; i<cd.nrRows(); i++)
		{
			clientNames[i] = tableCl[i][1];
		}
		clientList = new JComboBox(clientNames);
		clientList.setPreferredSize(new Dimension(90,30));
		orderPanel.add(spaceO1);
		orderPanel.add(clientToOrder);
		orderPanel.add(clientList);
		orderPanel.add(productToOrder);
		orderPanel.add(productList);
		orderPanel.add(quantityToOrder);
		orderPanel.add(quantityToOrderTxt);
		orderPanel.add(makeOrder);
		orderPanel.add(spaceO2);
		panelO1.add(message);
		orderPanel.add(panelO1);
		orderPanel.add(spaceO3);
		panelO2.add(prevFromOrder);
		orderPanel.add(panelO2);
	}
	
	public void setNewInfoPr() {
		productInfo.remove(jspPr);
		tablePr = pd.selectAll();
		String[] productHeader = {"id", "name", "quantity"};
		JTable prInfo = new JTable(tablePr, productHeader);
		jspPr = new JScrollPane(prInfo);
		jspPr.setPreferredSize(new Dimension(750,350));
		productInfo.add(jspPr);
		cl.show(defaultPanel, "1");
		cl.show(defaultPanel, "2");
		
		orderPanel.removeAll();
		productNames = new String[pd.nrRows()];
		for(int i=0; i<pd.nrRows(); i++)
		{
			productNames[i] = tablePr[i][1];
		}
		productList = new JComboBox(productNames);
		productList.setPreferredSize(new Dimension(90,30));
		orderPanel.add(spaceO1);
		orderPanel.add(clientToOrder);
		orderPanel.add(clientList);
		orderPanel.add(productToOrder);
		orderPanel.add(productList);
		orderPanel.add(quantityToOrder);
		orderPanel.add(quantityToOrderTxt);
		orderPanel.add(makeOrder);
		orderPanel.add(spaceO2);
		panelO1.add(message);
		orderPanel.add(panelO1);
		orderPanel.add(spaceO3);
		panelO2.add(prevFromOrder);
		orderPanel.add(panelO2);
	}
	
	public void refreshOrder() {
		cl.show(defaultPanel, "3");
	}
	
	public void newInfoFindCl(Client c) {
		clientInfo.remove(jspCl);
		String[] clientHeader = {"id", "name", "age"};
		String[][] tableRowCl = new String[1][3];
		tableRowCl[0][0] = Integer.toString(c.getId());
		tableRowCl[0][1] = c.getName();
		tableRowCl[0][2] = Integer.toString(c.getAge());
		JTable clInfo = new JTable(tableRowCl, clientHeader);
		jspCl = new JScrollPane(clInfo);
		jspCl.setPreferredSize(new Dimension(750,350));
		clientInfo.add(jspCl);
		cl.show(defaultPanel, "2");
		cl.show(defaultPanel, "1");
	}
	
	public void newInfoFindPr(Product p) {
		productInfo.remove(jspPr);
		String[] productHeader = {"id", "name", "quantity"};
		String[][] tableRowPr = new String[1][3];
		tableRowPr[0][0] = Integer.toString(p.getId());
		tableRowPr[0][1] = p.getName();
		tableRowPr[0][2] = Integer.toString(p.getQuantity());
		JTable prInfo = new JTable(tableRowPr, productHeader);
		jspPr = new JScrollPane(prInfo);
		jspPr.setPreferredSize(new Dimension(750,350));
		productInfo.add(jspPr);
		cl.show(defaultPanel, "1");
		cl.show(defaultPanel, "2");
	}
	
	public int getProdQuantity(String productName) {
		for(int i=0; i<pd.nrRows(); i++) {
			if(tablePr[i][1] == productName)
			{
				return Integer.parseInt(tablePr[i][2]);  
			}
		}
		return 0;
	}
	
	public int getProductId(String productName) {
		for(int i=0; i<pd.nrRows(); i++) {
			if(tablePr[i][1] == productName)
			{
				return Integer.parseInt(tablePr[i][0]);  
			}
		}
		return 0;
	}
	
	public int getClientId(String clientName) {
		for(int i=0; i<cd.nrRows(); i++) {
			if(tableCl[i][1] == clientName)
			{
				return Integer.parseInt(tableCl[i][0]);
			}
		}
		return 0;
	}
	
	public void addActionListener(ActionListener nextToProduct, ActionListener prevFromPr, ActionListener nextFromPr, ActionListener prevFromOrder, ActionListener insertClient, ActionListener deleteClient, ActionListener updateClient, ActionListener findClient, ActionListener insertProduct, ActionListener deleteProduct, ActionListener updateProduct, ActionListener findProduct, ActionListener makeOrder ) {
		this.nextToProduct.addActionListener(nextToProduct);
		this.prevFromPr.addActionListener(prevFromPr);
		this.nextFromPr.addActionListener(nextFromPr);
		this.prevFromOrder.addActionListener(prevFromOrder);
		this.insertClient.addActionListener(insertClient);
		this.deleteClient.addActionListener(deleteClient);
		this.updateClient.addActionListener(updateClient);
		this.findClient.addActionListener(findClient);
		this.insertProduct.addActionListener(insertProduct);
		this.deleteProduct.addActionListener(deleteProduct);  
		this.updateProduct.addActionListener(updateProduct);
		this.findProduct.addActionListener(findProduct);
		this.makeOrder.addActionListener(makeOrder);
	}
	
	public CardLayout getCardLayout() {
		return this.cl;
	}
	
	public JPanel getDefaultPanel() {
		return this.defaultPanel;
	}
	
	public String getClientId() {
		return "'" + this.clientIdTxt.getText() + "'";
	}
	
	public String getClientName() {
		return "'" + this.clientNameTxt.getText() + "'";
	}
	
	public String getClientAge() {
		return "'" + this.clientAgeTxt.getText() + "'";
	}
	
	public String getClientIdVal() {
		return this.clientIdTxt.getText();
	}
	
	public String getClientNameVal() {
		return this.clientNameTxt.getText();
	}
	
	public String getClientAgeVal() {
		return this.clientAgeTxt.getText();
	}
	
	public String getProductId() {
		return "'" + this.productIdTxt.getText() + "'";
	}
	
	public String getProductName() {
		return "'" + this.productNameTxt.getText() + "'";
	}
	
	public String getProductQuantity() {
		return "'" + this.productQuantityTxt.getText() + "'";
	}
	
	public String getComboName() {
		return this.clientList.getSelectedItem().toString();  
	}
	
	public String getComboProduct() {
		return this.productList.getSelectedItem().toString();  
	}
	
	public int getOrderedQuantity() {
		return Integer.parseInt(this.quantityToOrderTxt.getText());
	}
	
	public void setMessage(String s) {
		this.message.setText(s);
	}
	
	
	public static void main(String[] args) {
		View view = new View();
		Client c = new Client(4, "Dan", 22);
		
	}

}

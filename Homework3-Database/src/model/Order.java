package model;

public class Order {
	private int id;
	private int clientID;
	private int productID;
	private int size;
	
	public Order(int id, int client, int product, int size) {
		this.id = id;
		this.clientID = client;
		this.productID = product;
		this.size = size;
	}
	
	public Order(String id, String client, String product, String size) {
		this.id = Integer.parseInt(id);
		this.clientID = Integer.parseInt(client);
		this.productID = Integer.parseInt(product);
		this.size = Integer.parseInt(size);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}
}

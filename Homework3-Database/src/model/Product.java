package model;

public class Product {
	private int id;
	private String name;
	private int quantity;
	
	public Product(int id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}
	
	public Product(String id, String name, String quantity) {
		this.id = Integer.parseInt(id);
		this.name = name;
		this.quantity = Integer.parseInt(quantity);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}



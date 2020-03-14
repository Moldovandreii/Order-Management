package model;

public class Client {
	private int id;
	private String name;
	private int age;
	
	public Client(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public Client(String id, String name, String age) {
		this.id = Integer.parseInt(id);
		this.name = name;
		this.age = Integer.parseInt(age);
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
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}


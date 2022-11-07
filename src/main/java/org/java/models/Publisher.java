package org.java.models;

public class Publisher {
	private int id;
	private String name;
	
	public Publisher() {
		// TODO Auto-generated constructor stub
	}

	public Publisher(int id) {
		super();
		this.id = id;
	}
	
	

	public Publisher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}
	
	
}

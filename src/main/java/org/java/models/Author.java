package org.java.models;

public class Author {
	private int id;
	private String name;
	private int yearBorn;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public Author(String...row) {
		try {
			this.id = Integer.parseInt(row[0]);
			this.name = row[1];
			this.yearBorn = Integer.parseInt(row[2]);
		} catch (Exception e) {
			System.out.println("Error :" + e.getMessage());
		}
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

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public Author(int id, String name, int yearBorn) {
		super();
		this.id = id;
		this.name = name;
		this.yearBorn = yearBorn;
	}

	
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", yearBorn=" + yearBorn + "]";
	}
	
	
}

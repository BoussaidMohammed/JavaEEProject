package org.java.models;

import java.util.List;
import java.util.Vector;

public class Title {
	
	private String isbn;
	private String title;
	private int yearPublished;
	private Publisher publisher;
	private List<Author> authors;
	
	public Title() {
		// TODO Auto-generated constructor stub
	}
	
	public Title(String isbn, String title, int yearPublished, int publisherId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
		publisher = new Publisher(publisherId);
		authors = new Vector<Author>();
	}
	
	public void add(Author author) {
		authors.add(author);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		String s = "";
		for(Author author: authors) {
			s += author.getName() + ";";
		}
		s += "(" + yearPublished + ")." + title + ".published by: " + publisher.getName();
		return s;
	}
	
	
	
	
}

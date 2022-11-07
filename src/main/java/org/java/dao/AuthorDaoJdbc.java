package org.java.dao;

import java.util.List;
import java.util.Vector;

import org.java.jdbc.DataBase;
import org.java.mapppers.BiblioMapper;
import org.java.models.Author;

public class AuthorDaoJdbc implements AuthorDao {
	private String tableName = "authors";
	private DataBase db;
	
	public AuthorDaoJdbc(DataBase db) {
		this.db = db;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public List<Author> selectAll() {
		List<Author> authors = new Vector<Author>();
		String[][] data = db.select(tableName);
		for (int i = 1; i < data.length; i++) {
			authors.add(new Author(data[i]));
		}
		return authors;
	}

	@Override
	public int insert(Author author) {
		return db.insert(tableName, author.getId(), author.getName(), author.getYearBorn());
	}

	@Override
	public void update(Author author) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Author select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> selectAuthorsByIsbn(String isbn) {
		String query = "SELECT * FROM authors a, title_author ta WHERE ta.isbn = '" + isbn
				+ "' and a.au_id = ta.au_id";
		String[][] data = db.executeQuery(query);
		List<Author> authors = new Vector<Author>();
		for(int i = 1; i < data.length;i++) {
			authors.add(new Author(data[i]));
		}
		return authors;
	}
	
}

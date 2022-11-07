package org.java.dao;

import java.util.List;

import org.java.models.Author;


public interface AuthorDao {
	public List<Author> selectAll();
	public int insert(Author author);
	public void update(Author author);
	public Author select(int id);
	public Author delete(int id);
	public List<Author> selectAuthorsByIsbn(String isbn);
}

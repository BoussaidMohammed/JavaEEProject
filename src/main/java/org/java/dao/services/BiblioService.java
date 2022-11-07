package org.java.dao.services;

import java.util.List;

import org.java.models.Author;
import org.java.models.Title;

public interface BiblioService {
	public int addAuthor(Author author);
	public Author getAuthor(int id);
	public List<Author> getAuthors();
	public List<Title> getTitlesBykeyword(String keyword);
}

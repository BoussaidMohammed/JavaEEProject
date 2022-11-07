package org.java.dao.services;

import java.util.List;

import org.java.dao.AuthorDao;
import org.java.dao.AuthorDaoJdbc;
import org.java.dao.PublisherDao;
import org.java.dao.TitleDao;
import org.java.jdbc.DataBase;
import org.java.jdbc.MySQLDataSource;
import org.java.models.Author;
import org.java.models.Title;

public class DefaultBiblioService implements BiblioService {
	private AuthorDao authorDao;
	private TitleDao titleDao;
	private PublisherDao publisherDao;
	@Override
	public int addAuthor(Author author) {
		return authorDao.insert(author);
	}
	

	public DefaultBiblioService(AuthorDao authorDao, TitleDao titleDao, PublisherDao publisherDao) {
		super();
		this.authorDao = authorDao;
		this.titleDao = titleDao;
		this.publisherDao = publisherDao;
	}



	@Override
	public Author getAuthor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> getAuthors() {
		return authorDao.selectAll();
	}
	


	@Override
	public List<Title> getTitlesBykeyword(String keyword) {
		List<Title> titles =  titleDao.selectByKeyword(keyword);
		for(Title t : titles) {
			t.setPublisher(publisherDao.select(t.getPublisher().getId()));
			List<Author> authors = authorDao.selectAuthorsByIsbn(t.getIsbn());
			t.setAuthors(authors);
		}
		return titles;
	}
}

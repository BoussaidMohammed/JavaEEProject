package org.java.actions;

import java.util.List;

import org.java.dao.services.BiblioService;
import org.java.models.Author;
import org.java.models.Title;
import org.java.web.ParameterResolver;

public class BiblioActions {
	private BiblioService service;
	private Object model;
	private ParameterResolver resolver;
	
	public Object getModel() {
		return model;
		
	}
	
	public BiblioActions(BiblioService service, ParameterResolver resolver) {
		this.service = service;
		this.resolver = resolver;
	}
	
	public String listAuthors() {
		model = service.getAuthors();
		return "ListAuthors";
	}
	
	public String example() {
		model = new Author(101, "James Gosling", 1955);
		return "Example";
	}
	
	public String addAuthor() {
		Author author = resolver.getAuthor();
		int rs = service.addAuthor(author);
		if(rs == -1) {
			model = "Erreur d'insertion";
			return "addAuthorFail";
		}
		model = "Ajoute d'auteur avec success";
		return "AddAuthorSuccess";
	}

	public String titleList() {
		String keyword = resolver.getKeyword();
		List<Title> titles = service.getTitlesBykeyword(keyword);
		model = titles;
		return "ListTitles";
	}
	
}

package org.java.web;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.java.models.Author;

public class HttpParameterResolver implements ParameterResolver{
	private HttpServletRequest request;
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public Author getAuthor() {
		Author a = new Author();
		a.setId(intParameter("id"));
		a.setName(parameter("name"));
		a.setYearBorn(intParameter("yearBorn"));
		return a;
	}

	private int intParameter(String param) {
		try {
			int nbParam = Integer.parseInt(parameter(param));
			return nbParam;
		} catch (Exception e) {
			return 0;
		}
		
	}
	
	private String parameter(String param) {
		return request.getParameter(param);
	}

	@Override
	public String getKeyword() {
		return parameter("keyword");
	}
}

package org.java.web;

import javax.servlet.http.HttpServletRequest;

import org.java.models.Author;

public interface ParameterResolver {
	Author getAuthor();
	void setRequest(HttpServletRequest request);
	String getKeyword();
}

package org.java.dao;

import java.util.List;

import org.java.models.Title;



public interface TitleDao {
	public List<Title> selectByKeyword(String keyword);
}

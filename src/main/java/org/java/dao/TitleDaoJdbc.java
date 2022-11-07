package org.java.dao;

import java.util.List;
import java.util.Vector;

import org.java.jdbc.DataBase;
import org.java.mapppers.BiblioMapper;
import org.java.models.Title;

public class TitleDaoJdbc implements TitleDao {

	private String tablename = "titles";
	private DataBase db ;
	
	
	public TitleDaoJdbc(DataBase db) {
		super();
		this.db = db;
	}
	
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}


	public List<Title> selectByKeyword(String keyword) {
		String[][] data =  db.selectLike(tablename, "Title", keyword);
		List<Title> titles = new Vector<Title>();
		for (int i = 1; i < data.length; i++) {
			Title t = BiblioMapper.getTitle(data[i]);
			titles.add(t);
		}
		return titles;
	}

}

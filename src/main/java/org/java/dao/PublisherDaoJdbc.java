package org.java.dao;

import org.java.jdbc.DataBase;
import org.java.mapppers.BiblioMapper;
import org.java.models.Publisher;

public class PublisherDaoJdbc implements PublisherDao{
	private String tablename = "publishers";
	private DataBase db;
	
	public PublisherDaoJdbc(DataBase db) {
		this.db = db;
	}
	
	@Override
	public Publisher select(int id) {
		String[][] data = db.selectLike(tablename, "Publisher_ID", id);
		if(data != null && data.length > 1) {
			return  BiblioMapper.getPublisher(data[1]);
		}else {
			return null;
		}
	}

}

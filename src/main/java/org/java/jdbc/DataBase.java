package org.java.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Iterator;

public class DataBase {
	private DataSource dataSource;
	private Connection connection;

	public DataBase(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
		connection = dataSource.getConnection();
	}
	
	public String[][] executeQuery(String query){
		String[][] data = null;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			//rs.executeQuery pour les requetes de type select
			rs.last(); int rows = rs.getRow();
			rs.beforeFirst();ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			data = new String[rows + 1][cols];
			for(int i = 0;i < cols; i++) {
				data[0][i] = rsm.getColumnName(i + 1);
			}
			int row = 0;
			while(rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
				}
			}
		}catch(Exception e) {
			System.out.println("Error :" +e.getMessage());
		}
		
		return data;
	}
	
	public String[][] select(String tableName){
		return executeQuery("SELECT * FROM "+ tableName);
	}
	
	public int insert(String tablename, Object...row) {
		String query = "INSERT INTO " + tablename + " VALUES('" + row[0] + "'";
		for (int i = 1; i < row.length; i++) {
			query += ",'" + row[i] + "'";
		}
		
		query += ")";
		Statement st;
		try {
			st = connection.createStatement();
			return st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error :" + e.getMessage());
			return -1;
		}
		
	}
	
	public String[][] selectLike(String tableName, String key, Object value){
		return executeQuery("SELECT * FROM " + tableName + " WHERE " + key + " LIKE '%"+ value + "%'");
	}
}

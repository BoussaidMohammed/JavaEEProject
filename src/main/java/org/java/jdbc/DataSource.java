package org.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

abstract public class DataSource {
	private String driver;
	private String bridge;
	private String host;
	private String source;
	private String user;
	private String password;
	
	public DataSource(String driver, String bridge, String host, String source, String user, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.user = user;
		this.password = password;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			String url = bridge + "//" + host + "/" + source;
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("connection bien établie");
		}catch(Exception e) {
			System.out.println("Errror "+e.getMessage());
		}
		return connection;
	}
	
	
}

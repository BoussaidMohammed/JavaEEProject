package org.java.jdbc;

public class MySQLDataSource extends DataSource{
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQ_BRIDGE = "jdbc:mysql:";
	
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQ_BRIDGE, "localhost", source, "root", "");
	}
}

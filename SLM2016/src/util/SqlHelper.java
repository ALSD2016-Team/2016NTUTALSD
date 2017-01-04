package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

public class SqlHelper {
	public static String SuccessString="Success";
	public static String FailString="Fail";
//	private final String DB_URL = "jdbc:mysql://45.32.62.194:3306/SLM2016?useUnicode=true&characterEncoding=utf-8";
//	private final String DB_URL = "jdbc:sqlite:C:\\Users\\leo\\Desktop\\courseCreate\\slm2016.db";
//	private final String DB_URL = "jdbc:sqlite:C:\\Users\\leo\\Desktop\\2015ALSM\\SLM2016\\slm2016.db";
	private final String DB_URL = "jdbc:sqlite:slm2016.db";
//	private final String ACCOUNT = "SLM2016";
//	private final String PASSWORD = "Teddysoft";
	
	private Connection connection = null;
	private Statement statement = null;

	public SqlHelper() {
	}

	
	public String excuteSql(String sqlString,CachedRowSet responseData) {
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.sqlite.JDBC");
			
			System.out.println("OOOOOO1");
			//connection = DriverManager.getConnection(DB_URL, ACCOUNT, PASSWORD);
			connection  = DriverManager.getConnection(DB_URL);
			
			System.out.println("OOOOOO2");
			statement = connection.createStatement();
			
			
			System.out.println("OOOOOO3");
			 ResultSet resultSet= statement.executeQuery(sqlString);
			 //statement.executeQuery(sql)
			//statement.execute(sqlString);
			 
			 System.out.println("OOOOOO4");
			responseData.populate(resultSet);
	
			
			System.out.println("OOOOOO5");
		} catch (ClassNotFoundException e) {
			return "JDBC Driver Exception! " + e.toString();
		} catch (SQLException e) {
			return "Excute SqlCommand Error! " + e.toString();
		} finally {
			try {if (statement != null) statement.close(); } catch (Exception e) {return "Statement Close Fail!" + e.toString();}
			try {if (connection != null)connection.close();} catch (Exception e) {return "Connection Close Fail!" + e.toString();}
		}
		return SuccessString;	
	}
}

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

public class sqliteHelper {
	public static String SuccessString="Success";
	public static String FailString="Fail";
	private final String DB_URL = "jdbc:sqlite:C:/Users/leo/Desktop/2015ALSM/SLM2016/slm2016.db";

	public sqliteHelper() {
	}
	
	public String excuteSql(String sqlString,CachedRowSet responseData) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(DB_URL);
			statement = connection.createStatement();
			statement.execute(sqlString);	
			if(statement.getResultSet()!=null)
			{
				responseData.populate(statement.getResultSet());
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (SQLException e) {
			return "Excute SqlCommand Error! " + e.toString();
		} finally {
			try {if (statement != null) statement.close(); } catch (Exception e) {return "Statement Close Fail!" + e.toString();}
			try {if (connection != null)connection.close();} catch (Exception e) {return "Connection Close Fail!" + e.toString();}
		}
		return SuccessString;	
	}
}

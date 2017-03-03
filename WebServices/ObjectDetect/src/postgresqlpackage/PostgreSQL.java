package postgresqlpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQL {
	//Ket noi
	public Connection ConnectionPostgreSQL(String hostName, String userName, String password) {
		Connection c = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return c;
		}
		
		try {
			c = DriverManager.getConnection(hostName, userName, password);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			return c;
		}
		System.out.println("Opened database successfully");
		return c;
	}
	
	public static ResultSet SelectAll(String sql,Connection c,Statement stmt){	
		ResultSet rs;
		try {
			stmt = c.createStatement(ResultSet.CONCUR_UPDATABLE, 1);
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void Close(Connection c) throws SQLException
	{
		c.close();
	}

}

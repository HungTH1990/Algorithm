package objectpackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import postgresqlpackage.PostgreSQL;

public class DataSet {
	public static Connection c = null;
	public PostgreSQL postgreSQL = new PostgreSQL();
	Statement stmt = null;
	
	public DataSet(String hostName, String userName, String password)
	{
		c = postgreSQL.ConnectionPostgreSQL(hostName, userName, password);
	}
	
	public HashMap<String, List<String>> readDataFromPostgreSQL(String sql)
	{
		HashMap<String, List<String>> allObject = new HashMap<String, List<String>>();
		int columnCount = 0;
		
		try {
			//String sql = "SELECT * FROM my_table LIMIT 100;";
			ResultSet rs = PostgreSQL.SelectAll(sql, c, stmt);
			ResultSetMetaData rsm = rs.getMetaData();
			columnCount = rsm.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				List<String> listString = new ArrayList<String>();
				rs.first();
				do {
					listString.add(rs.getString(i));
				} while (rs.next());
				allObject.put(rsm.getColumnLabel(i), listString);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			return allObject;
		}
		try {
			PostgreSQL.Close(c);
		} catch (SQLException e) {
			e.printStackTrace();
			return allObject;
		}
		return allObject;
	}
	
}

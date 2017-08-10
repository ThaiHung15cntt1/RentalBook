package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {
	public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url="jdbc:sqlserver://localhost:1433;databaseName=RentalBook";
	public static String user = "sa";
    public static String password = "1234";
    
    public static Connection open()
    {
    	try
    	{
    		Class.forName(driver);
    		return DriverManager.getConnection(url, user, password);
    	}
    	catch(Exception ex)
    	{
    		ex.getMessage();
    	}
    	return null;
    }
}

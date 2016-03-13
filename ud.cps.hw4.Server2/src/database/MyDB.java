package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sample.Msg;

public class MyDB {
	private static Connection conn;
	public static void getConnection()

	{
		try{
			if(conn == null || !conn.isValid(0))
			{
				String driver = "com.mysql.jdbc.Driver";

				String url = "jdbc:mysql://localhost:3306/ChatHistory";

				String username = "root";

				String password = "Luxinzhong91";

				Class.forName(driver);


				conn = DriverManager.getConnection(url, username, password);

				System.out.println("Connection is established.");
			}
		}

		catch(Exception e)

		{

			e.printStackTrace();

		}
	}
	public static void createTable() throws Exception{

		try{


			getConnection();

			Statement stmt = conn.createStatement();



			String sql = "CREATE TABLE IF NOT EXISTS records " +

                  "(id INTEGER not NULL AUTO_INCREMENT, " +

                  " user VARCHAR(255), " + 

                  " message VARCHAR(255), " + 

                  " time VARCHAR(20), " + 

                  " PRIMARY KEY ( id ))"; 

			stmt.executeUpdate(sql);
			System.out.println("Table is created successfully!");
		}catch(Exception e)

		{

			e.printStackTrace();

		}finally{

		}

	}

	public static void insertMsg(Msg m){
		try{

			getConnection();

			Statement stmt = conn.createStatement();

			stmt.executeUpdate("Insert into records values("
					+ "null,'"+m.getName() +"','"+m.getContent() +"','"+m.getTime() +"')");

		}catch(Exception e){

			e.printStackTrace();

		}finally{
		}

	}
	public static ResultSet getRecords(String command){

		try{

			getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(command);


			return rs;

		}catch(Exception e){

			e.printStackTrace();

		}finally{

		}
		return null;

	}
	public static Msg convertToMsg(ResultSet rs)
	{
		Msg m;
		try {
			m = new Msg(rs.getString("user"),rs.getString("message")," ",rs.getString("time"));
			return m;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}

package application;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;



public class Main{
	static Connection conn;

	public static void main(String[] args) {
		try {
			createTable();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executePsmt("Pii","Mpp",20);
		showRecords();

	}

	public static void getConnection()

	{
		try{
			if(conn == null || !conn.isValid(0))
			{
				String driver = "com.mysql.jdbc.Driver";

				String url = "jdbc:mysql://localhost:3306/java_proj";

				String username = "root";

				String password = "Luxinzhong91";

				Class.forName(driver);


				conn = DriverManager.getConnection(url, username, password);

				System.out.println("Connection is established.");
			}
		}

		catch(Exception e)

		{

			System.out.println(e);

		}






	}
	public static void createTable() throws Exception{

		try{


			getConnection();

			Statement stmt = conn.createStatement();



			String sql = "CREATE TABLE IF NOT EXISTS registration " +

                  "(id INTEGER not NULL, " +

                  " first VARCHAR(255), " + 

                  " last VARCHAR(255), " + 

                  " age INTEGER, " + 

                  " PRIMARY KEY ( id ))"; 



			stmt.executeUpdate(sql);

		}catch(Exception e)

		{

			System.out.println(e);

		}finally{

			System.out.println("Table is created successfully!");

		}

	}
	public static void insertRecords(String command){
		try{

			getConnection();

			Statement stmt = conn.createStatement();

			stmt.executeUpdate(command);

		}catch(Exception e){

			System.out.println(e);

		}finally{

			System.out.println("Records are inserted successfully!");

		}

	}
	public static ResultSet getRecords(String command){

		try{

			getConnection();

			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(command);


			return rs;

		}catch(Exception e){

			System.out.println(e);

		}finally{

			System.out.println("Records are inserted successfully!");

		}


		return null;

	}
	private static void executePsmt(String first,String last,int age)
	{
		getConnection();
		try {
			PreparedStatement psmt=conn.prepareStatement("Insert into registration values(?,?,?,?)");
			psmt.setNull(1,1);
			psmt.setString(2,first);
			psmt.setString(3, last);
			psmt.setInt(4, age);
			psmt.executeUpdate();
	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	private static void showRecords()
	{
		String sql;
		sql = "SELECT id, first, last, age FROM Registration";

		ResultSet rs = getRecords(sql);

		try {
			while(rs.next()){

				//Retrieve by column name

				int id  = rs.getInt("id");

				int age = rs.getInt("age");

				String first = rs.getString("first");

				String last = rs.getString("last");

				//Display values

				System.out.print("ID: " + id);

				System.out.print(", Age: " + age);

				System.out.print(", First: " + first);

				System.out.println(", Last: " + last);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
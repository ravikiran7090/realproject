package PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;

public class Jdbc2 {

	

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String ProjectName = "amazon";
		try{
			Driver driverref= new Driver();
			//step1: load/register*mysql* the database
			DriverManager.registerDriver(driverref);
			//step2: connect to db
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			System.out.println("connection done");
			//step3: create a query statement
			Statement stat = conn.createStatement();
			String query = "select * from project";
			//step4:execute the query
		
			ResultSet resultset = stat.executeQuery(query);
			boolean flag=false;
			while(resultset.next()){
				String actprojectName = resultset.getString(4);
				if(actprojectName.equals(ProjectName)){
					flag=true;
				}
			}
			
			Assert.assertTrue(flag);
		}
				
		catch (Exception e) {
		}
		finally 
		{	//step5: close the connection
			conn.close();
			System.out.println("====close db connection==");
			
		}
		
		}

	}

	

package testng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class projectUnitTest {
	@Test
	public void projectUnitTest() throws SQLException{
		Connection conn=null;
		String project_name = "amazon_1";
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
				if(actprojectName.equals(project_name)){
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
	



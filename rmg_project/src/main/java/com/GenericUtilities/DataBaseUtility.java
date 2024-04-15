package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con = null;
	
	public void connectToDB() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstant.DBURL,IPathConstant.DBUsername , IPathConstant.DBPassword);
		
	}
	
	public void executeAndgetData(String query,int colIndex,String expData) throws SQLException {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		 boolean flag = false;
		 while(result.next())
		 {
			 String actualResult = result.getString(colIndex);
			 if(actualResult.contains(expData)) {
				flag = true;
				break;
			 }
		 }
		 if(flag==true) {
			 System.out.println("--data is verified--");
		 }
		 else {
			 System.out.println("--data is not present");
		 }
		 
		 
	}
	public void closeDB() throws SQLException {
		con.close();
	}
}

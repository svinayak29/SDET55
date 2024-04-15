package testng;

import org.testng.annotations.DataProvider;

public class DataStore {

	
	@DataProvider
	public Object[][] data() {
		Object obj[][]= new Object[2][2];
		
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="admin";
		obj[1][1]="Test@123";
		
		return obj;
		
		
	}
}

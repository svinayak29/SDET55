package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {

	
	
	@BeforeSuite
	public void bs() {
		System.out.println("connect to db");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("logOut from Appln");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("close the browser");
	}
	
	@Test
	
	public void testScript1() {
		System.out.println("test script 1");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("login to Appln");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("close the db");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("launch the browser");
	}
	
	@Test
	public void testScript2() {
		System.out.println("test Script 2");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

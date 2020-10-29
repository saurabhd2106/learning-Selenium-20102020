package day6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGClass2 {
	
	@BeforeSuite
	public void beforeASuite() {
		System.out.println("Before a suite");
	}
	
	@AfterSuite
	public void afterASuite() {
		System.out.println("After a suite");
	}
	
	@BeforeTest
	public void beforeATest() {
		System.out.println("Before a test..");
	}
	
	@AfterTest
	public void afterATest() {
		System.out.println("After a test..");
	}
	
	@BeforeClass
	public void beforeAClass() {
		System.out.println("First method of this class..");
	}
	
	@AfterClass
	public void afterAClass() {
		System.out.println("Last Method of this class..");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeATestcase() {
		System.out.println("Before a test case..");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterATestcase() {
		System.out.println("After a test case..");
	}
 
	@Test(priority = 0)
	public void testcase1() {
		
		System.out.println("Test case 1...");
		
	}
	
	@Test(priority = 1)
	public void testcase5() {
		
		System.out.println("Test case 5...");
		
	}
	
	
	@Test(priority = -1, groups = "Sanity")
	public void testcase2() {
		
		System.out.println("Test case 2...");
		
	}
	
	@Test(priority = 7)
	public void testcase3() {
		
		System.out.println("Test case 3...");
		
	}
}

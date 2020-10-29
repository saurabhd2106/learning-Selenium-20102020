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

public class TestNGClass1 {
	
	@BeforeSuite(alwaysRun = true)
	public void beforeASuite() {
		System.out.println("Before a suite");
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterASuite() {
		System.out.println("After a suite");
	}
	
	@BeforeTest(alwaysRun = true)
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
		System.out.println("Before a Class 1 Test case..");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterATestcase() {
		System.out.println("After a Class 1 Test case..");
	}
 
	@Test(priority = 0)
	public void testcase1() {
		
		System.out.println("Class 1 Test case 1...");
		
	}
	
	@Test(priority = 10000, groups = {"Sanity"})
	public void testcase5() {
		
		System.out.println("Class 1 Test case 5...");
		
	}
	
	
	@Test(priority = -10000)
	public void testcase2() {
		
		System.out.println("Class 1 Test case 2...");
		
	}
	
	@Test(priority = 20000, groups = "Sanity")
	public void testcase3() {
		
		System.out.println("Class 1 Test case 3...");
		
	}
}

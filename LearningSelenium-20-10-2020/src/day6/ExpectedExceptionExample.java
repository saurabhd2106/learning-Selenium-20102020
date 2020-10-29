package day6;

import org.testng.annotations.Test;

public class ExpectedExceptionExample {
	
	@Test(priority = -1, expectedExceptions = ArrayIndexOutOfBoundsException.class)
	public void testcase2() {
		
		int[] numbers = new int[5];
		
		numbers[1] = 90;
		numbers[3] = 90;
		numbers[2] = 90;
		numbers[4] = 90;
	//	numbers[5] = 90;
		
		
	}

}

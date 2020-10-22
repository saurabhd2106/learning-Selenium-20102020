package day2;

public class DemoGuru99 {
	
	public static void main(String[] args) {
		
		Guru99Project guru = new Guru99Project();
		
		guru.invokeBrowser();
		
		guru.loginToApplication("mngr291233", "hEnYhuv");
		
		String titleOFThePage = guru.getTitle();
		
		/*System.out.println("Title of the page - "+ titleOFThePage);
		
		guru.addCustomer();
		
		String customerId = guru.getCutomerId();
		
		System.out.println("Customer Id - "+ customerId);
		
		guru.addAccount(customerId);*/
		
		guru.logout();
		
		guru.closeBrowser();
		
	}

}

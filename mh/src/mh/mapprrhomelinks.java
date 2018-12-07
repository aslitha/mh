package mh;

import java.io.IOException;

public class mapprrhomelinks {
	

	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// WebDriver driver=new ChromeDriver();
		methodsclass call=new methodsclass();
		call.openmapprr();
	    Thread.sleep(3000);
	    call.locationenable();
		// call.company();
		//call.socialmedia();
	    Thread.sleep(3000);
		//call.login();
		 //Thread.sleep(5000);
		// call.appdownloadbuttons();
		 //call.FAQ();
		// call.myaccountclicking();
		// call.myaccountdetails();
	   //  call.myaccount_subcategories();
		// Thread.sleep(2000);
		// call.popularlocationindia();
		//call.popularstoresinindia();
	    //call.popular_brands_in_india();
		// Thread.sleep(3000);
		 // call.FeaturedCategories();
		 //Thread.sleep(3000);
		//call .FoodandGroceries();
		// call.RemovingMycartProducts();
		 // call.Careers();
		// call.contactus();
		// call.logout();
	    call.Homepage_Subcategories();
		 
		 
		 
		
		
		
	
	}

}

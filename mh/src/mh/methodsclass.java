package mh;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.StaleElementReferenceException;

import javax.swing.text.View;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.AlertHandler;

public class methodsclass extends mapprrhomelinks 
{
	WebDriver driver=new ChromeDriver();
	String featcat[]= {"Food-and-Groceries?query=84bNiiHFE20Nwrptvnn1yg==","Health-and-Beauty?query=ML8RNj9MWxtWWgYODzPadA==","Electronics?query=y3GFz+xoXRSG3zLIVGML8g==","Health-and-Pharmacy?query=68jmucEwXArJaB6xd6BHZw==","Books-and-Stationery?query=FEqZbgzNtPEHq82oD2lnUA=="};
	String stores[]= {"Spar","Reliance Digital","Pai Electronics","FirstCry","Big C","Lot Mobiles","MedPlus","Apollo Pharmacy","Nykaa","New U","The Body Shop","Himalaya"};
	String location[]= {"Mumbai","Pune","Kolkata","Kanpur","Ahmedabad","New Delhi","Bengaluru","Chennai","Hyderabad","Visakhapatnam","Kochi","Vijayawada"};
	String brands[]= {"Gsk","Apple","Alembic","Oppo","Spar Fresh","Lupin","Pampers","Durex","Pfizer","Eveready","Cipla","Bose"};
	public void openmapprr()
	{
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		// WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.mapprr.com");
	}
	//***************************************************************************************************************************************************************************************
	public void company() throws InterruptedException {
		
		String linktext[]= {"Home","Privacy Policy",  "About Us","Careers","Contact Us","Team","Terms & Conditions","Refund Policy","Blogs"};
		for (int i=0;i<linktext.length;i++) {
		driver.findElement(By.xpath("//*[contains(text(),'"+linktext[i]+"')]")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = driver.findElement(By.xpath("//*[contains(text(),'"+linktext[i]+"')]")).getText();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println(actualTitle);	
		}
		else {
			System.out.println(expectedTitle+" page title is = "+actualTitle);
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		}
		
	}
	//***************************************************************************************************************************************************************************************
	public void socialmedia() throws InterruptedException {
		String media[]= {"Mapprr facebook","Mapprr instagram","Mapprr linkedin","Mapprr twitter","Mapprr google-plus"};
		for(int i=0;i<media.length;i++) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1500);
			WebElement so=driver.findElement(By.xpath("//*[contains(@title,'"+media[i]+"')]"));
			System.out.println(so.getAttribute("href"));
			so.click();
			driver.navigate().to("https://qa.mapprr.com");
		}
	}
	//***************************************************************************************************************************************************************************************
	public void login() throws InterruptedException {
		driver.navigate().to("https://qa.mapprr.com");
		Thread.sleep(2000);
		driver.findElement(By.id("login_btn")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id=\"mobile\"]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//*[contains(@class,'common_btn login_submit_modal')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"otp\"]")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"otp_form\"]/div[3]/div/button")).click();
		System.out.println("login completed successfully");
	}
	//***************************************************************************************************************************************************************************************
	public void appdownloadbuttons() throws InterruptedException {
		for(int i=1;i<=2;i++) 
		{
			WebElement apps=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/div[2]/a["+i+"]"));
			System.out.println(apps.getAttribute("href"));
			Thread.sleep(2000);
			apps.click();
			driver.navigate().to("https://qa.mapprr.com");
		}
	}
	//***************************************************************************************************************************************************************************************
	public void myaccountclicking() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"h_profile\"]/img")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		System.out.println("My account is opened");
	}
	//***************************************************************************************************************************************************************************************
	public void myaccountdetails() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("My Account Details are given below");
		for(int i=1;i<=5;i++) 
		{
			WebElement account=driver.findElement(By.xpath("//*[@id=\"full_profile\"]/div[1]/div["+i+"]/div[1]/div"));
		for(int j=i;j<=i;j++) 
			{
				WebElement data=driver.findElement(By.xpath("//*[@id=\"full_profile\"]/div[1]/div["+j+"]/div[2]/div"));
				System.out.println(account.getText() + ":" +data.getText());
			}
		}
		
	
	}
	//***************************************************************************************************************************************************************************************
	public void FAQ() throws InterruptedException {
		for(int i=2;i<=4;i++) {
			WebElement quest=driver.findElement(By.xpath("//*[@id=\"full_profile\"]/div[3]/div/div["+i+"]/div[1]"));
			System.out.println(i+".question = "+ quest.getText());
			for(int j=i;j<=i;j++) {
				WebElement answ=driver.findElement(By.xpath("//*[@id=\"full_profile\"]/div[3]/div/div["+j+"]/div[2]"));
				System.out.println(i+".answer = "+ answ.getText());
			}
		}
	}
	//***************************************************************************************************************************************************************************************
	public void myaccount_subcategories() throws InterruptedException {
		Thread.sleep(3000);
		for(int i=1;i<=8;i++) {
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"myGroup\"]/div[2]/div/div/a["+i+"]"));
		Thread.sleep(3000);
		ele.click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement products=driver.findElement(By.className("profile_main_grid_in"));
		if (products.isEnabled())
		{
			System.out.println(products.getAttribute("class"));	
			System.out.println(products.getText());
			
		}
		}
	}
	//***************************************************************************************************************************************************************************************
	public void locationenable(){
		driver.findElement(By.id("detect_loc")).click();
		System.out.println("successfully accessed the location");
	}
	//***************************************************************************************************************************************************************************************
	public void popularlocationindia() throws InterruptedException {
		Thread.sleep(2000);
		String location[]= {"Mumbai","Pune","Kolkata","Kanpur","Ahmedabad","New Delhi","Bengaluru","Chennai","Hyderabad","Visakhapatnam","Kochi","Vijayawada"};
		for(int i=0;i<location.length;i++) {
			WebElement loca=driver.findElement(By.xpath("//*[contains(text(),'"+location[i]+"')]"));
			Thread.sleep(3000);
			loca.click();
			Thread.sleep(3000);
			WebElement place=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/span[2]"));
			System.out.println(location[i]+ " = " +place.getText());
	}
	}
	//***************************************************************************************************************************************************************************************
	public void popularstoresinindia() throws InterruptedException {
		Thread.sleep(2000);
		String stores[]= {"MedPlus","Nykaa","Big C","Ratnadeep Super Market","Vijetha Super Market","Ghanshyam Super Market","Healthkart","The Body Shop","Apollo Pharmacy","New U"};
		for(int i=0;i<stores.length;i++) {
			WebElement sto=driver.findElement(By.xpath("//*[contains(text(),'"+stores[i]+"')]"));
			Thread.sleep(3000);
		    JavascriptExecutor js=(JavascriptExecutor)driver;
			sto.click();
			for(int j=0;j<location.length;j++) {
				Thread.sleep(3000);
				WebElement loco=driver.findElement(By.xpath("//*[contains(text(),'"+location[j]+"')]"));
				Thread.sleep(3000);
				js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
				loco.click();
				Thread.sleep(3000);
				js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
				List<WebElement> details = driver.findElements(By.className("profile_s_card"));
					for(WebElement det : details) 
					{
						if(det.isEnabled()) 
						{
							System.out.println(" In "+ location[j] +"  "+ stores[i] + "  stores are ");
							System.out.println(det.getText());
					}
						else {
							System.out.println(" No" +stores[i] + "stores");
						}
				}
			}
			
		}
	}
	//*********************************************************************************************************************************************************************************************
	public void popular_brands_in_india() throws InterruptedException {
		Thread.sleep(2000);
		String brands[]= {"Gsk","Apple","Alembic","Oppo","Lupin","Pampers","Durex","Pfizer","Eveready","Cipla","Bose"};//,"Spar Fresh"
		for(int i=0;i<brands.length;i++) {
			driver.get("https://qa.mapprr.com/products-by-brand/"+brands[i]);
			WebElement top=driver.findElement(By.className("brand_heading"));
			Thread.sleep(2000);
			List<WebElement> top1=driver.findElements(By.className("p_details"));
			for(WebElement top2:top1) {
				System.out.println(top.getText());
				System.out.println(top2.getText());
			}
		}
		
	}
//***************************************************************************************************************************************************************************************
public void FeaturedCategories() throws InterruptedException {
	Thread.sleep(4000);
	String featcat[]= {"Food-and-Groceries?query=84bNiiHFE20Nwrptvnn1yg==","Health-and-Beauty?query=ML8RNj9MWxtWWgYODzPadA==","Electronics?query=y3GFz+xoXRSG3zLIVGML8g==","Health-and-Pharmacy?query=68jmucEwXArJaB6xd6BHZw==","Books-and-Stationery?query=FEqZbgzNtPEHq82oD2lnUA=="};
	for(int i=0;i<=featcat.length;i++) {
		driver.get("https://qa.mapprr.com/products-by-category/"+featcat[i]);
		Thread.sleep(4000);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		List<WebElement> elements=driver.findElements(By.className("p_details"));
		for(WebElement elementtext:elements) {
			System.out.println(elementtext.getText());
		}
		Thread.sleep(2000);
	
	}
	driver.navigate().back();
	
}
//********************************************************************************************************************************************************************************************************************************************************************************************************
public void FoodandGroceries() throws InterruptedException {
	// for(int i=0;i<=featcat.length-1;i++) {
	driver.get("https://qa.mapprr.com/products-by-category/"+featcat[0]);
	Thread.sleep(3000);
	System.out.println(driver.getCurrentUrl());
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,500)");
	driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[3]/div[4]/div[3]")).click();//i can change product by changing last div number//
	Thread.sleep(3000);
	for (String handle : driver.getWindowHandles()) {

		   driver.switchTo().window(handle);}
	List<WebElement> cart1=driver.findElements(By.className("add_c"));
	if (driver.findElements(By.className("empty_state_txt")).size() != 0)// add to cart
	{
		WebElement noprod = driver.findElement(By.className("empty_state_txt"));
		System.out.println(noprod.getText());
	}
	else if(driver.findElements(By.className("coming_soon")).size() != 0){
		System.out.println("Out Of Stock");
	}
	else
	{
		Thread.sleep(3000);
		for(WebElement elementtext:cart1)
		{
			Thread.sleep(3000);
			elementtext.click();
			System.out.println(" click on Add to cart");
		}
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[4]/a")).click();
			System.out.println("click on View cart");
			Thread.sleep(3000);
			WebElement butttonToClick = driver.findElement(By.xpath("//a[@class='common_btn proceed_checkout']"));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",butttonToClick );
			System.out.println("click on Proceed to Pay");
			 Thread.sleep(3000);
			List<WebElement> addr=driver.findElements(By.className("adr_pickup"));
			if(addr.size() != 0) {
			for(WebElement add:addr)
				if (add.isEnabled()) {
					add.click();
					System.out.println("Address is selected");
				}
			}
			else
			{
				WebElement new_address = driver.findElement(By.xpath("//*[contains(text(),'Add Address')]"));
				new_address.click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@id=\"delivery_adrs\"]")).sendKeys("2-107/2");
				driver.findElement(By.xpath("//*[@id=\"delivery_nearby\"]")).sendKeys("police station");
				driver.findElement(By.xpath("//*[@id=\"add_adrs_form\"]/div[4]/div/label[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"add_adrs_form\"]/button[1]")).click();
				Thread.sleep(3000);
				List<WebElement> addr1=driver.findElements(By.className("adr_pickup"));
				for(WebElement add1:addr1) {
				add1.click();
				System.out.println("Address is selected");}
			}
			Thread.sleep(4000);
			JavascriptExecutor sj=(JavascriptExecutor)driver;
			sj.executeScript("window.scrollBy(0,1000)");
				System.out.println("page is scrolled");
			Thread.sleep(5000);
			List<WebElement>cash=driver.findElements(By.className("ch_payment"));
			for(WebElement cash1:cash)
			{
				cash1.click();
				Thread.sleep(5000);
			}
			Thread.sleep(4000);
			WebElement pay=driver.findElement(By.xpath("//*[@id=\"rzp-button1\"]"));
			Actions action=new Actions(driver);
			action.moveToElement(pay).click();
			action.perform();
}
	
}
//}
//***********************************************************************************************************************************************************************************************
public void Homepage_Subcategories() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,800)");
	for(int i=1;i<=4;i++) {
		WebElement grid=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/a["+i+"]/div/div/div[2]"));
		Thread.sleep(4000);
		System.out.println("click on  "+grid.getText());
		grid.click();
		Thread.sleep(3000);
		driver.navigate().back();
	}
}
//******************************************************************************************************************************************************************************************
public void RemovingMycartProducts() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[3]/div/span/span[1]/a[1]/img")).click();
	System.out.println("My cart is opened");
	List<WebElement> products=driver.findElements(By.className("container pd_card"));
	System.out.println("have to clilck on remove ");
	if(products.size()!=0) {
		for(WebElement pro:products) {
			pro.isEnabled();
			driver.findElement(By.xpath("//*[contains(text(),'Remove')]")).click();
		}
	}else {
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div/div/div/a")).click();
	}
	
}
//**********************************************************************************************************************************************************************************
public void Careers() throws InterruptedException, IOException {
	System.out.println("Hello Tester now i am Testing Careers Page");;
	driver.get("https://qa.mapprr.com/careers");
	System.out.println("careers page is opened");
	Thread.sleep(3000);
	//driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[1]/a")).click();
	System.out.println("click on see our openings");
	List<WebElement> positions= driver.findElements(By.className("panel"));
	System.out.println(positions.size());
	if(positions.size()!=0) {
		for(int i=2;i<=2;i++) {
			driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[1]/a")).click();
			Thread.sleep(5000);
			JavascriptExecutor js3=(JavascriptExecutor)driver;
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"accordion\"]/div["+i+"]/div[1]/h4/a/div/div[3]/button")).click();
			// System.out.println(positions.get(i-1).getText());
			Thread.sleep(3000);
			js3.executeScript("window.scrollBy(0,500)");
			System.out.println("page is scrolled");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[contains(@name,'first_name')]")).sendKeys("sony");
			driver.findElement(By.xpath("//*[contains(@name,'last_name')]")).sendKeys("somuch");
			driver.findElement(By.xpath("//*[contains(@name,'mobile')]")).sendKeys("9876546787");
			driver.findElement(By.xpath("//*[contains(@name,'email')]")).sendKeys("sony@sony.com");
			driver.findElement(By.xpath("//*[contains(@name,'quality')]")).sendKeys("i am very good girl");
			driver.findElement(By.className("attach_cv")).click();
			Runtime.getRuntime().exec("C:\\Users\\user\\Desktop\\autoit\\file1.exe");
			System.out.println("Resume uploded successfully");
			Thread.sleep(3000);
			JavascriptExecutor js31=(JavascriptExecutor)driver;
			js31.executeScript("window.scrollBy(0,30)");
			Thread.sleep(4000);
			String submit[]= {"ios","full_stack"};
			driver.findElement(By.xpath("//*[@id=\""+submit[i-1]+"\"]")).click();
			Thread.sleep(4000);
			System.out.println("submitted");
			
			
		}
	}
	
}
//******************************************************************************************************************************************************************************************************
public void contactus() {
	driver.get("https://qa.mapprr.com/contact");
	JavascriptExecutor js31=(JavascriptExecutor)driver;
	js31.executeScript("window.scrollBy(0,100)");
	driver.findElement(By.xpath("//*[contains(@name,'first_name')]")).sendKeys("sony");
	driver.findElement(By.xpath("//*[contains(@name,'last_name')]")).sendKeys("somuch");
	driver.findElement(By.xpath("//*[contains(@name,'mobile')]")).sendKeys("9876546787");
	driver.findElement(By.xpath("//*[contains(@name,'email')]")).sendKeys("sony@sony.com");
	driver.findElement(By.xpath("//*[contains(@name,'message')]")).sendKeys("Thank you");
	driver.findElement(By.xpath("//*[@id=\"contact_submit\"]/div[6]/button/img")).click();
	System.out.println("Thanks for contacting");
}
//********************************************************************************************************************************************************************************************************************
public void logout() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"mapprr-navbar\"]/div/div/div[3]/div/span[2]/ul/li[4]")).click();
	
}
}


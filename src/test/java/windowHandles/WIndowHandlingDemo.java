package windowHandles;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WIndowHandlingDemo {
	
	public static void main (String [] args) throws Exception {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
	driver.manage().window().maximize();
	
	String parentID = driver.getWindowHandle();
	System.out.println("Parent ID is : "+parentID);
	
	WebElement First = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", First);
	Thread.sleep(2000);
	
	First.click();

	//# 1. Method One switching window using Set method and for loop , if conditions
	
	Set <String> allID = driver.getWindowHandles();
	System.out.println(allID);
	
	for (String TotalID :allID ) {
	   if(!parentID.equals(TotalID)){
		   driver.switchTo().window(TotalID);
	
	   }
	}
	System.out.println("Child ID is:"+ driver.getWindowHandle());
	driver.manage().window().maximize();
	
	WebElement Third = driver.findElement(By.xpath("//a[@class='bmc-btn']"));
    js.executeScript("arguments[0].scrollIntoView({block:'center'});", Third);
    Third.click();
    
    Set <String> allID2 = driver.getWindowHandles();
    System.out.println(allID2);
    
    for (String TotalID2 : allID2) {
    	if (!TotalID2.equals(allID)) {
    		driver.switchTo().window(TotalID2);
    	}
    	
    }
    System.out.println("Child ID 2 is : "+driver.getWindowHandle());
    
    // #2. Method two of switching window using list method, without using for loop and if conditions:
    
    List <String> ListIDmethod = new ArrayList (driver.getWindowHandles());
    System.out.println("WindowID via list method, are: "+ListIDmethod);
    driver.switchTo().window(ListIDmethod.get(0));  
     
  
    
}
}
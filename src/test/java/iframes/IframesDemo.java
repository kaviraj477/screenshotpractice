package iframes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframesDemo {
	
	public static void main (String [] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/iframes");
        driver.manage().window().maximize();
        
        List <WebElement> iframes = driver.findElements(By.tagName("iframe"));
        int total = iframes.size();
        System.out.println("total number of iframes available = "+ total);
        
        for (int i=0; i<total; i++) {
        	driver.switchTo().defaultContent();
        	driver.switchTo().frame(i);
        	Thread.sleep(2000);
        	
        	
        	List <WebElement> box = driver.findElements(By.xpath("//a[@data-widget-id='713327011951992832']")); 
        	
       
        	
        	if(!box.isEmpty() && box.get(0).isDisplayed()) {
        		System.out.println("item found");
      
        		
        	}
        	else {
        		System.out.println("element not found");
        	}
        	
        	
        	
        }
	}

}

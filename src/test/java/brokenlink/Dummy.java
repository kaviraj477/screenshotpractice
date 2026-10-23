package brokenlink;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {
	
	public static void main (String [] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");  
		driver.manage().window().maximize();
		
      List <WebElement> a = driver.findElements(By.tagName("a"));
      Iterator <WebElement> it = a.iterator();
      int count =1;
      
      while (it.hasNext()) {
    	  WebElement link = it.next();
    	  String s = link.getAttribute("href");
    	  System.out.println(count+" ."+s);
      count++;
}
      
	
	}}

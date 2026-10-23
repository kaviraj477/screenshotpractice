package brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenlinkDemo {
	
	public static void main (String [] args) throws Exception, IOException {
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
    	  System.out.println(s);
   
      
      
      if (s.isEmpty() || s == null) {
    	  System.out.println("the link is empty");
    	  
      }
      
      else {
    		  HttpURLConnection http = (HttpURLConnection) (new URL (s).openConnection()); // these 3 codes exception handling
    		  http.setRequestMethod("HEAD");
    		  http.connect();
    		  
    		  int in = http.getResponseCode();
    		  
    		  if (in >=200 && in <300) {
    			  System.out.println(count + ". The response code is valid ["+http+"]");
    		  }
    		  else {
    			  System.out.println("The codes are not valid :"+ http);
    		  }
    		  }
    	  count++;
    	  
      }
    
      }
     
     
	}

	
 
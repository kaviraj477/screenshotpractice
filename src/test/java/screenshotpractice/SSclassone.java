package screenshotpractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSclassone {
	
	public static void main (String [] args) throws Exception {
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File Source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File ("C:\\kaviScreenShot\\ScreenShot2.png");
		FileUtils.copyFile(Source, destination);
		
		Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
		
		//#METHOD-TWO
		WebDriverManager.chromedriver().setup();
		WebDriver driverE = new ChromeDriver();
		driverE.get("https://www.facebook.com/");
		//https://www.flipkart.com/
		driverE.manage().window().maximize();
		
		File sourcefile = ((TakesScreenshot)driverE).getScreenshotAs(OutputType.FILE);
		File Target = new File ("C:\\KaviScreenShot\\Screenshot3.jpeg");
		
		FileUtils.copyFile(sourcefile, Target);
		driverE.quit();
		
	}

}

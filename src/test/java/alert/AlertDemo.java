package alert;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {
	
	public static void main (String [] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		WebElement First = driver.findElement(By.xpath("//button[@id='alertButton']"));
		First.click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
		
		WebElement Second = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
		Second.click();
		Thread.sleep(7000);
		a.accept();
		
		WebElement Third = driver.findElement(By.xpath("//button[@id='confirmButton']"));
		Third.click();
		a.accept();
		
		WebElement Fourth = driver.findElement(By.xpath("//button[@id='promtButton']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", Fourth);
		Thread.sleep(1000);
		Fourth.click();
		a.sendKeys("Doomsday");
		Thread.sleep(2000);
		a.accept();
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File ("C:\\KAVI\\alert.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

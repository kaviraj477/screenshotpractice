package dropdown;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {
	
	public static void main (String [] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		WebElement drops = driver.findElement(By.xpath("//select"));
		drops.click();
		
		
		Select st = new Select(drops);
		
		boolean bo = st.isMultiple();
		System.out.println("whether there are many options :"+ bo );
		
		// 1.To print all the options :
		List <WebElement> options = st.getOptions();
		System.out.println("The available options are : ");
		
		for (WebElement opt : options) {
			System.out.println( opt.getText());
		}
		
		st.selectByIndex(6);
		
		WebElement wb = st.getFirstSelectedOption();
		System.out.println("the selected option is : "+ wb.getText());
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File fl =  new File ("C:\\KAVI\\dropdown.png"); //C:\\kaviScreenShot\\ScreenShot2.png
		FileUtils.copyFile(source, fl);
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
	}

}

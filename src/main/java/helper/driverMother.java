package helper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class driverMother {
	protected  static WebDriver driver;
	protected WebDriverWait fluentWait;
	protected String url = "https://www.webuyanycar.com";

	public driverMother(WebDriver driver) {
		if (driver != null) {
			this.driver = driver;
		} 
		
		else {
			System.out.println("NEW DRIVER HERE");
			this.driver = new ChromeDriver();
			this.driver.manage().window().maximize();
			this.driver.get(url);
			this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	public void acceptCookies() {
		this.driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}
	
	public void goBack() {
		this.driver.navigate().back();
	}

	public void disposeDriver() {
		try {
			if (this.driver != null) {
				this.driver.quit();
				this.driver = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

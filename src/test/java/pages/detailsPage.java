package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import helper.driverMother;

public class detailsPage extends driverMother {
	
	protected String _textRegistration = "//section[contains(@class,'primary')]//div[@class='d-none d-lg-block vehicle-details']//div[@class='details-vrm ng-star-inserted']";
	protected String _textMake = "//section[contains(@class,'primary')]//div[@class='d-none d-lg-block vehicle-details']//div[@class='d-table']//div[1]/div[@class='d-table-cell heading'][1]/following-sibling::div";
	protected String _textModel = "//section[contains(@class,'primary')]//div[@class='d-none d-lg-block vehicle-details']//div[@class='d-table']//div[2]/div[@class='d-table-cell heading'][1]/following-sibling::div";
	protected String _textYear = "//section[contains(@class,'primary')]//div[@class='d-none d-lg-block vehicle-details']//div[@class='d-table']//div[3]/div[@class='d-table-cell heading'][1]/following-sibling::div";
	protected String _YourDetailsPage = "//h1[@id='questions-title']//following-sibling::p";
	private String resultFormat = "%s,%s,%s,%s";
	protected String _Step2of2 =  "Step 2 of 2";

	public detailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getCarDetails(String reg) {
		String checkVehicle = read(_textRegistration);
		 String result = (checkVehicle == "No Vehicle Found") ? "None,None,None,None":
			 String.format(
		                resultFormat,
		                read(_textRegistration),
		                read(_textMake),
		                read(_textModel),
		                read(_textYear));
			System.out.println ("result" + result);

		return result;
	}

	
	private String read(String locaterText) {
		
		try
		{
			FluentWait wait = new FluentWait(driver);
			wait.withTimeout(Duration.ofSeconds(10));
	        wait.pollingEvery(Duration.ofSeconds(5));
			WebElement element = driver.findElement(By.xpath(_YourDetailsPage));
            wait.until(ExpectedConditions.textToBePresentInElement(element,_Step2of2));
            return driver.findElement(By.xpath(locaterText)).getText();
            
        } 
		catch (NoSuchElementException ignore)
		{
			System.out.println ("No Vehicle Found");

        }
		catch (TimeoutException ignore)
		{
			System.out.println("No Data Found");
        }
		
		return  "No Vehicle Found";

	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
}

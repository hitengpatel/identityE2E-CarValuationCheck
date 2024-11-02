package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.driverMother;


public class homePage extends driverMother{
	protected String _inputVehicleReg = "input[name='vehicleReg'";
	protected String _inputMileage = "input[name='Mileage'";
	protected String _buttonGetmycarvaluation = "btn-go";
	
	public homePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterVehicleReg(String vehicleReg)
	{
		System.out.println(" =>>>>>>>>>>> " + vehicleReg);
		driver.findElement(By.cssSelector(_inputVehicleReg)).clear();
		driver.findElement(By.cssSelector(_inputVehicleReg)).sendKeys(vehicleReg);
	}
	
	public void enterMilage(String milage)
	{
		driver.findElement(By.cssSelector(_inputMileage)).sendKeys(milage);
	}
	
	public void clicketmycarvaluation ()
	{
		driver.findElement(By.id(_buttonGetmycarvaluation)).click();
	}

	
	public void searchVehicle( String registrationNumber) {
		this.enterVehicleReg(registrationNumber);
		this.enterMilage("86767");
		this.clicketmycarvaluation();
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}

}

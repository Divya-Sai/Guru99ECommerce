package eCommerceProject.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	WebDriver  driver;

	@FindBy(xpath=".//div[@class='page-title']")
	public WebElement titleofHomePage;

	@FindBy(xpath=".//a[@class='skip-link skip-account']")
	public WebElement linkAccount;

	@FindBy(xpath=".//input[@title='Confirm Password']")
	public WebElement txtconfirmPass;

	@FindBy(xpath=".//input[@title='Password']")
	public WebElement txtPass;

	@FindBy(xpath=".//input[@title='First Name']")
	public WebElement txtfirstname;

	@FindBy(xpath=".//input[@title='Last Name']")
	public WebElement txtlastname;

	@FindBy(xpath=".//a[@title='Register']")
	public WebElement titRegister;

	@FindBy(xpath=".//button[@title='Register']")
	public WebElement btnRegister;




	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyTitleofHomePage() {

		String HomePage =titleofHomePage.getText();
		System.out.println(HomePage);
		Assert.assertEquals(HomePage, "THIS IS DEMO SITE FOR   ");


	}



	public void registerNewUser() {

		linkAccount.click();
		titRegister.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		txtfirstname.sendKeys("Divya");
		txtlastname.sendKeys("Div1");
		txtPass.sendKeys("Roshita141");
		txtconfirmPass.sendKeys("Roshita141");
		btnRegister.click();


	}




}

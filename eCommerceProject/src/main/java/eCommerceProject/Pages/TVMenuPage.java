package eCommerceProject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVMenuPage {
	WebDriver  driver;
	
	@FindBy(xpath=".//li[@class='level0 nav-2 active last']")
	public WebElement TVMenu;
	
	public TVMenuPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnTV() {
		TVMenu.click();
	}
	
}

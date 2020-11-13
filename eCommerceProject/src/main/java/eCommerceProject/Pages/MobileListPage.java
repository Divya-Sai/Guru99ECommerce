package eCommerceProject.Pages;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.reporters.Files;

public class MobileListPage {
	
	WebDriver driver;
	 public int scc = 0;
	
		/*
		 * @FindBy(css = ".//select[title=\"Sort By\"]") public WebElement
		 * selectDropDown;
		 */
	
	@FindBy(xpath=".//li[@class='level0 nav-1 first']/a[contains(.,'Mobile')]")
	public WebElement linkMobile;
	
	@FindBy(xpath=".//div[@class='category-products']/div/div/div/select/option[contains(.,'Name')]")
	public WebElement sortByName;
	
	@FindBy(xpath=".//div[@class='category-products']/div/div/div/select/option[contains(.,'Position')]")
	public WebElement sortByPosition;
	
	@FindBy(xpath=".//div[@class='category-products']/div/div/div/select/option[contains(.,'Price')]")
	public WebElement sortByPrice;
	
	@FindBy(xpath=".//div[@class='category-products']/div/div/div/select[@title='Sort By']")
	public WebElement SortBy;
	
	@FindBy(xpath=".//h2[@class='product-name']/a")
	public WebElement productName;
	
	@FindBy(xpath=".//div[@class='price-box']/span[contains(@id,'product-price-1')]")
	public WebElement priceofSonyXperia;
	
	@FindBy(id="product-collection-image-1")
	public WebElement imgxperia;
	
	@FindBy(id="product-collection-image-2")
	public WebElement imgIphone;
	
	@FindBy(xpath=".//div[@class='add-to-cart-buttons']")
	public WebElement btnAddToCart;
	
	@FindBy(xpath=".//li[@class='success-msg']")
	public WebElement Sucessmessage;
	
	@FindBy(xpath=".//li[@class='error-msg']")
	public WebElement Errormessage;
	
	@FindBy(xpath=".//input[@title='Qty']")
	public WebElement txtQty;
	
	@FindBy(xpath=".//button[@title='Update']")
	public WebElement btnUpdate;
	
	@FindBy(xpath=".//button[@title='Empty Cart']")
	public WebElement btnEmptyCart;
	
	@FindBy(xpath=".//div[@class='page-title']")
	public WebElement pagetitle;
	
	
	@FindBy(xpath=".//a[@class='link-compare']")
	public WebElement linkAddtoCompare;
	
	@FindBy(xpath=".//button[@title='Compare']")
	public WebElement btnCompare;
	
	public MobileListPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * public void sortBy() { selectDropDown.isSelected(); }
	 */
	
	public void MobileMenu() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		linkMobile.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String TitleOfMobileMenu =driver.getTitle();
		Assert.assertEquals(TitleOfMobileMenu, "Mobile");
		Thread.sleep(5000);
		//selectDropDown.isSelected();
	    //new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
	    Thread.sleep(5000);
		
	}
	
	public void SortBy(String SortByOptions) throws InterruptedException {
		
		Select options = new Select(SortBy);
		/*
		 * List<String> originalList = new ArrayList(); for(WebElement e:
		 * options.getOptions()) { System.out.println(e.getText());
		 * originalList.add(e.getText());
		 * 
		 * }
		 */
		options.selectByVisibleText(SortByOptions);
		
		List<WebElement> list = driver.findElements(By.xpath(".//h2[@class='product-name']/a"));
		System.out.println(list.size());
		
		for(int i=0;i<=2;i++)
		{
			System.out.println(list.get(i).getText());
			Assert.assertEquals(list.get(0).getText(), "IPHONE");
			Assert.assertEquals(list.get(1).getText(), "SAMSUNG GALAXY");
			Assert.assertEquals(list.get(2).getText(), "SONY XPERIA");
		}

		//System.out.println(productName);
		
		
		/*
		 * Select se = new Select(productName); System.out.println(se.getOptions());
		 * List<String> originalList = new ArrayList(); for (WebElement e :
		 * se.getOptions()) { originalList.add(e.getText());
		 * 
		 * } //----logic block starts List<String> tempList= originalList;
		 * Collections.sort(tempList); Assert.assertEquals(tempList, originalList);
		 * //----logic ends starts
		 */		
		//sortByPrice.isSelected()
		//driver.findElement(By.xpath(".//div[@class='category-products']/div/div/div/select/option[contains(.,'options')]")).isSelected();
		
	}
	
	public void readCost() {
		
		String priceofsonyxperiaout = priceofSonyXperia.getText();
		System.out.println("priceofsonyxperiaout : "+priceofSonyXperia.getText());
        imgxperia.click();
        String priceofsonyxperiaIn = priceofSonyXperia.getText();
        System.out.println("priceofsonyxperiaIn : "+priceofSonyXperia.getText());
        Assert.assertEquals(priceofsonyxperiaout, priceofsonyxperiaIn);
		
		
	}
	
	public void childWindowVeifyProducts() {
		List<WebElement> list = driver.findElements(By.xpath(".//h2[@class='product-name']/a"));
		System.out.println(list.size());
		
		for(int i=0;i<=1;i++)
		{
			System.out.println(list.get(i).getText());
			Assert.assertEquals(list.get(0).getText(), "SONY XPERIA");
			Assert.assertEquals(list.get(1).getText(), "IPHONE");
			
		}
		
	}
}

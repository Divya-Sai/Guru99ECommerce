package eCommerceProject.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import eCommerceProject.Pages.HomePage;
import eCommerceProject.Pages.MobileListPage;
import eCommerceProject.library.ConfigFile;

public class Guru99eComTest4 {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	ConfigFile configfile;
	WebDriver driver;
	HomePage home;
	MobileListPage mob;

	@BeforeSuite

	public void getExtentReports() {
		htmlReporter = new ExtentHtmlReporter("D:\\SeleniumWebdriver-Java-from-Scratch\\eCommerceProject\\ExtentReports\\Guru99eComtestcase4.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void launchBrowser() throws IOException, InterruptedException {
		test = extent.createTest("Login");
		configfile =new ConfigFile();
		System.setProperty("webdriver.chrome.driver", configfile.configProp("chromepath"));
		driver = new ChromeDriver();
		driver.get(configfile.configProp("Guru99eComm"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(Status.INFO, "launchBrowser is successfully launched");
		test.addScreenCaptureFromPath("screenshot.png");

		//configuration items to change the look and feel
		//add content, manage tests etc
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Guru 99 EComm Project");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}


	@Test(priority=1)
	public void MobileMenu() throws IOException, InterruptedException {
		test = extent.createTest("navigateToMobileMenu");
		home = new HomePage(driver);
		mob = new MobileListPage(driver);
		mob.MobileMenu();
		mob.imgxperia.click();
		mob.linkAddtoCompare.click();
		mob.MobileMenu();
		mob.imgIphone.click();
		mob.linkAddtoCompare.click();
		mob.MobileMenu();
		mob.btnCompare.click();
		Thread.sleep(5000);

		//Handling Window
		// To handle all new opened window.	
		String MainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();		
		Iterator<String> i1=s1.iterator();		

		while(i1.hasNext())			
		{		
			String ChildWindow=i1.next();		

			if(!MainWindow.equalsIgnoreCase(ChildWindow))			
			{    		

				// Switching to Child window
				driver.switchTo().window(ChildWindow);	                                                                                                           
				mob.childWindowVeifyProducts();		

				// Closing the Child Window.
				driver.close();		
			}		
		}		
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);				

		test.log(Status.INFO, "navigateToMobileMenu is successfully completed");
		test.addScreenCaptureFromPath("screenshot.png");
	}


}

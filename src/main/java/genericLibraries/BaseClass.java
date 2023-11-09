package genericLibraries;

import org.apache.poi.xslf.model.ParagraphPropertyFetcher;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pomPages.AddCategoryPage;
import pomPages.AddNewUser;
import pomPages.AddnewCourse;
import pomPages.AdminHomePage;
import pomPages.CategoryPage;
import pomPages.CourseList;
import pomPages.LoginPage;
import pomPages.UserPage;
import pomPages.WelecomePage;
//Base class (checking push and pull)
public class BaseClass {
	//@BeforeSuite
	//@BeforeTest
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtitlity webUtil;
	protected WebDriver driver;//WEbdriver is a non static variable
	protected JavaUtility jutil;
	
	public static WebDriver sdriver;//this is created because we need to use this in lisiners because lisiners thread is different for that we are creating this satic methods
	public static JavaUtility sjutil;
	
	
	protected WelecomePage welcome;
	protected LoginPage login;
	protected AdminHomePage home;
	protected UserPage users;
	
	protected CategoryPage category;
	protected CourseList course;
	protected AddNewUser addUser;
	protected AddnewCourse addcourse;
	protected AddCategoryPage addcategory;
	
	
	
	@BeforeClass
	public void classConfig()
	{
		property= new PropertiesUtility();
		excel= new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtitlity();
		
		property.propertiesIntilization(IConstantPath.PROPERTIES_PATH);
		driver = webUtil.lunchBrowser(property.readFromProperties("browser"));
		sdriver=driver;
		sjutil=jutil;
		
	}
	
	@BeforeMethod
	public void methodConfig() 
	{
		excel.excelInitilization(IConstantPath.EXCEL_PATH);
		
		welcome = new WelecomePage(driver);
		login = new LoginPage(driver);
		home = new AdminHomePage(driver);
		course = new CourseList(driver);
		category = new CategoryPage(driver);
		addUser = new AddNewUser(driver);
		addcourse = new AddnewCourse(driver);
		addcategory = new AddCategoryPage(driver);
		
		webUtil.navigateToApp(property.readFromProperties("url"));
		
		long time = Long.parseLong(property.readFromProperties("timeouts"));
		
		webUtil.waitUntilElementFound(time);
		
		welcome.clickLoginButton();
		
		Assert.assertEquals(login.getPageHedar(), "Login");
		login.setEmail(property.readFromProperties("username"));
		login.setPassword(property.readFromProperties("password"));
		login.clcikLogin();
	}
	
	@AfterMethod
	public void methodTeardown()
	{
		excel.CloseExcel();
		home.singOutApp();
	}
	
	@AfterClass
	public void classTeardown()
	{
		webUtil.closeAllWindows();
	}
	//@AfterTest
	//@AfterSuite

}

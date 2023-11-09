package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	//Declaration
	@FindBy(xpath = "//span[text()='SkillRary Admin']")
	private WebElement adminIcon;
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement userTab;
	
	@FindBy(xpath = "//span[text()='Courses']")
	private WebElement coursesTab;
	
	@FindBy(xpath = "//a[text()=' Course List']")
	private WebElement courseListLink;
	
	@FindBy(xpath = "//a[text()=' Category']")
	private WebElement catagoryLink;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement singOutLink;
	
	//Initialization
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 //Utilization
	public String getAdminIcon()
	{
		return adminIcon.getText();
	}
	
	public void clickUserTab()
	{
		userTab.click();
	}
	
	public void clcikCoursesTab()
	{
		coursesTab.click();
	}
	
	public void clcikCourseListLink()
	{
		courseListLink.click();
	}
   
	public void clickCategoryLink()
	{
		catagoryLink.click();
	}
	
	public void singOutApp()
	{
		adminIcon.click();
		singOutLink.click();
	}
}

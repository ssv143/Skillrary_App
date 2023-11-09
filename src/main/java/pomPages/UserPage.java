package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	
	@FindBy(xpath = "//h1[normalize-space(text())='Users']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
   
	@FindBy(xpath = "//ul[@class=\"pagination\"]//li[last()-1]/a")
	private WebElement userListLastPage;
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
	private  WebElement lastUser;
	
	public UserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String PageHeader()
	{
		return pageHeader.getText();
		
	}
	
	public void clickNewButton()
	{
		newButton.click();
	}
	
	public void clickNewUserListLastPage()
	{
		userListLastPage.click();
	}
	
	public String getLastUserName()
	{
		return lastUser.getText();
	}
}

package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class AddNewUser {
	
	@FindBy(xpath = "//b[text()='Add New User']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//input[@id='email' and@required]")
	private WebElement emailTF;
	
	@FindBy(xpath = "//input[@id='password' and@required]")
	private WebElement passwordTF;
	
	@FindBy(xpath = "//input[@id='firstname' and@required]")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='lastname' and@required]")
	private WebElement lastName;
	
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressTextArea;
	
	@FindBy(xpath = "//input[@id='contact']")
	private WebElement contactInfo;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement photo;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveButton;
	
	public AddNewUser(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void createNewUser(String email, String password,String firstname,String lastname, String address, String contact, String photopath)
	{
		emailTF.sendKeys(email);
		passwordTF.sendKeys(password);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		addressTextArea.sendKeys(address);
		contactInfo.sendKeys(contact);
		photo.sendKeys(photopath);
		saveButton.click();
		
	}
}

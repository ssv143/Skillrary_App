package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddnewCourse {
	//Delecration
	
	@FindBy(xpath ="//b[text()='Add New Course']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameTf;
	
	@FindBy(id="category")
	private WebElement categoryDropdown;
	
	@FindBy(id="price")
	private WebElement priceTf;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement photoButton;
	
	@FindBy(xpath = "(//input[@id='photo'])[2]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionFrame;
	
	//Instailization
	
	public AddnewCourse(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public String getPageheader()
	{
		return pageHeader.getText();
	}
    
	public void setName(String courseName)
	{
		nameTf.sendKeys(courseName);
	}
	
	public void setPrice(String price)
	{
		priceTf.sendKeys(price);
	}
	
	public void uploadPhoto(CharSequence photopath)
	{
		photoButton.sendKeys(photopath);
	}
	
	public void Description()
	{
		
	}
	
}

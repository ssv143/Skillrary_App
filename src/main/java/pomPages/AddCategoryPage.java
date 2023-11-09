package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage {
	
//Declaration
	@FindBy(xpath = "//b[text()='Add New Category']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement nameTf;
	
	@FindBy(xpath = "//button[@name=\"add\"]")
	private WebElement saveButton;
	
	//Initialization
	public AddCategoryPage(WebDriver driver)
	{
	  	PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	public void setNameTextfiled(String NameOfcatogory)
	{
		nameTf.sendKeys(NameOfcatogory);
		
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}

}

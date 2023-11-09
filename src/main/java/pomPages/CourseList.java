package pomPages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class CourseList//<WebElements>//
{
	
	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	private WebElement PageHedar;
	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private  List<WebElement>  CourseList;
	
	@FindBy(xpath = "//h4[text()=' Success!']")
	private WebElement sucessMessage;
	
	private String deletPath="//td[text()=%s]//following-sibling::td/button[text()='Delete']";
	
	@FindBy(xpath = "//button[@name='delete']")
	private WebElement deleteButton;
	
	
	public CourseList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getPageHeader()
	{
		return PageHedar.getText();
	}
	
	public void clickNewButton()
	{
		newButton.click();
	}
	
	public List<WebElement> getCourseLsit()
	{
		return CourseList;
	}
	
	//used to delete a course from name to delete button traversing
	public void ClcikDeleteButton(String courseName, WebDriver driver)
	{
		String requriedPath=String.format(deletPath,courseName);
		driver.findElement(By.xpath(requriedPath)).click();
	}
	
	
	
	public void clickOndeleteButton()
	{
		deleteButton.click();
	}
	
	

}

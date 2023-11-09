package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declaration
	@FindBy(xpath = "//h3[text()='Login']")
	private WebElement pageHeader;
	
	@FindBy(id = "email")
	private WebElement EnterEmail;

	@FindBy(id = "password")
	private WebElement EnterPassword;

	@FindBy(id = "last")
	private WebElement ClickOnLogin;

	@FindBy(id = "toPasswordRecoveryPageLink")
	private WebElement ForgotPassword;

	// Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	
	public String getPageHedar()
	{
		return pageHeader.getText();
	}

	 public void setEmail(String email)
	 {
		 EnterEmail.sendKeys(email);
	 }
	 
	 public void setPassword(String password)
	 {
		 EnterPassword.sendKeys(password);
	 }
	 
	 public void clcikLogin()
	 {
		 ClickOnLogin.submit();
	 }
}

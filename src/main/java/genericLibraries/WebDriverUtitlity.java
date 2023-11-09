package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all reusable methods to perform web actions
 * 
 * @author VIKAS ABHILASH
 *
 */
public class WebDriverUtitlity {
	WebDriver driver;

	/**
	 * This method is used to launch user desired browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver lunchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");

			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser info");
		}

		// driver.manage().window().maximize();
		return driver;
	}

	/**
	 * This method is used to navigate to applications
	 * 
	 * @param url
	 */
	public void navigateToApp(String url) {
		driver.get(url);
	}

	/**
	 * This method is used to wait until element is visible
	 * 
	 * @param time
	 */
	public void waitUntilElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	/**
	 * This method used to wait until element is visible
	 * 
	 * @param time
	 * @param element
	 * @return
	 */

	public WebElement ExcpicityWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to wait until the element is enable
	 * 
	 * @param time
	 * @param element
	 * @return
	 */

	public WebElement ExcpicityWait(long time, By element) {
		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used until title of
	 * 
	 * @param title
	 * @param time
	 * @return
	 */

	public Boolean ExcpicityWait(String title, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * This method is used to hover an element
	 * 
	 * @param element
	 */
	public void mouseHoveringToElement(WebElement element) {
		Actions action = new Actions(driver);

		action.contextClick(element).perform();
	}

	/**
	 * This method is used to right click ton an element
	 * 
	 * @param element
	 */

	public void RightClickOnElement(WebElement element) {
		Actions action = new Actions(driver);

		action.doubleClick().perform();
	}

	/**
	 * This method is used to drag and drop an element
	 * 
	 * @param element
	 * @param source
	 * @param target
	 */
	public void DragAndDropOnElement(WebElement element, WebElement target) {
		Actions action = new Actions(driver);

		action.dragAndDrop(element, target).perform();
		;
	}

	/**
	 * This method is used to select an element from drop down based on index
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * This method is used to select the drop down based on value
	 * 
	 * @param element
	 * @param value
	 */

	public void handleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	/**
	 * This method is used to select the drop down based on text
	 * 
	 * @param text
	 * @param element
	 */

	public void handleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	/**
	 * This method is used to de select the drop down by index
	 * 
	 * @param element
	 * @param index
	 */

	public void deselectDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}

	/**
	 * This method is used to de select the drop down by value
	 * 
	 * @param element
	 * @param value
	 */

	public void deselectDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);

	}

	/**
	 * This method is used to de select the drop down by text
	 * 
	 * @param text
	 * @param element
	 */
	public void deselectDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);

	}

	/**
	 * This method is used to switch to frame based on index
	 * 
	 * @param index
	 */

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch to frame based on id or name
	 * 
	 * @param idOrName
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	/**
	 * This method is used to switch to frame based on frame element reference
	 * 
	 * @param frameElement
	 */

	public void swithchToFrame(String frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method is used to switch back from frame
	 */
	public void switchToFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to capture window Screenshot
	 * 
	 * @param className
	 * @param jutil
	 */

	public void takeScreenShoot(String className, JavaUtility jutil) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File("/Screenshot" + className + "_" + jutil.getCurrentTime() + "png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to scroll till element
	 * 
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method is used to handle alert
	 * 
	 * @param status
	 */
	public void handelAlert(String status) {
		Alert alert = driver.switchTo().alert();
		if (status.equalsIgnoreCase("ok"))
			alert.accept();
		else
			alert.dismiss();
	}

	/**
	 * This method is used to switch to child browser
	 */
	public void switchToChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String windowId : set) {
			driver.switchTo().window(windowId);
		}
	}

	/**
	 * This method returns parent browser address
	 * 
	 * @return
	 */

	public String getParentWindoId() {
		return driver.getWindowHandle();
	}

	/**
	 * This method is used to specified window
	 * 
	 * @param WindowID
	 * @return
	 */
	public WebDriver switchToWindow(String WindowID) {
		return driver.switchTo().window(WindowID);
	}

	/**
	 * This method is used to close current window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	
	/**
	 * This method is used to close all the windows
	 */
	public void closeAllWindows()
	{
		driver.quit();
	}

}

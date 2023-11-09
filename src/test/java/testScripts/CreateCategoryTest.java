package testScripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class CreateCategoryTest extends BaseClass{
	
	@Test
	public void createCategoryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clcikCoursesTab();
		home.clickCategoryLink();
		soft.assertTrue(category.getPageHeader().contains("Category"));
		
		category.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addcategory.getPageHeader(), "Add New Category");
		Map<String,String> map = excel.readFromExcel("Sheet1", "Add Category");
		String categoryName = map.get("Name")+jutil.generateRandomNum(100);
		addcategory.setNameTextfiled(categoryName);
		addcategory.clickSaveButton();
		
		soft.assertTrue(category.getSuccessMesage().contains("success"));
		boolean isPresent = false;
		List<WebElement> categoryList = category.getCategoryList();
		for (WebElement e : categoryList) {
			if (e.getText().equals(categoryName)) {
				isPresent = true;
				break;
			}
		}
		soft.assertTrue(isPresent);
		
		category.ClickDeleteButton(driver, categoryName);
		category.ClickDelete();
		soft.assertTrue(category.getSuccessMesage().contains("Success"));
		soft.assertAll();
	
	}
}

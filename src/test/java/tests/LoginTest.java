package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utilis.ExcelUtilis;
import utilis.ExtentReportManager;
import utilis.Log;

public class LoginTest extends BaseTest {
	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() throws IOException {
		String filePath = System.getProperty("user.dir") + "/testdata/TestData.xlsx";
		ExcelUtilis.loadExcel(filePath, "Sheet1");
		int rowCount = ExcelUtilis.getRowCount();
		Object[][] data = new Object[rowCount - 1][2];
		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtilis.getCellData(i, 0); // username
			data[i - 1][1] = ExcelUtilis.getCellData(i, 1);// password

		}
		ExcelUtilis.CloseExcel();
		return data;

	}

	// @Test(dataProvider="LoginData2")
	@Test
	@Parameters({ "username", "password" })
	public Object[][] getData() {
		return new Object[][] { { "user1", "pass1" }, { "user2", "pass2" }, { "user3", "pass3" } };
	}

	@Test(dataProvider = "Login Data")

	public void testValidLogin(String username, String password) {
		Log.info("Starting Login Test...");
		test = ExtentReportManager.createTest("Login Test with valid credentials");
		test.info("Navigating To URL");

		LoginPage loginpage = new LoginPage(driver);
		Log.info("Entering Credentials...");
		test.info("Entering Credentials...");
//			loginpage.enterUserName("admin@yourstore.com");
//			loginpage.enterPassword("admin");
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		test.info("Clicking on Login button");
		loginpage.clickLogin();

		System.out.println("Title if the page is" + driver.getTitle());
		Log.info("Verifying Page Title...");
		test.info("Verifying Page Title...");
		Assert.assertEquals(driver.getTitle(), " Just a moment...");
		test.pass("Login Successful");
	}

//	@Test
//
//	public void testLoginInvalidCredentials() {
//		Log.info("Starting Login Test...");
//		test = ExtentReportManager.createTest("Login Test with invalid credentials");
//		test.info("Navigating To URL");
//
//		LoginPage loginpage = new LoginPage(driver);
//		Log.info("Entering Credentials...");
//		test.info("Entering Credentials...");
//		loginpage.enterUserName("admin@yourstore.com");
//		loginpage.enterPassword("admin");
//		test.info("Clicking on Login button");
//		loginpage.clickLogin();
//
//		System.out.println("Title if the page is" + driver.getTitle());
//		Log.info("Verifying Page Title...");
//		test.info("Verifying Page Title...");
//		Assert.assertEquals(driver.getTitle(), " Just a moment...");
//		test.pass("Login Successful");
//	}

}

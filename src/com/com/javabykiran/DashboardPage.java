package com.com.javabykiran;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPage {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\eclipse-workspace\\POM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// verify title
	@Test
	public void verifyTitle() {
		String actual = driver.getTitle();
		Assert.assertEquals(actual, "JavaByKiran | Dashboard");
	}

	// verify Java By kiran text
	@Test
	public void verifyText() {
		String actual = driver.findElement(By.xpath("//b[contains(text(),'Java By Kiran')]")).getText();
		Assert.assertEquals(actual, "Java By Kiran");
	}

	// verify dashboard table Label
	@Test
	public void verifyDashboardTableLabel() {
		String actual = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(actual, "Dashboard Courses Offered");
	}

	// verify logout button
	@Test
	public void verifyLogOutBtn() {
		driver.findElement(By.partialLinkText("LOGOUT")).click();
		String actual = driver.getTitle();
		Assert.assertEquals(actual, "JavaByKiran | Log in");
	}

	// verify MAIN NAVIGATION

	@Test
	public void verifyTextofMainNavigation() {
		String actual = driver.findElement(By.xpath("//li[contains(text(),'MAIN NAVIGATION')]")).getText();
		Assert.assertEquals(actual, "MAIN NAVIGATION");
	}

//		 verify logout Successfully message on login page
	@Test(dependsOnMethods = { "verifyLogOutBtn" })
	public void verifyLogoutsuccessful() {
		driver.findElement(By.partialLinkText("LOGOUT")).click();
		String actual = driver.findElement(By.xpath("//p[contains(text(),'Logout successfully')]")).getText();
		Assert.assertEquals(actual, "Logout successfully");

	}

	// verify the Online word
//	@Test
//	public void verifyOnlineWord() {
//		String actual = driver.findElement(By.xpath("//i[@class='fa fa-circle text-success']//following-sibling::text()")).getText();
//		Assert.assertEquals(actual, "Online");
//	}
	
	// verify the Home word
//		@Test
//		public void verifyHomeWord() {
//			String actual = driver.findElement(By.xpath("//i[@class='fa fa-dashboard']//following-sibling::text()")).getText();
//			Assert.assertEquals(actual, "Online");
//		}

	
	
	// verify dashboard menus
    @Test
	public void verifyDashboardMenus() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = new ArrayList<String>();

		expected.add("Dashboard");
		expected.add("Users");
		expected.add("Operators");
		expected.add("Useful Links");
		expected.add("Downloads");
		expected.add("Logout");

		List<WebElement> menu = driver.findElements(By.xpath("//li//span"));

		for (WebElement element : menu) {
			System.out.println(element.getText());
			actual.add(element.getText());
		}

		Assert.assertEquals(actual, expected);

	}

	// verify courses
	@Test
	public void verifyCourses() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = new ArrayList<String>();

		expected.add("Selenium");
		expected.add("Java / J2EE");
		expected.add("Python");
		expected.add("Php");

		List<WebElement> menu = driver.findElements(By.xpath("//h3"));

		for (WebElement element : menu) {
			System.out.println(element.getText());
			actual.add(element.getText());
		}

		Assert.assertEquals(actual, expected);

	}

	// verify subcourses
	@Test
	public void verifySubCourses() {
		ArrayList<String> expected = new ArrayList<String>();
		ArrayList<String> actual = new ArrayList<String>();

		expected.add("Automation Testing");
		expected.add("Software Development");
		expected.add("Data Science");
		expected.add("Web Development");

		List<WebElement> menu = driver.findElements(By.xpath("//section[@class='content' ]//following::p"));

		for (WebElement element : menu) {
			System.out.println(element.getText());
			actual.add(element.getText());
		}

		Assert.assertEquals(actual, expected);

	}

	// verify click on more info
//    @Test
//	public void verifymoreinfo() {
//		List<WebElement> menu = driver.findElements(By.xpath("//section[@class='content' ]//following::a"));
//		
//
//		for (WebElement element : menu) {
//			
//			element.click();
//			ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
//			System.out.println(tabHandles);
//			
//			for (String eachHandle : tabHandles) {
//				
//				driver.switchTo().window(eachHandle);
//				System.out.println(driver.getTitle());
//
//			}
//		}
//	}

	// check links

	@Test
	public void verifymoreinfo() {
		List<WebElement> link = driver.findElements(By.xpath("//section[@class='content' ]//following::a"));
		System.out.println(link.size());
		for (WebElement element : link) {
			
			element.click();
			System.out.println( element.getText());
		}

	}

}

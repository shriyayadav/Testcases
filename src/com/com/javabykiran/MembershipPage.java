package com.com.javabykiran;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MembershipPage {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\eclipse-workspace\\POM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div[2]/a")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// verify membership title
	@Test
	public void verifyMemberTitle() {
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Registration Page";
		Assert.assertEquals(actual, expected);
	}
	
	//verify URL
	@Test(dependsOnMethods = {"verifyMemberTitle"})
	public void verifyURL()
	{
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertEquals(actual, "file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/pages/examples/register.html");
	}

	// verify Headline Java By Kiran
	@Test
	public void verifyHeadline() {

		String actual = driver.findElement(By.xpath("//b")).getText();
		String expected = "Java By Kiran";
		Assert.assertEquals(actual, expected);
	}

	// verify tagline Register a new membership
	@Test
	public void verifyTagline() {
		String actual = driver.findElement(By.xpath("//p")).getText();
		String expected = "Register a new membership";
		Assert.assertEquals(actual, expected);
	}

	// verify Name placeholder
	@Test
	public void verifyNamePlaceholder() {
		String actual = driver.findElement(By.id("name")).getAttribute("placeholder");
		String expected = "Name";
		Assert.assertEquals(actual, expected);
	}

	// verify Mobile placeholder
	@Test
	public void verifyMobilePlaceholder() {
		String actual = driver.findElement(By.id("mobile")).getAttribute("placeholder");
		String expected = "Mobile";
		Assert.assertEquals(actual, expected);
	}

	// verify Email placeholder
	@Test
	public void verifyEmailPlaceholder() {
		String actual = driver.findElement(By.id("email")).getAttribute("placeholder");
		String expected = "Email";
		Assert.assertEquals(actual, expected);
	}

	// verify password placeholder
	@Test
	public void verifyPasswordPlaceholder() {
		String actual = driver.findElement(By.id("password")).getAttribute("placeholder");
		String expected = "Password";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank Name Error Message
	@Test
	public void verifyBlankName() {
		// WebElement name=driver.findElement(By.xpath("//input[@name='name']"));
		// name.sendKeys("");
		driver.findElement(By.id("name")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.findElement(By.id("name_error")).getText();
		String expected = "Please enter Name.";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank Mobile Error Message
	@Test
	public void verifyBlankMobile() {
		WebElement mobile = driver.findElement(By.id("mobile"));
		mobile.sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.findElement(By.id("mobile_error")).getText();
		String expected = "Please enter Mobile.";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank Email Error Message
	@Test
	public void verifyBlankEmail() {
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.findElement(By.id("email_error")).getText();
		String expected = "Please enter Email.";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank password Error Message
	@Test
	public void verifyBlankPassword() {
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actual = driver.findElement(By.id("password_error")).getText();
		String expected = "Please enter Password.";
		Assert.assertEquals(actual, expected);
	}
	
	//verify Text box
	@Test
	public void verifyTextBox()
	{
		driver.findElement(By.id("name")).sendKeys("shreya");
		driver.findElement(By.id("mobile")).sendKeys("9763011849");
		driver.findElement(By.id("email")).sendKeys("shreya@gmail.com");
		driver.findElement(By.id("password")).sendKeys("shreya123");
		driver.findElement(By.xpath("//button")).click();
		Alert al=driver.switchTo().alert();
		String actual=al.getText();
		al.accept();
		Assert.assertEquals(actual, "User registered successfully.");
	}
	
	//Verify spell of link  Already have a membership
	@Test
	public void verifyAlreadyMemberLinkSpell()
	{
		String actual=driver.findElement(By.partialLinkText("I already")).getText();
		Assert.assertEquals(actual, "I already have a membership");
	}
	
	//Verify link of  Already have a membership
		@Test
		public void verifyAlreadyMemberLink()
		{
			driver.findElement(By.partialLinkText("I already")).click();
			String actual=driver.getTitle();
			Assert.assertEquals(actual, "JavaByKiran | Log in");
		}
	
	

}

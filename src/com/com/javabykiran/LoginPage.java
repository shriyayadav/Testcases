package com.com.javabykiran;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\eclipse-workspace\\POM\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// verify URL
	@Test
	public void verifyURL() {
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Log in";
		Assert.assertEquals(actual, expected);
	}

	// verify Blank Email
	@Test
	public void verifyBlankEmail() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("email_error")).getText();
		String expected = "Please enter email";
		Assert.assertEquals(actual, expected);
}

	// verify Blank password
	@Test
	public void verifyBlankPassword() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("password_error")).getText();
		String expected = "Please enter password.";
		Assert.assertEquals(actual, expected);

	}

	// verify Wrong Email
	@Test
	public void verifyWrongEmail() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("ikhfjh");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("email_error")).getText();
		String expected = "Please enter email as kiran@gmail.com";
		Assert.assertEquals(actual, expected);

	}

	// verify Wrong password
	@Test
	public void verifyWrongPassword() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("45666");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.findElement(By.id("password_error")).getText();
		String expected = "Please enter password 123456";
		Assert.assertEquals(actual, expected);

	}

	// Verify LogIn
	@Test
	public void verifyLogIn() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("123456");
		WebElement submitbtn = driver.findElement(By.xpath("//button[@type='submit']"));
		submitbtn.click();
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Dashboard";
		Assert.assertEquals(actual, expected);

	}

	// verify sign in to start your session
	@Test
	public void verifyText() {
		String actual = driver.findElement(By.xpath("//p")).getText();
		String expected = "Sign in to start your session";
		Assert.assertEquals(actual, expected);
	}

	// verify member link spell
	@Test
	public void verifyMemberLinkSpell() {
		String actual = driver.findElement(By.xpath("//a[starts-with(@href, \"pages\")]")).getText();
		String expected = "Register a new membership";
		Assert.assertEquals(actual, expected);
	}

	// verify subject JAVA | SELENIUM | PYTHON
	@Test
	public void verifySubject() {
		String actual = driver.findElement(By.xpath("//h4")).getText();
		String expected = "JAVA | SELENIUM | PYTHON";
		Assert.assertEquals(actual, expected);
	}

	// verify email placeholder
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

	// Verify Logo is present or not
	@Test
	public void verifyLogo() {
		boolean logo = driver.findElement(By.xpath("//img")).isDisplayed();
		Assert.assertEquals(logo, true);

	}

	// verify Register Member Link
	@Test
	public void verifyMemberLink() {
		WebElement link = driver.findElement(By.xpath("/html/body/div/div[2]/a"));
		link.click();
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Registration Page";
		Assert.assertEquals(actual, expected);

	}

}

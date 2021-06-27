package com.com.javabykiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserPage {

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
		driver.findElement(By.xpath("//li[3]/a/span")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// print table
	@Test
	public void printTable() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> actual = new ArrayList<String>();
		System.out.println("no of rows in table " + rows.size());
		List<WebElement> coldata;

		for (WebElement rowElement : rows) {
			
			if (rows.indexOf(rowElement) == 0)
				coldata = rowElement.findElements(By.tagName("th"));
			else
				coldata = rowElement.findElements(By.tagName("td"));
			for (WebElement col : coldata) {
				System.out.print(col.getText());
				String a=col.getText();
				actual.add(a);
			}
			System.out.println();
		}
         
	}

	@Test
	public void printMaleusers() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (WebElement rowElement : rows) {
			List<WebElement> cols = rowElement.findElements(By.tagName("td"));
			for (WebElement element : cols) {
				if (element.getText().contains("Male")) {
					System.out.print(cols.get(1).getText() + "  " + element.getText());
					al.add(cols.get(1).getText());
				}
			}
		}
		System.out.println(al);

	}

	@Test
	public void printUsersFromMaharashtra() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (WebElement ele : rows) {
			List<WebElement> cols = ele.findElements(By.tagName("td"));
			for (WebElement e : cols) {
				if (e.getText().contains("Maharashtra")) {
					System.out.println(cols.get(1).getText() + "  " + e.getText());
					al.add(cols.get(1).getText());
				}
			}

		}
		System.out.println(al);
	}

	@Test
	public void printUsersFromPunjab() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (WebElement ele : rows) {
			List<WebElement> cols = ele.findElements(By.tagName("td"));
			for (WebElement e : cols) {
				if (e.getText().contains("Punjab")) {
					System.out.println(cols.get(1).getText() + "  " + e.getText());
					al.add(cols.get(1).getText());
				}
			}

		}
		System.out.println(al);
	}

//	@Test
//	public void printMaleusers2() {
//
//		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//
//		for (int i = 0; i < rows.size(); i++) {
//
//			if (rows.get(i).getText().contains("Male")) {
//				System.out.println(rows.get(i).getText());
//				List<WebElement> td = rows.get(i).findElements(By.tagName("td"));
//				System.out.println(td.get(1).getText());
//			}
//		}
//
//	}

	@Test
	public void printUserName() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			System.out.println(cols.get(1).getText());
			String a = cols.get(1).getText();
			al.add(a);

		}
		System.out.println("Before Sort " + al);
		Collections.sort(al);
		System.out.println("After Sort  " + al);

	}

	@Test
	public void verifyMailId() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (WebElement r : rows) {
			List<WebElement> cols = r.findElements(By.tagName("td"));
			for (WebElement c : cols) {
				if (c.getText().contains("@gmail.com")) {
					System.out.println(cols.get(1).getText() + "    " + c.getText());
					al.add(c.getText());
				}
			}
		}
		System.out.println(al);
	}

	@Test
	public void verifyUserEnteredCorrectGender() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			String gender = cols.get(5).getText();

			if (gender.equals("Male") || gender.equals("Female")) {
				System.out.println(cols.get(1).getText() + "  " + cols.get(5).getText());
			}

		}

	}

	@Test
	public void countMaleGender() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();
		int count = 0;
		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			String gender = cols.get(5).getText();

			if (gender.equals("Male")) {
				System.out.println(cols.get(1).getText() + "  " + cols.get(5).getText());
				count++;
			}

		}
		System.out.println("No of male is : " + count);
	}

	@Test
	public void countFemaleGender() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();
		int count = 0;
		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			String gender = cols.get(5).getText();

			if (gender.equals("Female")) {
				System.out.println(cols.get(1).getText() + "  " + cols.get(5).getText());
				count++;
			}

		}
		System.out.println("No of male is : " + count);
	}

	@Test
	public void countRowsAndColoumn() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<WebElement> cols = null;
		System.out.println(" No of rows in table is : " + rows.size());
		for (WebElement row : rows) {

			cols = row.findElements(By.tagName("td"));

		}
		System.out.println(" No of Coloumn in table is : " + cols.size());

		System.out.println(" Coloumn header is ");
		for (WebElement row : rows) {
			List<WebElement> head = row.findElements(By.tagName("th"));
			{
				for (WebElement header : head) {
					System.out.print(header.getText() + "  ");
				}
			}

			System.out.println();
		}
	}

	@Test
	public void verifyMobile() {

		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 1; i < rows.size(); i++) {

			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			String mobile = cols.get(3).getText();

			if (mobile.length() == 10) {
				System.out.println(cols.get(1).getText() + "  " + cols.get(3).getText());
			}

		}

	}

	@Test
	public void verifyCourseOfUser() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		// ArrayList<String> al = new ArrayList<String>();

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the User name");
		String username = sc.next();

		for (WebElement r : rows) {
			List<WebElement> cols = r.findElements(By.tagName("td"));
			for (WebElement c : cols) {

				if (c.getText().contains(username)) {
					System.out.println(cols.get(4).getText() + "  ");
				}

			}
		}
	}

//	@Test
//	public void verifyDeleteBtn1() {
//		WebElement table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
//		List<WebElement> rows = table.findElements(By.tagName("tr"));
//		for (WebElement r : rows) {
//			List<WebElement> cols = r.findElements(By.tagName("td"));
//			
//				for (WebElement c : cols) {
//					if (r.getText().contains("Delete")) {
//					c.click();
//					//System.out.println("click");
//
//				}
//			}
//		}

	@Test
	public void verifyAddUserBtn() {
		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		btn.click();
		String actual = driver.getTitle();
		String expected = "JavaByKiran | Add User";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void verifyHeadline() {
		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		btn.click();
		String actual = driver.findElement(By.xpath("//h1")).getText();
		String expected = "Add User";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void verifyHeading() {
		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		btn.click();
		String actual = driver.findElement(By.xpath("//h3[contains(text(),'Fill Below Details')]")).getText();
		String expected = "Fill Below Details";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void verifydetails() {
		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		btn.click();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("shreya");
		WebElement mobile = driver.findElement(By.id("mobile"));
		mobile.sendKeys("11111");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("shreya@gmail.com");
		WebElement course = driver.findElement(By.id("course"));
		course.sendKeys("selenium");
		WebElement gender = driver.findElement(By.id("Female"));
		gender.click();
		WebElement state = driver.findElement(By.xpath("//div//following::select"));
		Select select = new Select(state);
		select.selectByValue("Maharashtra");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("shreya777");
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		Alert al = driver.switchTo().alert();
		String actual = al.getText();
		al.accept();
		String expected = "User Added Successfully. You can not see added user.";
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void cancelbtn() {
		WebElement btn = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		btn.click();
		WebElement cancel = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));
		cancel.click();
		String actual = driver.getTitle();
		String expected = "JavaByKiran | User";
		Assert.assertEquals(actual, expected);
	}

}

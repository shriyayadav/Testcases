import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class LoginPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\eclipse-workspace\\POM\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/Shreya%20Yadav/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
//@BeforeMethod
	}
	
//	@Befo
}
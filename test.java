package cs458;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Ayca/Desktop/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		
		Thread.sleep(1000);
		WebElement searchBox;
		searchBox = driver.findElement(By.name("Username"));
		searchBox.sendKeys("21000001");
		Thread.sleep(1000);
		WebElement searchBox1;
		searchBox1 = driver.findElement(By.name("password"));
		searchBox1.sendKeys("hs");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}
}

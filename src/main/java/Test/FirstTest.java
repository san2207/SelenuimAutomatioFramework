package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	driver.get("https://admin-demo.nopcommerce.com/login");
	String title= driver.getTitle();
	System.out.println("Title is :" +title);
//	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
//	System.out.println("Text of LoginButton is" +loginButton.getText());
//	WebElement emailbox = driver.findElement(By.id("Email"));
//	emailbox.clear();
//	emailbox.sendKeys("admin@yourstore.com");
//	
	driver.findElement(By.id("Email")).clear();
 driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");

driver.findElement(By.id("Password")).clear();
driver.findElement(By.id("Password")).sendKeys("admin");
driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
	
	//driver.close();
	
	
   //driver.quit();
}
}

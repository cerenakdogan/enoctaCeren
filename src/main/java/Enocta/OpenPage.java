package Enocta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OpenPage extends BaseClass {

	CommonFunctions ortakfonk;


	
	//Kullanıcı bilgileri ile giriş yapma

	public static void userLogin() {
		
		CommonFunctions.beklemesüresi();

		try {
			WebElement cookieAccept = driver.findElement(By.id("onetrust-accept-btn-handler"));
			cookieAccept.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
//		Actions a= new Actions(driver);
		WebElement mainmenu=driver.findElement(By.xpath("//div[@class='link account-user']"));
//		a.moveToElement(mainmenu).build().perform();
//		WebElement Sub = driver.findElement(By.className("login-button"));   
		mainmenu.click();



		WebElement mail = driver.findElement(By.id("login-email"));
		mail.sendKeys("crnulcn@gmail.com");

		CommonFunctions.beklemesüresi();
		WebElement password = driver.findElement(By.id("login-password-input"));
		password.sendKeys("1Q2w3e4r*");
		
		WebElement signInButton = driver.findElement(By.xpath("//div[@id='login-register']/div[3]/div[1]/form[1]/button[1]"));
		signInButton.click();



	}

}

package Enocta;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class BasketPage extends BaseClass {
	
	public static void addBasket() {
	
		WebElement sepetEkleButton = driver.findElement(By.xpath("//button[@component-id='1']"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -250);", sepetEkleButton);
		sepetEkleButton.click();
		CommonFunctions.beklemesüresi();

		
		WebElement urunAdi = driver.findElement(By.xpath("//a[@class='product-preview-link']"));
		System.out.println("Eklenen Urun"+ urunAdi.getText());
		
		goBasket();
		WebElement urunAdiBasket = driver.findElement(By.xpath("//p[@class='pb-item']"));
		System.out.println("Eklenen Urun"+ urunAdiBasket.getText());
		
		CommonFunctions.beklemesüresi();
        Assert.assertEquals(urunAdi.getText(), urunAdiBasket.getText(), "Sepete Eklenen ürün doğru");
        
	    deleteBasket();

	}
	
	public static void goBasket() {
		
		CommonFunctions.beklemesüresi();
		
		try {
			WebElement goBasketButton = driver.findElement(By.xpath("//a[@class='go-basket-button']"));
			goBasketButton.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		CommonFunctions.beklemesüresi();
		 System.out.println("Sepete gidildi.");

	}
	
	
	public static void deleteBasket() {

		CommonFunctions.beklemesüresi();
		WebElement overlay = driver.findElement(By.xpath("//div[@class='onboarding-overlay']"));
		overlay.click();
		
		try {
            WebElement deleteButton = driver.findElement(By.xpath("//i[@class='i-trash']"));
            // Element bulundu
            deleteButton.click();
            System.out.println("Sepete temizlendi.");
        } catch (NoSuchElementException e) {
            // Element bulunamadı
            System.out.println("Element mevcut değil.");
        }
		
		CommonFunctions.beklemesüresi();
		

	}
	
}

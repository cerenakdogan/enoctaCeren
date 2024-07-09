package Enocta;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class ProductSelectRandomProcess extends BaseClass {

	// Ürün arama (iphone)

	public static void search() {
		
		CommonFunctions.beklemesüresi();
		
		WebElement araButton = driver.findElement(By.xpath("//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']"));

		araButton.clear();
		
		araButton.sendKeys("cep telefonu");
		
		CommonFunctions.beklemesüresi();

		araButton.sendKeys(Keys.ENTER);
		
		CommonFunctions.beklemesüresi();

		System.out.println("Cep telefonu aramalı ürünler getirildi.");

	}

	public static void filtrePrice() {

		WebElement filtreButton = driver.findElement(By.xpath("//div[text()='Fiyat']"));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", filtreButton);

		try {
			WebElement scrollButton = driver.findElement(By.xpath("//div[@class='overlay']"));
			scrollButton.click();
		} catch (Exception e) {
			// TODO: handle exception
		
		}
		
		filtreButton.click();

		WebElement minPrice = driver.findElement(By.xpath("//input[@class='fltr-srch-prc-rng-input min']"));
		minPrice.sendKeys("15000");

		WebElement maxPrice = driver.findElement(By.xpath("//input[@class='fltr-srch-prc-rng-input max']"));
		maxPrice.sendKeys("20000");

		WebElement searchPrice = driver.findElement(By.xpath("//button[@class='fltr-srch-prc-rng-srch']"));
		searchPrice.click();

		CommonFunctions.beklemesüresi();
		
		System.out.println("Fiyat Filtresi Başarılı");


	}
	
	public static WebElement findSmallestNumberButton(List<WebElement> buttons) {
		
        WebElement smallestButton = null;
        
        double smallestNumber = Double.MIN_VALUE;

        for (WebElement button : buttons) {
            try {
                double number = Double.parseDouble(button.getText().trim());
                if (number < smallestNumber) {
                    smallestNumber = number;
                    smallestButton = button;
                }
            } catch (NumberFormatException e) {
                // Buton metni sayısal değilse veya boşsa, atla
                continue;
            }
        }

        return smallestButton;
    }

	// Arama sonucunda açılan sayfadan rastgele ürün seçme

	public static void randomProductSelect() {

		//new Actions(driver).sendKeys(Keys.PAGE_DOWN).build().perform();
		CommonFunctions.beklemesüresi();


		List<WebElement> allElements =
				driver.findElements(By.xpath("//span[@class='prdct-desc-cntnr-name hasRatings']"));


		System.out.println("Toplam element sayısı: "+allElements.size());

		List<WebElement> subList = allElements.subList(allElements.size()-4, allElements.size());
		
		Random objGenerator = new Random();
		int randomUrun = objGenerator.nextInt(subList.size());
		System.out.println("Random seçilen ürun no : " + randomUrun);
		WebElement urunSec = subList.get(randomUrun);
		
		CommonFunctions.beklemesüresi();
		
		System.out.println("Seçilen ürün adı:" + urunSec.getText());

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", urunSec);

		CommonFunctions.beklemesüresi();

		urunSec.click();
		
		System.out.println("Ürün seçildi");

		CommonFunctions.beklemesüresi();

		
	}
}

	
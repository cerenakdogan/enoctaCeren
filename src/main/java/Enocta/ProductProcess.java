package Enocta;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class ProductProcess extends BaseClass {

	
	public static WebElement findSmallestNumberButton(List<WebElement> buttons) {
		
        WebElement smallestButton = null;
        
        double smallestNumber = Double.MAX_VALUE;

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

	public static void addBasketLowPointSeller() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		CommonFunctions.beklemesüresi();
		WebElement showAllSellers = driver.findElement(By.xpath("//a[@class='show-all']"));

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 250);", showAllSellers);

		showAllSellers.click();
		CommonFunctions.beklemesüresi();
	        
	        // Tüm button elementlerini bulun
	    List<WebElement> allSellerElements = driver.findElements(By.xpath("//div[@class='sl-pn']"));

	        // En küçük sayı değerine sahip olan butonu bulun
	    WebElement smallestNumberButton = findSmallestNumberButton(allSellerElements);

	    if (smallestNumberButton != null) {
	    	    CommonFunctions.beklemesüresi();
	            smallestNumberButton.click(); // En küçük sayı değerine sahip butona tıkla
	            CommonFunctions.beklemesüresi();
	            System.out.println("En küçük sayı değerine sahip butona tıklandı.");
	       } else {
	            System.out.println("Buton bulunamadı.");
	            BasketPage.addBasket();
	            System.out.println("En küçük sayı değerine sahip sayfadaki butona tıklandı.");
	       }
	    CommonFunctions.beklemesüresi();
	}

}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.Journey;

public class SeatSelectionPage {
	public WebDriver driver;

	public SeatSelectionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public Integer getAvaliableSeats(String preferredTrain, Journey journey) {
		selectATrain(preferredTrain, journey);
		return countSeats();
	}

	private Integer countSeats() {
		Integer retVal = 0;
		try {
			
			List<WebElement> avalSeats  = driver
					.findElements(By.xpath("//div[@class='route-item__cars-list__item j-car-list-item current']//b"));
			for(WebElement elt : avalSeats) {
				retVal+= Integer.valueOf(elt.getText());
			}
			return retVal;
		} catch (Exception e) {
			e.printStackTrace();
			return retVal;
		} 
	}

	private void selectATrain(String preferredTrain, Journey journey) {
		try {
			new WebDriverWait(driver, 1000)
					.until(ExpectedConditions.presenceOfElementLocated(By.className("j-trains-box")));
			new WebDriverWait(driver, 1000)
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("j-trains-box"))));
			driver.findElement(By.xpath("//span[contains(text(),'" + preferredTrain + "')]"
					+ "/ancestor::div[@class='j-train'][1]//div[contains(text(),'"+journey.getComfortClass()+"')]")).click();
			new WebDriverWait(driver, 1000).until(
					ExpectedConditions.elementToBeClickable(driver.findElement(By.className("j-route-select-btn"))));
			driver.findElement(By.className("j-route-select-btn")).click();;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}

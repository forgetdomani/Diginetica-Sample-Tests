package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testData.Journey;

public class DirectionAndDatePage {
	public WebDriver driver;

	public DirectionAndDatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "name0")
	private WebElement from;

	@FindBy(id = "name1")
	private WebElement to;

	@FindBy(id = "date0")
	private WebElement depDateBox;

	@FindBy(id = "Submit")
	private WebElement btBuy;

	public void enterJourney(Journey oneWay2Tula) {
		fillBox(from, oneWay2Tula.getPointOfDeparture());
		fillBox(to, oneWay2Tula.getDestination());
		selectDate(depDateBox, oneWay2Tula.getTravelMonth(), oneWay2Tula.getTravelDay());
	}

	public void SearchForTrains() {
		try {
			new WebDriverWait(driver, 1000).until(ExpectedConditions.elementToBeClickable(btBuy));

			btBuy.click();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private void selectDate(WebElement calendarBox, String month, String day) {
		try {

			calendarBox.findElement(By.xpath(".."))
					.findElement(By.cssSelector("div.box-form__datetime__calendar.sh_calendar")).click();

			driver.findElement(By.xpath(
					"//span[text()='" + month + "']/ancestor::div[@class='month_wrap'][1]//span[text()=" + day + "]"))
					.click();

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	private void fillBox(WebElement textBox, String data) {
		try {
			textBox.sendKeys(data);
			textBox.sendKeys(Keys.RETURN);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}

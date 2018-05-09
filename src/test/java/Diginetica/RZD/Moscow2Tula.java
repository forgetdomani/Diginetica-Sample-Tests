package Diginetica.RZD;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.DirectionAndDatePage;
import pages.SeatSelectionPage;
import testData.Journey;

public class Moscow2Tula {
	private static WebDriver driver;
	private static DirectionAndDatePage directionAndDatePage;
	private static SeatSelectionPage seatSelectionPage;

	@BeforeClass
	public static void setup() {

		System.setProperty("webdriver.gecko.driver", "c:\\gecodriver\\geckodriver.exe");

		driver = new FirefoxDriver();
		directionAndDatePage = new DirectionAndDatePage(driver);
		seatSelectionPage = new SeatSelectionPage(driver);

		driver.manage().window().maximize();
		driver.navigate().to("http://pass.rzd.ru/");
	}

	@Test
	public void MoscowToTulaTest() {
		Journey oneWay2Tula = new Journey("Москва", "Тула", "Май", "30", "Купе");
		String preferredTrain = "119";

		directionAndDatePage.enterJourney(oneWay2Tula);
		directionAndDatePage.SearchForTrains();

		Integer seats = seatSelectionPage.getAvaliableSeats(preferredTrain, oneWay2Tula);

		System.out.println(seats + " seats avaliable");

	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}
}

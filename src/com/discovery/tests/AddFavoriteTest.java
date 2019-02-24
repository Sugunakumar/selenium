package com.discovery.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.discovery.pages.HomePage;
import com.discovery.pages.MyVideosPage;

// Page Object Model is followed - POM
// Thread.sleep just to used only for ease of  viewing on the browser. 
// In real time we need use fluent of explicit wait and sleep need to be avoided as it kills the performance

public class AddFavoriteTest {

	public static void main(String[] args) throws InterruptedException {

		String path = System.getProperty("user.dir");
		System.out.println(path);

		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\suguna
		// kumar\\eclipse-workspace\\Discovery\\resources\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.discovery.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// ------- First item ------------

		// Create object for HomePage
		HomePage home = new HomePage(driver);

		// Get First item in Recommended videos
		WebElement item1 = home.getItem1();

		// Mouse Hover on First item
		home.mouseHover(item1);

		// Get title
		String title1 = home.getItem1Title();

		// Get Description
		String description1 = home.getItem1Description();

		// Click on Add to Favorites
		home.getItem1AddToFav().click();

		Thread.sleep(4000);

		// ------- Second item ------------

		// Get Second item in Recommended videos
		WebElement item2 = home.getItem2();

		// Mouse Hover on First item
		home.mouseHover(item2);

		// Get title
		String title2 = home.getItem2Title();

		// Get Description
		String description2 = home.getItem2Description();

		// Click on Add to Favorites
		home.getItem2AddToFav().click();

		Thread.sleep(4000);

		// ------- Verification in my-videos ----------------

		// Navigate to my videos
		// driver.navigate().to("https://www.discovery.com/my-videos");
		driver.get("https://www.discovery.com/my-videos");

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,-1000)", "");
//		js.executeScript("window.scrollBy(0,-1000)", "");

		// Create Page object for My videos page - POM
		MyVideosPage myVideosPage = new MyVideosPage(driver);

		// --------- First item verification ----------------------

		// Get first element in the Favorites
		WebElement item1Fav = myVideosPage.getItem1();

		// Verification for first item in favorites
		if (item1Fav != null)
			System.out.println("Test: Passed -> First item added to Favorite : " + title1);
		else
			System.out.println("Test: Failed -> First item not added to Favorite : " + title1);

		// mouse hover on first item in favorites
		myVideosPage.mouseHover(item1Fav);

		// Get title and description of the same
		String title1Fav = myVideosPage.getItem1Title();
		String description1Fav = myVideosPage.getItem1Description();

		// Get Second element in the Favorites
		WebElement item2Fav = myVideosPage.getItem2();

		// Verification for Second item in favorites
		if (item2Fav != null)
			System.out.println("Test: Passed -> Second item added to Favorite : " + title2);
		else
			System.out.println("Test: Failed -> Second item not added to Favorite : " + title2);

		// mouse hover on Second item in favorites
		myVideosPage.mouseHover(item2Fav);

		// Get title and description of the same
		String title2Fav = myVideosPage.getItem2Title();
		String description2Fav = myVideosPage.getItem2Description();

		// assert itemFav.isDisplayed();

		Thread.sleep(4000);

		// Verification for the title
		if (title2.equals(title1Fav))
			System.out.println("Test: Passed -> First Item: Title : " + title1Fav);
		else
			System.out.println("Test: Failed -> First Item: Title : expected is " + title2 + " but was " + title1Fav);

		// Verification for the description
		description2 = description2.substring(0, 80);
		if (description1Fav.contains(description2))
			System.out.println("Test: Passed -> First Item: Description : " + description1Fav);
		else
			System.out.println("Test: Failed -> First Item: Description : expected is " + description2 + " but was "
					+ description1Fav);

		// --------- Second item verification ----------------------

		// assert itemFav.isDisplayed();

		Thread.sleep(4000);

		// Verification for the title
		if (title1.equals(title2Fav))
			System.out.println("Test: Passed -> Second Item: Title : " + title2Fav);
		else
			System.out.println("Test: Failed -> Second Item: Title : expected is " + title1 + " but was " + title2Fav);

		// Verification for the description
		description1 = description1.substring(0, 80);
		if (description2Fav.contains(description1))
			System.out.println("Test: Passed -> Second Item: Description : " + description2Fav);
		else
			System.out.println("Test: Failed -> Second Item: Description : expected is " + description1 + " but was "
					+ description2Fav);

		driver.quit();

	}

}

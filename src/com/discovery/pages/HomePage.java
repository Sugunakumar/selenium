package com.discovery.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// Page object model
// For each page in the application one class is created

public class HomePage {

	protected WebDriver driver;
	protected Actions action;

	By item1Locator = By
			.xpath("//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[1]/section/div//h3");
	By item2Locator = By
			.xpath("//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[2]/section/div//h3");

	By item1TitleLocator = By
			.xpath("//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[1]/section/div//h3/div");
	By item2TitleLocator = By
			.xpath("//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[2]/section/div//h3/div");

	By item1DescriptionLocator = By.xpath(
			"//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[1]/section/div//div[@class='showTileSquare__description']/div");
	By item2DescriptionLocator = By.xpath(
			"//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[2]/section/div//div[@class='showTileSquare__description']/div");

	By item1AddToFavLocator = By
			.xpath("//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[1]/section/div//i");
	By item2AddToFavLocator = By
			.xpath("//section[@class='layout-section ShowCarousel layoutSection__main '][1]/div//div[2]/section/div//i");

	public HomePage(WebDriver dri) {
		this.driver = dri;
		this.action = new Actions(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement getItem1() {
		WebElement item1 = driver.findElement(item1Locator);
		return item1;
	}

	public WebElement getItem2() {
		WebElement item2 = driver.findElement(item2Locator);
		return item2;
	}

	public String getItem1Title() {
		WebElement item1Title = driver.findElement(item1TitleLocator);
		return item1Title.getAttribute("textContent");
	}

	public String getItem2Title() {
		WebElement item2Title = driver.findElement(item2TitleLocator);
		return item2Title.getAttribute("textContent");
	}

	public String getItem1Description() {
		WebElement item1Description = driver.findElement(item1DescriptionLocator);
		return item1Description.getAttribute("textContent");
	}

	public String getItem2Description() {
		WebElement item1Description = driver.findElement(item2DescriptionLocator);
		return item1Description.getAttribute("textContent");
	}

	public WebElement getItem1AddToFav() {
		WebElement item1AddToFav = driver.findElement(item1AddToFavLocator);
		return item1AddToFav;
	}

	public WebElement getItem2AddToFav() {
		WebElement item2AddToFav = driver.findElement(item2AddToFavLocator);
		return item2AddToFav;
	}

	public void mouseHover(WebElement element) {
		action.moveToElement(element).perform();
	}

	public void tearDown() {
		try {
			this.driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

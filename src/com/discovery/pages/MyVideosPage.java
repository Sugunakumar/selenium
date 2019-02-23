package com.discovery.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

// Page object model
// For each page in the application one class is created

public class MyVideosPage {

	protected WebDriver driver;
	protected Actions action;

	By item1 = By
			.xpath("//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']//div[1]/section");
	By item2 = By
			.xpath("//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']//div[2]/section");

	By item1Title = By
			.xpath("//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']//div[1]/section//h3");
	By item2Title = By
			.xpath("//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']//div[2]/section//h3");

	By item1Description = By.xpath(
			"//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']//div[1]/section//div[@class='showTileSquare__description']/div");
	By item2Description = By.xpath(
			"//section[@class='layout-section FavoriteShowsCarousel layoutSection__main ']//div[2]/section//div[@class='showTileSquare__description']/div");

	public MyVideosPage(WebDriver dri) {
		this.driver = dri;
		this.action = new Actions(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement getItem1() {
		return driver.findElement(item1);
	}

	public WebElement getItem2() {
		return driver.findElement(item2);
	}

	public String getItem1Title() {
		return driver.findElement(item1Title).getAttribute("textContent");
	}

	public String getItem2Title() {
		return driver.findElement(item2Title).getAttribute("textContent");
	}

	public String getItem1Description() {
		return driver.findElement(item1Description).getAttribute("textContent");
	}

	public String getItem2Description() {
		return driver.findElement(item2Description).getAttribute("textContent");
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

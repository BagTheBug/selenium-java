package com.fb.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fb.utils.Utils;

public class UnFriend {

	public boolean unFriendValid(WebDriver driver, String frndName) {
		WebElement profileLink = driver.findElement(By.xpath("//div[@class='linkWrap noCount' and text()='Poornima Poorni']"));
		profileLink.click();
		
		Utils.waitForLoad(driver);
		
		WebElement friendsTabLink = driver.findElement(By.xpath("//li/a[text()='Friends']"));
		Utils.waitForVisible(friendsTabLink,"//a[text()='Friends']");
		Utils.waitforElementClick(friendsTabLink);
		Utils.waitForLoad(driver);
		
		WebElement friendsButton = driver.findElement(By.xpath("//a[contains(text(),'" + frndName
				+ "')]/ancestor::div[@class='uiProfileBlockContent']/preceding-sibling::div//a//span[text()='Friends']"));
		friendsButton.click();
		
		WebElement unFriendBtn = driver.findElement(By.xpath("//*[@data-label='Unfriend']/a"));
		unFriendBtn.click();
		
		WebElement addFriend = driver
				.findElement(By.xpath("//button[contains(@aria-label,'Karthiban') and text()='Add Friend']"));
		return addFriend.isDisplayed();

	}
}

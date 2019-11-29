package com.fb.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLogin {
	public void validLogin(WebDriver driver, String email, String pwd) {

		WebElement emailTxtBox = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement pwdTxtBox = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login'] | //input[@value='Log In']"));

		emailTxtBox.sendKeys(email);
		pwdTxtBox.sendKeys(pwd);
		loginBtn.click();

	}
}

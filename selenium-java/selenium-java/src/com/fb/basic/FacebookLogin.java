package com.fb.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fb.utils.Utils;

public class FacebookLogin {
	
	public boolean validLogin(WebDriver driver, String email, String pwd) {

		WebElement emailTxtBox = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement pwdTxtBox = driver.findElement(By.xpath("//input[@name='pass']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login'] | //input[@value='Log In']"));

		emailTxtBox.sendKeys(email);
		pwdTxtBox.sendKeys(pwd);
		loginBtn.click();
		
		Utils.waitForLoad(driver);
		
		return true;
	}
}

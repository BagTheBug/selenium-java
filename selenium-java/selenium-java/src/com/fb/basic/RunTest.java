package com.fb.basic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fb.utils.ReadPropertiesFile;
import com.fb.utils.ScreenShot;

public class RunTest {
	public static void main(String args[]) {
		
		String siteUrl ="";
		String email ="";
		String pwd ="";
		String chromeDriverPath ="";
		String chromeWebDriver ="";
		String friendName ="";

		try {
			siteUrl = ReadPropertiesFile.getCredPropValue("SiteURL");
			email = ReadPropertiesFile.getCredPropValue("TestUserEmail");
			pwd = ReadPropertiesFile.getCredPropValue("TestUserPassword");
			chromeWebDriver = ReadPropertiesFile.getConfigParm("ChromeWebDriver");
			chromeDriverPath = ReadPropertiesFile.getConfigParm("ExecutableChromeDriverPath");
			friendName = ReadPropertiesFile.getConfigParm("friendName");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty(chromeWebDriver, chromeDriverPath);
		WebDriver driver = new ChromeDriver(options);
		FacebookLogin fl = new FacebookLogin();
		UnFriend uf = new UnFriend();
		ScreenShot sc = new ScreenShot();

		driver.manage().window().maximize();
		driver.get(siteUrl);

		System.out.println("Login Test Case Passed : " +fl.validLogin(driver, email, pwd));
		System.out.println("Unfriend Test Case Passed : " +uf.unFriendValid(driver, friendName));
		
		try {
			sc.screen(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}

package com.fb.basic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.fb.utils.ReadPropertiesFile;
import com.fb.utils.ScreenShot;

public class RunTest {
	public static void main(String args[]) {
		String siteUrl = null, email = null, pwd = null, chromeDriverPath = null, chromeWebDriver = null;

		try {
			siteUrl = ReadPropertiesFile.getCredPropValue("SiteURL");
			email = ReadPropertiesFile.getCredPropValue("TestUserEmail");
			pwd = ReadPropertiesFile.getCredPropValue("TestUserPassword");
			chromeWebDriver = ReadPropertiesFile.getConfigParm("ChromeWebDriver");
			chromeDriverPath = ReadPropertiesFile.getConfigParm("ExecutableChromeDriverPath");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty(chromeWebDriver, chromeDriverPath);
		WebDriver driver = new ChromeDriver(options);
		FacebookLogin fl = new FacebookLogin();
		ScreenShot sc = new ScreenShot();

		driver.manage().window().maximize();
		driver.get(siteUrl);

		fl.validLogin(driver, email, pwd);

		try {
			sc.screen(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}

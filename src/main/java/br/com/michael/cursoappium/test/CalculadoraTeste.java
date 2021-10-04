package br.com.michael.cursoappium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTeste {
	
	private static final String ANDROID_DEVICE_NAME = "0032903534";

	@Test
	public void deveSomarDoisNumeros() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", ANDROID_DEVICE_NAME);
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<MobileElement> driver = 
				new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		
		MobileElement el1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("mais");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
		el4.click();
		
		driver.quit();
	}
}

package br.com.michael.cursoappium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	private DriverFactory() {
	}
	
	public static final AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		
		return driver;
	}

	private static final void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
//		Não precisa pois é android, se fosse IOS sim
//		desiredCapabilities.setCapability("deviceName", DEVICE_NAME);
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.ctappium");
		desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
//		Faz com que o Appium instale a aplicação automaticamente
//		desiredCapabilities.setCapability(MobileCapabilityType.APP, "Caminho até o APK AQUI");
		
		try {
			URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static final void killDriver() {
		if (driver != null) {
			driver.closeApp();
			driver.quit();
			driver = null;
		}
	}
	
	public static final void restartAPP() {
		if (driver != null) {
			driver.resetApp();
		}
	}
}

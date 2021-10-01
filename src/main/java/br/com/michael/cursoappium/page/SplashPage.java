package br.com.michael.cursoappium.page;

import static br.com.michael.cursoappium.core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class SplashPage extends BasePage {
	
	private final By textoSplash = MobileBy.xpath("//android.widget.TextView[@text='Splash!']");

	public boolean telaSplashEstaAparecendo() {
		return existeElementoPorTexto("Splash");
	}

	public void aguardarSplashSumir() {
		getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(textoSplash));
	}
}

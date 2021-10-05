package br.com.michael.cursoappium.core;

import static br.com.michael.cursoappium.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	protected static MobileElement obterElemento(By by) {
		return getDriver().findElement(by);
	}

	protected static List<MobileElement> obterElementosPorTexto(String texto) {
		final By by = MobileBy.xpath(String.format("//*[@text='%s']", texto));
		return getDriver().findElements(by);
	}

	protected void escrever(By by, String texto) {
		obterElemento(by).sendKeys(texto);
	}

	protected String obterTexto(By by) {
		return obterElemento(by).getText();
	}

	protected void clicar(By by) {
		obterElemento(by).click();
	}
	
	protected void cliqueLongo(By by) {
		ElementOption elementOption = element(obterElemento(by));
		LongPressOptions longPressOptions = longPressOptions().withElement(elementOption);
		new TouchAction<>(getDriver())
			.longPress(longPressOptions)
			.perform()
		;
	}
	
	protected void scroll(double inicio, double fim) {
		
		if (inicio >= 1) {
			inicio /= 100;
		}
		
		if (fim >= 1) {
			fim /= 100;
		}
		
		final Dimension size = getDriver().manage().window().getSize();
		final int x = size.getWidth() / 2;
		final int yInicial = (int) (size.getHeight() * inicio);
		final int yFinal = (int) (size.getHeight() * fim);
		
		final PointOption<?> coordenadaInicial = PointOption.point(x, yInicial);
		final PointOption<?> coordenadaFinal = point(x, yFinal);
		final WaitOptions tempoEspera = waitOptions(ofSeconds(1));

		new TouchAction<>(getDriver())
			.press(coordenadaInicial)
			.waitAction(tempoEspera)
			.moveTo(coordenadaFinal)
			.release()
			.perform()
		;
	}
	
	protected void cliqueDuplo(By by) {
		clicar(by);
		clicar(by);
	}

	protected void selecionarItemCombo(By by, String valor) {
		obterElemento(by).click();
		clicarPorTexto(valor);
	}

	protected void clicarPorTexto(String texto) {
		final String xpath = String.format("//*[@text='%s']", texto);
		obterElemento(By.xpath(xpath)).click();
	}

	protected boolean checkboxEstaSelecionada(By by) {
		return obterElemento(by).isSelected();
	}

	protected boolean switchEstaSelecionado(By by) {
		return Boolean.valueOf(obterElemento(by).getAttribute("checked"));
	}

	protected boolean existeElementoPorTexto(String texto) {
		final List<MobileElement> elementosEncontrados = obterElementosPorTexto(texto);
		final boolean haElementosEncontrados = !elementosEncontrados.isEmpty();
		return haElementosEncontrados;
	}

	protected void tap() {
		tap(100, 150);
	}

	protected void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(point(x, y));
	}
}

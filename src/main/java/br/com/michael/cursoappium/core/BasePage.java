package br.com.michael.cursoappium.core;

import static br.com.michael.cursoappium.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

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

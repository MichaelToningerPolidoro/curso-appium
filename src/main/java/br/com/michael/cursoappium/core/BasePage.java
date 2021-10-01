package br.com.michael.cursoappium.core;

import static br.com.michael.cursoappium.core.DriverFactory.getDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BasePage {
	
	private static MobileElement obterElemento(By by) {
		return getDriver().findElement(by);
	}
	
	private static List<MobileElement> obterElementosPorTexto(String texto) {
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
}

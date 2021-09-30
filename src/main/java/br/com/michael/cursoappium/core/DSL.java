package br.com.michael.cursoappium.core;

import static br.com.michael.cursoappium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class DSL {

	private static MobileElement obterElemento(By by) {
		return getDriver().findElement(by);
	}
	
	public void escrever(By by, String texto) {
		obterElemento(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return obterElemento(by).getText();
	}
	
	public void clicar(By by) {
		obterElemento(by).click();
	}
	
	public void selecionarItemCombo(By by, String valor) {
		//clicando combo
		obterElemento(by).click();
		//clicando opção
		clicarPorTexto(valor);
	}
	
	public void clicarPorTexto(String texto) {
		final String xpath = String.format("//*[@text='%s']", texto);
		obterElemento(By.xpath(xpath)).click();
	}
	
	public boolean checkboxEstaSelecionada(By by) {
		return obterElemento(by).isSelected();
	}
	
	public boolean switchEstaSelecionado(By by) {
		return Boolean.valueOf(obterElemento(by).getAttribute("checked"));
	}
}

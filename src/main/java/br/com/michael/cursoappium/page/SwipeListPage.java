package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SwipeListPage extends BasePage {
	
	private static final String opcaoTemplate = "//*[@text='%s']/..";
	

	public void swipeElementRight(String opcao) {
		MobileElement element = obterElemento(By.xpath(getXpath(opcao)));
		swipeElement(element, 0.9, 0.2);
	}
	
	public void escolherElemento(String texto) {
		clicarPorTexto(texto);
	}
	
	public boolean existeElementoNaTela(String texto) {
		return existeElementoPorTexto(texto);
	}
	
	private final String getXpath(String texto) {
		return String.format(opcaoTemplate, texto);
	}
}

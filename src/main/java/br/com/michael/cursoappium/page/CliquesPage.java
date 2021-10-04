package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class CliquesPage extends BasePage {
	
	private final By btnCliqueLongo = MobileBy.xpath("//android.widget.TextView[@text='Clique Longo']");
	private final By btnCliqueDuplo = MobileBy.xpath("//android.widget.TextView[@text='Clique duplo']");
	private final By btnLimpar = MobileBy.xpath("//android.widget.TextView[@text='Limpar']");
	
	private final By campoTexto = MobileBy.xpath("//android.widget.TextView[2]");

	public void efetuarCliqueLongo() {
		cliqueLongo(btnCliqueLongo);
	}
	
	public void efetuarCliqueDuplo() {
		cliqueDuplo(btnCliqueDuplo);
	}
	
	public void clicarLimpar() {
		clicar(btnLimpar);
	}
	
	public String obterTextoCampo() {
		return obterTexto(campoTexto);
	}
}

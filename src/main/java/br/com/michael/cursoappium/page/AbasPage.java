package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class AbasPage extends BasePage {
	
	private static final By btnAba1 = MobileBy.xpath("//android.widget.TextView[@text='ABA 1']");
	private static final By btnAba2 = MobileBy.xpath("//android.widget.TextView[@text='ABA 2']");
	private static final By textoAba = MobileBy.xpath("//android.widget.TextView[contains(@text, 'Este é')]");
	
	public void clicarAba1() {
		clicar(btnAba1);
	}
	
	public void clicarAba2() {
		clicar(btnAba2);
	}
	
	public String obterTextoAba() {
		return obterTexto(textoAba);
	}
}

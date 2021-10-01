package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage {
	
	private static final By formulario = MobileBy.xpath("//android.widget.TextView[@text='Formulário']");
	private static final By splash = MobileBy.xpath("//android.widget.TextView[@text='Splash']");
	
	public void acessarFormulario() {
		clicar(formulario);
	}
	
	public void acessarSplash() {
		clicar(splash);
	}
}

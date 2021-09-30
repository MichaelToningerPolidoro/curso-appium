package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage {
	
	private static final By formularioHome = MobileBy.xpath("//android.widget.TextView[@text='Formulário']");
	
	public void acessarFormulario() {
		clicar(formularioHome);
	}
}

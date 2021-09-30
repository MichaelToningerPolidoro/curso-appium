package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.DSL;
import br.com.michael.cursoappium.core.DSLFactory;
import io.appium.java_client.MobileBy;

public class MenuPage {
	
	private static final By formularioHome = MobileBy.xpath("//android.widget.TextView[@text='Formulário']");
	
	private static final DSL dsl = DSLFactory.getDSL();

	public void acessarFormulario() {
		dsl.clicar(formularioHome);
	}
}

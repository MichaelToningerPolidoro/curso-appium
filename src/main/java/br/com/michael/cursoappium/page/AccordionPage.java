package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class AccordionPage extends BasePage {
	
	//*[@text='Op��o 1']/../..//following-sibling::android.view.ViewGroup

	private final By descricaoOpcao1 = MobileBy.xpath("//android.widget.TextView[@text='Esta � a descri��o da op��o 1']");
	
	public void clicarOpcao1() {
		clicarPorTexto("Op��o 1");
	}
	
	public String obterTextoDescricao1() {
		return obterTexto(descricaoOpcao1);
	}
}

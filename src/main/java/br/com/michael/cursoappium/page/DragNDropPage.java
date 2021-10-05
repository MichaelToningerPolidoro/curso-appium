package br.com.michael.cursoappium.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DragNDropPage extends BasePage {
	
	private static final String xpathTemplate = "//*[@text='%s']";
	private final By inicio = getXpath("inicio");
	private final By fim = getXpath("fim");
	private final By classeItensLista = By.className("android.widget.TextView");

	public void arrastar() {
//		new TouchAction<>(getDriver())
//			.longPress(inicio)
//			.moveTo(fim)
//			.release()
//			.perform()
//		;
	}
	
	public List<String> obterListaDeElementos() {
		List<MobileElement> elementos = obterElementos(classeItensLista);
		return elementos.stream().map(e -> e.getText()).collect(Collectors.toList());
	}
	
	private static final By getXpath(String texto) {
		return MobileBy.xpath(String.format(xpathTemplate, texto));
	}
}

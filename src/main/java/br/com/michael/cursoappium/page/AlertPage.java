package br.com.michael.cursoappium.page;

import org.openqa.selenium.By;

import br.com.michael.cursoappium.core.BasePage;
import io.appium.java_client.MobileBy;

public class AlertPage extends BasePage {

	private static final By frameAlerta = MobileBy.xpath("//android.widget.FrameLayout");
	private static final By tituloAlerta = MobileBy.AccessibilityId("android:id/alertTitle");
	private static final By textoAlerta = MobileBy.AccessibilityId("android:id/message");
	private static final By botaoAlerta = MobileBy.AccessibilityId("android:id/button1");
	
	private static final By alertaSimples = MobileBy.xpath("//android.widget.TextView[@text='ALERTA SIMPLES']");
	private static final By alertaRestritivo = MobileBy.xpath("//android.widget.TextView[@text='ALERTA RESTRITIVO']");
	private static final By alertaConfirm = MobileBy.xpath("//android.widget.TextView[@text='ALERTA CONFIRM']");
	
	private static final By botaoConfirmarAlerta = MobileBy.AccessibilityId("android:id/button2");
	private static final By botaoNegarNegar = MobileBy.AccessibilityId("android:id/button1");
}

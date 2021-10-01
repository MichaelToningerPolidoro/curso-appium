package br.com.michael.cursoappium.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();

	@AfterClass
	public static void finish() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
		generateScreenshot();
		DriverFactory.restartAPP();
	}

	private final void generateScreenshot() {
		System.out.println("Guardando print -> " + testName.getMethodName());
		final String fileName = testName.getMethodName();
		final String extension = "png";
		final String imagePath = "src/main/resources/images/" + fileName + "." + extension;
		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
		File imagem = ts.getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage bi = ImageIO.read(imagem);
			File newFile = new File(imagePath);
			ImageIO.write(bi, extension, newFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("PRINT SALVO!!! -> " + imagePath);
	}
}

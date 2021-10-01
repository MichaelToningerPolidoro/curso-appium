package br.com.michael.cursoappium.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
	
	private static final String BASE_PATH = "src/main/resources/images/";

	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void setup() {
		deleteScreenshots();
	}

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
		final String imagePath = BASE_PATH + fileName + "." + extension;
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
	
	private final void deleteScreenshots() {
		System.out.println("Deletando evidências do teste anterior");
		File directory = new File(BASE_PATH);
		File[] listedFiles = directory.listFiles();
		Arrays.stream(listedFiles).forEach(file -> {
			file.delete();
		});
		
		System.out.println("Tudo excluído com sucesso!");
	}
}

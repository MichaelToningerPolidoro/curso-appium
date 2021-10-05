package br.com.michael.cursoappium.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	private static final String SCREENSHOTS_BASE_PATH = "src/main/resources/images/";
	private static final String RECORDED_VIDEOS_BASE_PATH = "src/main/resources/images/";
	private static final String SCREENSHOTS_EXTENSION = "png";
	private static final String VIDEOS_EXTENSION = "mp4";

	@Rule
	public TestName testName = new TestName();

	@BeforeClass
	public static void initialSetup() {
		//deleteEvidence();
		DriverFactory.getDriver();
	}

	@Before
	public void setup() {
		//System.out.println("Iniciando gravação de tela");
		//DriverFactory.getDriver().startRecordingScreen();
	}

	@AfterClass
	public static void finish() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
		//saveRecordedVideo();
		//generateEndTestScreenshot();
		DriverFactory.restartAPP();
	}

	private final void generateEndTestScreenshot() {
		System.out.println("Guardando print -> " + testName.getMethodName());
		final String imagePath = getScreenshotCompletePath();
		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
		File imagem = ts.getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage bi = ImageIO.read(imagem);
			File newFile = new File(imagePath);
			ImageIO.write(bi, SCREENSHOTS_EXTENSION, newFile);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("PRINT SALVO!!! -> " + imagePath);
	}

	private static final void deleteEvidence() {
		System.out.println("Deletando evidências do teste anterior");
		File directory = new File(SCREENSHOTS_BASE_PATH);
		File[] listedFiles = directory.listFiles();
		Arrays.stream(listedFiles).forEach(file -> {
			file.delete();
		});

		System.out.println("Tudo excluído com sucesso!");
	}

	private final void saveRecordedVideo() {
		System.out.println("Salvando video ...");
		final String base64String = DriverFactory.getDriver().stopRecordingScreen();
		byte[] decodedBytes = Base64.getDecoder().decode(base64String);
		
		try {
			FileOutputStream fos = new FileOutputStream(new File(getVideosCompletePath()));
			fos.write(decodedBytes);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Video salvo com sucesso!!");
	}
	
	private final String getScreenshotCompletePath() {
		final String fileName = testName.getMethodName();
		return SCREENSHOTS_BASE_PATH + fileName + "." + SCREENSHOTS_EXTENSION;
	}
	
	private final String getVideosCompletePath() {
		final String fileName = testName.getMethodName();
		return RECORDED_VIDEOS_BASE_PATH + fileName + "." + VIDEOS_EXTENSION;
	}
	
	protected void esperar(int millisegundos) {
		try {
			Thread.sleep(millisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SiExHomePage;

public class SiExHomeTest {
	SiExHomePage paginaSiexHome;

	@BeforeClass
	public void beforeClass() throws FileNotFoundException, IOException {
		paginaSiexHome = new SiExHomePage(LoginTest.driver);
	}
	
	@Test
	public void isContenedorDisplayed() throws InterruptedException {
		paginaSiexHome.clickBtnOpcionesMenu();
		Thread.sleep(3000);
	}
}

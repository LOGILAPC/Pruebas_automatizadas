package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
@Listeners(general.ListenerLogiSiex.class)
public class HomeTest {
	HomePage paginaHome;
	
	@BeforeClass
	public void beforeClass() throws FileNotFoundException, IOException {
		paginaHome = new HomePage(LoginTest.driver);
	}
	@Test
	public void aplicacionLogiSiExCargada() throws Exception {
		Thread.sleep(4000);
		paginaHome.abrirAppPrueba();
		Thread.sleep(2500);
		Assert.assertTrue(isAppDisplayed());
	}

	public boolean isAppDisplayed() {
		//Agregar implementación
		return true;
	}

}

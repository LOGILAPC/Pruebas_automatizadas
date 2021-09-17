package test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CamposSistemaExternoPage;
import pages.CopiaTramasProcesoPage;
import pages.ProcesoExternoPage;

@Listeners(general.ListenerLogiSiex.class)
public class CopiaTramasProcesoTest {
	SoftAssert softAssert = new SoftAssert();
	ProcesoExternoPage paginaProcesoExterno;
	CamposSistemaExternoPage paginaCamposSistemaExterno;
	CopiaTramasProcesoPage paginaCopiaTramas;
	ProcesoExternoTest testProcesoExterno;
	CamposSistemaExternoTest testCamposSistemaExterno;
	SiExHomeTest testSiextHome;
	String procesoOrigen, procesoDestino;

	@BeforeClass
	public void beforeTestLogin() throws FileNotFoundException, IOException {
		paginaProcesoExterno = new ProcesoExternoPage(LoginTest.driver);
		paginaCopiaTramas = new CopiaTramasProcesoPage(LoginTest.driver);
		testSiextHome = new SiExHomeTest();
		testCamposSistemaExterno = new CamposSistemaExternoTest();
		testProcesoExterno= new ProcesoExternoTest();
	}

	@Test(priority = 1)
	public void copiarTramaProceso() throws InterruptedException, FileNotFoundException, IOException, SQLException {
		testCamposSistemaExterno.beforeTestLogin();
		//Crear Proceso Origen
		procesoOrigen = testCamposSistemaExterno.crearCampos();
		//Crear Proceso Destino
		testProcesoExterno.beforeTestLogin();
		testProcesoExterno.cerrarPestana();
		testSiextHome.beforeClass();
		testSiextHome.isContenedorDisplayed();
		procesoDestino = testProcesoExterno.crearProcesoExterno();
		testProcesoExterno.cerrarPestana();
		Thread.sleep(2000);
		testSiextHome.isContenedorDisplayed();
		Thread.sleep(2000);
		paginaCopiaTramas.abrirMenu();
		Thread.sleep(2000);
		//Cambiar de frame
		LoginTest.driver.switchTo().frame(0);
		paginaCopiaTramas.seleccionarSistemaExternoOrigen("LOGIFLOW");
		Thread.sleep(2000);
		paginaCopiaTramas.seleccionarProcesoOrigen(procesoOrigen);
		Thread.sleep(2000);
		paginaCopiaTramas.seleccionarSistemaExternoDestino("LOGIFLOW");
		Thread.sleep(2000);
		paginaCopiaTramas.clickChkProcesosDestinoSinTrama();
		Thread.sleep(2000);
		paginaCopiaTramas.seleccionarProcesoDestino(procesoDestino);
		paginaCopiaTramas.clickBtnCopiar();
		Thread.sleep(1000);
		paginaCopiaTramas.clickBtnAceptar();
		
	}
	
	@Test(priority=2)
	public void cerrarPestana() {
		LoginTest.driver.switchTo().defaultContent();
		paginaCopiaTramas.cerrarPestana();
	}
}

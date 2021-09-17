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

import pages.ProcesoExternoPage;

@Listeners(general.ListenerLogiSiex.class)
public class ProcesoExternoTest {
	WebDriver driver;
	String codigoProceso;
	SoftAssert softAssert = new SoftAssert();
	ProcesoExternoPage paginaProcesoExterno;


	@BeforeClass
	public void beforeTestLogin() throws FileNotFoundException, IOException, SQLException {
		paginaProcesoExterno = new ProcesoExternoPage(LoginTest.driver);
		codigoProceso=paginaProcesoExterno.generarCodigo5("SELECT * FROM SistemasExternos.PROCESOS_SISTEMAS_EXTERNOS WHERE CODIGO = ?");
	}
	
	@Test(priority=1)
	public String crearProcesoExterno() throws InterruptedException {
		paginaProcesoExterno.abrirMenuProcesosExternos();
		paginaProcesoExterno.CambiarFrame(0);
		paginaProcesoExterno.clickBtnCrear();
		paginaProcesoExterno.teclearCodigo(codigoProceso);
		paginaProcesoExterno.teclearDescripcion("PRUEBAS AUTOMATIZADAS");
		paginaProcesoExterno.seleccionarTipoReferencia("NIP");
		paginaProcesoExterno.seleccionarTipoProceso("WEB SERVICE");
		paginaProcesoExterno.seleccionarTipoTramaInput();
		Thread.sleep(500);
		paginaProcesoExterno.seleccionarTipoTramaOutput();
		paginaProcesoExterno.seleccionarPestanaConfigAvanzada();
		paginaProcesoExterno.teclearDireccion("http:\\datapowertest.com");
		paginaProcesoExterno.teclearSoapAction("ConsultarRiesgosIntervinientes");
		paginaProcesoExterno.clickBtnGuardar();
		Thread.sleep(1000);
		paginaProcesoExterno.clickBtnAceptarAlert();
		
		return codigoProceso;
	}
	@Test(priority=2)
	public void editarProcesoExterno() throws InterruptedException {
		paginaProcesoExterno.clickBtnFtrCodigo();
		Thread.sleep(1000);
		paginaProcesoExterno.teclearFiltro(codigoProceso);
		paginaProcesoExterno.aplicarFiltro();
		Thread.sleep(1000);
		paginaProcesoExterno.clickBtnEditar();
		Thread.sleep(1000);
		paginaProcesoExterno.teclearDescripcion("REGISTRO EDITADO");
		paginaProcesoExterno.seleccionarTipoReferencia("NIDoc");
		paginaProcesoExterno.seleccionarTipoProceso("GENERACION TRAMA XML ACTUALIZACION SOL. DINAMICA");
		Thread.sleep(1000);
		paginaProcesoExterno.seleccionarTipoTramaOutput();
		paginaProcesoExterno.clickBtnGuardarMod();
		Thread.sleep(1000);
		paginaProcesoExterno.clickBtnAceptarAlert();
	}
	@Test(priority=3)
	public void eliminarProcesoExterno() throws InterruptedException {
		paginaProcesoExterno.clickBtnEliminar();
		Thread.sleep(500);
		paginaProcesoExterno.clickBtnConfirmarEliminar();
	}
	@Test(priority=4)
	public void exportarProcesosExterno() {
		paginaProcesoExterno.clickBtnLimpiarFiltros();
		paginaProcesoExterno.clickBtnExportar();
		
	}
	@Test(priority=5)
	public void cerrarPestana() {
		paginaProcesoExterno.cerrarPestana();
	}
}

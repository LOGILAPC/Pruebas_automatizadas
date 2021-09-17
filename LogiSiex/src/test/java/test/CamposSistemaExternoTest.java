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
import pages.CamposSistemaExternoPage;

@Listeners(general.ListenerLogiSiex.class)
public class CamposSistemaExternoTest {

	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	ProcesoExternoPage paginaProcesoExterno;
	CamposSistemaExternoPage paginaCamposSisExt;
	ProcesoExternoTest testProcesoExterno;
	String codigoProceso;
	
	@BeforeClass
	public void beforeTestLogin() throws FileNotFoundException,IOException{
		paginaProcesoExterno = new ProcesoExternoPage(LoginTest.driver);
		paginaCamposSisExt = new CamposSistemaExternoPage(LoginTest.driver);
		testProcesoExterno= new ProcesoExternoTest();
	}
	
	@Test(priority=1)
	public String crearCampos() throws InterruptedException, FileNotFoundException, IOException, SQLException{
		//Crear proceso para parametrizar la trama
		testProcesoExterno.beforeTestLogin();
		codigoProceso = testProcesoExterno.crearProcesoExterno();
		//Ingresar a la gestión
		paginaProcesoExterno.clickBtnFtrCodigo();
		Thread.sleep(500);
		paginaProcesoExterno.teclearFiltro(codigoProceso);
		Thread.sleep(500);
		paginaProcesoExterno.aplicarFiltro();
		Thread.sleep(500);
		paginaProcesoExterno.clickFila1();
		paginaProcesoExterno.clickBtnTramas();
		//Seleccionar Criterios de selección
		Thread.sleep(500);
		paginaCamposSisExt.seleccionarSistemasExternos("LOGIFLOW");
		Thread.sleep(2500);
		paginaCamposSisExt.seleccionarTipoTrama("OUTPUT");
		paginaCamposSisExt.clickBtnCrear();
		//Creación campo padre
		Thread.sleep(4000);
		paginaCamposSisExt.teclearNombreCampo("PruebaPadre");
		paginaCamposSisExt.seleccionarDdlTipoCampo("GRUPO DE CAMPOS");
		Thread.sleep(500);
		paginaCamposSisExt.clickBtnGuardar();
		//Creación campo hijo
		Thread.sleep(2000);
		paginaCamposSisExt.clickUlNodoPadre();
		Thread.sleep(2500);
		paginaCamposSisExt.clickBtnCrear();
		Thread.sleep(4000);
		paginaCamposSisExt.teclearNombreCampo("PruebaHijo");
		paginaCamposSisExt.seleccionarTipoDato("STRING");
		Thread.sleep(1000);
		paginaCamposSisExt.teclearLongitudCampo("10");
		Thread.sleep(1000);
		paginaCamposSisExt.teclearOrden("1");
		Thread.sleep(1000);
		paginaCamposSisExt.clickDefinicionSql1();
		Thread.sleep(1000);
		paginaCamposSisExt.teclearSelect("1");
		paginaCamposSisExt.clickBtnGuardar();
		return codigoProceso;
	}
	@Test(priority=2)
	public void revisarCampos() throws InterruptedException {
		//Ver SQL del campo
		Thread.sleep(1000);
		paginaCamposSisExt.clickBtnDesplegar();
		Thread.sleep(1000);
		paginaCamposSisExt.clickUlNodoHijo();
		paginaCamposSisExt.clickBtnSql();
		Thread.sleep(500);
		paginaCamposSisExt.clickBtnCerrarSql();
		//Ver trama de ejemplo
		paginaCamposSisExt.clickBtnVerTramaEjemplo();
		Thread.sleep(500);
		paginaCamposSisExt.clickBtnCerrarTrama();
	}
	@Test(priority=3)
	public void editarCampos() throws InterruptedException {
		Thread.sleep(500);
		paginaCamposSisExt.clickUlNodoHijo();
		paginaCamposSisExt.clickBtnEditar();
		Thread.sleep(500);
		paginaCamposSisExt.teclearNombreCampo("campoEditado");
		paginaCamposSisExt.seleccionarCriterioAsignacionDefault("ASIGNAR SIEMPRE");
		Thread.sleep(500);
		paginaCamposSisExt.teclearValorDefault("probando");
		Thread.sleep(500);
		paginaCamposSisExt.clickBtnGuardar();
	}
	@Test(priority=4)
	public void eliminarCampos() throws InterruptedException {
		Thread.sleep(500);
		paginaCamposSisExt.clickUlNodoHijo();
		paginaCamposSisExt.clickBtnEliminar();
		Thread.sleep(1500);
		paginaCamposSisExt.clickBtnConfirmarEliminar();
		Thread.sleep(1500);
		paginaCamposSisExt.clickBtnAceptarAlert();
		paginaCamposSisExt.clickUlNodoPadre();
		paginaCamposSisExt.clickBtnEliminar();
		Thread.sleep(1500);
		paginaCamposSisExt.clickBtnConfirmarEliminar();
		Thread.sleep(1500);
		paginaCamposSisExt.clickBtnAceptarAlert();
		paginaCamposSisExt.clickLinkProcesosExternos();
		paginaProcesoExterno.clickBtnEliminar();
		Thread.sleep(500);
		paginaProcesoExterno.clickBtnConfirmarEliminar();
		driver.switchTo().defaultContent();
		paginaProcesoExterno.cerrarPestana();
	}
}

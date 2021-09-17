package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.FiltroPage;

@Listeners(general.ListenerLogiSiex.class)
public class FiltroTest {
	WebDriver driver;
	String codigoFiltro;
	SoftAssert softAssert = new SoftAssert();
	FiltroPage paginaFiltro;
	
	@BeforeClass
	public void beforeTestLogin() throws FileNotFoundException, IOException, SQLException {
		paginaFiltro = new FiltroPage(LoginTest.driver);
		codigoFiltro=paginaFiltro.generarCodigo5("SELECT * FROM SistemasExternos.FILTROS WHERE CODIGO = ?");
	}
	
	@Test(priority=1)
	public void crearFiltro() throws SQLException, InterruptedException {
		paginaFiltro.abrirMenuFiltro();
		paginaFiltro.CambiarFrame(0);
		Thread.sleep(1000);
		paginaFiltro.seleccionarAplicacion("LogiFlow");
		paginaFiltro.clickBtnCrear();
		Thread.sleep(1000);
		paginaFiltro.teclearCodigo(codigoFiltro);
		Thread.sleep(1000);
		paginaFiltro.teclearDescripcion("FILTRO PRUEBAS AUTOMATIZADAS");
		Thread.sleep(500);
		paginaFiltro.seleccionarTipoFiltro("INCLUSION");
		Thread.sleep(500);
		paginaFiltro.seleccionarDefinicionSql1();
		Thread.sleep(500);
		paginaFiltro.teclearTxaWhere("USR.LOGIN = 'PEPITO'");
		paginaFiltro.clickBtnGuardar();
		Thread.sleep(1000);
		paginaFiltro.clickBtnAceptarAlert();
		//Assert.assertTrue(paginaDefinicionSql.registroCorrecto());
	}
	
	@Test(priority=2)
	public void editarFiltro () throws InterruptedException {
		paginaFiltro.clickBtnFtrCodigo();
		Thread.sleep(500);
		paginaFiltro.aplicarFiltro(codigoFiltro);
		Thread.sleep(500);
		paginaFiltro.clickBtnEditar();
		Thread.sleep(1500);
		paginaFiltro.teclearDescripcion("FILTRO AUTOMATIZADO EDITADO PRUEBAS");
		Thread.sleep(500);
		paginaFiltro.seleccionarTipoFiltro("EXCLUSION");
		Thread.sleep(500);
		paginaFiltro.seleccionarDefinicionSql2();
		Thread.sleep(500);
		paginaFiltro.teclearTxaWhere("");
		paginaFiltro.clickBtnModificar();
		Thread.sleep(1000);
		paginaFiltro.clickBtnAceptarAlert();
	}
	
	@Test(priority=3)
	public void verSql() throws InterruptedException {
		paginaFiltro.clickBtnFtrCodigo();
		Thread.sleep(500);
		paginaFiltro.aplicarFiltro(codigoFiltro);
		Thread.sleep(500);
		paginaFiltro.clickFila1();
		paginaFiltro.clickBtnSql();
		Thread.sleep(1000);
		paginaFiltro.clickBtnCerrar();
	}
	
	@Test(priority=4)
	public void eliminarFiltro() throws InterruptedException {
		paginaFiltro.clickBtnFtrCodigo();
		Thread.sleep(500);
		paginaFiltro.aplicarFiltro(codigoFiltro);
		Thread.sleep(500);
		paginaFiltro.clickBtnEliminar();
		Thread.sleep(1000);
		paginaFiltro.clickBtnConfirmarEliminar();
		Thread.sleep(1500);
		paginaFiltro.clickBtnAceptarAlert();
	}
	@Test(priority=5)
	public void exportar() {
		paginaFiltro.clickBtnLimpiarFiltros();
		paginaFiltro.clickBtnExportar();
	}
	
	@Test(priority=6)
	public void cerrarPestana() {
		paginaFiltro.cerrarPestana();
	}
}

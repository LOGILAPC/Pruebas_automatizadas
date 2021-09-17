package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import general.Settings;

import org.apache.commons.lang3.RandomStringUtils;

import pages.DefinicionSqlPage;

@Listeners(general.ListenerLogiSiex.class)
public class DefinicionSqlTest {
	WebDriver driver;
	String codigoSql;
	SoftAssert softAssert = new SoftAssert();
	DefinicionSqlPage paginaDefinicionSql;
	
	@BeforeClass
	public void beforeTestLogin() throws FileNotFoundException, IOException, SQLException {
		paginaDefinicionSql = new DefinicionSqlPage(LoginTest.driver);
		codigoSql=paginaDefinicionSql.generarCodigo5("SELECT * FROM SistemasExternos.DEFINICIONES_SQL WHERE CODIGO_SQL = ?");
	}

	@Test(priority=1)
	public void crearDefinicionSql() throws SQLException, InterruptedException {
		paginaDefinicionSql.abrirMenuDefinicionSql();
		paginaDefinicionSql.CambiarFrame(0);
		paginaDefinicionSql.clickBtnCrear();
		paginaDefinicionSql.teclearCodigo(codigoSql);
		paginaDefinicionSql.teclearDescripcion("PRUEBAS AUTOMATIZADAS");
		paginaDefinicionSql.seleccionarSql("DINAMICO");
		paginaDefinicionSql.seleccionarCadenaConexion("InstanciaLogiFlow");
		Thread.sleep(500);
		paginaDefinicionSql.teclearTablaPrincipalSP("LOGIFLOW.DATOS_INSTANCIA_PROCESO");
		Thread.sleep(500);
		paginaDefinicionSql.seleccionarPestanaSqlDinamico();
		Thread.sleep(500);
		paginaDefinicionSql.teclearIdReferencia1("INP_NUMERO_INSTANCIA_PROCESO");
		paginaDefinicionSql.clickBtnGuardar();
		Thread.sleep(500);
		
		Thread.sleep(500);
		//Assert.assertTrue(paginaDefinicionSql.registroCorrecto());
	}

	@Test(priority=2)
	public void editarDefinicionSql() throws InterruptedException {
		paginaDefinicionSql.ingresarFtrCodigo(codigoSql);
		Thread.sleep(4000);
		paginaDefinicionSql.clickBtnEditar();
		Thread.sleep(4000);
		//Verificar que solo el campo de código esté deshabilitado
		softAssert.assertTrue(paginaDefinicionSql.registrosHabilitadosCorrectamente(),"Botones habilitados/deshabilitados correctamente");
		//Cambia los datos de los campos habilitados
		paginaDefinicionSql.seleccionarPestanaDefinicionSql();
		paginaDefinicionSql.teclearDescripcion("EDITANDO EL REGISTRO"); 
		Thread.sleep(2500);
		paginaDefinicionSql.seleccionarSql("SP");
		paginaDefinicionSql.seleccionarCadenaConexion("SiEx");
		Thread.sleep(2500);
		paginaDefinicionSql.teclearTablaPrincipalSP("LOGIFLOW.INSTANCIA_PROCESO");
		paginaDefinicionSql.seleccionarPestanaSqlDinamico();
		paginaDefinicionSql.teclearIdReferencia1("NUMERO_INSTANCIA_PROCESO");
		paginaDefinicionSql.clickBtnModificar();
		Thread.sleep(2500);
		//softAssert.assertTrue(paginaDefinicionSql.registroCorrecto());
	}
	
	@Test(priority=3)
	public void eliminarDefinicionSql() throws InterruptedException {
		paginaDefinicionSql.ingresarFtrCodigo(codigoSql);
		paginaDefinicionSql.clickBtnEliminar(); 
		Thread.sleep(1500);
		paginaDefinicionSql.clickBtnConfirmarEliminar();
	}
}

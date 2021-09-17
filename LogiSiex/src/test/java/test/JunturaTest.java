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
import pages.DefinicionSqlPage;
import pages.JunturaPage;

@Listeners(general.ListenerLogiSiex.class)
public class JunturaTest {
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();
	JunturaPage paginaJuntura;
	DefinicionSqlPage paginaDefinicionSql;
	DefinicionSqlTest testDefinicionSql;
	
	@BeforeClass
	public void beforeTestLogin() throws FileNotFoundException, IOException {
		paginaJuntura = new JunturaPage(LoginTest.driver);
		paginaDefinicionSql=new DefinicionSqlPage(LoginTest.driver);
		testDefinicionSql = new DefinicionSqlTest();
	}
	
	@Test(priority=1)
	public void asignarJuntura() throws InterruptedException, SQLException, FileNotFoundException, IOException {
		testDefinicionSql.beforeTestLogin();
		testDefinicionSql.crearDefinicionSql();
		paginaDefinicionSql.ingresarFtrDescripcion("PRUEBAS AUTOMATIZADAS");
		Thread.sleep(2000);
		paginaDefinicionSql.clickFila1();
		paginaDefinicionSql.clickBtnMasOpciones();
		Thread.sleep(2000);
		paginaDefinicionSql.clickBtnJunturas();
		paginaJuntura.clickBtnAsignar();
		paginaJuntura.teclearTxtTablaJuntura("SEGURIDADES.USUARIOS USR");
		paginaJuntura.seleccionarCondicionJuntura("LEFT JOIN");
		paginaJuntura.teclearTxaCondicionesJuntura("USR.LOGIN = PEPITO");
		paginaJuntura.clickBtnGuardar();
		Thread.sleep(2000);
		paginaJuntura.clickBtnAceptarAlert();
	}
	
	@Test(priority=2)
	public void editarJuntura() throws InterruptedException, SQLException, FileNotFoundException, IOException {
		paginaJuntura.clickBtnEditarFila1();
		Thread.sleep(2000);
		paginaJuntura.teclearTxtTablaJuntura("SISTEMASEXTERNOS.PROCESOS_SISTEMAS_EXTERNOS P");
		paginaJuntura.seleccionarCondicionJuntura("INNER JOIN");
		paginaJuntura.teclearTxaCondicionesJuntura("P.CODIGO = 'PRUEB'");
		paginaJuntura.clickBtnGuardarEdicion();
		Thread.sleep(2000);
		paginaJuntura.clickBtnAceptarAlert();
		paginaJuntura.clickBtnDefinicionesSQL();
	}
	
	@Test(priority=3)
	public void verSQL() throws InterruptedException, SQLException, FileNotFoundException, IOException {
		paginaDefinicionSql.clickFila1();
		paginaDefinicionSql.clickBtnMasOpciones();
		Thread.sleep(2000);
		paginaDefinicionSql.clickBtnSql();
		paginaDefinicionSql.clickBtnCerrar();
	}
	@Test(priority=4)
	public void desasignarJuntura() throws InterruptedException, SQLException, FileNotFoundException, IOException {
		paginaDefinicionSql.clickFila1();
		paginaDefinicionSql.clickBtnMasOpciones();
		Thread.sleep(2000);
		paginaDefinicionSql.clickBtnJunturas();
		paginaJuntura.clickBtnDesasignarFila1();
		Thread.sleep(2000);
		paginaJuntura.clickBtnConfirmarEliminar();
		Thread.sleep(2000);
		paginaJuntura.clickBtnAceptarAlert();
		paginaJuntura.clickBtnDefinicionesSQL();
		paginaDefinicionSql.clickBtnEliminar();
		Thread.sleep(2000);
		paginaDefinicionSql.clickBtnConfirmarEliminar();
		paginaDefinicionSql.cerrarPestana();
	}

	
}

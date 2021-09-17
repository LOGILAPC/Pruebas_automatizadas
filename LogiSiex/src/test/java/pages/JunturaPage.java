package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.LoginTest;
import test.TestBase;

public class JunturaPage extends TestBase{
	public JunturaPage(WebDriver driver) throws FileNotFoundException,IOException{
		super(driver);
	}
	
	//Barra de menú
	private By btnAsignar = By.xpath("//body/form[@id='ctl01']/div[4]/div[5]/div[2]/div[1]/div[1]/ul[1]/li[1]/span[1]");
	private By btnLimpiarFiltros = By.xpath("//body/form[@id='ctl01']/div[4]/div[5]/div[2]/div[1]/div[1]/ul[1]/li[4]/span[1]");
	private By btnDefinicionesSQL = By.cssSelector("#ctl01 > div.view.overflow-hidden > div.view--sheet > div.view__header.d-flex.align-items-center > div.header__title.flex-grow-1 > nav > ol > li:nth-child(1) > button");
	private By btnDesasignarFila1 = By.id("ctl00_MainContent_dgdJunturas_ctl00_ctl04_btnEliminar");
	
	//Formulario creación/edición
	private By txtSecuencia = By.id("ctl00_MainContent_winAcciones_C_txtSecuencia");
	private By txtTablaJuntura = By.id("ctl00_MainContent_winAcciones_C_txtTablaJuntura"); 
	private By ddlCriterioJuntura = By.id("ctl00_MainContent_winAcciones_C_dwlCriteriosJuntura_Input");
	private By elementosCriterioJuntura = By.xpath("//body/form[@id='ctl01']/div[1]/div[1]/div[1]/ul[1]/li");
	private By txaCondicionesJuntura = By.id("ctl00_MainContent_winAcciones_C_txtComandoWhere");
	private By btnCancelar = By.id("ctl00_MainContent_winAcciones_C_btnCancelar");
	private By btnGuardar = By.id("ctl00_MainContent_winAcciones_C_btnIngresar");
	private By btnGuardarEdicion = By.id("ctl00_MainContent_winAcciones_C_btnModificar_input");
	private By btnAceptar = By.id("btnAceptarAlert");
	
	//Fila editar
	private By btnEditarFila1 = By.id("ctl00_MainContent_dgdJunturas_ctl00_ctl04_btnEditar");
		
	public void clickBtnAsignar() {
		this.click(btnAsignar);
	}
	
	public void teclearTxtTablaJuntura(String tabla) {
		this.LimpiarTexto(txtTablaJuntura);
		this.teclear(tabla, txtTablaJuntura);
	}
	
	public void seleccionarCondicionJuntura(String condJuntura) throws InterruptedException {
		this.seleccionarValorDDL(ddlCriterioJuntura, elementosCriterioJuntura, condJuntura);
	}
	
	public void teclearTxaCondicionesJuntura(String condJuntura) {
		this.LimpiarTexto(txaCondicionesJuntura);
		this.teclear(condJuntura, txaCondicionesJuntura);
	}
	
	public void clickBtnCancelar() {
		this.click(btnCancelar);
	}
	
	public void clickBtnGuardar() {
		this.click(btnGuardar);
	}
	
	public boolean registroCorrecto() {
		return this.isRegistroCorrecto(alert, btnAceptar);
	}
	
	public void clickBtnAceptarAlert() {
		this.click(btnAceptarAlert);
	}

	public void clickBtnEditarFila1() {
		this.click(btnEditarFila1);
	}
	
	public void clickBtnDefinicionesSQL(){
		this.click(btnDefinicionesSQL);
	}
	
	public void clickBtnGuardarEdicion() {
		this.click(btnGuardarEdicion);
	}
	
	public void clickBtnDesasignarFila1() {
		this.click(btnDesasignarFila1);
	}
}

package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.LoginTest;
import test.TestBase;

public class DefinicionSqlPage extends TestBase {

	public DefinicionSqlPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
		//wait = new WebDriverWait(driver,10);
	}
	
	//Barra de menú
	private By mnuDefinicionSql = By.xpath("//a[contains(@href,'DefinicionSqls')]");
	private By btnCrear = By.xpath("//div[@id='ctl00_MainContent_rtbToolbar']/ul/li/span/span[2]");
	private By btnMasOpciones = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[4]/span[1]");
	private By btnLimpiarFiltros = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[5]/span");
	private By btnExportar = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[6]/span");
	private By btnSql = By.xpath("//*[@id=\"ctl01\"]/div[1]/div/ul/li[1]/span");
	private By btnJunturas = By.xpath("//*[@id=\"ctl01\"]/div[1]/div/ul/li[2]/span");
	//Pestañas
	private By liDefinicionSql = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rtsTabSql\"]/div/ul/li[1]");
	private By liSqlDinamico = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rtsTabSql\"]/div/ul/li[2]");
	//Elementos crear/editar
	//Pestaña 1
	private By txtCodigoSql = By.id("ctl00_MainContent_winAcciones_C_txtCodigoSql");
	private By txaDescripcion = By.id("ctl00_MainContent_winAcciones_C_txtDescripcion");
	private By ddlTipoSql = By.id("ctl00_MainContent_winAcciones_C_dwlTiposSql_Input");
	private By elementosDdlTipoSql = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlTiposSql_DropDown\"]/div/ul/li");
	private By ddlCadenaConexion = By.id("ctl00_MainContent_winAcciones_C_dwlCadenasConexion_Input");
	private By elementosDdlCadenaConexion = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlCadenasConexion_DropDown\"]/div/ul/li");
	private By txaTablaPrincipalSP = By.id("ctl00_MainContent_winAcciones_C_txtTablaPrincipal");
	//Pestaña 2
	private By txtReferencia1 = By.id("ctl00_MainContent_winAcciones_C_txtIdCampoNumReferencia1");
	private By txtReferencia2 = By.id("ctl00_MainContent_winAcciones_C_txtIdCampoNumReferencia2");
	private By txtReferencia3 = By.id("ctl00_MainContent_winAcciones_C_txtIdCampoNumReferencia3");
	private By txtCodigoAplicacion = By.id("ctl00_MainContent_winAcciones_C_txtIdCampoCodAplicacion");
	private By txtCodigoProducto = By.id("ctl00_MainContent_winAcciones_C_txtIdCampoCodProducto");
	private By txaWhere = By.id("ctl00_MainContent_winAcciones_C_txtWhere_ClientState");
	
	private By btnGuardar = By.id("ctl00_MainContent_winAcciones_C_btnIngresar");
	private By btnModificar = By.id("ctl00_MainContent_winAcciones_C_btnModificar_input");
	private By btnCancelar = By.id("ctl00_MainContent_winAcciones_C_btnCancelar_input");
	private By btnCerrarSql = By.id("ctl00_MainContent_winSql_C_btnAceptarSql");
	
	private By alert = By.xpath("//div[@id='tablaAlert']/div/div");
	//Elementos editar y eliminar
	private By cellElimEditar = By.xpath("//*[@id=\"ctl00_MainContent_dgdSqls_ctl00__0\"]/td[3]"); //Lee la 3ra columna de la primera fila;
	//Filtros
	private By btnFtrCodigo = By.cssSelector("#ctl00_MainContent_dgdSqls_ctl00_Header > thead > tr > th:nth-child(4) > button");
	private By txtFtrCodigo = By.id("ctl00_MainContent_dgdSqls_rghcMenu_i6_HCFMRTBFirstCond");
	private By btnFtrDescripcion = By.xpath("//thead/tr[1]/th[5]/button[1]");
	private By txtFtrDescripcion = By.id("ctl00_MainContent_dgdSqls_rghcMenu_i6_HCFMRTBFirstCond");
	private By btnAplicar = By.id("ctl00_MainContent_dgdSqls_rghcMenu_i6_HCFMFilterButton");
	//Seleccionando la primera fila de los resultados filtrados
	private By filaDefinicionSql=By.id("ctl00_MainContent_dgdSqls_ctl00__0");

	//Boton Cerrar Pestaña
	private By btnCerrarPestana = By.xpath("//button[@id='btnCloseLSXM0101']");
	
	public void abrirMenuDefinicionSql () {
		this.click(mnuDefinicionSql);
	}
	/* Barra de menús */
	public void clickBtnCrear() {
		this.click(btnCrear);
	}
	
	public void clickBtnMasOpciones() {
		this.click(btnMasOpciones);
	}
	
	public void clickBtnLimpiarFiltros() {
		this.click(btnLimpiarFiltros);
	}
	
	public void clickBtnExportar() {
		this.click(btnExportar);
	}
	
	public void clickBtnSql() {
		this.click(btnSql);
	}
	
	public void clickBtnJunturas() {
		this.click(btnJunturas);
	}
	
	/* Formulario de creación/edición */
	public void seleccionarPestanaDefinicionSql() {
		this.click(liDefinicionSql);
	}
	public void teclearCodigo(String codigo) {
		this.LimpiarTexto(txtCodigoSql);
		this.teclear(codigo, txtCodigoSql);
	}
	
	public void teclearDescripcion(String descripcion) {
		this.LimpiarTexto(txaDescripcion);
		this.teclear(descripcion, txaDescripcion);
	}
	
	public void seleccionarSql(String valor) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipoSql,elementosDdlTipoSql, valor);
	}
	
	public void seleccionarCadenaConexion(String valor) throws InterruptedException {
		this.seleccionarValorDDL(ddlCadenaConexion,elementosDdlCadenaConexion, valor);
	}
	
	public void teclearTablaPrincipalSP(String tablaPrincipalSP) {
		this.LimpiarTexto(txaTablaPrincipalSP);
		this.teclear(tablaPrincipalSP, txaTablaPrincipalSP);
	}
	
	public void seleccionarPestanaSqlDinamico() {
		this.click(liSqlDinamico);
	}
	
	public void teclearIdReferencia1(String referencia1) {
		this.LimpiarTexto(txtReferencia1);
		this.teclear(referencia1, txtReferencia1);
	}
	
	public void teclearIdReferencia2(String referencia2) {
		this.LimpiarTexto(txtReferencia2);
		this.teclear(referencia2, txtReferencia2);
	}
	
	public void teclearIdReferencia3(String referencia3) {
		this.LimpiarTexto(txtReferencia3);
		this.teclear(referencia3, txtReferencia3);
	}
	
	public void teclearCodigoAplicacion(String codAplicacion) {
		this.LimpiarTexto(txtCodigoAplicacion);
		this.teclear(codAplicacion, txtCodigoAplicacion);
	}
	
	public void teclearCodigoProducto (String codProducto) {
		this.LimpiarTexto(txtCodigoProducto);
		this.teclear(codProducto, txtCodigoProducto);
	}
	
	public void teclearWhere (String where) {
		this.LimpiarTexto(txaWhere);
		this.teclear(where, txaWhere);
	}
	
	public void clickBtnGuardar() {
		this.click(btnGuardar);
	}
	
	public void clickBtnModificar() {
		this.click(btnModificar);
	}
	
	//Filtros
	public void clickBtnFtrCodigo() {
		this.click(btnFtrCodigo);
	}
	
	public void teclearTxtFtrCodigo(String filtroCodigo) {
		this.LimpiarTexto(txtFtrCodigo);
		this.teclear(filtroCodigo, txtFtrCodigo);
	}
	
	public void clickBtnFtrDescripcion() {
		this.click(btnFtrDescripcion);
	}
	
	public void teclearTxtFtrDescripcion(String filtroDescripcion) {
		this.LimpiarTexto(txtFtrCodigo);
		this.teclear(filtroDescripcion, txtFtrCodigo);
	}
	
	public void clickBtnAplicarFiltro() {
		this.click(btnAplicar);
	}
	
	public void ingresarFtrCodigo(String texto) throws InterruptedException {
		this.clickBtnFtrCodigo();
		Thread.sleep(500);
		this.teclearTxtFtrCodigo(texto);
		this.clickBtnAplicarFiltro();
	}
	
	public void ingresarFtrDescripcion(String texto) throws InterruptedException {
		this.clickBtnFtrDescripcion();
		Thread.sleep(500);
		this.teclearTxtFtrDescripcion(texto);
		this.clickBtnAplicarFiltro();
	}
			
	public void clickFila1() {
		this.click(filaDefinicionSql);
	}
	
	public void clickBtnCerrar() {
		this.click(btnCerrarSql);
	}
	
	public void cerrarPestana() {
		this.cerrarPestana(btnCerrarPestana);
	}
	
	public boolean registrosHabilitadosCorrectamente() throws InterruptedException {
		boolean pestana1= !this.estaHabilitado(txtCodigoSql) && this.estaHabilitado(txaDescripcion)
							&& this.estaHabilitado(ddlTipoSql) && this.estaHabilitado(ddlCadenaConexion)
							&& this.estaHabilitado(txaTablaPrincipalSP);
		Thread.sleep(2500);
		seleccionarPestanaSqlDinamico();
		boolean pestana2= this.estaHabilitado(txtReferencia1) && this.estaHabilitado(txtReferencia2)
				&& this.estaHabilitado(txtReferencia3) && this.estaHabilitado(txtCodigoAplicacion)
				&& this.estaHabilitado(txtCodigoProducto)&& this.estaHabilitado(txaWhere);
		
		return pestana1 && pestana2;	
	}
}

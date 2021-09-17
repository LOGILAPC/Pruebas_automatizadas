package pages;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.TestBase;

public class ProcesoExternoPage extends TestBase{
	public ProcesoExternoPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}
	
	//Barra de menú
	private By mnuProcesoExterno = By.xpath("//a[contains(@href,'ProcesosSistemasExternos')]");
	private By btnCrear = By.xpath("//div[@id='ctl00_MainContent_rtbToolbar']/ul/li/span/span[2]"); //*[@id="ctl00_MainContent_rtbToolbar"]/ul/li[1]/span
	private By btnTramas = By.xpath("//div[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[4]/span");
	private By btnLimpiarFiltros = By.xpath("//div[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[5]/span");
	private By btnExportar = By.xpath("//div[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[6]/span");
	
	//Pestañas
	private By liInformacionGeneral = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rtsTabProceso\"]/div/ul/li[1]/span");
	private By liConfiguracionAvanzada = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rtsTabProceso\"]/div/ul/li[2]/span");
	
	//Formulario creación/edición
	//Pestaña 1
	private By txtCodigo=By.id("ctl00_MainContent_winAcciones_C_txtCodigo");
	private By txaDescripcion = By.id("ctl00_MainContent_winAcciones_C_txtDescripcion");
	private By ddlTipoReferencia = By.id("ctl00_MainContent_winAcciones_C_dwlTiposReferencia_Input");
	private By elementosDdlTipoReferencia = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlTiposReferencia_DropDown\"]/div/ul/li");
	private By ddlTipoProceso = By.id("ctl00_MainContent_winAcciones_C_dwlTiposProceso_Input");
	private By elementosDdlTipoProceso = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlTiposProceso_DropDown\"]/div/ul/li");
	private By ddlTiposTrama = By.id("ctl00_MainContent_winAcciones_C_rcbTiposTrama_Input");
	private By chkTipoTraInput = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rcbTiposTrama_DropDown\"]/div/ul/li[1]/label/input");
	private By chkTipoTraOutput = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rcbTiposTrama_DropDown\"]/div/ul/li[2]/label/input");
	//Pestaña 2
	private By txaDireccion = By.id("ctl00_MainContent_winAcciones_C_txtDireccionWs");
	private By txaSoapAction = By.id("ctl00_MainContent_winAcciones_C_txtNombreMetodo");
	private By txtProgramaInterfaz = By.id("ctl00_MainContent_winAcciones_C_txtProgramaInterfaz");
	private By txtRequestTimeout = By.id("ctl00_MainContent_winAcciones_C_txtSoapRequestTimeout");
	private By chkRequiereEncriptacion = By.id("ctl00_MainContent_winAcciones_C_chkRequiereEncriptacion");
	private By ddlAlgoritmoEncriptacion = By.id("ctl00_MainContent_winAcciones_C_dwlAlgoritmosEncriptacion_Input");
	private By elementosDdlAlgEncriptacion = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlAlgoritmosEncriptacion_DropDown\"]/div/ul/li");
	private By ddlParametrosEncriptacion = By.id("ctl00_MainContent_winAcciones_C_dwlParametrosEncriptacion_Input");
	private By elementosDdlParEncriptacion = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlParametrosEncriptacion_DropDown\"]/div/ul/li");
	private By btnCancelar = By.id("ctl00_MainContent_winAcciones_C_btnCancelar");
	private By btnGuardar = By.id("ctl00_MainContent_winAcciones_C_btnIngresar_input");
	private By btnModificar = By.id("ctl00_MainContent_winAcciones_C_btnModificar_input");
	
	//Filtros
	private By ftrCodigo = By.xpath("//*[@id=\"ctl00_MainContent_dgdProcesos_ctl00_Header\"]/thead/tr/th[4]/button");
	private By ftrDescripcion = By.xpath("//*[@id=\"ctl00_MainContent_dgdProcesos_ctl00_Header\"]/thead/tr/th[5]/button");
	private By txtFiltro= By.id("ctl00_MainContent_dgdProcesos_rghcMenu_i6_HCFMRTBFirstCond");
	private By btnFtrAplicar = By.id("ctl00_MainContent_dgdProcesos_rghcMenu_i6_HCFMFilterButton");
	private By btnFtrLimpiar = By.id("ctl00_MainContent_dgdProcesos_rghcMenu_i6_HCFMClearFilterButton");
	
	//Opciones en el registro
	private By btnEditar = By.cssSelector("span[id*='btnEditar']");
	private By btnEliminar = By.cssSelector("span[id*='btnEliminar']");
	
	private By filaProcesoExterno=By.id("ctl00_MainContent_dgdProcesos_ctl00__0");
	
	private By btnClose= By.id("btnCloseLSXM0102");
	
	public void abrirMenuProcesosExternos() {
		this.click(mnuProcesoExterno);
	}
	
	public void clickBtnCrear() {
		this.click(btnCrear);
	}
	
	public void clickBtnTramas() {
		this.click(btnTramas);
	}
	
	public void seleccionarPestanaInforGeneral() {
		this.click(liInformacionGeneral);
	}
	
	public void seleccionarPestanaConfigAvanzada() {
		this.click(liConfiguracionAvanzada);
	}
	
	public void teclearCodigo(String codigo) {
		this.LimpiarTexto(txtCodigo);
		this.teclear(codigo,txtCodigo);
	}
	
	public void teclearDescripcion(String descripcion) {
		this.LimpiarTexto(txaDescripcion);
		this.teclear(descripcion,txaDescripcion);
	}
	
	public void seleccionarTipoReferencia(String tipoReferencia) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipoReferencia, elementosDdlTipoReferencia, tipoReferencia);
	}
	
	public void seleccionarTipoProceso(String tipoProceso) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipoProceso, elementosDdlTipoProceso, tipoProceso);
	}
	
	public void seleccionarTipoTramaInput() throws InterruptedException {
		this.click(ddlTiposTrama);
		Thread.sleep(1000);
		this.click(chkTipoTraInput);
	}
	
	public void seleccionarTipoTramaOutput() throws InterruptedException {
		this.click(ddlTiposTrama);
		Thread.sleep(1000);
		this.click(chkTipoTraOutput);
	}
	
	public void teclearDireccion(String direccion) {
		this.LimpiarTexto(txaDireccion);
		this.teclear(direccion, txaDireccion);
	}
	
	public void teclearSoapAction(String soapAction) {
		this.LimpiarTexto(txaSoapAction);
		this.teclear(soapAction, txaSoapAction);
	}
	
	public void teclearProgramaInterfaz(String programaInterfaz) {
		this.LimpiarTexto(txtProgramaInterfaz);
		this.teclear(programaInterfaz, txtProgramaInterfaz);
	}
	
	public void teclearRequestTimeOut(String timeout) {
		this.LimpiarTexto(txtRequestTimeout);
		this.teclear(timeout, txtRequestTimeout);
	}
	
	public void clickChkRequiereEncriptacion() {
		this.click(chkRequiereEncriptacion);
	}
	
	public void seleccionarAlgoritmoEncriptacion(String algoritmo) throws InterruptedException {
		this.seleccionarValorDDL(ddlAlgoritmoEncriptacion,elementosDdlAlgEncriptacion,algoritmo);
	}
	
	public void seleccionarParametrosEncriptacion(String parametro) throws InterruptedException {
		this.seleccionarValorDDL(ddlParametrosEncriptacion,elementosDdlParEncriptacion,parametro);
	}
	
	public void clickBtnGuardar() {
		this.click(btnGuardar);
	}
	
	public void clickBtnFtrCodigo() {
		this.click(ftrCodigo);
	}
	
	public void teclearFiltro(String filtro) {
		this.LimpiarTexto(txtFiltro);
		this.teclear(filtro, txtFiltro);
	}
	
	public void clickBtnFtrDescripcion() {
		this.click(ftrDescripcion);
	}
	
	public void aplicarFiltro() {
		this.click(btnFtrAplicar);
	}
	
	public void clickBtnEditar() {
		this.click(btnEditar);
	}
	
	public void clickBtnGuardarMod() {
		this.click(btnModificar);
	}
	
	public void clickBtnEliminar() {
		this.click(btnEliminar);
	}
	
	public void clickBtnLimpiarFiltros() {
		this.click(btnLimpiarFiltros);
	}
	
	public void clickFila1() {
		this.click(filaProcesoExterno);
	}
	
	public void clickBtnExportar() {
		this.click(btnExportar);
	}
	
	public void cerrarPestana() {
		this.cerrarPestana(btnClose);
	}
}

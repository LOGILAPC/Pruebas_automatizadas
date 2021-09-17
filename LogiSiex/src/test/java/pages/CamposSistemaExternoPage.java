package pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import test.LoginTest;
import test.TestBase;

public class CamposSistemaExternoPage extends TestBase{
	public CamposSistemaExternoPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}

	//Barra de menú
	private By btnCrear = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[1]/span");
	private By btnEditar = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[2]/span");
	private By btnEliminar = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[3]/span");
	private By btnSql = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[4]/span");
	private By btnVerTramaEjemplo = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[5]/span");
	
	//Criterios de selección
	private By ddlSistemasExternos = By.id("ctl00_MainContent_dwlSistemasExternos_Input");
	private By elementosSistemasExternos = By.xpath("//*[@id=\"ctl00_MainContent_dwlSistemasExternos_DropDown\"]/div/ul/li");
	private By ddlTipoTrama = By.id("ctl00_MainContent_dwlTiposGrupo");
	private By elementosTipoTrama = By.xpath("//*[@id=\"ctl00_MainContent_dwlTiposGrupo_DropDown\"]/div/ul/li");
	
	//Sección crear/editar
	private By txtCampoPadre = By.id("ctl00_MainContent_txtCampoPadre");
	private By txtSecuenciaPadre = By.id("ctl00_MainContent_txtSecCampoPadre");
	private By txtSecuencia = By.id("ctl00_MainContent_txtSecuencia");
	private By ddlCamposEstandar = By.id("ctl00_MainContent_dwlNombresCampos_Input");
	private By elementosCamposEstandar = By.xpath("//*[@id=\"ctl00_MainContent_dwlNombresCampos_DropDown\"]/div/ul/li");
	private By txtNombreCampo = By.id("ctl00_MainContent_txtNombreCampo");
	private By ddlTipoCampo = By.id("ctl00_MainContent_dwlTiposCampo_Input");
	private By elementosTipoCampo = By.xpath("//*[@id=\"ctl00_MainContent_dwlTiposCampo_DropDown\"]/div/ul/li");
	private By txaAtributos = By.id("ctl00_MainContent_txtAtributos");
	private By ddlTipoDato = By.id("ctl00_MainContent_dwlTiposDato_Input");
	private By elementosTipoDato = By.xpath("//*[@id=\"ctl00_MainContent_dwlTiposDato_DropDown\"]/div/ul/li");
	private By ddlFormato = By.id("ctl00_MainContent_dwlFormatosTipoDato_Input");
	private By elementosFormato = By.xpath("//*[@id=\"ctl00_MainContent_dwlFormatosTipoDato_DropDown\"]/div/ul/li");
	private By txtLongitudCampo = By.id("ctl00_MainContent_txtLongitud");
	private By txtPosicionesDecimales = By.id("ctl00_MainContent_txtPrecision");
	private By txtOrden = By.id("ctl00_MainContent_txtOrden");
	private By chkAlmacenarValor= By.id("MainContent_chkAlmacenarValor");
	//private By ddlDefinicionSql = By.id("ctl00_MainContent_rcbDefinicionesSql_Input");
	private By ddlDefinicionSql = By.xpath("//*[@id=\"ctl00_MainContent_rcbDefinicionesSql\"]/span");
	private By elemento1DefinicionSql = By.xpath("//*[@id=\"ctl00_MainContent_rcbDefinicionesSql_DropDown\"]/div/ul/li[2]");
	private By ddlCriterioAsignacionDefault = By.id("ctl00_MainContent_dwlCriteriosAsigDefault_Input");
	private By elementosCriterioAsignacion = By.xpath("//*[@id=\"ctl00_MainContent_dwlCriteriosAsigDefault_DropDown\"]/div/ul/li");
	private By txaValorDefault = By.id("ctl00_MainContent_txtValorDefault");
	private By txaSelect = By.id("ctl00_MainContent_txtSelect");
	private By ddlOcurMaximaAccion = By.id("ctl00_MainContent_dwlAccionesOcurrenciaMax_Input");
	private By elementosOcurMaximaAccion= By.xpath("//*[@id=\"ctl00_MainContent_dwlAccionesOcurrenciaMax_DropDown\"]/div/ul/li");
	private By txtOcurMaxima = By.id("ctl00_MainContent_txtNumOcurrenciasMax");
	private By ddlOcurMinimaAccion = By.id("ctl00_MainContent_dwlAccionesOcurrenciaMin_Input");
	private By elementosOcurMinimaAccion = By.xpath("//*[@id=\"ctl00_MainContent_dwlAccionesOcurrenciaMin_DropDown\"]/div/ul/li");
	private By txtOcurMinima=By.id("ctl00_MainContent_txtNumOcurrenciasMin");
	private By chkCodificarCaracteres= By.id("MainContent_chkCodificarValor");
	private By chkIncluirCData = By.id("MainContent_chkIncluirCData");
	private By btnAceptarAlert = By.id("btnAceptarAlert");
	private By btnCancelar = By.id("ctl00_MainContent_btnCancelarGrabar");
	private By btnGuardar = By.id("ctl00_MainContent_btnGrabar");
	//private By btnCerrarTrama = By.id("ctl00_MainContent_winTrama_C_btnCancelarTramaEjemplo_input");
	private By btnCerrarTrama = By.xpath("//*[@id=\"ctl00_MainContent_winTrama_C_btnCancelarTramaEjemplo_input\"]");
	private By btnCerrarSql = By.id("ctl00_MainContent_winSql_C_btnCancelar_input");
	private By ulNodoPadre = By.xpath("//*[@id=\"ctl00_MainContent_tvwArbolJerarquico\"]/ul/li/ul"); 
	private By ulNodoHijo = By.xpath("//*[@id=\"ctl00_MainContent_tvwArbolJerarquico\"]/ul/li/ul/li/ul/li/div/div");
	private By linkProcesosExternos = By.xpath("//*[@id=\"ctl01\"]/div[5]/div[5]/div[1]/div[2]/nav/ol/li[1]/button");
	private By btnDesplegarNodoPadre = By.xpath("//*[@id=\"ctl00_MainContent_tvwArbolJerarquico\"]/ul/li/ul/li/div/span");
	
	public void clickLinkProcesosExternos() {
		this.click(linkProcesosExternos);
	}
	
	public void seleccionarSistemasExternos(String elSisExt) throws InterruptedException {
		this.seleccionarValorDDL(ddlSistemasExternos, elementosSistemasExternos, elSisExt);
	}
	
	public void seleccionarTipoTrama(String tipoTrama) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipoTrama, elementosTipoTrama, tipoTrama);
	}
	
	public void clickUlNodoPadre() {
		this.click(ulNodoPadre);
	}
	
	public void clickUlNodoHijo() {
		this.click(ulNodoHijo);
	}
	
	public void clickBtnEditar() {
		this.click(btnEditar);
	}
	
	public void clickBtnEliminar() {
		this.click(btnEliminar);
	}
	
	public void clickBtnSql() {
		this.click(btnSql);
	}
	
	public void clickBtnAceptarAlert() {
		this.click(btnAceptarAlert);
	}
	
	public void clickBtnCerrarTrama() {
		this.click(btnCerrarTrama);
	}
	
	public void clickBtnCerrarSql() {
		this.click(btnCerrarSql);
	}
	
	public void clickBtnVerTramaEjemplo() {
		this.click(btnVerTramaEjemplo);
	}
	
	public void clickBtnCrear() {
		this.click(btnCrear);
	}
	
	public void clickBtnGuardar() {
		this.click(btnGuardar);
	}
	
	public void clickTxtCampoPadre() {
		this.click(txtCampoPadre);
	}
	
	public void clickTxtSecuenciaPadre() {
		this.click(txtSecuenciaPadre);
	}
	
	public void clickTxtSecuencia() {
		this.click(txtSecuencia);
	}
	
	public void seleccionarDdlCamposEstandar(String opcion) throws InterruptedException {
		this.seleccionarValorDDL(ddlCamposEstandar, elementosCamposEstandar, opcion);
	}
	
	public void teclearNombreCampo(String nombreCampo) {
		this.LimpiarTexto(txtNombreCampo);
		this.teclear(nombreCampo, txtNombreCampo);
	}
	
	public void seleccionarDdlTipoCampo(String opcion) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipoCampo, elementosTipoCampo, opcion);
	}
	
	public void teclearAtributos(String atributo) {
		this.LimpiarTexto(txaAtributos);
		this.teclear(atributo, txaAtributos);
	}
	
	public void seleccionarCriterioAsignacionDefault(String criterio) throws InterruptedException {
		this.seleccionarValorDDL(ddlCriterioAsignacionDefault, elementosCriterioAsignacion, criterio);
	}
	
	public void teclearValorDefault(String valor) {
		this.LimpiarTexto(txaValorDefault);
		this.teclear(valor, txaValorDefault);
	}
	
	public void seleccionarTipoDato(String tipoDato) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipoDato, elementosTipoDato, tipoDato);
	}
	
	public void seleccionarFormato(String formato) throws InterruptedException {
		this.seleccionarValorDDL(ddlFormato, elementosFormato, formato);
	}
	
	public void teclearLongitudCampo(String longitud) {
		this.LimpiarTexto(txtLongitudCampo);
		this.teclear(longitud, txtLongitudCampo);
	}
	
	public void teclearPosicionesDecimales(String posiciones) {
		this.LimpiarTexto(txtPosicionesDecimales);
		this.teclear(posiciones, txtPosicionesDecimales);
	}
	
	public void teclearOrden(String orden) {
		this.LimpiarTexto(txtOrden);
		this.teclear(orden, txtOrden);
	}
	
	public void teclearSelect(String select) {
		this.LimpiarTexto(txaSelect);
		this.teclear(select, txaSelect);
	}
	
	public void clickDefinicionSql1() throws InterruptedException {
		this.click(ddlDefinicionSql);
		this.click(ddlDefinicionSql);
		Thread.sleep(1000);
		this.click(elemento1DefinicionSql);
	}
	
	public void clickBtnDesplegar() {
		this.click(btnDesplegarNodoPadre);
	}
}

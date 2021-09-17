package pages;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.TestBase;

public class FiltroPage extends TestBase{

	public FiltroPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}

	//Barra de menú
	private By mnuFiltro = By.xpath("//a[contains(@href,'Filtros')]");
	private By btnCrear = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[1]/span");
	private By btnSql = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[4]/span");
	private By btnLimpiarFiltros = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[6]/span");
	private By btnExportar = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[7]/span");

	//Criterios de selección
	private By ddlAplicacion = By.id("ctl00_MainContent_dwlAplicaciones_Input");
	private By elementosAplicacion = By.xpath("//*[@id=\"ctl00_MainContent_dwlAplicaciones_DropDown\"]/div/ul/li");

	//Formulario creación/edición
	private By txtCodigo = By.id("ctl00_MainContent_winAcciones_C_txtCodigoFiltro");
	private By txaDescripcion = By.id("ctl00_MainContent_winAcciones_C_txtDescripcion");
	private By ddlTipo = By.id("ctl00_MainContent_winAcciones_C_dwlTiposFiltro_Input");
	private By elementoTipo = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlTiposFiltro_DropDown\"]/div/ul/li");
	private By ddlDefinicionSql = By.id("ctl00_MainContent_winAcciones_C_rcbDefinicionesSql_Input");
	private By elementoDefinicionSql1 = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rcbDefinicionesSql_DropDown\"]/div/ul/li[2]");
	private By elementoDefinicionSql2 = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rcbDefinicionesSql_DropDown\"]/div/ul/li[3]");
	private By txaComandoWhere = By.id("ctl00_MainContent_winAcciones_C_txtComandoWhere");
	private By txaComandoGroupBy = By.id("ctl00_MainContent_winAcciones_C_txtGroupBy");
	private By txaComandoHaving = By.id("ctl00_MainContent_winAcciones_C_txtHaving");
	private By btnGuardar = By.id("ctl00_MainContent_winAcciones_C_btnIngresar");
	private By btnModificar = By.id("ctl00_MainContent_winAcciones_C_btnModificar_input");
	private By btnCancelar = By.id("ctl00_MainContent_winAcciones_C_btnCancelar");
	private By btnCerrar = By.id("ctl00_MainContent_winSql_C_btnCancelarSql_input");
	//Elementos filtro
	private By ftrCodigo = By.xpath("//*[@id=\"ctl00_MainContent_dgdFiltros_ctl00_Header\"]/thead/tr/th[3]/button");
	private By txtFiltro = By.id("ctl00_MainContent_dgdFiltros_rghcMenu_i6_HCFMRTBFirstCond");
	private By btnAplicar = By.id("ctl00_MainContent_dgdFiltros_rghcMenu_i6_HCFMFilterButton");
	private By btnLimpiar = By.id("ctl00_MainContent_dgdFiltros_rghcMenu_i6_HCFMClearFilterButton");

	//Opciones en el registro

	private By filaFiltro1 =By.id("ctl00_MainContent_dgdFiltros_ctl00__0");
	private By btnClose= By.id("btnCloseLSXM0104");

	public void abrirMenuFiltro() {
		this.click(mnuFiltro);
	}
	
	/* Seleccionar aplicación */
	public void seleccionarAplicacion(String aplicacion) throws InterruptedException {
		this.seleccionarValorDDL(ddlAplicacion, elementosAplicacion, aplicacion);
	}
	
	/* Barra de menús */
	public void clickBtnCrear() {
		this.click(btnCrear);
	}
	
	public void clickBtnSql() {
		this.click(btnSql);
	}
	
	public void clickBtnLimpiarFiltros() {
		this.click(btnLimpiarFiltros);
	}
	
	public void clickBtnExportar() {
		this.click(btnExportar);
	}
	
	/* Formulario creación/edición */
	public void teclearCodigo (String codigo) {
		this.LimpiarTexto(txtCodigo);
		this.teclear(codigo, txtCodigo);
	}
	
	public void teclearDescripcion (String descripcion) {
		this.LimpiarTexto(txaDescripcion);
		this.teclear(descripcion, txaDescripcion);
	}
	
	public void seleccionarTipoFiltro(String tipoFiltro) throws InterruptedException {
		this.seleccionarValorDDL(ddlTipo, elementoTipo, tipoFiltro);
	}
	
	public void seleccionarDefinicionSql1() throws InterruptedException {
		this.click(ddlDefinicionSql);
		this.click(ddlDefinicionSql);
		Thread.sleep(1000);
		this.click(elementoDefinicionSql1);
	}
	
	public void seleccionarDefinicionSql2() throws InterruptedException {
		this.click(ddlDefinicionSql);
		this.click(ddlDefinicionSql);
		Thread.sleep(1000);
		this.click(elementoDefinicionSql2);
	}
	
	public void teclearTxaWhere(String where) {
		this.LimpiarTexto(txaComandoWhere);
		this.teclear(where, txaComandoWhere);
	}
	
	public void teclearTxaGroupBy(String groupBy) {
		this.LimpiarTexto(txaComandoGroupBy);
		this.teclear(groupBy, txaComandoGroupBy);
	}
	
	public void teclearTxaHaving(String having) {
		this.LimpiarTexto(txaComandoHaving);
		this.teclear(having, txaComandoHaving);
	}
	
	public void clickFila1() {
		this.click(filaFiltro1);
	}
	
	public void cerrarPestana() {
		this.cerrarPestana(btnClose);
	}
	
	public void clickBtnGuardar() {
		this.click(btnGuardar);
	}
	
	public void clickBtnModificar() {
		this.click(btnModificar);
	}
	
	public void clickBtnCerrar() {
		this.click(btnCerrar);
	}
	
	/* Abrir filtro */
	public void clickBtnFtrCodigo() {
		this.click(ftrCodigo);
	}
	
	public void aplicarFiltro(String filtro) {
		this.LimpiarTexto(txtFiltro);
		this.teclear(filtro, txtFiltro);
		this.click(btnAplicar);
	}
}

package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.TestBase;

public class FiltroSistemaExternoPage extends TestBase{

	public FiltroSistemaExternoPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}
	//Barra de menú
	private By btnAsignar = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[1]/span");
	private By btnSql = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[4]/span");
	private By btnLimpiarFiltros = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li[5]/span");
	
	//Criterios de selección
	private By ddlSistemasExternos = By.id("ctl00_MainContent_dwlSistemasExternos_Input");
	private By elementosSistemasExternos = By.xpath("//*[@id=\"ctl00_MainContent_dwlSistemasExternos_DropDown\"]/div/ul/li");
	private By ddlAplicacion = By.id("ctl00_MainContent_dwlAplicaciones_Input");
	private By elementosAplicacion = By.xpath("//*[@id=\"ctl00_MainContent_dwlAplicaciones_DropDown\"]/div/ul/li");
	
	//Formulario de asignación
	private By ddlFiltros = By.id("ctl00_MainContent_winAcciones_C_rcbFiltros_Input");
	private By elementoFiltro1 = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_rcbFiltros_DropDown\"]/div/ul/li[1]");
	private By ddlNaturalezaFiltro = By.id("ctl00_MainContent_winAcciones_C_dwlNaturalezaFiltros_Input");
	private By elementosNaturalezaFiltro = By.xpath("//*[@id=\"ctl00_MainContent_winAcciones_C_dwlNaturalezaFiltros_DropDown\"]/div/ul/li");
	private By txtOrden = By.id("ctl00_MainContent_winAcciones_C_txtOrden");
	private By btnGuardar = By.id("ctl00_MainContent_winAcciones_C_btnIngresar_input");
	private By btnCancelar = By.id("ctl00_MainContent_winAcciones_C_btnCancelar_input");
	
	//Opciones registro
	private By filtroAsignado1 = By.id("ctl00_MainContent_dgdFiltros_ctl00__0");
	
	
}

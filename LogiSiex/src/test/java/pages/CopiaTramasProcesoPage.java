package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.TestBase;

public class CopiaTramasProcesoPage extends TestBase{
	public CopiaTramasProcesoPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}
	
	private By mnuCopiarTrama = By.xpath("//a[contains(@href,'CopiarTramas')]");
	//Criterios de selección
	private By ddlSistemasExternosOrigen = By.id("ctl00_MainContent_dwlSistemasExternos_Input");
	private By elementosSistemaExternoOrigen = By.xpath("//*[@id=\"ctl00_MainContent_dwlSistemasExternos_DropDown\"]/div/ul/li");
	private By ddlProcesoOrigen = By.id("ctl00_MainContent_dwlProcesosSistemasExternos_Input");
	private By elementosProcesoOrigen = By.xpath("//*[@id=\"ctl00_MainContent_dwlProcesosSistemasExternos_DropDown\"]/div/ul/li");
	private By elementoProcesoOrigen1 = By.xpath("//li[contains(@class,'rcbHovered')]");
	private By ddlSistemasExternosDestino = By.id("ctl00_MainContent_dwlSistemasExternosDestino_Input");
	private By elementosSistemasExternosDestino = By.xpath("//*[@id=\"ctl00_MainContent_dwlSistemasExternosDestino_DropDown\"]/div/ul/li");
	private By ddlProcesoDestino = By.id("ctl00_MainContent_dwlProcesosDestino_Input");
	private By elementosProcesoDestino = By.xpath("//*[@id=\"ctl00_MainContent_dwlProcesosDestino_DropDown\"]/div/ul/li");
	private By elementoProcesoDestino1 = By.xpath("//li[contains(@class,'rcbHovered')]");
	private By chkProcesoDestinoSinTrama = By.id("ctl00_MainContent_ctl00_MainContent_chkNuevoProcesoPanel");
	private By btnLimpiar = By.id("ctl00_MainContent_btnLimpiarCrtSlt");
	//Botón copiar
	private By btnCopiar = By.xpath("//*[@id=\"ctl00_MainContent_rtbToolbar\"]/ul/li/span");
	//Botón Aceptar
	private By btnAceptar = By.id("btnAceptarAlert");
	private By btnClose = By.id("btnLSXM0103");
	
	public void abrirMenuCopiarTramas() {
		this.click(mnuCopiarTrama);
	}
	
	public void seleccionarSistemaExternoOrigen(String sisExtOrigen) throws InterruptedException {
		this.seleccionarValorDDL(ddlSistemasExternosOrigen, elementosSistemaExternoOrigen, sisExtOrigen);
	}
	
	public void seleccionarSistemaExternoDestino(String sisExtDestino) throws InterruptedException {
		this.seleccionarValorDDL(ddlSistemasExternosDestino, elementosSistemasExternosDestino, sisExtDestino);
	}
	
	public void seleccionarProcesoOrigen(String proceso) throws InterruptedException {
		this.click(ddlProcesoOrigen);
		Thread.sleep(1000);
		this.teclear(proceso,ddlProcesoOrigen);
		Thread.sleep(1000);
		this.click(elementoProcesoOrigen1);
	}
	
	public void seleccionarProcesoDestino(String proceso) throws InterruptedException {
		this.click(ddlProcesoDestino);
		Thread.sleep(1000);
		this.teclear(proceso,ddlProcesoDestino);
		Thread.sleep(1000);
		this.click(elementoProcesoDestino1);
	}
	
	public void abrirMenu() {
		this.click(mnuCopiarTrama);
	}
	
	public void clickChkProcesosDestinoSinTrama() {
		this.click(chkProcesoDestinoSinTrama);
	}
	
	public void clickBtnCopiar() {
		this.click(btnCopiar);
	}
	
	public void clickBtnAceptar() {
		this.click(btnAceptar);
	}
	
	public void cerrarPestana() {
		this.cerrarPestana(btnClose);
	}
}

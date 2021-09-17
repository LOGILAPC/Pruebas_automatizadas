package com.logiciel.test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ServidoresPagina extends TestBase{
	
	//private String paginaWebLogiFTP = "http://logiserver09.logiciel.com:15080/Logiciel/WebLogiFTP/";
	//private By enlaceLogiFTP = By.xpath("//div[@id='apps']/div/div[6]/img");
	private By enlaceLogiFTP = By.xpath("//*[@id=\"apps\"]/div/div[6]/img");	
	//private By menuAdministracion = By.cssSelector("svg.svg-inline--fa.fa-bars.fa-w-14 > path");
	private By menuAdministracion = By.cssSelector("body > app-root > div > div > div > div.navigation.d-flex.align-items-center > button > fa-icon > svg > path");
	//private By menuServidores = By.cssSelector("body > app-root > app-sidenav > div.content.d-flex.flex-md-column > div.list.flex-grow-1 > div > a:nth-child(1)");
	private By menuServidores = By.cssSelector("body > app-root > app-sidenav > div.content.d-flex.flex-md-column > div.list.flex-grow-1 > div > a:nth-child(1) > div > div.item__label");
	private By logoLogiFTP = By.cssSelector("body > app-root > div > div > div > div.navigation.d-flex.align-items-center > div"); 
	private String iFrameServidores = "LFTM0101";
	private By botonCrearServidor = By.id("btnCrearSrv");	
	private By campoCodigo = By.id("Codigo");
	private By campoDescripcion = By.id("Descripcion");
	private By comboProtocolo = By.cssSelector("#grdServidores_active_cell > span.k-widget.k-dropdown > span");
	private By comboProtocoloItems = By.cssSelector("div.k-list-container ul.k-list li.k-item");
	//private By chkEsServidorRespaldo = By.cssSelector("#grdServidores > div.k-grid-content.k-auto-scrollable > table > tbody > tr:nth-child(1) > td:nth-child(6)"); 
	private By chkEsServidorRespaldo = By.id("ServidorRespaldo");
	private By botonGrabarServidor = By.id("btnGrabarSrv");
	
	private By celdaActiva = By.id("grdServidores_active_cell");
	
	
	public ServidoresPagina(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void navegaPaginaLogiFTP()throws InterruptedException {
		this.click(enlaceLogiFTP);		
	}
	
	public void despliegaMenuAdministracion()throws InterruptedException {
		this.click(menuAdministracion);		
	}
	
	public void seleccionarMenuServidores() {
		this.click(menuServidores);
	}
	
	public void grabarServidor()throws InterruptedException {
		this.click(botonGrabarServidor, iFrameServidores);		
	}
	
		
	public Boolean estaDesplagadaPaginaLogiFTP()throws InterruptedException {
		return this.estaDesplegado(logoLogiFTP);		
	}
	
	public void limpiarCampoCodigo()throws InterruptedException {
		this.LimpiarTexto(campoCodigo,iFrameServidores);		
	}
	
	public void crearServidor()throws InterruptedException {
		
		this.click(botonCrearServidor,iFrameServidores);		
	}
	
	public void ingresarCampoCodigo(String codigo)throws InterruptedException {
		this.teclear(codigo,campoCodigo,iFrameServidores);
		this.teclear(Keys.TAB,campoCodigo,iFrameServidores);
	}
		
	public void ingresarCampoDescripcion(String descripcion)throws InterruptedException {
		//this.click(campoDescripcion,iFrameServidores);		
		this.teclear(descripcion,campoDescripcion,iFrameServidores);	
		this.teclear(Keys.TAB,campoDescripcion,iFrameServidores);
	}
	
	public void seleccionarProtocolo(String valor)throws InterruptedException {
		this.seleccionarValorKendoDDL(comboProtocolo,comboProtocoloItems,valor, iFrameServidores);
		Thread.sleep(2000);		
	}
		
	public void seleccionarEsServidorRespaldo(boolean valor) throws InterruptedException{
		//this.teclear(Keys.TAB,celdaActiva,iFrameServidores);
		//Thread.sleep(2000);
		this.seleccionarValorKendoChk(chkEsServidorRespaldo,valor, iFrameServidores);
		
	}
}

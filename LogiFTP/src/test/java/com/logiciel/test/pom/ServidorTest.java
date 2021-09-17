package com.logiciel.test.pom;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.testng.Assert;

public class ServidorTest {
	private WebDriver driver;
	private ServidoresPagina paginaServidores;
	private AutenticacionPagina paginaAutenticacion;
	
  //@Test(priority=1)
  public void loginExitoso() throws InterruptedException {
//	  paginaAutenticacion.ingresarNombreUsuario("cmacias");
//	  paginaAutenticacion.ingresarContrasenaUsuario("Logiciel123");
//	  Thread.sleep(2000);
//	  paginaAutenticacion.autenticar();
//  	  Thread.sleep(2000);
//  	  paginaServidores.paginaLogiFTP();
//  	  Thread.sleep(2000);
//  	  paginaServidores.menuServidor();
//  	  Thread.sleep(2000);
//  	  paginaServidores.paginaServidor();
  }
  //@Test(priority=2)
  public void crearServidores() throws InterruptedException {
	  Thread.sleep(1000);
	  paginaServidores.crearServidor();
  	  Thread.sleep(500);
  	  paginaServidores.limpiarCampoCodigo();
  	  paginaServidores.ingresarCampoCodigo("01");
//  	  Thread.sleep(2000);  	  
//  	  paginaServidores.activarGrillaServidores();
//  	  Thread.sleep(5000);
  	  paginaServidores.ingresarCampoDescripcion("prueba01");
  	  Thread.sleep(5000);
//  	  paginaServidores.activarGrillaServidores();
//  	  Thread.sleep(5000);  	  
  }
  
   @BeforeClass
   public void inicializarPrueba() {
	  paginaAutenticacion = new AutenticacionPagina(driver);
	  driver = paginaAutenticacion.obtenerConexionChrome();
	  paginaAutenticacion.navegar("http://logiserver09.logiciel.com:15080/Logiciel/WebLogiPortal/"); 
	  paginaServidores = new ServidoresPagina(driver);		  	  
  }

   @AfterClass
   public void finalizarPrueba() {
	  paginaServidores.finalizar();
  }

}

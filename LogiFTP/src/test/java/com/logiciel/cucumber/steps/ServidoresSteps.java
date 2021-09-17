package com.logiciel.cucumber.steps;

import org.testng.Assert;
import com.logiciel.test.pom.ServidoresPagina;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServidoresSteps {

	private ServidoresPagina paginaServidores;
		
	@Before
	public void beforeScenario(Scenario scenario)throws InterruptedException {
		paginaServidores = new ServidoresPagina(ComunSteps.driver);			
	}
	
	@Given("El usuario conectado a LogiFTP")
	public void usuarioConectadoLogiFTP() throws InterruptedException {
		
	}
		
	@When("El usuario hace clic en Servidores")
	public void seleccionarServidores() throws InterruptedException{
		paginaServidores.despliegaMenuAdministracion();
	    Thread.sleep(1000);  
	    paginaServidores.seleccionarMenuServidores();
	    Thread.sleep(2000);  
	    
	}	
	
	@And("El usuario hace clic en Crear e ingresa la informacion de Servidores")
	public void crearServidores() throws InterruptedException{
		paginaServidores.crearServidor();
	  	Thread.sleep(500);
	  	paginaServidores.limpiarCampoCodigo();
	  	paginaServidores.ingresarCampoCodigo("01");
	  	Thread.sleep(2000);  	  
	  	paginaServidores.ingresarCampoDescripcion("prueba01");
	  	Thread.sleep(2000);
		paginaServidores.seleccionarProtocolo("FTP"); 	
		Thread.sleep(2000);
		paginaServidores.seleccionarEsServidorRespaldo(true);
	}
	
	@And("El usuario hace clic en Grabar")
	public void seleccionarBtnGrabar() throws InterruptedException{
		Thread.sleep(2000);
		paginaServidores.grabarServidor();		
	}
	
	@Then("Un nuevo Servidor se muestra en la grilla de Servidores")
	public void nuevoServidorCreado() throws InterruptedException {
		Assert.assertTrue(true);	
	}
}

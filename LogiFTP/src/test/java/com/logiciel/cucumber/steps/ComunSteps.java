package com.logiciel.cucumber.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.logiciel.test.pom.AutenticacionPagina;
import com.logiciel.test.pom.ServidoresPagina;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComunSteps {
	public static WebDriver driver;
	private AutenticacionPagina paginaAutenticacion;
	private ServidoresPagina paginaServidores;
	private Scenario scenarioActual;	
	
	@Before
	public void beforeScenario(Scenario scenario)throws InterruptedException {
		scenarioActual=scenario;  
		paginaAutenticacion = new AutenticacionPagina(driver);
		  driver = paginaAutenticacion.obtenerConexionChrome();
		  paginaAutenticacion.navegar("http://logiserver09.logiciel.com:15080/Logiciel/WebLogiPortal/"); 
		  paginaServidores = new ServidoresPagina(driver);	
	}
	@Given("El usuario requiere conectarse a LogiCorba")
	public void usuarioRequiereConectarse() throws InterruptedException {
		
	}
		
	@When("El usuario se loguea en la aplicacion")
	public void ingresarLogiCorba() throws InterruptedException{
		paginaAutenticacion.ingresarNombreUsuario("lpadilla");
		paginaAutenticacion.ingresarContrasenaUsuario("Logi5328");
		Thread.sleep(2000);
		capturaPantalla("Captura de pantalla después de un paso");
		paginaAutenticacion.autenticar();	
			  	
	}
	
	@And("El usuario selecciona la aplicacion LogiFTP")
	public void seleccionarLogiFTP() throws InterruptedException{
			
		Thread.sleep(2000);
	  	paginaServidores.navegaPaginaLogiFTP();
		//paginaServidores.navegar("http://logiserver09.logiciel.com:15080/Logiciel/WebLogiFTP/?icono=ICLFT&logo=LGLFT&appId=LPTM10");
	  	Thread.sleep(2000);
	}
	
	@Then("El usuario se encuentra conectado a LogiFTP")
	public void usuarioConectado()throws InterruptedException{
			
	  Assert.assertTrue(paginaServidores.estaDesplagadaPaginaLogiFTP());	
	  Thread.sleep(2000);		
	}
	
	@After
	public void afterScenario(){
		paginaAutenticacion.finalizar();
	}
	
	public void capturaPantalla(String titulo)
	{
        byte[] screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenarioActual.attach(screenshot1,"image/png", titulo);
	}
	
	
	@AfterStep
	public void AfterStep(Scenario scenario)
	{
		capturaPantalla("Captura de pantalla después de un paso");
	}
	
}

package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import general.Settings;
import general.Variables;

public class TestBase {
	WebDriver driver;
	private String url;
	
	public By alert = By.id("ctl00_winAlert_C");
	
	public By btnAceptarAlert = By.id("btnAceptarAlert");
	public By btnConfirmarEliminar = By.id("btnAceptarConfirm");
	public By btnCancelarEliminar = By.id("btnCancelarConfirm");
	private By btnEditar = By.cssSelector("span[id*='btnEditar']");
	private By btnEliminar = By.cssSelector("span[id*='btnEliminar']");
	
	public TestBase(WebDriver driver) throws FileNotFoundException, IOException {
		this.driver=driver;
		this.url=Variables.leerPropiedad("urlPrincipal");
	}
	
	public WebDriver obtenerConexionChrome() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver obtenerConexionIE() {
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	//Crear envoltorio de los métodos de Selenium
	public WebElement obtenerElemento(By localizador)
	{
		return driver.findElement(localizador);
	}
	
	public String obtenerTexto(WebElement elemento)
	{
		return elemento.getText();
	}
	
	public void LimpiarTexto(WebElement elemento)
	{
		elemento.clear();
	}
	
	public void LimpiarTexto(By localizador)
	{
		driver.findElement(localizador).clear();
	}
	public void LimpiarTexto(By localizador,String iframe)
	{
		driver.switchTo().frame(iframe);
		LimpiarTexto(localizador);
		driver.switchTo().parentFrame();
	}
	//Cambiar iFrame
	public void CambiarFrame(int indexFrame) {
		driver.switchTo().frame(indexFrame);
	}
	//Devuelve el texto del elemento
	public String obtenerTexto(By localizador)
	{
		return driver.findElement(localizador).getText();
	}
	
	public void teclear(String texto,By localizador) {
		driver.findElement(localizador).sendKeys(texto);
	}
	public void teclear(Keys texto,By localizador) {
		driver.findElement(localizador).sendKeys(texto);
	}

	public void teclear(String texto,By localizador,String iframe) {
		driver.switchTo().frame(iframe);
		teclear(texto,localizador);
		driver.switchTo().parentFrame();
	}	
	public void teclear(Keys texto,By localizador,String iframe) {
		driver.switchTo().frame(iframe);
		teclear(texto,localizador);
		driver.switchTo().parentFrame();
	}	

	public void click(By localizador) {
		driver.findElement(localizador).click();
	}
	
	public void click(By localizador,String iframe) {
		driver.switchTo().frame(iframe);
    	this.click(localizador);
		driver.switchTo().parentFrame();
	}	
	protected boolean estaDesplegado(By localizador) {
		try {
			return driver.findElement(localizador).isDisplayed();
		}
		catch(org.openqa.selenium.NoSuchContextException e) {
			return false;		
		}
	}
	public boolean estaDesplegado(By localizador, String iframe) {
		try {
			Boolean resultado;
			driver.switchTo().frame(iframe);
			new Actions(driver).moveToElement(driver.findElement(localizador)).perform();
			resultado=driver.findElement(localizador).isDisplayed();			
			driver.switchTo().parentFrame();
			return resultado;
		}
		catch(org.openqa.selenium.NoSuchContextException e) {
			return false;		
		}
	}
	
	public boolean estaHabilitado(By localizador) {
		try {
			if (driver.findElement(localizador).getAttribute("class").contains("Disabled")) {
				return false;
			}
			else if (driver.findElement(localizador).getAttribute("class").contains("Enabled")) {
				return true;
			}else
				return false;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void navegar() {
		driver.get(url);
	}
	public void navegar(String url) {
		driver.get(url);
	}
	
	public void finalizar() {
		try {
			driver.close(); // cerrar ventana
			driver.quit(); // finalizar webdrive
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void capturaPantalla(String titulo)
	{
        //byte[] screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        //scenarioActual.attach(screenshot1,"image/png", titulo);
	}
	
	
	public void seleccionarValorKendoDDL(By localizadorDDL , By localizadorDDLItems, String valor,String iframe) throws InterruptedException {
	
		driver.switchTo().frame(iframe);
		
		WebElement firstDropDown = driver.findElement(localizadorDDL);    
		firstDropDown.click();
	
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(localizadorDDLItems);

		System.out.println("El lista es: " + options.size());		        
		
		for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) {
	        WebElement webElement = (WebElement) iterator.next();
	        System.out.println("El valor del DDL seleccionado es: " + webElement.getText());
	        if (webElement.getText().equals(valor)) {
	            webElement.click();        
	            System.out.println("El seleccionado valor del DDL seleccionado es: " + webElement.getText());		        
	        }
	    }
	    driver.switchTo().parentFrame();
	}	
	public void seleccionarValorKendoChk(By localizadorChk , boolean valor,String iframe) throws InterruptedException {
		
		driver.switchTo().frame(iframe);		
		Thread.sleep(2000); 		
		WebElement webElement = driver.findElement(localizadorChk);
		
		System.out.println("El valor: " + webElement.isSelected());		        
	    
		if (!webElement.isSelected() && valor) {	
			webElement.click();  
        	System.out.println("El valor: " + webElement.isSelected());	
		}
		
		driver.switchTo().parentFrame();               
     }
	
	public void seleccionarValorDDL(By localizadorDDL, By localizadorDDLItems, String valor) throws InterruptedException {
	
		WebElement firstDropDown = driver.findElement(localizadorDDL);    
		firstDropDown.click();
	
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(localizadorDDLItems);
       
		for (Iterator<WebElement> iterator = options.iterator(); iterator.hasNext();) {
	        WebElement webElement = (WebElement) iterator.next();
	        //System.out.println(webElement.getAttribute("innerText"));
	        if (webElement.getAttribute("innerText").contains(valor)) {
	        	JavascriptExecutor executor = (JavascriptExecutor)driver;
	        	executor.executeScript("arguments[0].click();", webElement);
	            break;
	        }
	    }
	}
	
	public boolean isRegistroCorrecto(By localizadorAlerta, By localizadorAceptar) {
		try {
			if (this.obtenerTexto(localizadorAlerta).contains("éxito"))
			{
				this.click(localizadorAceptar);
				return true;
			}
			else
				return false;

		} catch (Exception e) {
			return false;
		}
	}
	
	public String generarCodigo5(String consultaSql) throws SQLException {
		String codigo;
		PreparedStatement sentencia;
		ResultSet resultados = null;
		do{
			codigo = RandomStringUtils.randomAlphabetic(5);
			try {
				sentencia = Settings.conexion.prepareStatement(consultaSql);
				sentencia.setString(1, codigo);
				resultados = sentencia.executeQuery();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}while(resultados.getRow()!=0);
		return codigo;
	}
	
	public void clickBtnAceptarAlert() {
		this.click(btnAceptarAlert);
	}
	
	public void clickBtnConfirmarEliminar() {
		this.click(btnConfirmarEliminar);
	}
	
	public void clickBtnCancelarEliminar() {
		this.click(btnCancelarEliminar);
	}
	
	/* Botones de opciones de registro Editar y Eliminar */
	public void clickBtnEditar () {
		this.click(btnEditar);
	}
	
	public void clickBtnEliminar () {
		this.click(btnEliminar);
	}
	
	public void cerrarPestana(By btnClose) {
		LoginTest.driver.switchTo().defaultContent();
		this.click(btnClose);
	}
}

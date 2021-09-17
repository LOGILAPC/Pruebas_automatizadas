package com.logiciel.test.pom;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class TestBase {
	private WebDriver driver;

	public TestBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver obtenerConexionChrome() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver obtenerConexionIE() {
		//bajar el driver de IE.
		System.setProperty("webdriver.ie.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
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
}


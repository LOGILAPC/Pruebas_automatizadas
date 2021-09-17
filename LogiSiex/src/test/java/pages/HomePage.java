package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import general.Variables;
import test.TestBase;

public class HomePage extends TestBase{
	public HomePage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}
	private String appPrueba=Variables.leerPropiedad("appPrueba");
	private By btnLogout = By.id("logout");
	private By contenedorApps = By.id("apps");
	//No borrar el comentario
	//private By divAppPrueba= By.xpath("//*[contains(@onclick,\""+appPrueba+"\")]");
	private By divAppPrueba= By.xpath("//*[contains(@onclick,\""+appPrueba+"\")]");

	public void clickBtnLogout () {
		this.click(btnLogout);
	}
	
	public void clickContenedorApps() {
		this.click(contenedorApps);
	}
	
	public void abrirAppPrueba() {
		this.click(divAppPrueba);
	}
	
}
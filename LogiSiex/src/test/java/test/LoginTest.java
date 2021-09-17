package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;
import general.ListenerLogiSiex;
import pages.LoginPage;
import general.Variables;
import org.openqa.selenium.*;

@Listeners(ListenerLogiSiex.class)
public class LoginTest {
	public static WebDriver driver;
	//public static String appPrueba;
	private LoginPage paginaLogin;
	String url,username, password;

	@BeforeSuite
	public void beforeClassLogin() throws FileNotFoundException, IOException {
		paginaLogin = new LoginPage(driver);
		driver = paginaLogin.obtenerConexionChrome();
		//appPrueba=Variables.leerPropiedad("appPrueba");
		username= Variables.leerPropiedad("username");
		password =  Variables.leerPropiedad("password");
	}
	@Test
	public void ingresoCorrectoALogicorba() throws Exception {
		paginaLogin.navegar();
		paginaLogin.setTxtUsuario(username);
		paginaLogin.setTxtContrasena(password);
		paginaLogin.clickBtnIngresar();
		Assert.assertTrue(isCorrectLoginApps()||isCorrectLoginApp());
	}


	//Verifica que el acceso sea exitoso cuando tiene acceso a varias aplicaciones
	private boolean isCorrectLoginApps() {
		try {
			driver.findElement(By.cssSelector("body > div.login > form > a > div"));
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		} 
	}

	//Verifica que el acceso sea exitoso cuando solamente tiene acceso a una aplicación
	private boolean isCorrectLoginApp() {
		try {
			driver.findElement(By.cssSelector("#frmLogiFlowMaster > div.view > app-root > div > div > div > div.actions.d-flex.ml-4 > div.dropdown-user.dropdown > button"));
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		} 
	}
}

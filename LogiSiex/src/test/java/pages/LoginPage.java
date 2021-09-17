package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.TestBase;

public class LoginPage extends TestBase{

	public LoginPage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}

	private By frmLogin = By.id("loginForm");
	private By txtUsuario = By.id("UsuarioLogin");
	private By txtContrasena = By.id("UsuarioPwd");
	private By txtDominio = By.id("Dominio");
	private By chkDominio = By.xpath("//label[contains(text(),'Autenticar contra dominio')]");
	private By btnIngresar = By.id("btnAceptar");
	
	public void setTxtUsuario(String username) {
		this.teclear(username, txtUsuario);
	}
	
	public void setTxtContrasena(String password) {
		this.teclear(password, txtContrasena);
	}
	
	public void setTxtDominio(String dominio) {
		this.teclear(dominio, txtDominio);
	}
	
	public void clickBtnIngresar() {
		this.click(btnIngresar);
	}
}

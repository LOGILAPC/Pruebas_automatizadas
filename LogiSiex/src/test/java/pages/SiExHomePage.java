package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import test.TestBase;

public class SiExHomePage extends TestBase{

	public SiExHomePage(WebDriver driver) throws FileNotFoundException, IOException {
		super(driver);
	}
	//private By btnOpcionesMenu = By.xpath("//*[contains(@class,\"navigation\")][contains(@title,\"men\")]");
	// 
	private By btnOpcionesMenu = By.xpath("//button[contains(@class,'navigation') and contains(@title,'men')]");
	
	public void clickBtnOpcionesMenu() {
		this.click(btnOpcionesMenu);
	}
}

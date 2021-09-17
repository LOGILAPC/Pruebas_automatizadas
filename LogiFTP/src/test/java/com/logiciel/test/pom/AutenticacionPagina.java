package com.logiciel.test.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutenticacionPagina extends TestBase{
	
	private By campoNombreUsuario = By.id("UsuarioLogin");
	private By campoContrasenaUsuario = By.id("UsuarioPwd");
	private By botonLogin = By.id("btnAceptar");	 
	private By mensajeErrorAutenticacion = By.id("spanMessage");
	
	public AutenticacionPagina(WebDriver driver) {
		super(driver);
	}
	
	public void ingresarNombreUsuario(String nombreUsuario)throws InterruptedException {
		this.teclear(nombreUsuario,campoNombreUsuario);		
	}
	
	public void ingresarContrasenaUsuario(String contrasenaUsuario)throws InterruptedException {
		this.teclear(contrasenaUsuario,campoContrasenaUsuario);		
	}
	
	public void autenticar()throws InterruptedException {
		this.click(botonLogin);		
	}
	
	public String obtenerMensajeAutenticacion() {
		try {
			return this.obtenerTexto(mensajeErrorAutenticacion);
		}
		catch(Exception e){
			return "";
		}
	}
}

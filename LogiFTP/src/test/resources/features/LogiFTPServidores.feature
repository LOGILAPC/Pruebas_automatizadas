Feature: Se automatizan las pruebas de Servidores

  Background: He iniciado sesion en la aplicacion LogiFTP
    Given El usuario requiere conectarse a LogiCorba
    When El usuario se loguea en la aplicacion
    And El usuario selecciona la aplicacion LogiFTP
    Then El usuario se encuentra conectado a LogiFTP

@SmokeTest
  Scenario: Verificar que en Servidores del módulo Administración de LogiFTP se permita crear un Servidor FTP.
    Given El usuario conectado a LogiFTP
    When El usuario hace clic en Servidores
    And El usuario hace clic en Crear e ingresa la informacion de Servidores
    And El usuario hace clic en Grabar 
    Then Un nuevo Servidor se muestra en la grilla de Servidores




 
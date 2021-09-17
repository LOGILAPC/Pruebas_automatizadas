package general;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerLogiSiex implements ITestListener{
	public void onFinish(ITestContext arg) {					
		System.out.println(arg.getName());			
	}		

	public void onStart(ITestContext arg) {					
		System.out.println(arg.getName());				
	}		
		
	public void onTestFailure(ITestResult arg) {					
		System.out.println("El caso de prueba " + arg.getName() +" ha fallado");			
	}		
			
	public void onTestSkipped(ITestResult arg) {					
		System.out.println("El caso de prueba " + arg.getName() +" no ha sido ejecutado");				
	}		

	public void onTestStart(ITestResult arg) {					
		System.out.println("El caso de prueba " + arg.getName() +" ha iniciado");				
	}		

	public void onTestSuccess(ITestResult arg) {					
		System.out.println("El caso de prueba " + arg.getName() +" se ha ejecutado exitosamente");				
	}		
}

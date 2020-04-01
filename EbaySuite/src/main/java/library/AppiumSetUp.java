package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;

import javax.swing.plaf.synth.SynthStyle;

import gherkin.deps.net.iharder.Base64.OutputStream;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumSetUp {
	
	static AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
	private Log log;
	public AppiumSetUp() throws MalformedURLException {
		// TODO Auto-generated constructor stub
		log = new Log(AppiumSetUp.class);
	}
	
	public  void startAppiumServer(int port) throws FileNotFoundException
	{
		if(!checkIfServerIsRunnning(port))
		{
			startService();
			log.info("Appium server started");
		}else {
			log.info("Appium server is already Running on port  "+port);
		}
	}
	
	public  void startService() throws FileNotFoundException
	{
		
		/*
		 * it will first check if service its in user if not then it will start new appium session
		 */
		
		if(service.isRunning())
		{
			stopService();
			log.info("Stopped existing running appium server");
		}
			service.start();
			
			log.info("Fresh Appium server started Again");
			
		}
	
	
	
	public  void stopService() throws FileNotFoundException
	{
		getAppiumServerLog();
		service.stop();
		log.info("Appium server service stopped");
		
	}
	public String serverStdOut()
	{
		return service.getStdOut();
	}
	
	public void getAppiumServerLog() throws FileNotFoundException
	{
		FileOutputStream output = new FileOutputStream(System.getProperty("user.dir"));
		service.sendOutputTo(output);
	}
public  boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
			log.info("service is already running");
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}	


}

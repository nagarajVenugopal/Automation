package library;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.*;

public class Log {
	static org.slf4j.Logger log ;

	public Log(Class<?> cl) throws MalformedURLException {
		//super();
	   // TODO Auto-generated constructor stub
		log = LoggerFactory.getLogger(cl);
	}
  
	public void info(String message)
	{
		log.info(message);
	}
	
	public void warn(String messgae)
	{
		log.warn(messgae);
	}
	
	public void error(String messgae)
	{
		log.error(messgae);
	}
	public void debug(String messgae)
	{
		log.debug(messgae);
	}
	
}

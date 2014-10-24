package ua.pasha.WebScraper.logging;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class LoggingAPILog4jImpl implements LoggingAPI {

	private org.apache.log4j.Logger logger = null;
	private static LoggingAPI instance = null;

	private LoggingAPILog4jImpl() {
		logger = org.apache.log4j.Logger.getLogger("Logger");
		Properties logProperty = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./log4j.properties");
			logProperty.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( fis != null){
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PropertyConfigurator.configure(logProperty);

	}

	public static LoggingAPI getLogger() {
		if (instance == null) {
			instance = new LoggingAPILog4jImpl();
		}
		return instance;
	}
	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#fatal(java.lang.String)
	 */
	public void fatal(String message){
		logger.fatal(message);
	}	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#fatal(java.lang.String, java.lang.Throwable)
	 */
	public void fatal(String message, Throwable t){
		logger.fatal(message, t);
	}
	
	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#error(java.lang.String)
	 */
	public void error(String message){
		logger.error(message);
	}
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#error(java.lang.String, java.lang.Throwable)
	 */
	public void error(String message, Throwable t){
		logger.error(message, t);
	}
	
	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#warn(java.lang.String)
	 */
	public void warn(String message){
		logger.warn(message);
	}
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#warn(java.lang.String, java.lang.Throwable)
	 */
	public void warn(String message, Throwable t){
		logger.warn(message, t);
	}
	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#info(java.lang.String)
	 */
	public void info(String message){
		logger.info(message);
	}
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#info(java.lang.String, java.lang.Throwable)
	 */
	public void info(String message, Throwable t){
		logger.info(message, t);
	}
	
	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#debug(java.lang.String)
	 */
	public void debug(String message){
		logger.debug(message);
	}
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#debug(java.lang.String, java.lang.Throwable)
	 */
	public void debug(String message, Throwable t){
		logger.debug(message, t);
	}
	
	
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#trace(java.lang.String)
	 */
	public void trace(String message){
		logger.trace(message);
	}
	/* (non-Javadoc)
	 * @see ua.pasha.HelloLogging.LoggingAPI#trace(java.lang.String, java.lang.Throwable)
	 */
	public void trace(String message, Throwable t){
		logger.trace(message);
	}

}

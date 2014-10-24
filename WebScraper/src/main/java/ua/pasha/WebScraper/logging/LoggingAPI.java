package ua.pasha.WebScraper.logging;

public interface LoggingAPI {

	public abstract void fatal(String message);

	public abstract void fatal(String message, Throwable t);

	public abstract void error(String message);

	public abstract void error(String message, Throwable t);

	public abstract void warn(String message);

	public abstract void warn(String message, Throwable t);

	public abstract void info(String message);

	public abstract void info(String message, Throwable t);

	public abstract void debug(String message);

	public abstract void debug(String message, Throwable t);

	public abstract void trace(String message);

	public abstract void trace(String message, Throwable t);

}
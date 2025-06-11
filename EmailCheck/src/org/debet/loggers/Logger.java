package org.debet.loggers;

/**
 * System logger
 */
public interface Logger {
	/**
	 * Write a log message
	 *
	 * @param message message
	 */
	void log(String message);

	/**
	 * Write an error message
	 *
	 * @param message message
	 */
	void error(String message);

	/**
	 * Write a warning message
	 *
	 * @param message message
	 */
	void warn(String message);

	/**
	 * Write an info message
	 *
	 * @param message message
	 */
	void info(String message);

	/**
	 * Write an debug message.
	 *
	 * @param message message
	 */
	void debug(String message);
}

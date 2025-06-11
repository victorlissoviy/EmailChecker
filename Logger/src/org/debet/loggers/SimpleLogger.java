package org.debet.loggers;

import java.util.logging.Level;

public class SimpleLogger implements Logger {
	java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Email Checker");

	@Override
	public void log(String message) {
		this.logger.log(java.util.logging.Level.INFO, message);
	}

	@Override
	public void error(String message) {
		this.logger.log(Level.SEVERE, message);
	}

	@Override
	public void warn(String message) {
		this.logger.log(Level.WARNING, message);
	}

	@Override
	public void info(String message) {
		this.logger.log(Level.INFO, message);
	}

	@Override
	public void debug(String message) {
		this.logger.log(Level.FINE, message);
	}
}

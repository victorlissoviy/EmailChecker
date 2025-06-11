package org.debet.email.readers;

/**
 * System email reader
 */
public interface EmailReader {
	/**
	 * Read next Email
	 * @return email
	 */
	String readNextEmail();
}

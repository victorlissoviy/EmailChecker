package org.debet.email.results;

/**
 * System writer
 */
public interface ResultsWriter {
	/**
	 * Write info by Email
	 *
	 * @param email  email
	 * @param result result message
	 */
	void writeByEmail(String email, String result);
}

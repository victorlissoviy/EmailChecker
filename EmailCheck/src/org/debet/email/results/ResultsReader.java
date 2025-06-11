package org.debet.email.results;

/**
 * System reader.
 */
public interface ResultsReader {
	/**
	 * Read an existed result by email.
	 *
	 * @param email email
	 * @return result message
	 */
	String readResultByEmail(String email);

	/**
	 * Check if exist result by email.
	 *
	 * @param email email
	 * @return if result existed
	 */
	Boolean checkExistsResults(String email);
}

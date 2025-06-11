package org.debet.email.api;

/**
 * System email API checker
 */
public interface Checker {
	/**
	 * Check email
	 * @param email email
	 * @param apiKey API key
	 * @return results
	 */
	String check(String email, String apiKey);
}

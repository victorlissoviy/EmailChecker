package org.debet.apikey;

/**
 * System key reader
 */
public interface ApiKeyReader {
	/**
	 * Read the next key for API.
	 * @return api key
	 */
	String readNextKey();
}

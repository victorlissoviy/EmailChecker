package org.debet.email.check;

import org.debet.apikey.ApiKeyReader;
import org.debet.email.api.Checker;
import org.debet.email.readers.EmailReader;
import org.debet.email.results.ResultsReader;
import org.debet.email.results.ResultsWriter;
import org.debet.loggers.Logger;

public class EmailCheck {
	private final ApiKeyReader apiKeyReader;
	private final Logger logger;
	private final ResultsWriter resultsWriter;
	private final ResultsReader resultsReader;
	private final Checker checker;
	private final EmailReader emailReader;

	public EmailCheck(ApiKeyReader apiKeyReader,
	                  Logger logger,
	                  ResultsWriter resultsWriter,
	                  ResultsReader resultsReader,
	                  Checker checker,
	                  EmailReader emailReader) {
		this.apiKeyReader = apiKeyReader;
		this.logger = logger;
		this.resultsWriter = resultsWriter;
		this.resultsReader = resultsReader;
		this.checker = checker;
		this.emailReader = emailReader;
	}

	public void check() {
		String currentApiKey = apiKeyReader.readNextKey();
		while (currentApiKey != null) {
			logger.debug("Starting to check email by key: " + currentApiKey);

			checkEmailsByKey(currentApiKey);

			logger.debug("End to check email by key: " + currentApiKey);
			currentApiKey = apiKeyReader.readNextKey();
		}
	}

	private void checkEmailsByKey(String apiKey) {
		String email = emailReader.readNextEmail();
		while (email != null) {
			logger.info("Starting to check email: " + email);

			checkEmail(email, apiKey);

			logger.info("End to check email: " + email);
			email = emailReader.readNextEmail();
		}
	}

	private void checkEmail(String email, String apiKey) {
		String result;
		if (Boolean.TRUE.equals(resultsReader.checkExistsResults(email))) {
			result = resultsReader.readResultByEmail(email);
		} else {
			result = checker.check(email, apiKey);
		}
		resultsWriter.writeByEmail(email, result);
	}
}

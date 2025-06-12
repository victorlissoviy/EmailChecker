package org.debet.apikey;

import org.debet.exceptions.ReadApiKeyException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileApiKeyReader implements ApiKeyReader {
	private final String fileName;
	private final List<String> apiKeys = new ArrayList<>();
	private Integer index = 0;

	public FileApiKeyReader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String readNextKey() {
		if (apiKeys.isEmpty()) {
			fullApiKeys();
		}

		if (apiKeys.isEmpty()) {
			throw new ReadApiKeyException("No API keys found");
		}

		String apiKey = null;
		if (index < apiKeys.size()) {
			apiKey = apiKeys.get(index++);
		}

		return apiKey;
	}

	private void fullApiKeys() {
		File file = new File(fileName);
		if (!file.exists()) {
			return;
		}

		try (FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
		     BufferedReader reader = new BufferedReader(fr)) {
			reader.lines().forEach(apiKeys::add);
		} catch (IOException e) {
			throw new ReadApiKeyException(e.getMessage(), e);
		}
	}
}

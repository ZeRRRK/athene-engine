package org.athene.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.athene.util.StringUtils;

/**
 * Manages configuration values.
 * @author Matt Yackel
 *
 */
public class ConfigManager {
	
	/**
	 * The default configuration manager for the engine.
	 */
	private static final ConfigManager INSTANCE = new ConfigManager();
	
	/**
	 * A table of configuration values.
	 */
	private Map<String, Map<String, Object>> configTable = new HashMap<String, Map<String, Object>>();
	
	private ConfigManager()  {
		File baseConfigDirectory = new File("./Engine/Config/");
		if(baseConfigDirectory.isDirectory()) {
			for(File file : baseConfigDirectory.listFiles()) {
				try {
					loadConfig(file.getPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Gets a configured value from the given group with the given key.
	 * @param groupName The group.
	 * @param key The key.
	 * @return The value.
	 */
	public Object getValue(String groupName, String key) {
		return configTable.get(groupName).get(key);
	}
	
	/**
	 * Loads configuration values from a file.
	 * @param fileName The name of the file.
	 * @throws IOException
	 */
	public void loadConfig(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String line = null;
		while((line = reader.readLine()) != null) {
			if(!line.startsWith("#")) {
				if(line.startsWith("[") && line.endsWith("]")) {
					String groupName = line.substring(1, line.length() - 1);
					Map<String, Object> configMap = new HashMap<String, Object>();
					while((line = reader.readLine()) != null) {
						if(line.startsWith("[")) {
							reader.reset();
							break;
						}
						if(!line.startsWith("#")) {
							if(line.contains("=")) {
								int index = line.indexOf("=");
								String key = line.substring(0, index);
								String value = line.substring(index + 1, line.length());
								if(StringUtils.isNumber(value)) {
									int val = Integer.parseInt(value);
									configMap.put(key, val);
								} else {
									configMap.put(key, value);
								}
							}
						}
						reader.mark(0);
					}
					configTable.put(groupName, configMap);
				}
			}
		}
		fileReader.close();
		reader.close();
	}

	/**
	 * Gets the default configuration manager.
	 * @return The default configuration manager.
	 */
	public static ConfigManager getInstance() {
		return INSTANCE;
	}

}

package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDatProvider {
	
	Properties pro;
	
	public ConfigDatProvider() {
		
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to load properties file: "+e.getMessage());
		}
		
		
	}
	
	public String getDataFromConfig(String keyToSearch) {
		
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}

}

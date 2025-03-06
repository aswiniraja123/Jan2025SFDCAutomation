package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class FileUtils {

	public static String readLoginPropertiesFile(String key) throws FileNotFoundException, IOException {

		Properties p = new Properties();
		p.load(new FileReader(FileConstants.LOGIN_TEST_DATA_FILE));
		return p.getProperty(key);
	}

	public static String readHomePagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.HOME_TEST_DATA_FILE));
		return p.getProperty(key);
	}

	public static String readAccountPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.ACCOUNT_TEST_DATA_FILE));
		return p.getProperty(key);
	}

	public static String readOpportunityPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.OPPORTUNITY_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	public static String readLeadsPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.LEADS_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	public static String readContactPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants.CONTACT_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	

}

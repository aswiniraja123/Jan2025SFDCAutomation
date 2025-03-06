package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String ROOT_PATH = System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/login.properties";
	public static final String  HOME_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/home.properties";
	public static final String SCREENSHOT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils.getTimeStamp()+ ".PNG";
	public static final String ACCOUNT_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/account.properties";
	public static final String OPPORTUNITY_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/opportunity.properties";
	public static final String REPORT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils.getTimeStamp()+ ".html";
	public static final String LEADS_TEST_DATA_FILE =  ROOT_PATH + "/src/main/java/testData/leads.properties";
	public static final String CONTACT_TEST_DATA_FILE =  ROOT_PATH + "/src/main/java/testData/contact.properties";
	

}

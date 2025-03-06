package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import constants.FileConstants;

public class CommonUtils {
	
public static String captureScreenshot(WebDriver driver,String testname) {
		
	String path = FileConstants.SCREENSHOT_PATH;
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);    //dst=destination
		src.renameTo(dst);
		return path;
	}
	
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}


}

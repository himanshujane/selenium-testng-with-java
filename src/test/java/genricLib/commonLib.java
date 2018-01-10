package genricLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class commonLib {
public WebDriver driver;	
public ExtentReports ereports;
public ExtentTest startTest;


//Annotation***************************************************

@BeforeSuite
public void inReport() {
ereports = new ExtentReports("D:\\SeleniumClasses\\HVF\\reports\\Report_"+ getdatetimestamp() + ".html"); 
}


@BeforeMethod	
public void launchApp() throws Exception {
	driver = new FirefoxDriver();
	driver.get(getprop("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
}
@AfterMethod
public void teardown() {
	System.out.println("Shutdown");
	ereports.endTest(startTest);
	ereports.flush();
	driver.quit();
}

//Annotation close***************************************************


//Keywords********************************************************
public static void sendkeys(WebElement we, String val) {
	we.clear();
	we.sendKeys(val);
	}
	
public static void enter(WebElement we) {
	we.sendKeys(Keys.ENTER);;
	}

public static void click(WebElement we) {
	we.click();
	}
//Keywords Close ***************************************************


//common methods *************************************************

// to validate URL
public boolean validateUrl(String str) {
		
	if (driver.getTitle().toLowerCase().contains(str)) {
		return true;
	}else
		 return false;
}

  //data and time
public String getdatetimestamp(){	
	
	Date date = new Date();	
	System.out.println(date);
	SimpleDateFormat sf = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
	String unique = sf.format(date);
	return unique;
}

// utility 

public static String getprop(String key) throws Exception {
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resource\\config.properties");
	Properties prop = new Properties();
	prop.load(fis);
	return prop.getProperty(key);

}



//common methods close ***********************************************

}

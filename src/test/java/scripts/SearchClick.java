package scripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genricLib.commonLib;
import pageFactory.PF_googlesearch;

public class SearchClick extends commonLib {

	@Test(dataProvider = "dphvf",dataProviderClass= dataProvider.dphvf.class)
	public void gsearch_google(Map <String, String> hm) {
	
	PF_googlesearch googlesearch= new PF_googlesearch(driver);
	startTest = ereports.startTest(hm.get("tc_id"), "Search"+hm.get("scriteria"));
	
	//validate current URL is google
	if(validateUrl("Google")){
		startTest.log(LogStatus.PASS, "Launch Google website", " Google Website Launched");
		}else {
			startTest.log(LogStatus.FAIL, "Launch Google website", " Google Website did not Launch");
		}
	sendkeys(googlesearch.txtbox_searchText, hm.get("scriteria"));
	enter(googlesearch.txtbox_searchText);
	
	// validate number of search result
	if((googlesearch.sresult(driver))>Integer.parseInt(hm.get("result").replaceAll(".0",""))){
		startTest.log(LogStatus.PASS, "Result should be greater than 100", " Results as expected");
		}else {
			startTest.log(LogStatus.FAIL, "Result should be greater than 100", "Result less than 100");
		}
	
	
	//validate opened website
	click(googlesearch.link_firstSearch);
		if(validateUrl(hm.get("url"))){
		startTest.log(LogStatus.PASS, "Launch Amazon website", " Amazon Website Launched");
		}else {
			startTest.log(LogStatus.FAIL, "Launch Amazon website", " Amazon Website did not Launch");
		}
	
	}
	
	

}

package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PF_googlesearch {
	
	@FindBy(xpath="//input[@id='lst-ib']")
	public WebElement txtbox_searchText;
	
	@FindBy(xpath="input[@type='submit'][1]")
	public WebElement btn_googleSearch;
	
	@FindBy(id="resultStats")
	public WebElement txt_searchResult;
	
	@FindBy(xpath="//div[@id='tvcap']/div/ol/li/div/h3/a[2]")
	public WebElement link_firstSearch;
	
	public PF_googlesearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int sresult(WebDriver driver) {
	String [] str = txt_searchResult.getText().split(" ");
	return Integer.parseInt(str[1].replaceAll(",", ""));
	}
}

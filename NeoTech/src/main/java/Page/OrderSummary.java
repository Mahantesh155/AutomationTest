package Page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NewTech.NeoTech.BaseTest;

public class OrderSummary extends BaseTest
{
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a"))private WebElement prodName;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]"))private WebElement catTotalObj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[1]/h3"))private WebElement delieveryAddHeaderObj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[2]"))private WebElement address1Obj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[3]"))private WebElement address2Obj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[4]"))private WebElement address3Obj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[5]"))private WebElement address4Obj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[6]"))private WebElement address5Obj;
	@FindBy(xpath = ("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[5]"))private WebElement address6Obj;
	@FindBy(name = "processAddress")private WebElement processAddress;
	@FindBy(name = "processCarrier")private WebElement processCarrier;
	@FindBy(xpath = ("//a[@class='bankwire']"))private WebElement bankWire;
	@FindBy(id = "amount")private WebElement amountObj;
	@FindBy(id = "uniform-cgv")private WebElement agreeChkBox;
	
	public OrderSummary(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 *function to Get the Summary Page details like product name, cart total,address
	 */		
	public List<String> GetSummaryPageDetails()
	{
		List<String> summaryPageDetails = new ArrayList<String>();
		
		String productName = prodName.getText();
		summaryPageDetails.add(productName);
		String cartTotal =  catTotalObj.getText();
		summaryPageDetails.add(cartTotal);

		String delieveryAddHeader = delieveryAddHeaderObj.getText();
		summaryPageDetails.add(delieveryAddHeader);
		
		String address1 = address1Obj.getText();
		summaryPageDetails.add(address1);
		String address2 = address2Obj.getText();		
		summaryPageDetails.add(address2);
		String address3 = address3Obj.getText();
		summaryPageDetails.add(address3);
		String address4 = address4Obj.getText();
		summaryPageDetails.add(address4);
		String address5 = address5Obj.getText();
		summaryPageDetails.add(address5);
		String address6 = address6Obj.getText();
		summaryPageDetails.add(address6);
		
		return summaryPageDetails;
	}
		
	public void ClickOnProcessSummary()
	{
		processAddress.click();
	}
	
	public void ClickOnContinuShipping()
	{
		processCarrier.click();
	}
	
	public void AgreeToTerm()
	{
		agreeChkBox.click();
	}
	/**
	 *function to Click on bank wire so to go to final order page
	 */

	public void clickOnBankWire()
	{
		bankWire.click();
	}
	/**
	 *function to get the amount displayed in final order page to verify is correctly displayed as previous
	 */
	public String GetTotalFromConfirmPage()
	{
		return amountObj.getText();
	}
}

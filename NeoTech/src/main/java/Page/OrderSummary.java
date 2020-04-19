package Page;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import NewTech.NeoTech.BaseTest;

public class OrderSummary extends BaseTest
{

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
		
		String productName = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[2]/p/a")).getText();
		summaryPageDetails.add(productName);
		String cartTotal =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[6]")).getText();
		summaryPageDetails.add(cartTotal);

		String delieveryAddHeader = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[1]/h3")).getText();
		summaryPageDetails.add(delieveryAddHeader);
		
		String address1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[2]")).getText();
		summaryPageDetails.add(address1);
		String address2 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[3]")).getText();		
		summaryPageDetails.add(address2);
		String address3 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[4]")).getText();
		summaryPageDetails.add(address3);
		String address4 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[5]")).getText();
		summaryPageDetails.add(address4);
		String address5 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[6]")).getText();
		summaryPageDetails.add(address5);
		String address6 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[3]/div[1]/ul/li[5]")).getText();
		summaryPageDetails.add(address6);
		
		return summaryPageDetails;
	}
	
	
	public void ClickOnProcessSummary()
	{
		driver.findElement(By.name("processAddress")).click();
	}
	
	public void ClickOnContinuShipping()
	{
		driver.findElement(By.name("processCarrier")).click();
	}
	
	public void AgreeToTerm()
	{
		driver.findElement(By.id("uniform-cgv")).click();
	}
	/**
	 *function to Click on bank wire so to go to final order page
	 */
	public void clickOnBankWire()
	{
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
	}
	/**
	 *function to get the amount displayed in final order page to verify is correctly displayed as previous
	 */
	public String GetTotalFromConfirmPage()
	{
		return driver.findElement(By.id("amount")).getText();
	}
}

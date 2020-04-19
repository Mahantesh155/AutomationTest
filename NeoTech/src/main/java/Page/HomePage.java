package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NewTech.NeoTech.BaseTest;

public class HomePage extends BaseTest
{
	@FindBy(xpath="(//a[text()='Dresses'])[2]")private WebElement mouseHoverDresses;
	@FindBy(xpath="(//a[text()='Summer Dresses'])[2]")private WebElement clickSummer;
	@FindBy(xpath="//span[text()='Mahantesh Patil']")private WebElement userAccount;
	@FindBy(xpath="//span[text()='My wishlists']")private WebElement wishList;
	@FindBy(className = "(By.className(\"product_infos\")).findElement(By.className(\"product-name\"))")private WebElement productDetail;
	@FindBy(linkText = "View")private WebElement viewLink;
			
	/**
	 *function to Click on Summer Dresses in Dresses Tab
	 */
	
	public void clickSummerTab()
	{
		clickSummer.click();
	}	
	/**
	 *function to Hover on Dresses Tab
	 */
	public void hoverOnDresses()
	{
		//pojo.mouseAction();
		Actions a=new Actions(driver);
		a.moveToElement(mouseHoverDresses).perform();		
	}
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 *function to Click on my account
	 */
	public void clickOnMyAccount()
	{
		userAccount.click();
	}
	/**
	 *function to Click on WishList added
	 */
	public void clickOnWishList() throws InterruptedException
	{
		wishList.click();
		Thread.sleep(2000);
	}
	/**
	 *function to Click on item which is added in WishList
	 */
	public void ClickOnViewWishItem() throws InterruptedException
	{
		viewLink.click();
		Thread.sleep(2000);
	}
	
	public String GetProductDetails()
	{
		return driver.findElement(By.className("product_infos")).findElement(By.className("product-name")).getText();
	}
}

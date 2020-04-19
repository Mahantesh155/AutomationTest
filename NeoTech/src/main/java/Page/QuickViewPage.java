package Page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import NewTech.NeoTech.BaseTest;

public class QuickViewPage extends BaseTest
{
	@FindBy(xpath="(//button[@type='button'])[2]")private WebElement facebook;
	
	public void clickToShareOnFacebook()
	{
		facebook.click();
	}
	
	public QuickViewPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	/**
	 *function to click on Facebook icon and to verify it is landed on Facebook page
	 */
	public boolean FrameHandling(String windowName) throws InterruptedException
	{
		boolean isFaceBookWindowDisplayed = false;
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		String MainWindow=driver.getWindowHandle();
		clickToShareOnFacebook();
		
		Set<String> windows =  driver.getWindowHandles();
		
		Iterator<String> windowsList=windows.iterator();
		while(windowsList.hasNext())
		{
			String ChildWindow=windowsList.next();
			if(!MainWindow.equalsIgnoreCase(ChildWindow))
			{
				String pageTile = driver.switchTo().window(ChildWindow).getTitle();
				System.out.println(pageTile);
				if(pageTile.contains(windowName))
				{
					isFaceBookWindowDisplayed = true;
					driver.close();
					driver.switchTo().window(MainWindow);
					Thread.sleep(2000);
				}
			}
		}
		return isFaceBookWindowDisplayed;
	}
	
	public void EnterQuantity(String quantity)
	{
		driver.switchTo().frame(0);
		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys(quantity);
	}
	/**
	 *function to click on WishList button
	 */
	public void AddProductToWishList()
	{
		driver.findElement(By.id("wishlist_button")).click();
		driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
	}
	/**
	 *function to click on add to cart
	 */
	public void AddToCart() throws InterruptedException
	{
		driver.findElement(By.id("add_to_cart")).click();
		Thread.sleep(2000);
	}
	
	/**
	 *function to get details of cart
	 */
	
	public List<String> GetCartDetails()
	{
		List<String> detailsList =  new ArrayList<String>();
		
		String cartDetails = driver.findElement(By.className("layer_cart_product")).getText();
		String quantityOfProduct = driver.findElement(By.id("layer_cart_product_quantity")).getText();
		String priceProduct = driver.findElement(By.id("layer_cart_product_price")).getText();
		
		detailsList.add(cartDetails);
		detailsList.add(quantityOfProduct);
		detailsList.add(priceProduct);
		return detailsList;
	}
	/**
	 *function to click on checkout
	 */
	
	public void ClickOnProceedToCheckout() throws InterruptedException
	{
		List<WebElement> wbBtns = driver.findElements(By.className("btn-default"));
		
		for(int i=0;i<wbBtns.size();i++)
		{
			if(wbBtns.get(i).getAttribute("title").equalsIgnoreCase("Proceed to checkout"))
			{
				if(wbBtns.get(i).isDisplayed())
				{
					wbBtns.get(i).click();
					Thread.sleep(3000);
					break;
				}
			}
		}
	}
	
	
	
	
	
}

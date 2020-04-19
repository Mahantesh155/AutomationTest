package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerPage 
{
	@FindBy(xpath="//a[text()='List']")private WebElement list;
	@FindBy(xpath="(//span[text()='Add to cart'])[1]")private WebElement addToCart;
	@FindBy(xpath="//a[@id='color_20']")private WebElement blueIcon;
	@FindBy(xpath="(//a[@class='quick-view'])[1]")private WebElement quickView;
	
	public void clickList()
	{
		list.click();
	}
	public SummerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
}	

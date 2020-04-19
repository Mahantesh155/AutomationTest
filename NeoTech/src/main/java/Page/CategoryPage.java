package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import NewTech.NeoTech.BaseTest;

public class CategoryPage extends BaseTest{
	
	/**
	 *function to click on List View
	 */
	public void ClickOnListView()
	{
		driver.findElement(By.id("list")).click();
	}
	
	/**
	 *function- to click on Quick view if Blue color is found
	 * @param 
	 * @return new SitePage
	 */
	public boolean AddDreesToCart(String colorName) throws InterruptedException
	{
		boolean isColorFound = false;
		List<WebElement> wbs = driver.findElement(By.className("product_list")).findElements(By.className("product-container"));
	
		for(int i=0;i<wbs.size();i++)
		{
			List<WebElement> listOfColor = wbs.get(i).findElement(By.className("center-block")).findElement(By.className("color_to_pick_list")).findElements(By.tagName("li"));
			
			for(int j=0;j<listOfColor.size();j++)
			{
				String colorHref = listOfColor.get(j).findElement(By.tagName("a")).getAttribute("href");
				System.out.println(colorHref);
				if(colorHref.contains(colorName))
				{
					isColorFound = true;
					
					WebElement quickViewElement = wbs.get(i).findElement(By.className("left-block"));
					Actions actions = new Actions(driver);
					actions.moveToElement(quickViewElement).perform();
					Thread.sleep(4000);
					driver.findElement(By.className("quick-view")).click();
					break;
				}								
			}
			if(isColorFound == true)
			{
				break;
			}			
		}		
		return isColorFound;		
	}
}

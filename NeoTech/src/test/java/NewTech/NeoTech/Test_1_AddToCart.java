package NewTech.NeoTech;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Page.CategoryPage;
import Page.HomePage;
import Page.LoginPage;
import Page.OrderSummary;
import Page.QuickViewPage;

public class Test_1_AddToCart extends BaseTest
{
	 @BeforeClass
	public void beforeClass() throws Exception {
		 super.setUp();
	}

	@Test
	public void testMethod() throws Exception
	{
		//Login to application
		LoginPage login = new LoginPage(driver);
	 	login.LogInToApplication();	 		
	 	
	 	//Login to home page and navigate to Summer dress page
	 	HomePage home = new HomePage(driver);
	 	home.hoverOnDresses();			
		home.clickSummerTab();
		Assert.assertTrue(getTitlte().contains("Summer Dress"),"Summer Dresses page is not diplayed");
				
		//Select blue color product and click on 'Quick View'
	 	CategoryPage category = new CategoryPage(driver);
	 	category.ClickOnListView();		
	 	Boolean isBlueColurItemFound =  category.AddDreesToCart("color-blue");
	 	Assert.assertTrue(isBlueColurItemFound,"Blue color product is not present");
	 	Thread.sleep(5000);
	 		 		
	 	//Verify facebook window from quickview frame
	 	QuickViewPage quick = new QuickViewPage(driver);
	 	boolean isFaceBookWindowDisplayed = quick.FrameHandling("Facebook");
	 	
	 	Assert.assertTrue(isFaceBookWindowDisplayed,"On click of facebook link 'Facebook' window is not displayed");
	 	
	 	//Enter the quantity
	 	quick.EnterQuantity("2");
	 		
	 	//Add product to wishlist
	 	quick.AddProductToWishList();
	 		
	 	//Add prodct to cart
	 	quick.AddToCart();
	 	List<String> cartDetails = quick.GetCartDetails();	
	 	Assert.assertTrue(cartDetails.get(0).contains("Printed Summer Dress"),"Added product not displayed in the cart");
	 	Assert.assertTrue(cartDetails.get(1).contains("2"),"quantity of product is not same as entered");
	 	Assert.assertNotNull(cartDetails.get(2),"Price of product is not null");

	 	String totalPrice = cartDetails.get(2);
	 	String productQty = cartDetails.get(1);
	 	
	 	//Checkout the product
	 	quick.ClickOnProceedToCheckout();
	 			 		
	 	//Verify product details from summary page
	 	OrderSummary orderSummary = new OrderSummary(driver);
	 	List<String> summaryDetailsList = orderSummary.GetSummaryPageDetails();	 	
	 	Assert.assertTrue(summaryDetailsList.get(0).contains("Printed Summer Dress"),"Product name is not displayed in summary page.");
	 	Assert.assertTrue(summaryDetailsList.get(1).equals(totalPrice),"Total price displayed is not correct.");
	 	Assert.assertTrue(summaryDetailsList.get(2).contains("DELIVERY ADDRESS (MY ADDRESS)"),"Sumary details does not have 'DELIVERY ADDRESS (MY ADDRESS)'.");
	 	Assert.assertTrue(summaryDetailsList.get(3).equals("Mahantesh Patil"),"Sumary details does not have correct address.");
	 	Assert.assertTrue(summaryDetailsList.get(4).equals("Balaji Nagar"),"Sumary details does not have correct address.");
	 	Assert.assertTrue(summaryDetailsList.get(5).equals("Pune, Indiana 00000"),"Sumary details does not have correct address.");
	 	Assert.assertTrue(summaryDetailsList.get(6).equals("United States"),"Sumary details does not have correct address.");
	 	Assert.assertTrue(summaryDetailsList.get(7).equals("7447219862"),"Sumary details does not have correct address.");
	 	
	 	QuickViewPage quick1 = new QuickViewPage(driver);
	 	quick1.ClickOnProceedToCheckout();
	 			 			 		
	 	OrderSummary orderSummary1 = new OrderSummary(driver);
	 	orderSummary1.ClickOnProcessSummary();
	 			 		
	 	orderSummary1.AgreeToTerm();
	 		
	 	orderSummary1.ClickOnContinuShipping();
	 		
	 	QuickViewPage quick2 = new QuickViewPage(driver);
	 	quick2.ClickOnProceedToCheckout();	 		
	 	
	 	orderSummary1.clickOnBankWire();
	 	String totalPriceVal = totalPrice.substring(0, 3);
	 	String totalPriceVl = totalPriceVal.substring(1);
 	
	 	int totalPriceValue = Integer.parseInt(totalPriceVl);
	 	int quantityInInt = Integer.parseInt(productQty);
	 	int totalVal = totalPriceValue+quantityInInt;
	 	
	 	//Verify price in confirmation order page
	 	Assert.assertTrue(orderSummary1.GetTotalFromConfirmPage().equals("$"+totalVal+totalPrice.substring(3)),"Total price displayed in checkout confirmation page is not correct");
	 	
	 	//Verify user in 'View my customer account' page
	 	home.clickOnMyAccount();
	 	Assert.assertTrue(getTitlte().contains("My account"),"My account page is not diplayed on click of 'View my customer account' link");
	 		 	
	 	//Click 'My wish List' and view the added product
	 	home.clickOnWishList();
	 	home.ClickOnViewWishItem();
	 	
	 	//Verify product present in wishlist
	 	home.GetProductDetails();
	 	Assert.assertTrue(home.GetProductDetails().contains("Printed Summer Dress"),"Added product is not present in customer wishlist");

	}
	 
	@AfterClass (alwaysRun = true)
	public void afterClass() throws Exception {
		super.tearDown();
	}			
}

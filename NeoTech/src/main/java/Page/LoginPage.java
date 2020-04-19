package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NewTech.NeoTech.BaseTest;

public class LoginPage extends BaseTest{


	@FindBy(xpath="//input[@id='email']")private WebElement emailId;
	@FindBy(xpath="//input[@id='passwd']")private WebElement pwd;
	@FindBy(xpath="//a[@class='login']")private WebElement signIn;
	@FindBy(xpath="//button[@id='SubmitLogin']")private WebElement clickSignIn;

	
	public void clickSignInMeth()
	{
		clickSignIn.click();
	}
	public void clickSignIn()
	{
		signIn.click();
	}

	public void enterEmailId()
	{
		emailId.sendKeys(userName);
	}
	public void enterPwd()
	{
		pwd.sendKeys(passWord);
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 *function to click on SignIn button, enter email id and pwd and click on sign in button to login in to the application
	 */
	public void LogInToApplication() throws InterruptedException
	{
		clickSignIn();
		enterEmailId();
		enterPwd();
		clickSignInMeth();
		Thread.sleep(1000);
	}
	
	
}

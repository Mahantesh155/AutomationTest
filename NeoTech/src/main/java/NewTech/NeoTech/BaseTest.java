package NewTech.NeoTech;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest
{
	private static Properties properties = new Properties();
	public static String  browser;
	public static String NeoTechURL;
	public static String  environment;
	public static String  faceBookUrl;
	public static String  userName;
	public static String  passWord;	
	
	public static WebDriver driver;
	
	public  void setUp() throws Exception {
		initializeStaticFields();
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "src/test/resource/driver/chromedriver.exe");
		 driver= new ChromeDriver();
		}
		driver.get(NeoTechURL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	private static void initializeStaticFields() {
	
		loadProperties("environment.properties"); 
	
		browser = System.getProperty("browser");
		if (browser == null)
			browser = properties.getProperty("browser");
		System.out.println(  "browser : " + browser);
		
		NeoTechURL = properties.getProperty("baseurl");
		faceBookUrl  = properties.getProperty("faceBookurl");
		userName =  properties.getProperty("userName");
		passWord = properties.getProperty("passWord");	
	}
	
	public String getTitlte()
	{
		return driver.getTitle();
	}

	private static void loadProperties(String propFileName) {
		try
		{
			InputStream is = BaseTest.class.getClassLoader().getResourceAsStream(propFileName);
			properties.load(is);
			is.close();
		} catch (Exception e)
		{
			System.out.println("#### Error: Unable to load the \"" + propFileName + "\" file.");
			System.exit(1);
		}
	}
	
	public void tearDown()
	{
		driver.quit();
	}
}

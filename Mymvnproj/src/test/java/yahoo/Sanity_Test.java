package yahoo;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Sanity_Test 
{
	{
		System.setProperty("atu.reporter.config", "D:\\6PMMay16\\myproj\\atu.properties");
	}
    WebDriver driver;
    //DesiredCapabilities ds=null;
	@Test
	@Parameters({"browser"})
	public void Sanity_testing(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			//ds=DesiredCapabilities.firefox();
			//ds.setPlatform(Platform.WINDOWS);
			driver=new FirefoxDriver();
			
		}
		if(br.matches("chrome"))
		{
			//ds=DesiredCapabilities.chrome();
			//ds.setPlatform(Platform.WINDOWS);
			System.setProperty("webdriver.chrome.driver","d:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		//driver=new RemoteWebDriver(new URL("http://192.168.1.100:1234/wd/hub"), ds);
		Home h=new Home(driver);
		h.validate_links();
		h.createacc();
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();
		
	}
}

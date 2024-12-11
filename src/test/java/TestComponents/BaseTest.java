package TestComponents;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
public	WebDriver driver;
	public HomePage homepage;
	
	//initializing the browser
	public WebDriver initialize() throws IOException {
		String browserName=System.getProperty("browser")!=null? System.getProperty("browser"):getGlobalProperties("browser");
		
		// For Chrome 
		if (browserName.contains("chrome")) {
			ChromeOptions options= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if (browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} 
		 
		// for  Firefox
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webDriver.gecko.driver", getGlobalProperties("firefoxPath"));
            driver= new FirefoxDriver();
		} 
		
		//For Edge
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",getGlobalProperties("egdePath"));
			driver = new EdgeDriver();
		}     
		return driver;
	}

	//to launch HomePage
	@BeforeMethod
	public void launchWebsite() throws IOException, InterruptedException {
		initialize();
		 homepage= new HomePage(driver);
		homepage.goTo();
	}
	
	//to take Screenshot
	public String screenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
	File source=	screenshot.getScreenshotAs(OutputType.FILE);
	File destination = new File(System.getProperty("user.dir")+"//reports//"+ testCaseName+".png");
	FileUtils.copyFile(source, destination);
	return System.getProperty("user.dir")+"//reports//"+ testCaseName+ ".png"; 
	}
	
	//To get the properties from global file
	public String getGlobalProperties(String property) {
		Properties prop= new Properties();
		String projectDir = System.getProperty("user.dir"); 
	    String filePath = projectDir + "\\src\\test\\java\\TestComponents\\global.properties";
	    try (FileInputStream inputStream = new FileInputStream(filePath)) {
	        prop.load(inputStream);
	    }
	    catch(Exception e) {
	    	   System.out.println("An error occurred: " + e.getMessage());
	    }
	 return prop.getProperty(property);
	    }
	}


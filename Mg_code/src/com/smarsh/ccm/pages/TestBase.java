package com.smarsh.ccm.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.smarsh.ccm.generalFuncction.GeneralFunction;
import com.smarsh.ccm.utils.DBVerifications;




public class TestBase {
	static Properties OR;
	public WebDriver driver;
	protected static Logger logger;
	protected static HomePage homePage;
	protected static EmployeesPage empPage;
	protected static LoginPage loginPage;
	protected static GeneralFunction generalFunction;
	protected static DBVerifications db= new DBVerifications();
	protected static Statement stmt;
	
	
	LoginPage login;
	
	@Parameters({"browser", "url", "username", "password", "copyright", "version", "dburl", "dbusername", "dbpassword"})
	@BeforeSuite
	public void beforeSuite(String browser, String url, String username, String password, 
			String copyright, String version, String dburl, String dbusername, String dbpassword)
	{
		
		System.setProperty("browser", browser);
		System.setProperty("url", url);
		System.setProperty("username", username);
		System.setProperty("password", password);
		System.setProperty("copyright", copyright);
		System.setProperty("version", version);
		System.setProperty("dburl", dburl);
		System.setProperty("dbusername", dbusername);
		System.setProperty("dbpassword", dbpassword);
		stmt = db.mgDBConnectivity(dburl, dbusername, dbpassword);
		
	}
	
	public static void loadData() throws IOException {
		OR = new Properties();
		File file = new File(".\\config\\config.properties");

		FileInputStream f = new FileInputStream(file);
		OR.load(f);
		
	}

	public static String getObject(String Data) {
		String data = OR.getProperty(Data);
		return data;

	}

	public void init() throws IOException {
		loadData();
		selectBrowser(System.getProperty("browser"));
		driver.get(System.getProperty("url")); 
		homePage=new HomePage(driver);
		empPage =new EmployeesPage(driver);
		loginPage= new LoginPage(driver);
		generalFunction=new GeneralFunction(driver);
		logger = logger.getLogger(TestBase.class);
		
		
	   	
		}
	
	public void selectBrowser(String browser) {

		if (browser.equals("chrome")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\CKumar\\eclipse-workspace\\github\\mg_mvn\\Mg_code\\libraries");
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
			
			
			//driver = new FirefoxDriver(); 
			//driver.manage().window().maximize();
			
			
			
			/* To disable cache (not sure if it works)
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.cache.disk.enable", false);
			profile.setPreference("browser.cache.memory.enable", false);
			profile.setPreference("browser.cache.offline.enable", false);
			profile.setPreference("network.http.use-cache", false);
			FirefoxOptions options = new FirefoxOptions();			
			options.setProfile(profile);			
			driver = new FirefoxDriver(options);*/
			
			FirefoxProfile profile = new FirefoxProfile();

			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + "Downloads");
			//profile.setPreference("browser.download.dir",downloadPath);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
			FirefoxOptions options = new FirefoxOptions();			
			options.setProfile(profile);
			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

	}
	
	public void mobileGuardLogin() throws InterruptedException {
		try {
			init();
			loginPage.loginMG();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterSuite
	public void afterSuite()
	{
		driver.close();
	}
}

package testSistema;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; 


public class CreazioneGdS {

	private static WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private static WebDriverWait jsWait;
	  private static JavascriptExecutor jsExec;
	  //Get the driver 
	    public static void setDriver (WebDriver driver) {
	        jsWait = new WebDriverWait(driver, 10);
	        jsExec = (JavascriptExecutor) driver;
	    }
 
	  public static void waitUntilJQueryReady() {
	        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	 
	        //First check that JQuery is defined on the page. If it is, then wait AJAX
	        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
	        if (jQueryDefined == true) {
	            //Pre Wait for stability (Optional)
	            sleep(20);
	 
	            //Wait JQuery Load
	            waitForJQueryLoad();
	 
	            //Wait JS Load
	            waitUntilJSReady();
	 
	            //Post Wait for stability (Optional)
	            sleep(20);
	        }  else {
	            System.out.println("jQuery is not defined on this site!");
	        }
	    }
	  
	  public static void waitUntilJSReady() {
	        WebDriverWait wait = new WebDriverWait(driver,15);
	        JavascriptExecutor jsExec = (JavascriptExecutor)driver;
	 
	        //Wait for Javascript to load
	        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
	                .executeScript("return document.readyState").toString().equals("complete");
	 
	        //Get JS is Ready
	        boolean jsReady =  (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");
	 
	        //Wait Javascript until it is Ready!
	        if(!jsReady) {
	            System.out.println("JS in NOT Ready!");
	            //Wait for Javascript to load
	            wait.until(jsLoad);
	        } else {
	            System.out.println("JS is Ready!");
	        }
	    }
	  
	  public static void waitForJQueryLoad() {
	        //Wait for jQuery to load
	        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
	                .executeScript("return jQuery.active") == 0);
	 
	        //Get JQuery is Ready
	        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
	 
	        //Wait JQuery until it is Ready!
	        if(!jqueryReady) {
	            System.out.println("JQuery is NOT Ready!");
	            //Wait for jQuery to load
	            jsWait.until(jQueryLoad);
	        } else {
	            System.out.println("JQuery is Ready!");
	        }
	    }
	  
	    public static void sleep (Integer seconds) {
	        long secondsLong = (long) seconds;
	        try {
	            Thread.sleep(secondsLong);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  
	   
	  
	  
	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testCreazioneGdS() throws Exception {
	    driver.get("http://localhost:8080/StudentPlace/ShowHome");
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("a.lino@studenti.unisa.it");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Registrati'])[1]/preceding::input[1]")).click();
	    driver.findElement(By.linkText("Crea gruppo di studio")).click();
	    driver.findElement(By.name("nomeGruppo")).click();
	    driver.findElement(By.name("nomeGruppo")).clear();
	    driver.findElement(By.name("nomeGruppo")).sendKeys("prova");
	    driver.findElement(By.name("materia")).click();
	    driver.findElement(By.name("materia")).clear();
	    driver.findElement(By.name("materia")).sendKeys("architettura");
	    driver.findElement(By.id("data")).sendKeys("21-12-2018");
	    driver.findElement(By.id("inizio")).click();
	    driver.findElement(By.id("inizio")).clear();
	    driver.findElement(By.id("inizio")).sendKeys("09:00");
	    
	    waitUntilJQueryReady();
	    driver.findElement(By.id("aule")).click();
	    new Select(driver.findElement(By.id("aule"))).selectByVisibleText("P3");
	    driver.findElement(By.id("aule")).click();
	    driver.findElement(By.id("bottone")).click();
	    
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }


}

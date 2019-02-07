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

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	 
 
	  
	  public boolean waitForJQueryToLoad() {

		    WebDriverWait wait = new WebDriverWait(driver, 30);

		    // wait for jQuery to load
		    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {
		        try {
		          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
		        }
		        catch (Exception e) {
		          // no jQuery present
		          return true;
		        }
		      }
		    };

		    // wait for Javascript to load
		    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {
		        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
		        .toString().equals("complete");
		      }
		    };

		  return wait.until(jQueryLoad) && wait.until(jsLoad);
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
	    
	    
	    waitForJQueryToLoad();
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

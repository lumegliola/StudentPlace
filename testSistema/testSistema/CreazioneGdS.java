package testSistema;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreazioneGdS {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	    baseUrl = "https://www.katalon.com/";
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

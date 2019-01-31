package testSistema;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Registrazione {
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
  public void testRegistrazione() throws Exception {
    driver.get("http://localhost:8080/StudentPlace/ShowHome");
    driver.findElement(By.id("pulsanteReg")).click();
    driver.findElement(By.id("nome")).clear();
    driver.findElement(By.id("nome")).sendKeys("Giorgio");
    driver.findElement(By.id("cognome")).clear();
    driver.findElement(By.id("cognome")).sendKeys("Mastrota");
    driver.findElement(By.id("cemail")).clear();
    driver.findElement(By.id("cemail")).sendKeys("g.mastrota1@studenti.unisa.it");
    driver.findElement(By.id("cpassword")).clear();
    driver.findElement(By.id("cpassword")).sendKeys("soloperoggi");
    driver.findElement(By.id("matricola")).clear();
    driver.findElement(By.id("matricola")).sendKeys("0512100007");
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

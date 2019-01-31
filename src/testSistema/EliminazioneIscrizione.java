package testSistema;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EliminazioneIscrizione{
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
  public void testCancIscrizione() throws Exception {
    driver.get("http://localhost:8080/StudentPlace/logout");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='StudentPlace'])[1]/following::span[1]")).click();
    driver.findElement(By.id("cemail")).clear();
    driver.findElement(By.id("cemail")).sendKeys("a.capodanno5@studenti.unisa.it");
    driver.findElement(By.id("cpassword")).clear();
    driver.findElement(By.id("cpassword")).sendKeys("123456");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("a.capodanno5@studenti.unisa.it");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("log")).submit();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.linkText("Alessandro")).click();
    driver.findElement(By.name("cancella_iscrizione")).click();
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

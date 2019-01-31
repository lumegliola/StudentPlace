package testSistema;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EliminaOrario {
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
	public void testEliminaOrario() throws Exception {
		driver.get("http://localhost:8080/StudentPlace/ShowHome");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("f.megliola@studenti.unisa.it");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Registrati'])[1]/preceding::input[1]")).click();
		driver.findElement(By.linkText("Gestione orari")).click();
		driver.findElement(By.name("data")).click();
		driver.findElement(By.name("data")).clear();
		driver.findElement(By.name("data")).sendKeys("2019-01-16");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Aula'])[2]/following::select[1]")).click();
		new Select(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Aula'])[2]/following::select[1]"))).selectByVisibleText("P20");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Aula'])[2]/following::select[1]")).click();
		driver.findElement(By.name("inizio")).click();
		driver.findElement(By.name("inizio")).clear();
		driver.findElement(By.name("inizio")).sendKeys("15:00");
		driver.findElement(By.name("fine")).clear();
		driver.findElement(By.name("fine")).sendKeys("18:00");
		driver.findElement(By.name("formReg")).submit();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Mercoledì'])[1]/following::input[5]")).click();
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

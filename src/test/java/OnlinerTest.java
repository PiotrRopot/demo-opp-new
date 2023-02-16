import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OnlinerTest {

    @Test
    public void testOpenOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        WebElement COPYRIGHT_Element = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals(COPYRIGHT_Element.getText(), OnlinerPage.TXT_COPYRIGHT);
        driver.quit();
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.URL);
        WebElement BTN_OPEN_Element = driver.findElement(By.xpath(OnlinerPage.BTN_OPEN));
        BTN_OPEN_Element.click();
        WebElement TITLE_Element = driver.findElement(By.xpath(OnlinerPage.TITLE));
        Assert.assertEquals(TITLE_Element.getText(), OnlinerPage.TXT_OPEN);
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(OnlinerPage.URL);

        WebElement BTN_OPEN_Element = driver.findElement(By.xpath(OnlinerPage.BTN_OPEN));
        BTN_OPEN_Element.click();

        WebElement BTN_LOGIN = driver.findElement(By.xpath(OnlinerPage.BTN_LOGIN));
        BTN_LOGIN.click();

        WebElement TITLE_EMAIL_Element = driver.findElement(By.xpath(OnlinerPage.TITLE_EMAIL));
        Assert.assertEquals(TITLE_EMAIL_Element.getText(), OnlinerPage.TXT_TITLE_EMAIL);
        WebElement TITLE_PASSWORD_Element = driver.findElement(By.xpath(OnlinerPage.TITLE_PASSWORD));
        Assert.assertEquals(TITLE_PASSWORD_Element.getText(), OnlinerPage.TXT_TITLE_PASSWORD);
        driver.quit();
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
        driver.get(OnlinerPage.URL);
        WebElement BTN_OPEN_Element = driver.findElement(By.xpath(OnlinerPage.BTN_OPEN));
        BTN_OPEN_Element.click();
        WebElement BTN_TXT_EMAIL_ENTRE = driver.findElement(By.xpath(OnlinerPage.TXT_EMAIL_ENTRE));
        BTN_TXT_EMAIL_ENTRE.click();
        WebElement INPUT_LOGIN = driver.findElement(By.xpath(OnlinerPage.TITLE_EMAIL_OP));
        INPUT_LOGIN.sendKeys(OnlinerPage.MAIL);
        driver.quit();
    }
}



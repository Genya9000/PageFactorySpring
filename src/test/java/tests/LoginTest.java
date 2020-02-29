package tests;
import config.SpringConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StartPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    WebDriver driver;
    StartPage startPage;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = context.getBean("webDriver", WebDriver.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        startPage = context.getBean("startPage", StartPage.class);
        driver.get(startPage.getPage());
    }

    @AfterMethod
    public void afterMeth() {
        driver.quit();
        context.close();
    }

    @Test
    public void test() {
        startPage.inputInSignUpForm("Петя", "Piton", "123456");
    }
}

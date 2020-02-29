package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class StartPage {


    WebDriver driver;

    public  String getPage() {
        return page;
    }

    @Value("${startPage.page}")
    private String page;
    @FindBy(xpath = "//a[@id='asignup']")
     WebElement signUpButton;

    @FindBy(id = "asignin")
     WebElement signIpButton;
    @FindBy(name = "userName")
     WebElement inputUserName;
    @FindBy(xpath = "(//input[@name='userLogin'])[2]")
     WebElement inputUserLogin;
    @FindBy(xpath = "(//input[@name='userPassword'])[2]")
     WebElement inputUserPassword;
    @FindBy(xpath = "(//button)[2]")
     WebElement getSignUpButtonForm;
    @FindBy(xpath = "//div[@class='message-body']")
    WebElement danger;


public StartPage(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver, this);
    System.out.println("pagefactory init");
}



    public void inputInSignUpForm(String name, String login, String Password){
signUpButton.click();
inputUserName.sendKeys(name);
inputUserLogin.sendKeys(login);
inputUserPassword.sendKeys(Password);
getSignUpButtonForm.click();
Assert.assertTrue(danger.getText().contains("user"));
}



}

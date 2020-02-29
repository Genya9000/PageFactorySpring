package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pages.StartPage;

@Configuration
@ComponentScan("pages")
@PropertySource("classpath:test.properties")
public class SpringConfig {
    @Bean
    public WebDriver webDriver(){
    return new ChromeDriver();
}
    @Bean
    public StartPage startPage(){
        return new StartPage(webDriver());
    }
}

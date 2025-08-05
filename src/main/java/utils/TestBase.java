package utils;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class TestBase {

    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
    	PropertyUtils config = new PropertyUtils("src/test/resources/global.properties");
        String url = config.getProperty("QAUrl");
        String browser_properties = config.getProperty("browser");
        String browser_maven = System.getProperty("browser");

        String browser = browser_maven != null ? browser_maven : browser_properties;

        if (driver == null) {
            WebDriver rawDriver;

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                rawDriver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");

                rawDriver = new FirefoxDriver();

            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            // Optional: wrap with logger
            SeleniumActionLogger logger = new SeleniumActionLogger();
            EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<WebDriver>(logger);
            driver = decorator.decorate(rawDriver);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }

        return driver;
    }
}

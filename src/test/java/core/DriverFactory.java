package core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() throws MalformedURLException {

        if (driver == null) {
            if (Propriedades.seleniumHub) {
                return remoto();
            } else return local();

        }
        return driver;

    }

    public static WebDriver local() {
        switch (Propriedades.browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
        }

        driver.get(Propriedades.url);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

        return driver;
    }

    public static WebDriver remoto() throws MalformedURLException {

        switch (Propriedades.browser) {

            case CHROME: {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("chrome");
                cap.setPlatform(Platform.WINDOWS);

                //Chrome option
                ChromeOptions options = new ChromeOptions();
                options.merge(cap);
                options.setHeadless(true);
                //options.addArguments("--no-sandbox");

                // Create driver with hub address and capability
                driver = new RemoteWebDriver(new URL(Propriedades.urlSeleniumHub), options);
                driver.manage().window().setSize(new Dimension(1440, 900));

                //Test case
                driver.get(Propriedades.url);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
                return driver;

            }
            case FIREFOX: {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("firefox");
                cap.setPlatform(Platform.WINDOWS);

                //Chrome option
                FirefoxOptions options = new FirefoxOptions();
                options.merge(cap);
                options.setHeadless(true);
                //options.addArguments("--no-sandbox");

                // Create driver with hub address and capability
                driver = new RemoteWebDriver(new URL(Propriedades.urlSeleniumHub), options);
                driver.manage().window().setSize(new Dimension(1440, 900));

                //Test case
                driver.get(Propriedades.url);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
                return driver;

            }
        }
        return driver;
    }


    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver getChromeDriver() {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";
        if (OS.isFamilyMac())
            chromeDriverLocation = currentProjectLocation + "/src/test/resources/drivers/chromedriver";
        if (OS.isFamilyWindows())
            chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";

        if (chromeDriverLocation.isEmpty())
            throw new IllegalArgumentException("Can't detect OS type to start browser");
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static RemoteWebDriver getDriver(String browserName) {

        RemoteWebDriver remoteWebDriver;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANY);
        if (browserName.equalsIgnoreCase("safari"))
            desiredCapabilities.setBrowserName("safari");
        else if (browserName.equalsIgnoreCase("firefox"))
            desiredCapabilities.setBrowserName("firefox");
        else
            desiredCapabilities.setBrowserName("chrome");

        try {
            remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
        return remoteWebDriver;
    }
}

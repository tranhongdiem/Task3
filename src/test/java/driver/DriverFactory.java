package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private WebDriver webDriver;

    public WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = Driver.getChromeDriver();
        }
        return webDriver;
    }

    public WebDriver getDriver(String browserName) {
        if(webDriver == null) {
            webDriver = Driver.getDriver(browserName);
        }
        return webDriver;
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}

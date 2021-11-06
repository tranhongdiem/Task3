package tests;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import testdata.url.URL;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {

    private final static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webDriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    @AfterSuite(alwaysRun = true)
    public static void clearCookies() {
        for (DriverFactory webDriverThread : webDriverThreadPool) {
            webDriverThread.quitDriver();
        }
    }

    public static WebDriver getDriver() {
        return driverThread.get().getDriver();
    }

    public static WebDriver getDriver(String browserName){
        return driverThread.get().getDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        getDriver().manage().deleteAllCookies();
        if (result.getStatus() == ITestResult.FAILURE) {
            // 1. Get the test Method name
            String testMethod = result.getName();

            // 2. Declare the file location
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH);
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);
            String dateTaken = y + "-" + (m + 1) + "-" + d + "-" + hr + "-" + min + "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshot/" + testMethod + "_"+ dateTaken + ".png";

            // 3. Declare the file name

            // 4. Save the screenshot to the system
            File screenShot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenShot, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                try (InputStream is = Files.newInputStream(content)) {
                    Allure.addAttachment(testMethod, is);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void goTo(URL pathEnum){

        final String baseUrlString = "baseUrl";
        // Get String path from enum value
        String path = pathEnum.getPath();

        // Get current base url
        String baseUrl;
        baseUrl = System.getProperty(baseUrlString);
        if(baseUrl == null){
            baseUrl = System.getenv(baseUrlString);
        }

        if (baseUrl == null){
            throw new IllegalArgumentException("[ERR] Please supply the baseURL for testing!");
        }

        // Get final url
        String url = baseUrl + path;
        driverThread.get().getDriver().get(url);
    }
}

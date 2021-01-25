package driver;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    protected void setUp(String deviceName, String SO, String rutaApp, String udID){
        try {
            server = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        cap.setCapability("deviceName", deviceName);
        cap.setCapability("platformName", SO);
        cap.setCapability("app", rutaApp);
        cap.setCapability("udid", udID);

        driver = new AppiumDriver(server, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected AppiumDriver getDriver(){
        return driver;
    }
}

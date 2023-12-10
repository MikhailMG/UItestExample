package Tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void beforeMethodRun(){
        ISettingsFile environment = new JsonSettingsFile("configdata.json");
        String startURL = environment.getValue("/startURL").toString();
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(startURL);
    }

    @AfterMethod
    public void afterMethodRun(){
        browser.quit();
    }
}
package framework.Forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomepageUI extends Form {
    private static By locator = By.xpath("//button[@class = 'start__button']");

    private static String name = "homepageUI";

    private IButton startButton = getElementFactory().getButton(By.
            xpath("//a[@href='/game.html'][contains(.,'HERE')]"),
            "StartLinkButton");

    public HomepageUI() {
        super(locator, name);
    }

    public void clickStartButton() {
        startButton.click();
    }
}
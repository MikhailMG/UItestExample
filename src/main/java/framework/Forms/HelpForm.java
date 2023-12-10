package framework.Forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private static By locator = By.xpath("//div[contains(@class,'help-form__container')]");

    private static String name = "helpForm";

    private IButton buttonHelpToBottom = getElementFactory().getButton(By.
                 xpath("//button[contains(@class,'send-to-bottom-button')]"),
         "buttonHelpToBottom");

    private ILabel helpFormLabel = getElementFactory().getLabel(By.
            xpath("//h2[@class='help-form__title'][contains(.,'How can we help?')]"),
            "helpFormLabel");

    public HelpForm() {
        super(locator, name);
    }

    public void clickButtonHelpToBottom() {
        buttonHelpToBottom.click();
    }

    public boolean checkHelpFormLabelIsNOTRedisplayed() {
        helpFormLabel.state().waitForNotDisplayed();
        return true;
    }
}
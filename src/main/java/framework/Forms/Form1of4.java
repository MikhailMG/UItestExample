package framework.Forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

public class Form1of4 extends Form {

    private static By locator = By.
                    xpath("//div[@class='page-indicator'][contains(.,'1 / 4')]");

    private static String name = "page1of4";

    private ITextBox passwordInput = getElementFactory().getTextBox(By.
                    xpath("//input[contains(@placeholder,'Choose Password')]"),
            "passwordInput");

    private ITextBox emailInput = getElementFactory().getTextBox(By.
                    xpath("//input[@placeholder='Your email']"),
            "emailInput");

    private ITextBox domainInput = getElementFactory().getTextBox(By.
                    xpath("//input[@placeholder='Domain']"),
            "domainInput");

    private IComboBox domainExtChoise = getElementFactory().getComboBox(By.
                    xpath("//div[contains(@class,'dropdown__field')]"),
            "domainExtChoise");

    private List<IElement> domainExtList = getElementFactory().findElements(By.
            xpath("//div[@class='dropdown__list-item']"), ElementType.LABEL);


    private ICheckBox checkBoxTerms = getElementFactory().getCheckBox(By.
                    xpath("//span[contains(@class, 'icon') and" +
                            " contains(@class,'icon-check') and contains(@class,'checkbox__check')]"),
            "checkBoxTerms");

    private IButton buttonNextForm = getElementFactory().getButton(By.
                    xpath("//a[contains(@class,'button--secondary')][contains(.,'Next')]"),
            "buttonNextForm");

    private ILabel cookiesBar = getElementFactory().getLabel(By.
                    xpath("//div[@class='cookies']"),
            "cookiesBar");

    private IButton noProblemButton = getElementFactory().getButton(By.
                    xpath("//button[@name='button'][contains(.,'Not really, no')]"),
            "noProblemButton");

    private ILabel timerOfForms = getElementFactory().getLabel(By.
                    xpath("//div[contains(@class,'timer') and" +
                            " contains(@class,'white timer')]"),
            "timerOfForms");

    public Form1of4() {
        super(locator, name);
    }

    private List<IElement> getDomainExtList() {
        List<IElement> domainExtList = getElementFactory().findElements(By.
                xpath("//div[@class='dropdown__list-item']"), ElementType.LABEL);
        return domainExtList;
    }

    public int getDomainExtListSize() {
        return getDomainExtList().size();
    }

    public int getDomainExtListRandomNumber() {
        int domainExtListSize = getDomainExtListSize();
        int domainExtListRandom = (int) ((domainExtListSize - 1) * Math.random());
        if (domainExtListRandom < 1) ;
        {
            domainExtListRandom = domainExtListRandom + 1;
        }
        return domainExtListRandom;
    }

    public void clickDomainExtListElement(int elementNumber) {
        getDomainExtList().get(elementNumber).click();
    }

    public void clearAndTypeinPasswordInput(String textToType) {
        passwordInput.clearAndType(textToType);
    }

    public void clearAndTypeinEmailInput(String textToType) {
        emailInput.clearAndType(textToType);
    }

    public void clearAndTypeinDomainInput(String textToType) {
       domainInput.clearAndType(textToType);
    }

    public void clickDomainExtChoise() {
        domainExtChoise.click();
    }

    public void checkCheckBoxTerms() {
        checkBoxTerms.check();
    }

    public void clickButtonNextForm() {
        buttonNextForm.click();
    }

    public boolean checkCookiesBarIsNOTdisplayed() {
        cookiesBar.state().waitForNotDisplayed();
        return true;
    }

    public void clickNoProblemButton() {
        noProblemButton.click();
    }

    public String getTextOfTimerOfForms() {
       return timerOfForms.getText();
    }
}
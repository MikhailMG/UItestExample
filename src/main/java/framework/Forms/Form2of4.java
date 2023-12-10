package framework.Forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;


public class Form2of4 extends Form {

    private static By locator = By.xpath("//div[@class='page-indicator'][contains(.,'2 / 4')]");

    private static String name = "page2of4";

    private IButton checkBoxUnselectAll = getElementFactory().getButton(By.
                    xpath(" //label[@class='checkbox__label'][@for='interest_unselectall']"),
            "checkBoxUnselectAll");

    private IButton checkBoxSelectAll = getElementFactory().getButton(By.
                    xpath(" //label[@class='checkbox__label'][@for='interest_selectall']"),
            "checkBoxSelectAll");

    private List<IButton> checkBoxesInterestsList = getElementFactory().findElements(By.
            xpath("//label[@class='checkbox__label']"), ElementType.BUTTON);

    private IButton uploadButton = getElementFactory().getButton(By.
                    xpath("//a[@class='avatar-and-interests__upload-button'][contains(.,'upload')]"),
            "uploadButton");

    private IButton nextFormButton = getElementFactory().getButton(By.
                    xpath("//button[@name='button'][contains(.,'Next')]"),
            "nextFormButton");

    public Form2of4() {
        super(locator, name);
    }

    public void clickCheckBoxUnselectAll() {
        checkBoxUnselectAll.click();
    }

    public IButton getCheckBoxUnselectAllElement() {
        return checkBoxUnselectAll;
    }

    public IButton getCheckBoxSelectAll() {
        return checkBoxSelectAll;
    }

    public List<IButton> getCheckBoxesInterestsList() {
        return checkBoxesInterestsList;
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    public void clickNextFormButton() {
        nextFormButton.click();
    }

    public void checkRandomCheckBoxes(int numberOfChecks) {
        List<IButton> checkBoxesInterestsListCopy = getCheckBoxesInterestsList();
        int interestsAmount = checkBoxesInterestsListCopy.size();
        List<Integer> checkedInterestNumbersList = new ArrayList<Integer>();
        for (int i = 0; i < numberOfChecks; ) {
            int randomInterestBoxN = (int) (interestsAmount * Math.random());
            if (checkBoxesInterestsListCopy.get(randomInterestBoxN).getAttribute("for").
                    equals(getCheckBoxUnselectAllElement().getAttribute("for"))) {

            } else if ((checkBoxesInterestsListCopy.get(randomInterestBoxN).getAttribute("for").
                    equals(getCheckBoxSelectAll().getAttribute("for")))) {

            } else if (checkedInterestNumbersList.contains(randomInterestBoxN)) {

            } else {
                checkBoxesInterestsListCopy.get(randomInterestBoxN).click();
                checkedInterestNumbersList.add(randomInterestBoxN);
                i++;
            }
        }
    }
}
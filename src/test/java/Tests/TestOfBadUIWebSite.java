package Tests;

import Utils.RandomUtils.StringRandomGenerator;
import Utils.RobotUtils.RobotUtils;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import framework.Forms.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestOfBadUIWebSite extends BaseTest {
    ISettingsFile environment = new JsonSettingsFile("testdata.json");
    @Test(priority=0)
    public void testTheFormsFilling() throws IOException {
        HomepageUI homepage = new HomepageUI();
        Assert.assertTrue(homepage.state().waitForDisplayed(), "Homepage is not loaded");
        homepage.clickStartButton();
        Form1of4 form1 = new Form1of4();
        Assert.assertTrue(form1.state().waitForDisplayed(), "Form1 is not loaded");
        Integer passwordLength = Integer.valueOf(environment.getValue("/minimuumPassLength").toString());

        String randomEmail = StringRandomGenerator.getRandomString((int) (Math.random() * passwordLength + 1),
                StringRandomGenerator.getALPHA_NUMERIC_STRING());

        String randomPassword = StringRandomGenerator.
                getRandomString((int) (Math.random() * passwordLength + passwordLength),
                        StringRandomGenerator.getALPHA_NUMERIC_STRING());

        String randomCirrilic = StringRandomGenerator.getRandomString((int) (Math.random() * passwordLength + 1),
                StringRandomGenerator.getCIRRILIC_STRING());

        String randomDomain = StringRandomGenerator.getRandomString((int) (Math.random() * passwordLength + 1),
                StringRandomGenerator.getALPHA_NUMERIC_STRING());

        form1.clearAndTypeinEmailInput(randomEmail);
        form1.clearAndTypeinPasswordInput(randomPassword + randomEmail + randomCirrilic);
        form1.clearAndTypeinDomainInput(randomDomain);
        form1.clickDomainExtChoise();
        form1.clickDomainExtListElement(form1.getDomainExtListRandomNumber());
        form1.checkCheckBoxTerms();
        form1.clickButtonNextForm();
        Form2of4 form2 = new Form2of4();
        Assert.assertTrue(form2.state().waitForDisplayed(), "Form2 is not loaded");
        form2.clickCheckBoxUnselectAll();
        Integer numberOfIntrests = Integer.valueOf(environment.getValue("/numberOfIntrests").toString());
        form2.checkRandomCheckBoxes(numberOfIntrests);
        form2.clickUploadButton();
        String pathToAvatarImage = environment.getValue("/pathToAvatarImage").toString();
        RobotUtils.robotSendPathToFileFromClipboard(pathToAvatarImage);
        form2.clickNextFormButton();
        Form3of4 form3 = new Form3of4();
        Assert.assertTrue(form3.state().waitForDisplayed(), "Form3 is not loaded");
    }

    @Test(priority=1)
    public void testTheHidingHelpForm() {
        HomepageUI homepage = new HomepageUI();
        Assert.assertTrue(homepage.state().waitForDisplayed(), "Homepage is not loaded");
        homepage.clickStartButton();
        Form1of4 form1 = new Form1of4();
        Assert.assertTrue(form1.state().waitForDisplayed(), "Form1 is not loaded");
        HelpForm helpForm = new HelpForm();
        helpForm.clickButtonHelpToBottom();
        Assert.assertTrue(helpForm.checkHelpFormLabelIsNOTRedisplayed(),
                "Help Form is still displayed!");
    }

    @Test(priority=2)
    public void testTheCookiesBarClosing () {
        HomepageUI homepage = new HomepageUI();
        Assert.assertTrue(homepage.state().waitForDisplayed(), "Homepage is not loaded");
        homepage.clickStartButton();
        Form1of4 form1 = new Form1of4();
        Assert.assertTrue(form1.state().waitForDisplayed(), "Form1 is not loaded");
        form1.clickNoProblemButton();
        Assert.assertTrue(form1.checkCookiesBarIsNOTdisplayed(),
                "Cookies acceptance request is still displayed!");
    }

    @Test(priority=3)
    public void testTheTimerZeroStart() {
        HomepageUI homepage = new HomepageUI();
        Assert.assertTrue(homepage.state().isDisplayed(), "Homepage is not loaded");
        homepage.clickStartButton();
        Form1of4 form1 = new Form1of4();
        Assert.assertTrue(form1.state().waitForDisplayed(), "Form1 is not loaded");
        browser.refresh();
        String timerStartValue = form1.getTextOfTimerOfForms();
        String timerZeroValue = environment.getValue("/timerZeroValue").toString();
        Assert.assertEquals(timerStartValue, timerZeroValue,
                "Timer has started not from 00:00:00 !!!");
    }
}
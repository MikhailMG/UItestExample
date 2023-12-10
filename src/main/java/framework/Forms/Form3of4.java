package framework.Forms;

import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class Form3of4 extends Form {
    private static By locator = By.xpath("//div[@class='page-indicator'][contains(.,'3 / 4')]");

    private static String name = "page3of4";

    public Form3of4() {
        super(locator, name);
    }
}


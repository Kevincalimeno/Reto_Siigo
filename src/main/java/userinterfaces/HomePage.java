package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public static final Target TXT_USER = Target.the("textbox user")
            .located(ByShadow.cssSelector("#username-input", "#username"));

    public static final Target TXT_PASS = Target.the("textbox pass")
            .located(ByShadow.cssSelector("#password-input", "#current-password"));

    public static final Target BTN_LOGIN = Target.the("login button")
            .located(By.id("login-submit"));
}

package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.shadow.ByShadow;
import utils.ShadowElementLocator;

public class MainPage {
    public static final Target BTN_CREATE = Target.the("Button on the mainpage to create")
            .located(ByShadow.cssSelector("button", "siigo-header-molecule[class='data-siigo-five9 hydrated']", "siigo-button-atom[data-id='header-create-button']"));

    public static final Target BTN_CLIENTS = Target.the("Button clients form")
            .located(ByShadow.cssSelector("a[data-value='Clientes']", "siigo-header-molecule.data-siigo-five9"));
}
